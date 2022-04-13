package edu.htwk.fdit.prog2.uebung1;

public class Cramer {
    public static void main(String[] args) {
        //Definition
        double a, b, c, d, e, f, x, y;
        a = 3;
        b = 1.52;
        c = 2;
        d = 1.03; //Bei der Änderung des Wertes von 1.02 zu 1.03 ändert sich das Ergebnis und die y Variable hat fast einen geraden Wert.
        e = 1;
        f = 1;

        //Berechnung
        x = (e * d - b * f) / (a * d - b * c);
        y = (a * f - e * c) / (a * d - b * c);

        //Ausgabe
        System.out.println("x: " + x);
        System.out.println("y: " + y);
    }
}