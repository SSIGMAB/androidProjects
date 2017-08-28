package com.example.borbely.kraken;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener{

    Button accueilButtonP3;
    Button previousButtonP3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        accueilButtonP3 = (Button) findViewById(R.id.homeButtonP3);
        accueilButtonP3.setOnClickListener(this);

        previousButtonP3 = (Button) findViewById(R.id.previousButtonP3);
        previousButtonP3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        if (v == accueilButtonP3){
            Intent intent= new Intent(this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Bienvenue à l'Accueil", Toast.LENGTH_SHORT).show();
        }

        if (v == previousButtonP3){
            Intent intent= new Intent(this, SecondActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Bienvenue à la deuxième page", Toast.LENGTH_SHORT).show();
        }

    }

}
