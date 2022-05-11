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
        Address Address1 = new Address("Teststraße", "12", "12345", "Testort", "Testland");
        Address Address2 = new Address("Aasd","asdasd","123123","asdsad","asdasdasdfg");
        BankAccount BankAccount_1 = new BankAccount("12384", "12345", "KTO123");
        BankAccount BankAccount_2 = new BankAccount("1453","12323","123134");
        Person Heinz = new Person("Test","Vorname",19,12,1999, Address1, BankAccount_1);
        Person p = new Person("Hallo","Tschuess",12,11,1234, Address2, BankAccount_2);
        System.out.println(Heinz.getGeburtstag());

        System.out.println(Address1.getAddress(Address1.strasse, Address1.hausnummer, Address1.plz, Address1.ort, Address1.land));

        System.out.println(BankAccount_1.getKto() + " " + BankAccount_1.getBlz());
        System.out.println(BankAccount_1.getIban());
        System.out.println();
        Heinz.setNachname("Hallo");
        Heinz.getNachname();
        Heinz.toString();
    }
}