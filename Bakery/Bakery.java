/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bakery;

/**
 *
 * @author toan4
 */
public class Bakery implements Lock {
    private int n;
    private volatile boolean[] choosing;
    private volatile int[] number;

    public Bakery(int n) {
        this.n = n;
        choosing = new boolean[n];
        number = new int[n];
        for (int i = 0; i < n; i++) {
            choosing[i] = false;
            number[i] = 0;
        }
    }

    public void requestCS(int pid) {
        choosing[pid] = true;

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, number[i]);
        }
        number[pid] = max + 1;
        choosing[pid] = false;

        for (int j = 0; j < n; j++) {
            if (j == pid) continue;

            while (choosing[j]); 

            while (number[j] != 0 && 
                (number[j] < number[pid] || 
                (number[j] == number[pid] && j < pid))) {
            }
        }
    }

    public void releaseCS(int pid) {
        number[pid] = 0;
    }
}

