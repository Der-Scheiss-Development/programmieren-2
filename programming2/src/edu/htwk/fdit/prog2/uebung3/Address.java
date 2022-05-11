package edu.htwk.fdit.prog2.uebung3;

public class Address {
    String strasse;
    String hausnummer;
    String plz;
    String ort;
    String land;

    public Address(String strasse, String hausnummer, String plz, String ort, String land) {
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.ort = ort;
        this.land = land;
    }

    // GET VALUES

    public String getAddress(String strasse, String hausnummer, String plz, String ort, String land) {
        return ("Strasse: " + strasse + " " + hausnummer + ", PLZ: " + plz + ", Ort: " + ort + ", Land: " + land);
    }

    // SET VALUES

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public void setLand(String land) {
        this.land = land;
    }

}