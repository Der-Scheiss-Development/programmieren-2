package edu.htwk.fdit.prog2.uebung3;

public class BankAccount {
    String iban, bic, blz, kto;

    public BankAccount(String bic, String blz, String kto) {
        this.bic = bic;
        this.blz = blz;
        this.kto = kto;
        this.iban = blz + kto;
    }

    // GET VALUES

    public String getBic() {
        return bic;
    }

    public String getBlz() {
        return blz;
    }

    public String getKto() {
        return kto;
    }

    public String getIban() {
        return iban;
    }

    // SET VALUES

    public void setBic(String bic) {
        this.bic = bic;
    }

    public void setBlz(String blz) {
        this.blz = blz;
    }

    public void setKto(String kto) {
        this.kto = kto;
    }

}