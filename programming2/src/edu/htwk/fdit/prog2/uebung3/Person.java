package edu.htwk.fdit.prog2.uebung3;

public class Person {
    String name, vorname, geburtsTag, geburtsMonat, geburtsJahr, strasse, hausnummer, plz, ort, land, iban, bic, blz, kto;

    public Person() {
        // IT`S EMPTY IN HERE
    }

    public int hashCode() {
        final int prime = 31; // multiplication with 31 is super fast by shifting
        int result = 1;
        result = prime * result + (( name == null) ? 0 : name.hashCode()); // für Strings, -> oder zusammengesetzte Datentypen
        // I NEED CODE
        return result;
    }
}