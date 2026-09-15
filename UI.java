import java.util.ArrayList;
import java.util.Scanner;

public class UI {
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

        if (player.getLevel() >= 5){
            System.out.println("--------------------");
            System.out.println("BOSS FIGHT AVAILABLE!");
            System.out.println("--------------------");
        }

        switch(operation){
            case 1 ->{
                if (enemies.isEmpty()){
                    System.out.println("There are no enemies here!");
                    enemies.addAll(EnemySpawning.createEnemies(player));
                }
                else{
                    if(Combat.fight(enemies.get(0), player)){
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
}
