import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Player createPlayer(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("The username must be within the range of 8-32 characters");
        System.out.println("Choose your username: ");
        String name = scanner.nextLine();
        while(name.length() < 8 || name.length() > 32){
            System.out.println("Insert a proper username!");
            name = scanner.nextLine();
        }
        return new Player(name);
    }

    public static boolean fight(Enemy enemy, Player player){
        while (player.getHp() > 0 && enemy.getHp() > 0){
            int damage = player.dealDamage();
            enemy.takeDamage(damage);

            System.out.println(player.getName() + " dealt " + damage + " damage to " + enemy.getName() + "!");

            if (enemy.getHp() <= 0){
                System.out.println(player.getName() + " has defeated the " + enemy.getName() + "!");
                player.gainXp(enemy.getXp());
                return true;
            }

            damage = enemy.dealDamage();
            player.takeDamage(damage);

            System.out.println("The enemy " + enemy.getName() + " dealt " + damage + " Damage to you!");

            if (player.getHp() <= 0){
                System.out.println(player.getName() + " was defeated by " + enemy.getName() + "!");
                return false;
            }
        }
        return false;
    }

    public static void showStats(Player player){
        System.out.println(player.getName() + "'s level is: " + player.getLevel());
        System.out.println(player.getName() + "'s Xp is: " + player.getXp());
        System.out.println(player.getName() + "'s Max Hp is: " + player.getMaxHp());
        System.out.println(player.getName() + "'s Strength is: " + player.getStrength());
    }

    public static void main_menu(Player player, ArrayList<Enemy> enemies){
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Menu ---");
        System.out.println("1. Fight");
        System.out.println("2. Show player stats");
        System.out.println("3. Quit");
        System.out.println("------------");
        System.out.println("Choose the operation (1-3): ");

        int operation = scanner.nextInt();

        switch(operation){
            case 1 ->{
                if (enemies.isEmpty()){
                    System.out.println("There are no enemies here!");
                    enemies.addAll(createEnemies(player));
                }
                else{
                    if(fight(enemies.get(0), player)){
                       enemies.remove(0); 
                    }
                }
            }
            case 2 ->{
                showStats(player);
            }
            case 3 ->{
                System.out.println("Goodbye!");
            }
        }
    }

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
            else{
                enemies.add(new Enemy("Zombie", player, 1));
            }
        }

        return enemies;
    }

    public static void main(String[] args){
        Player player = createPlayer();

        Item sword = new Item("Sword");
        Item healing_potion = new Item("Healing Potion");
        
        // Starting inventory
        player.addItem(sword);
        player.addItem(healing_potion);
        player.addItem(healing_potion);

        ArrayList<Enemy> enemies = createEnemies(player);

        while (player.getHp() > 0){
            main_menu(player, enemies);
        }
    }
}