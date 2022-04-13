package edu.htwk.fdit.prog2.uebung1;

import java.util.Scanner;

public class Loop {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        int[] a = new int[q];
        int[] b = new int[q];
        int[] n = new int[q];

        for(int i = 0; i < q; ++i) {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
            n[i] = in.nextInt();
        }
        in.close();

        for (int i = 0; i < q; ++i) {

            int ergebnis = a[i] + (int) Math.pow(2, 0) * b[i];
            System.out.printf("%d ", ergebnis);
            for(int j = 1; j < n[i]; ++j) {
                ergebnis += Math.pow(2, j) * b[i];
                System.out.printf("%d ", ergebnis);
            }
            System.out.println();
        }
        in.close();
    }
}