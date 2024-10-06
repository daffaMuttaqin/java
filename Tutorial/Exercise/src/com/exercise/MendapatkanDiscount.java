package com.exercise;

public class MendapatkanDiscount {
    int hargaBarang;
    int jumlahBarang;
    float discount;
    float hargaAkhir;

    void hitung(){
        if (this.jumlahBarang % 3 == 0 && this.jumlahBarang % 4 == 0) {
            hargaAkhir = (float)hargaBarang * (float)jumlahBarang;
            discount = hargaAkhir * 15 / 100;
            hargaAkhir = hargaAkhir - discount;
            System.out.printf("%.2f", hargaAkhir);
        } else {
            hargaAkhir = (float)hargaBarang * (float)jumlahBarang;
            System.out.printf("%.2f", hargaAkhir);
        }
    }
    
    MendapatkanDiscount(int hargaBarang, int jumlahBarang){
        this.hargaBarang = hargaBarang;
        this.jumlahBarang = jumlahBarang;
    }
}
