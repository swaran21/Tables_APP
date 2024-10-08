package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView user_value;
    Button Submit;
    TextView Table;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        user_value =findViewById(R.id.user_value);
        Submit = findViewById(R.id.Submit);
        Table = findViewById(R.id.Table);


        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = user_value.getText().toString();
                if(s.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter the number", Toast.LENGTH_SHORT).show();
                }

                int c = 0;
                try{
                    c = Integer.parseInt(s);
                }
                catch(NumberFormatException e){
                    Toast.makeText(MainActivity.this, "Enter in number format", Toast.LENGTH_SHORT).show();
                }

                StringBuilder table = new StringBuilder();
                table.append("Table of ").append(c).append(":\n");

                for(int i = 1;i<=10;i++)
                    table.append(String.format("%d * %d = %d\n",c,i,c*i));
                Table.setText(table.toString());
            }
        });
    }
}