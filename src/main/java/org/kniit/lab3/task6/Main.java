package main.java.org.kniit.lab3.task6;

abstract class Player{
    String name;
    int current_health = 100, max_health = 100, posX = 0, posY = 0, attackDamage = 15, protection = 10;
    boolean alive;
    void heal(int amount){
        this.current_health = Math.min(current_health + amount, max_health);
        System.out.println(name + " исцелился на " + amount + " единиц. Текущее здоровье: " + this.current_health);
    }
    void harm(int amount){
        if (this.current_health == 0){
            System.out.println(name + " уже мёртв.");
            return;
        }
        int prev_h = this.current_health, prev_p = this.protection;
        if (amount > protection){
            this.current_health = Math.max(0, current_health + protection - amount);
            this.protection = 0;
        }
        else{
            this.protection -= amount;
        }
        System.out.println(name + " получил урон " + amount + " единиц. Защита была " + prev_p + ", теперь " + this.protection + ". Здоровье было " + prev_h + ", теперь " + this.current_health);
        if (this.current_health == 0){
            System.out.println(name + " погиб ;(");
            this.alive = false;
        }
    }
    void move(int newX, int newY){
        System.out.println(name + " переместился с позиции " +  posX + ", " + posY + " на " + newX + ", " + newY);
        this.posX = newX;
        this.posY = newY;
    }

}

class Mage extends Player{
    public Mage(String name){
        this.name = name;
    }
    void lightning_bolt(Player player){
        System.out.println(name + " применил заклинание молнии на " + player.name);
        player.harm(attackDamage);
    }
}

class Priest extends Player{
    int healPower = 10;
    public Priest(String name){
        this.name = name;
    }
    void heal(Player player){
        if (player.current_health == 0){
            System.out.println(name + " попытался исцелить " + player.name + ", но было уже слишком поздно");
            return;
        }
        if (player != this){
            System.out.println(name + " применил исцеление на " + player.name);
            player.heal(healPower);
        }
        else{
            System.out.println(name + " попытался исцелить себя... Так делать нельзя");
        }
    }
}

class Warrior extends Player{
    void attack(Player player){
        if (this.current_health == 0){
            System.out.println(name + " попытался атаковать, но не смог, так как уже погиб");
            return;
        }
        System.out.println(name + " атаковал игрока " + player.name);
        player.harm(attackDamage);
    }
}

class WarriorTank extends Warrior{
    private int additionalProtection = 12;

    public WarriorTank(String name) {
        this.name = name;
        this.protection += additionalProtection;
    }
}


public class Main {
    public static void main(String[] args) {
        WarriorTank warrior = new WarriorTank("Some Ork");
        warrior.attackDamage = 17;
        Mage mage = new Mage("Some mage");
        Priest priest = new Priest("Some Healer");
        warrior.attack(mage);
        priest.heal(mage);
        mage.lightning_bolt(warrior);
        mage.lightning_bolt(warrior);
        mage.lightning_bolt(warrior);
        mage.lightning_bolt(warrior);
        priest.heal(warrior);
        mage.lightning_bolt(warrior);
        mage.lightning_bolt(warrior);
        mage.lightning_bolt(warrior);
        warrior.attack(warrior);
        warrior.attack(warrior);
        warrior.attack(warrior);
        warrior.attack(warrior);
        priest.heal(warrior);
        mage.lightning_bolt(priest);
        mage.lightning_bolt(priest);
        mage.lightning_bolt(priest);
        mage.lightning_bolt(priest);
        mage.lightning_bolt(priest);
        mage.move(123, 250);
    }
}
