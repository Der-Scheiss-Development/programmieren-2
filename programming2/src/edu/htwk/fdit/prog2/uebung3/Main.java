package edu.htwk.fdit.prog2.uebung3;

import java.time.LocalDate;

public class Main {
    Address address;
    BankAccount bankAccount;
    Person person;

    public static void main(String[] args) {
        LocalDate test = LocalDate.of(1904,12,12);
        Person Heinz = new Person("Test","Vorname",19,12,1999);
        System.out.println(Heinz.geburtsJahr);
        Address Atest = new Address("Teststraße", "12", "12345", "Testort", "Testland");
        System.out.println(Atest.getAddress(Atest.strasse, Atest.hausnummer, Atest.plz, Atest.ort, Atest.land));
    }
}