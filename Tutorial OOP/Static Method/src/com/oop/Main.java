package com.oop;
import java.util.ArrayList;

class Player{
    private String name;
    private static ArrayList<String> nameList = new ArrayList<String>();
    private static int numberOfAllPlayer;

    Player(String name){
        this.name = name;
        Player.numberOfAllPlayer++;
        Player.nameList.add(this.name);
    }

    public String getName() {
        return name;
    }

    public static ArrayList<String> getNameList() {
        return nameList;
    }
    public static int getNumberOfAllPlayer() {
        return numberOfAllPlayer;
    }

    static void show(){
        System.out.println("Jumlah Playernya adalah : " + getNumberOfAllPlayer());
        System.out.println("Nama Player : " + getNameList());
    }
}


public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("John");
        Player player2 = new Player("Alice");
        Player player3 = new Player("Bob");
        Player player4 = new Player("Abuy");

        Player.show();

    }
}
