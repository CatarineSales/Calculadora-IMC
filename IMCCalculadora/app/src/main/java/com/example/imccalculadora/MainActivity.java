package com.example.imccalculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textresultado;
    private EditText editpeso, editaltura;


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

        textresultado = findViewById(R.id.textresultado);
        editpeso = findViewById(R.id.editpeso);
        editaltura = findViewById(R.id.editaltura);

    }

    public void calcular(View view){ //"View" - atributo que deve ser importado e o "view" possibilita que esse metodo seja enchergado e desparado

        double peso = Double.parseDouble(editpeso.getText().toString());
        double altura = Double.parseDouble(editaltura.getText().toString());
        double resultado = peso / (altura * altura);

        if(resultado < 19){
            textresultado.setText("Abaixo do peso!");

        }else if( resultado <= 19 || resultado <25){

            textresultado.setText("Seu reultado é:" + resultado + "Você esta com peso normal");

        }else if( resultado <= 25 || resultado <30){

            textresultado.setText("Sobrepeso");

        }else if( resultado <= 30 || resultado <40){

            textresultado.setText("Obesidade tipo 1");

        }else if( resultado >= 40){

            textresultado.setText("Obesidade tipo 2");
        }


    }
}