public class Item {
    public String name;
    public int strength;
    public int hp;
    public int armor;
    public double gold;
    public int sell_price;

    public Item(String name, int strength, int hp, int armor, double gold){
        this.name = name;
        this.strength = strength;
        this.hp = hp;
        this.armor = armor;
        this.gold = gold;
    }
}