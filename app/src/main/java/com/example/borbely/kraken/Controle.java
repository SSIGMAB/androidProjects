package com.example.borbely.kraken;

import android.text.Editable;

import java.util.Random;

public class Controle {

    // Retourne true si le mot entré en paramètre est un palindrome, false si ce n'est pas le cas.
    public static boolean isMirror(Editable t) {

        int length = t.length();
        int i, begin, end, middle;

        begin = 0;
        end = length - 1;
        middle = (begin + end) / 2;
        if (length == 0) {
            return true;
        }
        else {
            for (i = begin; i <= middle; i++) {
                if (t.charAt(begin) == t.charAt(end)) {
                    begin++;
                    end--;
                }
                else {
                    break;
                }
            }
            if (i == middle + 1) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    // Retourne la moyenne des 4 chiffres
    public static double moyenne(int a, int b, int c, int d) {
        double total = (a + b + c + d) / 4;
        return total;
    }

    // Retourne un chiffre aléatoire compris entre 10 et 100 inclus
    // et qui est pair.
    public static int aleatoirePaire10_100() {
        int nbRandom = new Random().nextInt(41)+10; // la valeur dans le nextInt est la valeur max non incluse du Random la valeur min est 0 si non précisé.
        // En ajoutant 10 après, cela crée un random entre 10 et 50 inclus.
        nbRandom *= 2; // En multipliant par deux, on est sur que le chiffre soit paire.
        return nbRandom;
    }
}
