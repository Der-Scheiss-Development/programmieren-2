package edu.htwk.fdit.prog2.uebung3;

import java.time.LocalDate;

public class Main {
    Address address;
    BankAccount bankAccount;
    Person person;

    public static void main(String[] args) {
        LocalDate test = LocalDate.of(1904,12,12);
        Address Atest = new Address("Teststraße", "12", "12345", "Testort", "Testland");
        BankAccount Btest = new BankAccount("12384", "12345", "KTO123");
        Person Heinz = new Person("Test","Vorname",19,12,1999, Atest, Btest);
        System.out.println(Heinz.getGeburtstag());


        System.out.println(Atest.getAddress(Atest.strasse, Atest.hausnummer, Atest.plz, Atest.ort, Atest.land));


        System.out.println(Btest.getKto() + " " + Btest.getBlz());
        System.out.println(Btest.iban);
        System.out.println();
        System.out.println(Heinz.bankAccount.getIban());

    }
}