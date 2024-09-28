package com.tutorial;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Samsudin");
        Player player2 = new Player();
        player1.show();
        player2.show();
        
        Matematika.tambah(5, 10);
        
        double b;
        b = Matematika.tambah(2, 1.45);
        System.out.println(b);
    }
}
