package com.example.borbely.kraken;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    // // // // // // // // // // Déclaration des variables pour contenir les objets graphiques // // // // // // // //

    Button validerButton;
    Button annulerButton;
    Button nextButton;
    RadioButton jmpasCheckButton;
    RadioButton jmCheckButton;
    RadioGroup radioGroup;
    ImageView jeanneDarc;
    ImageView jeanneDarcMatrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /// /// Charge le fichier XML /// ///
        setContentView(R.layout.activity_main);

        // // // // // // // // // // // // Commandes à l'intérieur de la méthode onCreate pour créer des éléments // // // // // // // // // // // //

        /* Définie l'objet TextView avec id "tv" dans la variable voirText
        voirText = (TextView) findViewById(R.id.tv);

        // Change le texte de l'objet TextView dans voirText
        voirText.setText("Toto");
        */

        // Définie le bouton avec id "button" dans la variable validerButton
        validerButton = (Button) findViewById(R.id.validerButton);

        // J'indique au bouton qu'il faut qu'il previenne l'objet que je lui transmets en cas de click
        //this veut dire le fichier courant (MainActivity.java)
        validerButton.setOnClickListener(this);

        annulerButton = (Button) findViewById(R.id.annulerButton);
        annulerButton.setOnClickListener(this);

        nextButton = (Button) findViewById(R.id.nextButtonP1);
        nextButton.setOnClickListener(this);

        jmpasCheckButton = (RadioButton) findViewById(R.id.jenaimepasCheckButton);
        jmpasCheckButton.setOnClickListener(this);

        jmCheckButton = (RadioButton) findViewById(R.id.jaimeCheckButton);
        jmCheckButton.setOnClickListener(this);

        /*
        editText = (EditText) findViewById(R.id.editText);
        editText.setOnClickListener(this);
        */

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnClickListener(this);

        jeanneDarc = (ImageView) findViewById(R.id.imageView);
        jeanneDarc.setOnClickListener(this);

        jeanneDarcMatrix = (ImageView) findViewById(R.id.imageViewM);
        jeanneDarcMatrix.setOnClickListener(this);

    }

    // // // // // // // // // // // // // // Liste des méthodes // // // // // // // // // // // // // //

    // // // // // // // // // // // // // Méthode pour interagir avec les boutons cliqués // // // // // // // // // // //

    @Override
    public void onClick(View v) {

        if (v == nextButton) {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Bienvenue à la deuxième page", Toast.LENGTH_SHORT).show();
        }

        if (v == validerButton) {
            if (jmpasCheckButton.isChecked()) {
                // editText.setText(jmpasCheckButton.getText());
                jeanneDarcMatrix.setVisibility(View.GONE); // Enlève la visibilité de l'élément jeanneDarcMatrix qui est affiché avec une position matrix
                jeanneDarc.setVisibility(View.VISIBLE); // Affiche l'autre image avec position imageCrop
                jeanneDarc.setImageResource(R.drawable.jeanne_d_arc_sad);
                jeanneDarc.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            else if (jmCheckButton.isChecked()) {
                //  editText.setText(jmCheckButton.getText());
                jeanneDarcMatrix.setVisibility(View.GONE);
                jeanneDarc.setVisibility(View.VISIBLE);
                jeanneDarc.setImageResource(R.drawable.jeanne_d_ark_happy); // Définie l'image png happy du dossier drawable dans l'objet jeanneDarc
                jeanneDarc.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            else {
                //  editText.setText("Selectionner un des choix");
                jeanneDarc.setVisibility(View.GONE);
                jeanneDarcMatrix.setVisibility(View.VISIBLE);
                // Ajoute un filtre de couleur au dessus de l'image jeanneDarcMatrix :
                jeanneDarcMatrix.setColorFilter(Color.MAGENTA, PorterDuff.Mode.LIGHTEN); // le PorterDuff.Mode.LIGHTEN diminue l'opacity
            }
        }

        if (v == annulerButton) {
            radioGroup.clearCheck();
            jeanneDarc.setImageResource(R.drawable.jeannedarc);
            jeanneDarc.setVisibility(View.GONE);
            jeanneDarcMatrix.setVisibility(View.VISIBLE);
            jeanneDarcMatrix.clearColorFilter(); // Enlève le filtre de couleur
            //    editText.setText("");

        }
    }

    /// Méthode pour définir la liste des options du menu :

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0, 1, 0, "Crédits (AlertDialog)").setIcon(R.drawable.icon_fate_a).setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.add(0, 1, 0, "Crédits (AlertDialog)");
        menu.add(0, 2, 0, "Heure du RDV (TimePicker)");
        menu.add(0, 3, 0, "Date du RDV (DatePicker)");
        menu.add(0, 4, 0, "Boulangerie");

        return super.onCreateOptionsMenu(menu);
    }

    /// Méthode pour définir ce que font chacune des options du menu :

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case 1: // Dans le menu : Alert Dialog, il faut mettre tout ça pour définir la fenêtre d'alert qui va s'afficher :
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setMessage("Afficher qui est sur l'image");
                alertDialogBuilder.setTitle("Kraken Gallery");
                alertDialogBuilder.setIcon(R.mipmap.ic_launcher); // Définie le petit icon qui remplacera le titre de l'option du menu

                // Déclenche la fonction ci-dessous quand on clique sur le button "ok" :
                alertDialogBuilder.setPositiveButton("ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Il s'agit de :\nJeanne d'Arc de Fate Apocrypha", Toast.LENGTH_LONG).show();
                            }
                        });
                alertDialogBuilder.show(); // Ne pas oublier d'activer l'objet pour qu'il s'affiche.
                break;

            case 2:
                TimePickerDialog timePickerDialog = new TimePickerDialog(this, this, 00, 00, true); // Les "0" correspondent à l'heure de base, le reste faut copier
                timePickerDialog.show();
                break;

            case 3:
                Calendar calendar = Calendar.getInstance();
                // On entre en paramètre, ce que l'on veut pouvoir entrer dans le Date Dialog (ici YEAR, MONTH et DAY_OF_MONTH) :
                DatePickerDialog datePickerDialog = new DatePickerDialog(this, this,
                        calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
                break;

            case 4:
                Intent intent = new Intent(this, BoulangerieActivity.class); // Pour créer un nouveau lien vers une autre "page"
                startActivity(intent);

                Toast.makeText(this, "Bienvenue à la Boulangerie", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /// Méthode pour gérer les valeurs entrées dans le TimePicker :

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        Toast.makeText(this, "Tu as rdv avec Jeanne à " + hourOfDay + " h " + minute, Toast.LENGTH_LONG).show(); // Affiche un message pop-up bref
    }

    /// Méthode pour gérer les valeurs entrées dans le DatePicker :

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        Toast.makeText(this, "Ton rdv avec Jeanne est pour le : " + dayOfMonth + "/" + (++month) + "/" + year, Toast.LENGTH_SHORT).show();
    }


}












