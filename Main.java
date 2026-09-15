import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        Player player = UI.createPlayer();

        Shop shop = new Shop(player);

        ArrayList<Enemy> enemies = EnemySpawning.createEnemies(player);

        while (player.getHp() > 0){
            UI.main_menu(player, enemies);
        }
    }
}