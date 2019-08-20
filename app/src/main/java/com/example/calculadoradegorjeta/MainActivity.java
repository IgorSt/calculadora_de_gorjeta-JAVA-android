package com.example.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editGorjeta;
    private TextView textPorcentagem;
    private TextView textGorjeta;
    private TextView textTotal;
    private SeekBar seekGorjeta;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editGorjeta = findViewById(R.id.TextInput1);
        textGorjeta = findViewById(R.id.textGorjeta);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        textTotal = findViewById(R.id.textTotal);
        seekGorjeta = findViewById(R.id.seekBarGorjeta);

        double editGorjetaInt = Double.parseDouble(editGorjeta.getText().toString());

        //controlar seekbar
        seekGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                porcentagem = seekBar.getProgress();
                textPorcentagem.setText(porcentagem + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        double totalPorcentagem = (porcentagem / 100) * editGorjetaInt;
        String totalPorcentagemSt = String.valueOf(totalPorcentagem);

        textGorjeta.setText(totalPorcentagemSt);
    }
}
