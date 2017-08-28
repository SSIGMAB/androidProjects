package com.example.algo;

import android.util.Log;

import java.util.Random;

public class ExoEleve {

    public static String getRandomName() {
        String[] name = new String[]{"Arnaud", "Teddy", "Jeremi", "Seb", "Alex", "Antoine", "Adrien", "Jean-Baptiste"};
        return name[new Random().nextInt(name.length)];
    }

    public static void createEleves(Eleve[] tab) {
        for (int i = 0; i < tab.length; i++) {
            tab[i] = new Eleve();
            tab[i].name = getRandomName();
            tab[i].note = new Random().nextInt(21);
        }
    }

    public static void printEleves(Eleve[] tab) {
        for (int i = 0; i < tab.length; i++) {
            Log.w("tag", "Elève n°" + (i + 1) + ", de nom : " + tab[i].name + " et avec comme note : " + tab[i].note + "\n");
        }
    }

    public static void printEleve(Eleve tab) {
        if (tab == null) {
            Log.w("tag", "Pas de meilleur Seb");
        }
        else {
            Log.w("tag", "Elève de nom : " + tab.name + " et avec comme note : " + tab.note + "\n");
        }
    }


    public static Eleve bestSeb(Eleve[] tab) {
        Eleve bestSeb = null;

        for (int i = 0; i < tab.length; i++) {

            if ("Seb".equals(tab[i].name)) { // le .equals équivaut à un == pour des Strings. Mis à l'envers de cette façon, il n'y a plus de risques d'erreur
                if (bestSeb == null || (tab[i].note > bestSeb.note)) {
                    bestSeb = tab[i];
                }
            }
        }
        return bestSeb;
    }

    // // // Pour s'amuser :

    public static void createElevesFun(Eleve[] tab) {
        String[] name = new String[]{"Arnaud", "Teddy", "Jeremi", "Seb", "Alex", "Antoine", "Adrien", "Jean-Baptiste"};
        int p = 0;
        for (int y = 0; y < name.length; y++) {
            tab[p] = new Eleve();
            tab[p].name = name[y];
            tab[p].note = new Random().nextInt(21);
            p++;
        }
    }

    public static Eleve bestEleve(Eleve[] tab){
        Eleve bestEleve = null;
        for (int i = 0; i < tab.length; i++){
            if (bestEleve == null || (tab[i].note > bestEleve.note)){
                bestEleve = tab[i];
            }
        }
        return bestEleve;
    }
}
