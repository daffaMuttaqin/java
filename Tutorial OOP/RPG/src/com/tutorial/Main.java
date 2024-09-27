package com.tutorial;

// Player
class Player{
    String name;
    double health;

    // Memanggil class weapon
    Weapon weapon;
    Armor armor;

    // Constructor
    Player(String name, double health){
        this.name = name;
        this.health = health;

    }

    // Method

    void attack(Player opponent){
        System.out.println(this.name + " attacking " + opponent.name + " with power " + this.weapon.attackPower);

        opponent.defense(this.weapon.attackPower);
    }

    void defense(double attackPower){
        // Menghitung damage
        double damage;
        if (this.armor.defensePower < attackPower){
            damage = attackPower - this.armor.defensePower;
        } else {
            damage = 0;
        }

        this.health -= damage;
        System.out.println(this.name + " gets damage " + damage);
    }

    void equipWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    void equipArmor(Armor armor){
        this.armor = armor;
    }

    void display(){
        System.out.println("Name : " + this.name);
        System.out.println("Health : " + this.health + " HP");
        this.weapon.display();
        this.armor.display();
        System.out.print("\n");
    }
}

// Weapon
class Weapon{
    String name;
    double attackPower;

    Weapon(String name, double attackPower){
        this.name = name;
        this.attackPower = attackPower;
    }

    void display(){
        System.out.println("Weapon  : " + this.name + " , Power : " + this.attackPower);
    }
}

// Armor
class Armor{
    String name;
    double defensePower;

    Armor(String name, double defensePower){
        this.name = name;
        this.defensePower = defensePower;
    }

    void display(){
        System.out.println("Armor  : " + this.name + " , Defense : " + this.defensePower);
    }

}

public class Main {
    public static void main(String[] args) {

        // Membuat Object Player
        Player player1 = new Player("Budi", 100);
        Player player2 = new Player("Salman", 80);

        // Membuat Object Weapon
        Weapon sword = new Weapon("Sword", 15);
        Weapon knife = new Weapon("Knife", 10);
        Weapon pistol = new Weapon("Pistol", 25);

        // Membuat Object Armor
        Armor steelArmor = new Armor("Steel Armor", 10);
        Armor woodArmor = new Armor("Wood Armor", 5);
        Armor tshirt = new Armor("T-Shirt", 0);
        
        // Equip Weapon
        player1.equipWeapon(sword);
        player1.equipArmor(steelArmor);
        player2.equipWeapon(pistol);
        player2.equipArmor(woodArmor);

        // player1.weapon.display();
        // player1.armor.display();

        // Display
        player1.display();
        player2.display();

        System.out.println("\nPERTEMPURAN\n");
        System.out.println("Episode 1\n");
        player1.attack(player2);
        player1.display();
        player2.display();
        System.out.println("\nEpisode 2\n");
        player2.attack(player1);
        player1.display();
        player2.display();

    }
}
