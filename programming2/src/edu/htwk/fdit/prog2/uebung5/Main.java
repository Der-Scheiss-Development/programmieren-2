package edu.htwk.fdit.prog2.uebung5;

import edu.htwk.fdit.prog2.uebung5.monsters.Monster;
import edu.htwk.fdit.prog2.uebung5.monsters.MonsterGenerator;
import edu.htwk.fdit.prog2.uebung5.simulator.BattleSimulator;

public class Main {

    public static void main(String[] args) {
        Monster m1 = new Monster(10, 5);
        //Monster m2 = new Monster(10, 5, "Feuer", new Level("Mook"), ...) kann mit steigender Anzahl von Konstruktor-Argumenten sehr
        // unübersichtlich und umständlich werden; auf der anderen Seite passieren durch eine lange Abfolge von set...()
        // Aufrufen auch leicht Flüchtigkeitsfehler.
        // Möchte man Monster mit bestimmter Eigenschaft erstellen, lohnt es sich ggf. das an eine spezielle
        // Klasse mit entsprechender Methode auszulagern, wie hier:
        Monster m2 = MonsterGenerator.generateDummy();
        BattleSimulator.battle(m1, m2);

    }
}
