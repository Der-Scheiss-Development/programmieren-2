package edu.htwk.fdit.prog2.uebung5.monsters;

public abstract class Being {

    private static final String STANDARD_WEAPON_TEXT = "großen Klauen";

    private String name;

    private String weaponText;

    private int hp;
    private int maxHp;
    private int damage;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setWeaponText(String text) {
        if(text == null || "".equals(text)) {
            this.weaponText = STANDARD_WEAPON_TEXT;
        }
        this.weaponText = text;
    }

    public String getWeaponText() {
        return this.weaponText;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public boolean isDead() {
        return !isAlive();
    }

    protected int receiveDamage(Being source, int dmg) {
        this.hp -= dmg;
        if(this.hp < 1) {
            this.die(source);
        }
        return dmg;
    }

    public void die() {
        die(this);
    }

    public abstract void die(Being killer);
    public abstract String getName();
    public abstract void setName(String name);
    public abstract int attack(Being defender);

}
