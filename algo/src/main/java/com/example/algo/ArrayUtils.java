package com.example.algo;

import android.util.Log;

import java.util.Random;

public class ArrayUtils {

    // Méthode qui remplit un tableau de valeurs comprises entre 0 et 99
    public static void fillTab(int[] tab) {
        for (int i = 0; i < tab.length; i++) {
            tab[i] = new Random().nextInt(100);
        }
    }

    // Méthode qui remplit un tableau de valeurs comprises entre 0 et maxValue
    public static void fillTab(int[] tab, int maxValue) {
        for (int i = 0; i < tab.length; i++) {
            tab[i] = new Random().nextInt(maxValue);
        }
    }

    // Méthode qui affiche les valeurs d'un tableau sur une seule ligne
    public static void printTab(int[] tab) {
        String valeurs = "";
        for (int i = 0; i < tab.length; i++) {
            valeurs = valeurs + tab[i] + " ";
        }
        Log.w("tag", valeurs);
    }

    // Méthode qui trouve la valeur max d'un tableau
    public static int getMax(int[] tab) {
        int valMax = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] > valMax) {
                valMax = tab[i];
            }
        }
        return valMax;
    }

    // Méthode qui calcule la somme des valeurs d'un tableau
    public static int somme(int[] tab) {
        int somme = 0;
        for (int i = 0; i < tab.length; i++) {
            somme += tab[i];
        }
        return somme;
    }

    // Méthode qui calcule la moyenne des valeurs d'un tableau en s'aidant de la méthode somme.
    public static float moyenne(int[] tab) {
        return somme(tab) / (float) tab.length;
    }

    // Méthode qui affiche les valeurs qui sont supérieures à la moyenne dans un tableau
    public static void maxValue(int[] tab) {
        float moyenne = moyenne(tab);
        String valMax = "";
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] > moyenne) {
                valMax = valMax + tab[i] + " ";
            }
        }
        Log.w("tag", "Valeurs sup. à la moyenne : " + valMax);
    }

    // Méthode qui calcule combien il y a de fois la valeur max (avec deux boucles for : 0(2n) )
    public static int occurenceValueMax(int[] tab) {
        int compteur = 0;
        int valMax = getMax(tab);
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == valMax) {
                compteur++;
            }
        }
        return compteur;
    }

    public static int occurenceValueMaxBis(int[] tab) {
        int compteur = 0;
        int valMax = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] > valMax) {
                valMax = tab[i];
                compteur = 1;
            }
            else if (tab[i] == valMax) {
                compteur++;
            }
        }
        return compteur;
    }

    // Méthode qui fusionne deux tableaux en un, l'un après l'autre
    public static int[] fusion(int[] tab1, int[] tab2) {
        int[] tab3 = new int[tab1.length + tab2.length]; // il faut donc créer un troisième tableau de la taille des deux tableaux en paramètres additionnée
        for (int i = 0; i < tab1.length; i++) {
            tab3[i] = tab1[i];
        }
        for (int i = 0; i < tab2.length; i++) {
            tab3[tab1.length + i] = tab2[i];
        }
        return tab3;
    }

    // Méthode qui fusionne les deux tableaux en un et qui trie leurs valeurs dans l'ordre croissant
    public static int[] fusionTri(int[] tab1, int[] tab2) {
        int[] tab3;
        tab3 = fusion(tab1, tab2);
        triTabCroissant(tab3);
        return tab3;
    }

    // Méthode qui trie les valeurs d'un tableau dans l'ordre croissant
    public static int[] triTabCroissant(int[] tab) {
        int tampon = 0;
        int position = 0;
        for (int c = 0; c < tab.length; c++) { // J'enregistre la position de la valeur à changer si un chiffre est plus petit ensuite
            position = c;
            for (int i = c; i < tab.length; i++) { // Je traverse tout le tableau à partir de la position de la première boucle for
                if (tab[i] <= tab[position]) { // J'enregistre la position de la valeur la plus petite
                    position = i;
                }
            }
            tampon = tab[c]; // J'échange les valeurs grace à une variable tampon
            tab[c] = tab[position];
            tab[position] = tampon;
        }
        return tab;
    }

    // Méthode de ouf qui permet de trier dans l'ordre croissant avec une seule boucle for des tableaux qui ont pour valeurs 0, 1 et 2 .
    public static int[] tri012(int[] tab) {
        int d = 0, f = tab.length - 1; // Je crée des variables pour mémoriser les positions au début du tableau (d) et à la fin (f)
        for (int i = 0; i < tab.length; i++) {
            while (tab[i] == 2) { // Grâce au while je peux échanger les valeurs vers la fin du tableau même s'il y avait déjà un 2 à la base.
                if (i > f){ // Cette ligne permet d'arreter le programme une fois que les 2 sont bien triés et ne pas tout remélanger.
                    break;
                } else {
                    tab[i] = tab[f];
                    tab[f] = 2;
                    f--; // Je décrémente à chaque fois la variable qui positionne où je vais envoyer les 2
                }
            }
            if (tab[i] == 0 && d < f) { // Cette condition me permet d'arrêter d'échanger les valeurs une fois que le tri s'est bien fait
                tab[i] = tab[d];
                tab[d] = 0;
                d++; // J'incrémente à chaque fois la variable qui positionne où je vais envoyer mes 0
            }
        }
        return tab;
    }

    public static int[] tri012Jerome(int[] tab){
        int taille = tab.length-1;
        for(int i=taille; i>0; i--){
            int d=tab[i];
            int c=tab[i-1];
            if(d<c){
                tab[i]=c;
                tab[i-1]=d;
                i=taille;
            }
        }
        return tab;
    }

    // Méthode qui vérifie si les valeurs sont bien triées dans l'ordre croissant
    public static boolean verifTri(int[] tab) {
        for (int i = 0; i < tab.length - 1; i++) {
            if (tab[i] > tab[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Méthode qui crée 100 000 tableaux avec 10 valeurs chacun, les trie et vérifie si la méthode tri012 fonctionne bien
    public static void test1000Tri(){
        for (int i=0; i<=100000; i++){
            int[] tab = new int[10];
            int[] tab2 = new int[10];
            fillTab(tab, 3);
            for (int j=0; j<tab.length; j++){ // Je copie les tableaux pour pouvoir comparer ensuite les tableaux triés et non triés.
                tab2[j] = tab[j];
            }
            tri012(tab); // Je ne trie que les premiers tableaux
            if(!verifTri(tab)){ // Si la fonction renvoie des false, certains tableaux ne sont pas bien triés
                printTab(tab2); // ça affiche les tableaux mal triés et ces même tableaux avant d'etre trié.
                printTab(tab);
            }
        }
       Log.w("tag","Tout bon"); // Message orgasmique qui prouve que je suis dabest.
    }


}
