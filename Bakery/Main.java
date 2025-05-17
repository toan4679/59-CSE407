/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bakery;

/**
 *
 * @author toan4
 */
import java.util.*;

class SharedData {
    public int max = Integer.MIN_VALUE;
    public int min = Integer.MAX_VALUE;
}

class MyThread extends Thread {
    private int tid;
    private Lock lock;
    private int[] arr;
    private int start, end;
    private SharedData shared;

    public MyThread(int tid, Lock lock, int[] arr, int start, int end, SharedData shared) {
        this.tid = tid;
        this.lock = lock;
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.shared = shared;
    }

    private void CS(int localMax, int localMin) {
        if (localMax > shared.max) shared.max = localMax;
        if (localMin < shared.min) shared.min = localMin;
//        System.out.println("Thread " + tid + " update shared max/min.");
    }

    private void nonCS() {
//        System.out.println("Thread " + tid + " dang lam viec ngoai CS.");
    }

    public void run() {
        int localMax = arr[start];
        int localMin = arr[start];
        for (int i = start + 1; i < end; i++) {
            if (arr[i] > localMax) localMax = arr[i];
            if (arr[i] < localMin) localMin = arr[i];
        }

        lock.requestCS(tid);
        CS(localMax, localMin);
        lock.releaseCS(tid);
        nonCS();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so phan tu mang (N): ");
        int N = sc.nextInt();

        int[] arr = new int[N];
        System.out.println("Nhap cac phan tu:");
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Nhap so luong (K): ");
        int K = sc.nextInt();

        Lock lock = new Bakery(K);
        SharedData shared = new SharedData();

        Thread[] threads = new Thread[K];
        int chunkSize = N / K;
        for (int i = 0; i < K; i++) {
            int start = i * chunkSize;
            int end = (i == K - 1) ? N : (i + 1) * chunkSize;
            threads[i] = new MyThread(i, lock, arr, start, end, shared);
        }

        for (int i = 0; i < K; i++) threads[i].start();
        for (int i = 0; i < K; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Gia tri lon nhat: " + shared.max);
        System.out.println("Gia tri nho nhat: " + shared.min);
    }
}

