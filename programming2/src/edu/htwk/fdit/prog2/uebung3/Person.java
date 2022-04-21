package edu.htwk.fdit.prog2.uebung3;
import java.time.*;

public class Person {
    String nachname, vorname;
    Integer geburtsTag, geburtsMonat, geburtsJahr;
    LocalDate vgeburtstag;

    public Person(String nachname, String vorname, Integer geburtsTag, Integer geburtsMonat, Integer geburtsJahr) {
        this.nachname = nachname;
        this.vorname = vorname;
        this.geburtsJahr = geburtsJahr;
        this.geburtsMonat = geburtsMonat;
        this.geburtsTag = geburtsTag;
        this.vgeburtstag = LocalDate.of(geburtsJahr,geburtsMonat,geburtsTag);
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setGeburtsTag(Integer geburtsTag, Integer geburtsMonat, Integer geburtsJahr) {
        this.geburtsTag = geburtsTag;
        this.geburtsMonat = geburtsMonat;
        this.geburtsJahr = geburtsJahr;
        this.vgeburtstag = LocalDate.of(geburtsJahr,geburtsMonat,geburtsTag);
    }

    public String getNachname() {
        return nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public String getName() {
        return vorname + " " + nachname;
    }

    public LocalDate getGeburtstag() {
        return vgeburtstag;
    }
}