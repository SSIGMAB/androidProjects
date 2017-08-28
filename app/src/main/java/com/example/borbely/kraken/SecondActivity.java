package com.example.borbely.kraken;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    Button previousButtonP2;
    Button nextButtonP2;
    Button validerPalindrome;
    EditText testPalindrome;
    NumberPicker valeur1Moy;
    NumberPicker valeur2Moy;
    NumberPicker valeur3Moy;
    NumberPicker valeur4Moy;
    Button buttonCalculerMoy;
    Button buttonRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        previousButtonP2 = (Button) findViewById(R.id.previousButtonP2);
        previousButtonP2.setOnClickListener(this);

        nextButtonP2 = (Button) findViewById(R.id.nextButtonP2);
        nextButtonP2.setOnClickListener(this);

        validerPalindrome = (Button) findViewById(R.id.buttonPalindrome);
        validerPalindrome.setOnClickListener(this);

        testPalindrome = (EditText) findViewById(R.id.testPalindrome);
        testPalindrome.setOnClickListener(this);

        valeur1Moy = (NumberPicker) findViewById(R.id.valeur1Moy);
        valeur1Moy.setMaxValue(100);
        valeur1Moy.setMinValue(0);

        valeur2Moy = (NumberPicker) findViewById(R.id.valeur2Moy);
        valeur2Moy.setMaxValue(100);
        valeur2Moy.setMinValue(0);

        valeur3Moy = (NumberPicker) findViewById(R.id.valeur3Moy);
        valeur3Moy.setMaxValue(100);
        valeur3Moy.setMinValue(0);

        valeur4Moy = (NumberPicker) findViewById(R.id.valeur4Moy);
        valeur4Moy.setMaxValue(100);
        valeur4Moy.setMinValue(0);

        buttonCalculerMoy = (Button) findViewById(R.id.buttonCalculerMoy);
        buttonCalculerMoy.setOnClickListener(this);

        buttonRandom = (Button) findViewById(R.id.buttonRandom);
        buttonRandom.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v == previousButtonP2){
            Intent intent= new Intent(this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Bienvenue à l'Accueil", Toast.LENGTH_SHORT).show();
        }

        if (v == nextButtonP2){
            Intent intent= new Intent(this, ThirdActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Bienvenue à la troisième page", Toast.LENGTH_SHORT).show();
        }

        if (v == validerPalindrome){
           Toast.makeText(this, "Est-ce un palindrome : "+Controle.isMirror(testPalindrome.getText()), Toast
                    .LENGTH_SHORT).show();
        }

        if (v == buttonCalculerMoy){
            Toast.makeText(this, "La moyenne est : "+Controle.moyenne(valeur1Moy.getValue(),valeur2Moy.getValue(), valeur3Moy.getValue(), valeur4Moy.getValue()), Toast
                    .LENGTH_SHORT).show();
        }

        if (v == buttonRandom){
            Toast.makeText(this, "Voilà un multiple de 10 random : "+Controle.aleatoirePaire10_100(), Toast.LENGTH_SHORT).show();
        }

    }
}
