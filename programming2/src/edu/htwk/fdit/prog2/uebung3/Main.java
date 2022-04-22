package edu.htwk.fdit.prog2.uebung3;

/**
 * In der Main.java wird die Erstellung der einzelnen Objekte geregelt. <br>
 * Als Beispiel wird hier der liebe Heinz, mit seiner Adresse und seinem Bankkonto erstellt und in Verbindung gebracht.
 */

public class Main {
    /**
     * Person person;
     * Address address;
     * BankAccount bankAccount;
    **/

    public static void main(String[] args) {
        Address Address_1 = new Address("Teststraße", "12", "12345", "Testort", "Testland");
        BankAccount BankAccount_1 = new BankAccount("12384", "12345", "KTO123");
        Person Heinz = new Person("Test","Vorname",19,12,1999, Address_1, BankAccount_1);
        System.out.println(Heinz.getGeburtstag());


        System.out.println(Address_1.getAddress(Address_1.strasse, Address_1.hausnummer, Address_1.plz, Address_1.ort, Address_1.land));

        System.out.println(BankAccount_1.getKto() + " " + BankAccount_1.getBlz());
        System.out.println(BankAccount_1.iban);
        System.out.println();
        System.out.println(Heinz.bankAccount.getIban());
        Heinz.bankAccount.setKto("1234456");
        Heinz.setNachname("Hallo");
        Heinz.getNachname();

    }
}