package edu.htwk.fdit.prog2.uebung3;

public class BankAccount {
    String iban, bic, blz, kto;

    public BankAccount(String bic, String blz, String kto) {
        this.bic = bic;
        this.blz = blz;
        this.kto = kto;
        this.iban = blz + kto;
    }
}