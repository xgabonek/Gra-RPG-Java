import java.util.ArrayList;

public class EnemySpawning {
    public static ArrayList<Enemy> createEnemies(Player player){
    ArrayList<Enemy> enemies = new ArrayList<>();
    for (int i = 0; i < player.getLevel(); i++){
        double chance = Math.random() * 4;
        if (chance <= 2){
            enemies.add(new Enemy("Skeleton", player, 2));
        }
        else if (chance <= 3){
            enemies.add(new Enemy("Zombie", player, 1));
        }
    }
    return enemies;
    }
}
