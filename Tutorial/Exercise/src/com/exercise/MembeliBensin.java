package com.exercise;

public class MembeliBensin {
    int pilihan;
    float jumlahLiter;
    float premium = 7600.00f;
    float pertamax = 9000.00f;
    float harga = 0;

    void hitung(){
        if (this.pilihan == 1 && (this.jumlahLiter >= 1 || this.jumlahLiter <= 60)) {
            harga = jumlahLiter * pertamax;
            System.out.printf("%.2f", harga);
        } else if(this.pilihan == 2){
            harga = jumlahLiter * premium;
            System.out.printf("%.2f", harga);
        }
    }

    public MembeliBensin(int pilihan, float jumlahLiter) {
        this.pilihan = pilihan;
        this.jumlahLiter = jumlahLiter;
    }

    
}
