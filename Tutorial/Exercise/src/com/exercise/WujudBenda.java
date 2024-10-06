package com.exercise;

public class WujudBenda {
    int bilanganRil;

    void hitung(){
        if (this.bilanganRil <= -150 || this.bilanganRil >=150){
            System.out.println("berwujud non cair");
        } else{
            if (this.bilanganRil >= 0 && this.bilanganRil <= 100) {
                System.out.println("berwujud cair");
            } else{
                System.out.println("berwujud non cair");
            }
        }
    }

    WujudBenda(int input1){
        this.bilanganRil = input1;
    }
}
