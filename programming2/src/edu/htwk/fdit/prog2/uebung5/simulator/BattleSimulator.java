package edu.htwk.fdit.prog2.uebung5.simulator;

import edu.htwk.fdit.prog2.uebung5.monsters.Being;

import java.util.Scanner;

public class BattleSimulator {

    private static final Scanner PAUSE = new Scanner(System.in);
    private static final int MAX_TURNS = 10;

    private BattleSimulator() { /* No Instance. */ }

    public static void battle(Being attacker, Being defender) {
        int turn = 0;
        String message;
        int dmg;

        while(turn < MAX_TURNS
                    && attacker.isAlive()
                    && defender.isAlive()
        ) {
            System.out.println(attacker + " greift " + defender + " mit " + attacker.getWeaponText() + " an.");
            dmg = attacker.attack(defender);
            message = damageMessage(dmg);
            System.out.println(attacker + message  + defender + ".");
            if(defender.isAlive()) {
                System.out.println(defender + " greift " + attacker + " mit " + defender.getWeaponText() + " an.");
                dmg = defender.attack(attacker);
                message = damageMessage(dmg);
                System.out.println(defender + message + attacker + ".");
            }
            PAUSE.nextLine();
            turn++;
        }
    }

    private static String damageMessage(int damage) {
        if(damage <= 0) {
            return " verfehlt ";
        }
        if(damage <= 3) {
            return " kratzt ";
        }
        if(damage <= 5) {
            return " trifft ";
        }
        return " pulverisiert ";
    }
}
