package edu.htwk.fdit.prog2.uebung5.monsters;

public class Monster extends Being {

    public Monster(int maxHp, int damage) {
        this.setMaxHp(maxHp);
        this.setHp(maxHp);
        this.setDamage(damage);
    }

    @Override
    public void die(Being killer) {
        System.out.println(this + " ist besiegt.");
    }

    @Override
    public int attack(Being defender) {
        // TODO absichern
        return defender.receiveDamage(this, this.getDamage());
    }

    @Override
    public String getWeaponText() {
        return "blossen Haenden";
    }

    @Override
    public String getName() {
        // TODO implement
        return null;
    }

    @Override
    public void setName(String name) {
        // TODO implement
    }
}
