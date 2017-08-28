package com.example.jeudedes;

import android.util.Log;

public class Partie {
    private int VALEUR_MIN = 7;
    private int NBR_TOUR = 10;
    private int tourEnCours = 0;
    private Joueur j1, j2;
    private Joueur joueurEnCours;
    private String gagnant;

    public Partie(String nomJ1, String nomJ2) {
        j1 = new Joueur();
        j2 = new Joueur();
        j1.setNom(nomJ1);
        j2.setNom(nomJ2);
    }

    public void lancerJ1(){
        j1.lancer();
        int score= j1.getG1().getScore();
        Log.w("tag", "Score des dés de "+j1.getNom()+" est "+j1.getG1().getD1().getValue()+" et "+j1.getG1().getD2().getValue()+" pour un total de "+j1.getG1().getScore());
        if (score >= VALEUR_MIN) {
            j1.ajouter1Pts();
        }
        joueurEnCours = j2;
    }

    public void lancerJ2(){
        j2.lancer();
        int score= j2.getG1().getScore();
        Log.w("tag", "Score des dés de "+j2.getNom()+" est "+j2.getG1().getD1().getValue()+" et "+j2.getG1().getD2().getValue()+" pour un total de "+j2.getG1().getScore());
        if (score >= VALEUR_MIN) {
            j2.ajouter1Pts();
        }
        tourEnCours++;
        if(isTerminer()){
            Log.w("tag","Le score final est : "+j1.getScorePartie()+ " vs " +j2.getScorePartie());
            Log.w("tag", "Le gagnant est "+gagnant);
        }else joueurEnCours = j1;
    }

    public boolean isTerminer(){
        if (tourEnCours == NBR_TOUR){
            return true;
        }
        return false;
    }

    public String getGagnant() {
        if (j1.getScorePartie() > j2.getScorePartie()){
            gagnant = j1.getNom();
        }else if (j2.getScorePartie()> j1.getScorePartie()){
            gagnant = j2.getNom();
        }else gagnant = "Personne";
        return gagnant;
    }

    public void setGagnant(String gagnant) {
        this.gagnant = gagnant;
    }

    public Joueur getJoueurEnCours() {
        return joueurEnCours;
    }

    public void setJoueurEnCours(Joueur joueurEnCours) {
        this.joueurEnCours = joueurEnCours;
    }

    public int getTourEnCours() {
        return tourEnCours;
    }

    public void setTourEnCours(int tourEnCours) {
        this.tourEnCours = tourEnCours;
    }

    public Joueur getJ1() {
        return j1;
    }

    public void setJ1(Joueur j1) {
        this.j1 = j1;
    }

    public Joueur getJ2() {
        return j2;
    }

    public void setJ2(Joueur j2) {
        this.j2 = j2;
    }
}
