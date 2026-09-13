public class Enemy {
    private String name;
    private int hp;
    private int maxhp;
    private int level;
    private int strength;
    private int xp;

    public Enemy(String name, Player player, int levelOffset){
        this.name = name;

        this.level = (int)(Math.random() * player.getLevel() + 1 + levelOffset);

        this.maxhp = 50 + (level * 25);
        this.hp = maxhp;

        this.strength = 3 + (level * 2);

        this.xp = 50 * levelOffset;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getHp(){
        return hp;
    }

    public void setHp(int hp){
        this.hp = Math.min(hp, maxhp);
    }

    public int getMaxHp(){
        return maxhp;
    }

    public void setMaxHp(int maxhp){
        this.maxhp = maxhp;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public int getStrength(){
        return strength;
    }

    public void setStrength(int strength){
        this.strength = strength;
    }

    public int getXp(){
        return xp;
    }

    public void setXp(int xp){
        this.xp = xp;
    }

    public int dealDamage(){
        return strength + (int)(Math.random() * 6);
    }

    public void takeDamage(int damage){
        hp -= damage;
        if (hp < 0){
            hp = 0;
        }
    }
}
