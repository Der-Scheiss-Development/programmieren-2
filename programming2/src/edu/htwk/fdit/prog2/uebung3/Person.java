package edu.htwk.fdit.prog2.uebung3;
import java.time.*;

public class Person extends Object {

    private String nachname;
    private String vorname;
    private Integer geburtsTag;
    private Integer geburtsMonat;
    private Integer geburtsJahr;
    private LocalDate vgeburtstag;
    private Address address;
    private BankAccount bankAccount;

    public Person(String nachname, String vorname, Integer geburtsTag, Integer geburtsMonat, Integer geburtsJahr, Address address, BankAccount bankAccount) {
        this.nachname = nachname;
        this.vorname = vorname;
        this.geburtsJahr = geburtsJahr;
        this.geburtsMonat = geburtsMonat;
        this.geburtsTag = geburtsTag;
        this.vgeburtstag = LocalDate.of(geburtsJahr,geburtsMonat,geburtsTag);
        this.address = address;
        this.bankAccount = bankAccount;
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

    @Override
    public String toString() {
        return this.nachname + " *(" + this.geburtsTag + "." + this.geburtsMonat + "." + this.geburtsJahr + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if(! (obj instanceof Person)) {
            return false;
        }
        if(obj == null) {
            return false;
        }

        if(this == obj) {
            return true;
        }

        Person other = (Person) obj;

        return this.nachname.equals(other.nachname) && this.geburtsTag == other.geburtsTag;
    }
}