package com.example.algo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textAfficher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textAfficher = (TextView) findViewById(R.id.textAfficher);
        textAfficher.setText("La plus haute valeur est " + max(626, 66, 6, 1218));
        //boucle();
        String exempleString = "abracadabra1zizi";
        textAfficher.append("\nIl y a " + nbLettreA(exempleString) + " fois la lettre a dans le mot " + exempleString); // append ajoute du texte au textView
        textAfficher.append("\nC'est dans l'ordre alphabétique : " + triAlphabet("alu")); // le \n va à la ligne
        textAfficher.append("\nLa lettre la plus grande est écrite " + occurenceHighChar(exempleString) + " fois");
        textAfficher.append("\nLe dernier a est à la position : " + positionDernier(exempleString));
        textAfficher.append("\nLa somme des lettres en ASCII est égale à : " + sommeDesLettres(exempleString));
        textAfficher.append("\nLe mot sans voyelles est : " + removeVoyelle("abracadabra"));
        textAfficher.append("\nLe mot à l'envers est : " + reverse("abracadabra"));
        textAfficher.append("\nLe mot n'a que des minuscules : " + isMinuscule("Fouck"));
        textAfficher.append("\nLe nombre de minuscules est de : " + nbreMinuscule("Fouck"));

        De dale = new De();
        Log.w("tag","La valeur du dé est : "+dale.getValue());
        dale.lancer();
        Log.w("tag","La valeur du dé est : "+dale.getValue());

        /*Eleve[] tabEleves = new Eleve[8];
        Eleve bestSeb;
        ExoEleve.createElevesFun(tabEleves);
        ExoEleve.printEleves(tabEleves);
        ExoEleve.bestSeb(tabEleves);
        bestSeb = ExoEleve.bestEleve(tabEleves);
        ExoEleve.printEleve(bestSeb);*/

        /*Maison[] tabMaison = new Maison[5];
        Maison maison;
        ExoMaison.createMaisons(tabMaison);
        ExoMaison.printMaisons(tabMaison);
        maison = ExoMaison.bigMaison(tabMaison);
        ExoMaison.printMaison(maison);
        Log.w("tag", "La surface totale de toutes les maisons est de : "+ExoMaison.somme(tabMaison)+" m²");
        Log.w("tag", "La surface moyenne de toutes les maisons est de : "+ExoMaison.moyenne(tabMaison)+" m²");*/

        /*int[] tab1 = new int[10];
        int[] tab2 = new int[10];
        int[] tab3;*/
        //ArrayUtils.fillTab(tab1);
        //ArrayUtils.printTab(tab1);
        //ArrayUtils.triTabCroissant(tab1);
        //ArrayUtils.printTab(tab1);
        /*ArrayUtils.fillTab(tab2);
        ArrayUtils.printTab(tab2);*/
        // ArrayUtils.test1000Tri();
        /*tab3 = ArrayUtils.fusion(tab1, tab2);
        ArrayUtils.printTab(tab3);
        Log.w("tag", "Valeur max = "+ArrayUtils.getMax(tab1));
        Log.w("tag", "Somme = "+ArrayUtils.somme(tab1));
        Log.w("tag", "Moyenne = "+ArrayUtils.moyenne(tab1));
        ArrayUtils.maxValue(tab1);
        Log.w("tag", "Occurence valeur max = "+ArrayUtils.occurenceValueMaxBis(tab1));*/

    }

    /// Méthode qui retourne le paramètre le plus grand

    int max(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        }
        else if (b >= c) {
            return b;
        }
        else {
            return c;
        }
    }

    /// Méthode qui retourne le paramètre le plus grand (avec la méthode au dessus et une écriture simplifiée).

    int max(int a, int b, int c, int d) {
        return d >= max(a, b, c) ? d : max(a, b, c); // <=> if (d >= max(a,b,c)){ return d;} else return max(a,b,c);
    }

    /// Méthode avec des boucles qui ne retourne rien mais qui affiche la liste des nombres divisible par 47 entre 1 et 10 000

    void boucle() {
        for (int i = 1; i <= 10000; i++) {
            if (i % 47 == 0) {
                Log.w("tag", "" + i);
            }
        }

        // // Boucle qui trouve le premier nombre qui est divisible par 7, par 11 et par 5 puis dont la somme avec le nombre précédent donne 1 en reste pour la
        // division par 36.

        int i = 1;
        while (true) {
            if (i % 7 == 0 && i % 11 == 0 & i % 5 == 0) {
                if ((i + (i - 1)) % 36 == 1) {
                    Log.w("tag", "La valeur demandée est " + i);
                    return; // Sert à sortir de la boucle infinie
                }
            }
            i++;
        }
    }

    /// Méthode qui compte le nombre de "a" dans le string donné en paramètre.

    int nbLettreA(String maChaine) {
        int taille = maChaine.length();
        int compteur = 0;
        for (int i = 0; i < taille; i++) {
            if (maChaine.charAt(i) == 'a') {
                compteur++;
            }
        }
        return compteur;
    }

    /// Méthode qui retourne un true si la chaine de caractère entrée en paramètre est dans l'ordre alphabétique.

    boolean triAlphabet(String maChaine) {
        int taille = maChaine.length();

        for (int i = 0; i < taille - 1; i++) {
            if (maChaine.charAt(i) > maChaine.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /// Méthode qui trouve le caractère le plus haut (le plus proche de z) et retourne le nombre d'occurence de ce caractère au sein du paramètre

    int occurenceHighChar(String maChaine) {
        int taille = maChaine.length();
        char highCharac = 'a';
        int compteur = 0;
        for (int i = 0; i < taille; i++) {
            if (highCharac == maChaine.charAt(i)) {
                compteur++;
            }
            if (maChaine.charAt(i) > highCharac) {
                highCharac = maChaine.charAt(i);
                compteur = 1;
            }
        }
        return compteur;
    }

    /// Méthode qui donne la position du dernier "a" dans le mot donné en paramètre (en partant de la fin)

    int positionDernier(String maChaine) {
        int taille = maChaine.length();
        for (int i = taille - 1; i >= 0; i--) {
            if (maChaine.charAt(i) == 'a') {
                return i;
            }
        }
        return 0;
    }

    /// Méthode qui calcule le code Ascii total de la chaine de caractère entrée en paramètre.

    int sommeDesLettres(String maChaine) {
        int somme = 0;
        for (int i = 0; i < maChaine.length(); i++) {
            somme += maChaine.charAt(i);
        }
        return somme;
    }

    // Méthode pour retirer les voyelles d'une chaine de caractère
    String removeVoyelle(String maChaine) {
        String sansVoyelles = "";
        for (int i = 0; i < maChaine.length(); i++) {
            if (maChaine.charAt(i) == 'a' || maChaine.charAt(i) == 'e' || maChaine.charAt(i) == 'i' || maChaine.charAt(i) == 'o' || maChaine.charAt(i) == 'u') {
                // On ne met rien dedans pour que ce soit les consonnes que l'on rajoute dans la variable à retourner
                // Pour comparer des char, il faut utiliser les guillements simples, pour un String, ce sont les doubles guillemets
            }
            else {
                sansVoyelles += maChaine.charAt(i);
            }
        }
        return sansVoyelles;
    }

    // Méthode pour inverser une chaine de caractère de toto en otot par exemple
    String reverse(String maChaine) {
        String envers = "";
        for (int i = maChaine.length() - 1; i >= 0; i--) {
            envers += maChaine.charAt(i);
        }
        return envers;
    }

    // Méthode qui retourne true s'il n'y a que des minuscules ou false s'il y a au moins une Majuscule
    boolean isMinuscule(String maChaine) {
        for (int i = 0; i < maChaine.length(); i++) {
            if (maChaine.charAt(i) < 'a' || maChaine.charAt(i) > 'z') { // le code ASCII des lettres minuscules se suivent
                return false;
            }
        }
        return true;
    }

    int nbreMinuscule(String maChaine) {
        int compteur = 0;
        for (int i = 0; i < maChaine.length(); i++) {
            if (maChaine.charAt(i) > 'a' && maChaine.charAt(i) < 'z') {
                compteur++;
            }
        }
        return compteur;
    }

    //
}
