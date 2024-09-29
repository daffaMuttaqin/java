package com.tutorial;

public class Hero {
    String name;
    double attackPower, health;

    // Constructor
    Hero(String nameInput, double attackInput, double healthInput) {
        this.name = nameInput;
        this.attackPower = attackInput;
        this.health = healthInput;
    }

    void attack(Hero enemy){
        System.out.println("\n" + this.name + " attack " + enemy.name);
        enemy.takingDamage(this.attackPower);
        
    }
    
    void takingDamage(double damage){
        System.out.println(this.name + " take damage " + damage);
        this.health = this.health - damage;
    }

    void display(){
        System.out.println("\nName : " + this.name);
        System.out.println("Health : " + this.health);
        System.out.println("Attack : " + this.attackPower);
    }
}
