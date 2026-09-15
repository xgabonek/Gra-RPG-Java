import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        Player player = UI.createPlayer();

        Item sword = new Item("Sword");
        Item healing_potion = new Item("Healing Potion");
        
        player.addItem(sword);
        player.addItem(healing_potion);
        player.addItem(healing_potion);

        ArrayList<Enemy> enemies = EnemySpawning.createEnemies(player);

        while (player.getHp() > 0){
            UI.main_menu(player, enemies);
        }
    }
}