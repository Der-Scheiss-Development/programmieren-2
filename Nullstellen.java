public class Nullstellen {
    public static void main(String[] args) {
        //Definition
        double a,b,c,ergebnis1,ergebnis2,rundung1,rundung2;
        a = -1;
        b = 2;
        c = 3;

        //Mitternachtsformel
        double sqrt = Math.sqrt(Math.pow(b, 2) - 4 * a * c);
        ergebnis1 = (-b + sqrt) / 2*a;
        ergebnis2 = (-b - sqrt) / 2*a;

        //Rundung
        rundung1 = Math.round(ergebnis1*100.0)/100.0;
        rundung2 = Math.round(ergebnis2*100.0)/100.0;

        //Ausgabe
        if (Double.isNaN(ergebnis1) && Double.isNaN(ergebnis2)) {
            System.out.println("Es gibt keine reellen Nullstellen.");
        } else if (rundung1 == rundung2) {
            System.out.println("x1 = " + rundung1);
        } else if (ergebnis1 != ergebnis2) {
            System.out.println("x1 = " + rundung1 + ", " + "x2 = " + rundung2);
        } else {
            System.out.println("How did you get here?");
            System.out.println("Die Funktion hat immer noch keine Nullstellen.");
        }
    }
}