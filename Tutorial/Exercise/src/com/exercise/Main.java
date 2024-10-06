package com.exercise;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // int suhu = input.nextInt();
        // WujudBenda soal1 = new WujudBenda(inputInt);
        // soal1.hitung();

        // int pilihan = input.nextInt();
        // double jumlahLiter = input.nextDouble();
        // MembeliBensin soal2 = new MembeliBensin(inputInt, inputDouble);
        // soal2.hitung();
        
        // char inputChar = input.next().charAt(0);
        // MemeriksaHurufVokal soal3 = new MemeriksaHurufVokal(inputChar);
        // soal3.periksa();

        int hargaBarang = input.nextInt();
        int jumlahBarang = input.nextInt();
        MendapatkanDiscount soal4 = new MendapatkanDiscount(hargaBarang, jumlahBarang);
        soal4.hitung();

    }
}
