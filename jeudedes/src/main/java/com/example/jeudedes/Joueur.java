package com.example.jeudedes;


public class Joueur {
    private String nom;
    private int scorePartie;
    private Gobelet g1;

    public Joueur() {
        g1 = new Gobelet();
    }

    public void lancer(){
        g1.lancer();
    }

    public void ajouter1Pts(){
        scorePartie++;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getScorePartie() {
        return scorePartie;
    }

    public void setScorePartie(int scorePartie) {
        this.scorePartie = scorePartie;
    }

    public Gobelet getG1() {
        return g1;
    }

    public void setG1(Gobelet g1) {
        this.g1 = g1;
    }
}
