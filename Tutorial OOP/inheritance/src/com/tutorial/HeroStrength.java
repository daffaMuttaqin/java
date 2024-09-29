package com.tutorial;

public class HeroStrength extends Hero {
    String type = "Strength";

    HeroStrength(String nameInput, double attackInput, double healthInput ){
        super(nameInput, attackInput, healthInput);
    }

    @Override
    void display() {
        super.display();
        System.out.println("Type : " + type);
    }
    
    @Override
    void takingDamage(double damage) {
        System.out.println(this.name + " take damage " + damage + " -> " + damage*0.5);
        this.health = this.health - damage*0.5;
    }
    
}
