package com.example.equacao2grau;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/*
 *@author:<Brenda Santana Santos>
 1110482313042
 */

public class MainActivity extends AppCompatActivity {

    private EditText editTextA, editTextB, editTextC;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextC = findViewById(R.id.editTextC);
        textViewResultado = findViewById(R.id.textViewResultado);
        Button buttonCalcular = findViewById(R.id.buttonCalcular);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularRaizes();
            }
        });
    }

    private void calcularRaizes() {
        try {
            double a = Double.parseDouble(editTextA.getText().toString());
            double b = Double.parseDouble(editTextB.getText().toString());
            double c = Double.parseDouble(editTextC.getText().toString());

            if (a == 0) {
                textViewResultado.setText("Não é uma equação do 2º grau.");
                return;
            }

            double delta = b * b - 4 * a * c;
            String resultado;

            if (delta < 0) {
                resultado = "Não há raízes reais.";
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                resultado = "Delta: " + delta + "\nX1: " + x1 + "\nX2: " + x2;
            }

            textViewResultado.setText(resultado);
        } catch (NumberFormatException e) {
            textViewResultado.setText("Por favor, insira números válidos.");
        }
    }
}
