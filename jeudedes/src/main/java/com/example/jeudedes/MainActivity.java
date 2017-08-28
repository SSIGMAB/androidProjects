package com.example.jeudedes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText joueur1;
    EditText joueur2;
    EditText valueD1J1;
    EditText valueD2J1;
    EditText valueD1J2;
    EditText valueD2J2;
    EditText scoreJ1;
    EditText scoreJ2;
    EditText scorePartieJ1;
    EditText scorePartieJ2;
    TextView titreGagnant;
    EditText gagnant;

    Button lancerJ1;
    Button lancerJ2;

    String nomJoueur1, nomJoueur2;

    Partie daGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        joueur1 = (EditText) findViewById(R.id.nomJoueur1PageMain);
        joueur2 = (EditText) findViewById(R.id.nomJoueur2PageMain);
        valueD1J1 = (EditText) findViewById(R.id.valueD1J1);
        valueD2J1 = (EditText) findViewById(R.id.valueD2J1);
        valueD1J2 = (EditText) findViewById(R.id.valueD1J2);
        valueD2J2 = (EditText) findViewById(R.id.valueD2J2);
        scoreJ1 = (EditText) findViewById(R.id.scoreJ1);
        scoreJ2 = (EditText) findViewById(R.id.scoreJ2);
        scorePartieJ1 = (EditText) findViewById(R.id.scorePartieJ1);
        scorePartieJ2 = (EditText) findViewById(R.id.scorePartieJ2);
        titreGagnant = (TextView) findViewById(R.id.titreGagnant);
        gagnant = (EditText) findViewById(R.id.gagnant);

        lancerJ1 = (Button) findViewById(R.id.lancerJ1);
        lancerJ2 = (Button) findViewById(R.id.lancerJ2);

        Intent intent = getIntent();
        nomJoueur1 = intent.getStringExtra("nomJoueur1");
        nomJoueur2 = intent.getStringExtra("nomJoueur2");
        if (nomJoueur1 == null && nomJoueur2 == null){
            Intent i = new Intent(this, PseudoActivity.class);
            startActivity(i);
        }
        daGame= new Partie(nomJoueur1, nomJoueur2);
        joueur1.setText(nomJoueur1);
        joueur2.setText(nomJoueur2);
        lancerJ1.setOnClickListener(this);
        lancerJ2.setOnClickListener(this);
        lancerJ2.setVisibility(View.INVISIBLE);
        titreGagnant.setVisibility(View.INVISIBLE);
        gagnant.setVisibility(View.INVISIBLE);


    }

    @Override
    public void onClick(View v){

        if(v == lancerJ1){
            daGame.lancerJ1();
            valueD1J1.setText(""+daGame.getJ1().getG1().getD1().getValue());
            valueD2J1.setText(""+daGame.getJ1().getG1().getD2().getValue());
            scoreJ1.setText(""+daGame.getJ1().getG1().getScore());
            scorePartieJ1.setText(""+daGame.getJ1().getScorePartie());
            lancerJ1.setVisibility(View.INVISIBLE);
            lancerJ2.setVisibility(View.VISIBLE);

        }

        if (v == lancerJ2){
            daGame.lancerJ2();
            valueD1J2.setText(""+daGame.getJ2().getG1().getD1().getValue());
            valueD2J2.setText(""+daGame.getJ2().getG1().getD2().getValue());
            scoreJ2.setText(""+daGame.getJ2().getG1().getScore());
            scorePartieJ2.setText(""+daGame.getJ2().getScorePartie());
            lancerJ1.setVisibility(View.VISIBLE);
            lancerJ2.setVisibility(View.INVISIBLE);
            if(daGame.isTerminer()){
                lancerJ1.setVisibility(View.INVISIBLE);
                lancerJ2.setVisibility(View.INVISIBLE);
                titreGagnant.setVisibility(View.VISIBLE);
                gagnant.setVisibility(View.VISIBLE);
                gagnant.setText(daGame.getGagnant());
            }
        }



    }
}
