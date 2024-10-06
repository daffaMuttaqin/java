package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Hero hero1 = new Hero("Saitama", 26, "Strength");
        // // hero1.setName("Deku");
        // // hero1.display();
        // System.out.println(hero1.getName());

        String username = "admin";
        String password = "admin123";
        String usernameInput;
        String passwordInput;

        Scanner input = new Scanner(System.in);
        
        for (int i = 0; i < 3; i++) {
            System.out.println("Masukkan Username:");
            usernameInput = input.nextLine();
            System.out.println("Masukkan Password:");
            passwordInput = input.nextLine();
            if (usernameInput.equals(username)) {
                i++;
                if (passwordInput.equals(password)) {
                    i++;
                } else{
                    System.out.println("Password anda salah");
                }
            }else {
                System.out.println("Username anda salah atau tidak terdaftar");
            }
        }

        System.out.println("Selamat Datang");
    }
}