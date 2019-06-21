package com.gsep.myfin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CalcTempoSActivity extends AppCompatActivity {
    Button btnCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_tempo_s);

        final EditText valorMonetario = (EditText)findViewById(R.id.capital);
        final EditText valorPorcentagem = (EditText)findViewById(R.id.Taxa);
        final EditText tempoP = (EditText)findViewById(R.id.tempo);
        btnCalcular = (Button)findViewById(R.id.btnCalc);
        final TextView res = (TextView)findViewById(R.id.iResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(valorMonetario.getText().toString().equals("")){

                    valorMonetario.setError("Campo vazio");

                }else if (valorPorcentagem.getText().toString().equals("")){

                    valorPorcentagem.setError("Campo vazio");
                }else if (tempoP.getText().toString().equals("")){

                    tempoP.setError("Campo vazio");
                }else {
                    float juros = Float.parseFloat(valorMonetario.getText().toString());
                    float cap = Float.parseFloat(valorPorcentagem.getText().toString());
                    float porc = Float.parseFloat(tempoP.getText().toString());
                    float result = juros / (cap * (porc / 100));
                    DecimalFormat df = new DecimalFormat("##.##");
                    res.setText("Tempo: " + df.format(result));
                }
            }
        });
    }
}