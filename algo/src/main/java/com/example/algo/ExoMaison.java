package com.example.algo;

import android.util.Log;

import java.util.Random;

public class ExoMaison {
    public static void createMaisons(Maison[] tab) {
        for (int i = 0; i < tab.length; i++) {
            tab[i] = new Maison();
            tab[i].largeur = new Random().nextInt(1000);
            tab[i].longueur = new Random().nextInt(1000);
        }
    }

    public static void printMaisons(Maison[] tab) {
        for (int i = 0; i < tab.length; i++) {
            Log.w("tag", "Maison n°" + (i + 1) + ", de largeur : " + tab[i].largeur + " et de longueur : " + tab[i].longueur + "\n");
        }
    }

    public static void printMaison(Maison tab) {
        Log.w("tag", "Maison de largeur : " + tab.largeur + " et de longueur : " + tab.longueur + "\n");
    }

    public static Maison bigMaison(Maison[] tab) {
        Maison tampon = null;
        for (int i = 0; i < tab.length; i++) {
            if (tampon == null || (tab[i].longueur * tab[i].largeur) > (tampon.longueur * tampon.largeur)) {
                tampon = tab[i];
            }
        }
        return tampon;
    }

    public static int somme(Maison[] tab) {
        int surface = 0;
        for (int i = 0; i < tab.length; i++) {
            surface += tab[i].largeur*tab[i].longueur;
        }
        return surface;
    }

    public static float moyenne(Maison[] tab) {
        return somme(tab) / (float) tab.length;
    }
}

