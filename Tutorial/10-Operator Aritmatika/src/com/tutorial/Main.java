package com.tutorial;

public class Main {
    public static void main(String[] args){
        int variable1 = 12;
        int variable2 = 5;
        int hasil;

        // 1.Penjumlahan
        hasil = variable1 + variable2;
        System.out.printf("%d + %d = %d\n",variable1,variable2,hasil);

        // 2.Pengurangan
        hasil = variable1 - variable2;
        System.out.printf("%d - %d = %d\n",variable1,variable2,hasil);

        // 3.Perkalian
        hasil = variable1 * variable2;
        System.out.printf("%d x %d = %d\n",variable1,variable2,hasil);

        // 4.Pembagian
        hasil = variable1 / variable2;
        System.out.printf("%d : %d = %d\n",variable1,variable2,hasil);

        // 5.Modulus
        hasil = variable1 % variable2;
        System.out.printf("%d %% %d = %d\n",variable1,variable2,hasil);
    }
}
