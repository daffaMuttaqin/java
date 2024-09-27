package com.registrasi;

import java.util.Scanner;
import java.util.UUID;

abstract class Display{
    abstract void notification();
    void showToken(UUID token){
        System.out.println("Token generated : " + token);
    }
}

class User extends Display {
    protected String username;
    protected String password;
    protected UUID token;

    void tokenCreation(){
        token = UUID.randomUUID();
    }

    public void register(String username, String password){
        this.username = username;
        this.password = password;
        tokenCreation();
        System.out.println("Username : " + this.username);
        System.out.println("Password : " + this.password);
    }

    public void notification(){
        
        System.out.println("Akun telah berhasil dibuat oleh User");
        showToken(this.token);

    }
}

class Admin extends User{
    private final String role = "Admin";

    @Override
    public void notification() {
        System.out.println("Akun telah berhasil dibuat oleh " + role);
        showToken(this.token);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("REGISTRASI");
        System.out.println("Masukkan Username : ");
        String username = input.nextLine();
        
        System.out.println("Masukkan Password : ");
        String password = input.nextLine();

        // User user1 = new User();
        // user1.register(username, password);
        // user1.notification();

        Admin admin1 = new Admin();
        admin1.register(username, password);
        admin1.notification();
    }
}
