package com.example.menudelaplicativo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button calcular;
    Button base;
    Button creditos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcular = (Button)findViewById(R.id.cm);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calcular = new Intent(MainActivity.this, CalcularMetricas.class);
                startActivity(calcular);
            }
        });

        base = (Button)findViewById(R.id.bd);
        base.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent base = new Intent(MainActivity.this, BaseDeDatos.class);
                startActivity(base);
            }
        });

        creditos = (Button)findViewById(R.id.cs);
        creditos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent creditos = new Intent(MainActivity.this, Creditos.class);
                startActivity(creditos);
            }
        });
    }
}