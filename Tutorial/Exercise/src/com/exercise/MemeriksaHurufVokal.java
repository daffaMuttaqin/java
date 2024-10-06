package com.exercise;

public class MemeriksaHurufVokal {
    char input;

    void periksa(){
        if (this.input == 'a') {
            System.out.println("true");
        } else if (this.input == 'i') {
            System.out.println("true");
        } else if (this.input == 'u') {
            System.out.println("true");
        } else if (this.input == 'e') {
            System.out.println("true");
        } else if (this.input == 'o') {
            System.out.println("true");
        } else if (this.input == 'A') {
            System.out.println("true");
        } else if (this.input == 'I') {
            System.out.println("true");
        } else if (this.input == 'U') {
            System.out.println("true");
        } else if (this.input == 'E') {
            System.out.println("true");
        } else if (this.input == 'O') {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public MemeriksaHurufVokal(char input) {
        this.input = input;
    }

    
}
