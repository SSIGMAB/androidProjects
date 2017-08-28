package com.example.borbely.kraken;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

public class BoulangerieActivity extends AppCompatActivity implements View.OnClickListener {

    NumberPicker croissant;
    NumberPicker chocolatine;
    NumberPicker painAuxRaisins;
    Button calculerTotalBoulang;
    EditText editTextTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boulangerie);

        croissant = (NumberPicker) findViewById(R.id.croissantPicker);
        croissant.setMinValue(0);
        croissant.setMaxValue(30);

        chocolatine = (NumberPicker) findViewById(R.id.chocolatinePicker);
        chocolatine.setMinValue(0);
        chocolatine.setMaxValue(30);

        painAuxRaisins = (NumberPicker) findViewById((R.id.painAuxRaisinsPicker));
        painAuxRaisins.setMinValue(0);
        painAuxRaisins.setMaxValue(30);

        calculerTotalBoulang = (Button) findViewById(R.id.calculerButtonBoulangerie);
        calculerTotalBoulang.setOnClickListener(this);

        editTextTotal = (EditText) findViewById(R.id.editTextTotal);
        editTextTotal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == calculerTotalBoulang) {
            double total = (croissant.getValue() / 10) * 5 + (croissant.getValue() % 10) * 0.8 + (chocolatine.getValue() / 10) * 6 + (chocolatine.getValue() % 10)
                    * 0.9 + (painAuxRaisins.getValue() / 10) * 6 + (painAuxRaisins.getValue() % 10) * 0.85;
            editTextTotal.setText(total + "€");
        }
    }
}
