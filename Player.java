import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Item> inventory;
    private int level;
    private int xp;
    private int xp_needed;
    private int hp;
    private int maxhp;
    private int strength;
    private double gold;
    
    // Konstruktor
    public Player(String name){
        this.name = name;
        this.inventory = new ArrayList<>();

        this.level = 1;
        this.xp = 0;
        this.xp_needed = 100;
        this.maxhp = 120 + ((level - 1) * 15);
        this.hp = maxhp;
        this.strength = 5 + (level * 2);
        this.gold = 0;
    }

    // Gettery/Settery
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public void levelUp(){
        level++;
        strength += 2;
        maxhp += 20;
        hp = maxhp;
        System.out.println("Leveled up! Your current level is: " + getLevel());
    }

    public int getXp(){
        return xp;
    }

    public void setXp(int xp){
        this.xp = xp;
    }

    public void gainXp(int amount){
        xp += amount;

        if (xp >= xp_needed){
            xp -= xp_needed;
            levelUp();
            xp_needed = (int)(xp_needed * 1.5);
        }
    }

    public int getMaxHp(){
        return maxhp;
    }

    public void setMaxHp(int maxhp){
        this.maxhp = maxhp;
    }

    public int getHp(){
        return hp;
    }

    public void setHp(int hp){
        this.hp = Math.min(hp, maxhp);
    }

    public void takeDamage(int damage){
        hp -= damage;
        if (hp < 0){
            hp = 0;
        }
    }

    public int dealDamage(){
        return strength + (int)(Math.random() * 6);
    }

    public int getStrength(){
        return strength;
    }

    public void setStrength(int strength){
        this.strength = strength;
    }

    public double getGold(){
        return gold;
    }

    public void setGold(double gold){
        this.gold = gold;
    }

    public void gainGold(int amount){
        gold += amount;
    }

    // Inventory Management
    public void addItem(Item item){
        inventory.add(item);
    }

    public void removeItem(Item item){
        inventory.remove(item);
    }

    public ArrayList<Item> getInventory(){
        return inventory;
    }

    public void showInventory(){
        for (Item item : inventory){
            System.out.println(item.name);
        }
    }
}