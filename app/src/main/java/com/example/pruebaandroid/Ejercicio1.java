package com.example.pruebaandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ejercicio1 extends AppCompatActivity {

    private EditText pesoEdit, alturaEdit;
    private TextView resultadoIMC;
    private Button calcularIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ejercicio1);

        calcularIMC = (Button) findViewById(R.id.calcularIMC);
        ;
        resultadoIMC = (TextView) findViewById(R.id.resultadoIMC);
        ;
        pesoEdit = (EditText) findViewById(R.id.pesoEdit);
        ;
        alturaEdit = (EditText) findViewById(R.id.alturaEdit);
        ;

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
    public void calcularIMC(View view){

        if (pesoEdit.getText().toString().trim().length() == 0){
            pesoEdit.requestFocus();
            Toast.makeText(this, "Ingrese peso a calcular.", Toast.LENGTH_SHORT).show();
        } else if (alturaEdit.getText().toString().trim().length() == 0){
            alturaEdit.requestFocus();
            Toast.makeText(this, "Ingrese altura a calcular.", Toast.LENGTH_SHORT).show();
        } else {

            int kg = Integer.parseInt(pesoEdit.getText().toString());
            int cm = Integer.parseInt(alturaEdit.getText().toString());
            int imc = (kg / (cm * cm));

            if (imc < 18){
                resultadoIMC.setText("BAJO PESO.");
            }else {
                if (imc < 25){
                    resultadoIMC.setText("PESO NORMAL.");
                }
                else {
                    if (imc < 30){
                        resultadoIMC.setText("SOBRE PESO.");
                    }
                    else {
                        if (imc < 35){
                            resultadoIMC.setText("OBECIDAD.");
                        }
                        else {
                            if (imc > 35){
                                resultadoIMC.setText("MORBIDO.");
                            }
                        }
                    }
                }
            }
        }
    }

}
