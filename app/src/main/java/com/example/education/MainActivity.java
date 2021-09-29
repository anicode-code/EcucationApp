package com.example.education;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button fast_maths, others;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            fast_maths = findViewById(R.id.fast_maths);
            others = findViewById(R.id.others);
            fast_maths.setOnClickListener(view -> {
                Intent intent = new Intent(this, DoFastMaths.class);
                startActivity(intent);
            });
            others.setOnClickListener(view -> Toast.makeText(MainActivity.this, "others", Toast.LENGTH_SHORT).show());
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "an error occurred", Toast.LENGTH_SHORT).show();
        }
    }
}