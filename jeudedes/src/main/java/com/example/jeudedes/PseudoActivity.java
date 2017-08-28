package com.example.jeudedes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PseudoActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nomJoueur1;
    EditText nomJoueur2;
    Button lancerPartie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pseudo);

        nomJoueur1 = (EditText) findViewById(R.id.nomJoueur1);
        nomJoueur2 = (EditText) findViewById(R.id.nomJoueur2);
        lancerPartie = (Button) findViewById(R.id.lancerPartie);

        lancerPartie.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == lancerPartie){
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("nomJoueur1", nomJoueur1.getText().toString());
            intent.putExtra("nomJoueur2", nomJoueur2.getText().toString());
            startActivity(intent);
        }
    }
}
