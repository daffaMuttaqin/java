package com.tutorial;

class Player{
    private String name;
    private int baseHealth;
    private int baseAttack;
    private int actualHealth;
    private Armor armor;
    private Weapon weapon;
    private int level;
    private int incrementHealth;
    private int incrementAttack;
    
    public Player(String name){
        this.name = name;
        this.baseHealth = 500;
        this.baseAttack = 100;
        this.actualHealth = 0;
        this.level = 1;
        this.incrementHealth = 20;
        this.incrementAttack = 20;
    }

    private void levelUp(){
        this.level++;
        System.out.println("Yeaaay " + this.name + " naik ke level " + level);
        System.out.println();
    }

    public void setActualHealth(int actualHealth){
        this.actualHealth = actualHealth;
    }

    public void attack(Player opponent){
        int damage = this.maxAttack();
        
        System.out.println(this.name + " menyerang " + opponent.name + " dengan damage " + damage);
        this.levelUp();
    }

    public void display(){
        System.out.println("Player\t\t: " + this.name);
        System.out.println("Level\t\t: " + this.level);
        System.out.println("Max Health\t: " + maxHealth());
        System.out.println("Actual Health\t: " + getActualHealth());
        System.out.println("Attack\t\t: " + maxAttack());
    }

    public int getActualHealth(){
        return this.baseHealth + this.armor.getAddHealth() + this.level*this.incrementHealth;
    }

    public int getHealth(){
        return this.actualHealth;
    }

    public void setArmor(Armor armor){
        this.armor = armor;
    }
    
    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public int maxHealth(){
        return this.baseHealth + this.armor.getAddHealth() + this.level*this.incrementHealth;
    }

    public int maxAttack(){
        return this.baseAttack + this.weapon.getAddAttack() + this.level*this.incrementAttack;
    }
}

class Weapon{
    private String name;
    private int attack;

    public Weapon(String name, int attack){
        this.name = name;
        this.attack = attack;
    }

    int getAddAttack(){
        return this.attack;
    }
}
class Armor{
    private String name;
    private int strength;
    private int health;

    public Armor(String name, int strength, int health){
        this.name = name;
        this.strength = strength;
        this.health = health;
    }

    public int getAddHealth(){
        return this.strength*10 + this.health;
    }
}

public class Main {
    public static void main(String[] args) {
        
        Player player1 = new Player("Marni");
        Armor armor1 = new Armor("Baju Besi", 5, 100);
        Weapon weapon1 = new Weapon("Pedang", 10);
        player1.setArmor(armor1);
        player1.setWeapon(weapon1);

        Player player2 = new Player("Isabella");
        Armor armor2 = new Armor("Gaun Pesta", 1, 40);
        Weapon weapon2 = new Weapon("Pecut", 40);
        player2.setArmor(armor2);
        player2.setWeapon(weapon2);

        player1.display();
        System.out.println();
        player2.display();
        System.out.println();

        int actualHealth;
        int actualHealth2;

        System.out.println(player1.getHealth());

        while (player1.getHealth() > 0 || player2.getHealth() > 0) {
            int i = 1;
            System.out.println("BABAK KE " + i);
            player1.attack(player2);
            actualHealth = player2.getActualHealth() - player1.maxAttack();
            player2.attack(player1);
            actualHealth2 = player1.getActualHealth() - player2.maxAttack();
            player1.setActualHealth(actualHealth2);
            player2.setActualHealth(actualHealth);

            System.out.println("Darah Marni : " + player1.getHealth());
            System.out.println("Darah Isabella : " + player2.getHealth());
            i++;
            System.out.println("----------------------------");
        }

    }
}
