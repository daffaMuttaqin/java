package com.tutorial;


import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner userInput = new Scanner(System.in);
        int panjang, lebar, luas;

        System.out.println("Masukkan Panjang");
        panjang = userInput.nextInt();
        System.out.println("Masukkan Lebar");
        lebar = userInput.nextInt();


        luas = panjang * lebar;
        System.out.println("Luasnya adalah " + luas);

//        int nilaiBenar, nilaiTebakan;
//        boolean statusTebakan;
//        String statusTebakanAnda;
//
//        nilaiBenar = 6;
//        nilaiTebakan = userInput.nextInt();
//
//        statusTebakan = (nilaiTebakan == nilaiBenar);
//
//        if (!statusTebakan){
//            statusTebakanAnda = "salah";
//        }
//        else {
//            statusTebakanAnda = "Benar";
//        }
//        System.out.println("Tebakan anda adalah " + statusTebakanAnda);
    }
}
