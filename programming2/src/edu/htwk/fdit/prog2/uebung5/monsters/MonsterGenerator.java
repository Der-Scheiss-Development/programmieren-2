package edu.htwk.fdit.prog2.uebung5.monsters;

import java.util.Random;

public class MonsterGenerator {

    private static final Random rng = new Random();
    // rng.nextInt(5) -> Pseudo-Zufallszahl von 0 bis 4

    private MonsterGenerator() { /* No Instance. */ }

    public static Monster generateDummy() {
        return new Monster(10, 5);
    }

    /*public static Monster generateMonster(Element element, Stufe stufe) {

    }

    public static Monster generateMonster(Element element) {

    }

    public static Monster generateMonster(Stufe stufe) {

    }*/
}
