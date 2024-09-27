package com.tutorial;

// Class Player
class Player{
    String name;
    double health;

    //Constructor
    Player(String name, double health){
        this.name = name;
        this.health = health;
    }

    Weapon weapon;
    Armor armor;

    // Method
    void attack(Player opponent){
        double attackPower = this.weapon.attackPower;
        System.out.println(this.name + " attacking " + opponent.name + " with power " + attackPower);

        opponent.defense(attackPower);
    }

    void defense(double attackPower){
        double damage;
        if (this.armor.defensePower < attackPower){
            damage = attackPower - this.armor.defensePower;
        } else {
            damage = 0;
        }
        this.health -= damage;
        System.out.println(this.name + " gets attack " + damage + " damage");
    }
    // Equip
    void equipWeapon(Weapon weapon){
        this.weapon = weapon;
    }
    void equipArmor(Armor armor){
        this.armor = armor;
    }

    // Display
    void display(){
        System.out.println("Name : " + this.name);
        System.out.println("Health : " + this.health + " HP");
        this.weapon.display();
        this.armor.display();
        System.out.print("\n");
    }
}

// Class Weapon
class Weapon{
    String name;
    double attackPower;

    // Constructor
    Weapon(String name, double attackPower){
        this.name = name;
        this.attackPower = attackPower;
    }

    void display(){
        System.out.println("Weapon : " + this.name + ", Attack Power :" + this.attackPower);
    }
}

// Class Armor
class Armor{
    String name;
    double defensePower;

    // Constructor
    Armor(String name, double defensePower){
        this.name = name;
        this.defensePower = defensePower;
    }

    void display(){
        System.out.println("Armor : " + this.name + ", Defense Power :" + this.defensePower);
    }
}

public class Main {
    public static void main(String[] args) {
        // Membuat object Player
        Player player1 = new Player("Abuy", 100);
        Player player2 = new Player("Pon", 100);

        // Membuat Object Weapon
        Weapon sword = new Weapon("Sword", 15);
        Weapon knife = new Weapon("Knife", 10);

        // Membuat Object Armor
        Armor steelArmor = new Armor("Steel Armor", 10);
        Armor woodArmor = new Armor("Wood Armor", 8);

        // Equip Weapon & Armor
        player1.equipWeapon(sword);
        player2.equipWeapon(knife);
        player1.equipArmor(woodArmor);
        player2.equipArmor(steelArmor);

        // Display
        player1.display();
        player2.display();

        System.out.println("PERTEMPURAN");
        System.out.println("\nEPISODE 1\n");
        player1.attack(player2);
        player1.display();
        player2.display();

        System.out.println("\nEPISODE 1\n");
        player2.attack(player1);
        player1.display();
        player2.display();
    }
}
