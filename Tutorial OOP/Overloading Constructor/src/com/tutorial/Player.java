package com.tutorial;

public class Player {
    private String name;
    private static int jumlahPlayer;

    Player(String name){
        jumlahPlayer++;
        this.name = name;
    }

    public Player() {
        jumlahPlayer++;
        this.name = ("Player" + jumlahPlayer);
    }

    void show(){
        System.out.println(this.name);
    }

    
}
