import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    Item sword;
    Item health_crystal;
    ArrayList<Item> items;

    public Shop(Player player){
        items = new ArrayList<>();
        sword = new Item("Sword", 4 * player.getLevel(), 0, 0, 35);
        health_crystal = new Item("Health Crystal", 0, 30 * player.getLevel(), 0, 25);

        items.add(sword);
        items.add(health_crystal);
    } 

    public void buyItem(Item item, Player player){
        if (player.getGold() < item.gold){
            System.out.println("You don't have enough gold!");
        }
        else{
            player.setGold(player.getGold() - item.gold);
            player.addItem(item);
            System.out.println("You have bought a " + item.name + "!");
        }
    }

    public void sellItem(Player player){
        Scanner scanner = new Scanner(System.in);
        player.showInventory();
        System.out.println("Select an item to sell:");

        for (int i = 0; i < player.getInventory().size(); i++){
            Item currentItem = player.getInventory().get(i);
            System.out.println((i + 1) + ". " + currentItem.name + " - " + currentItem.gold + "$");
        }

        int choice = scanner.nextInt();
        
        if (choice < 1 || choice > player.getInventory().size()){
            System.out.println("Invalid Choice!");
        }
        
        Item itemToSell = player.getInventory().get(choice - 1);

        int sellPrice = (int)(itemToSell.gold * 0.7);

        player.setGold(player.getGold() + sellPrice);
        player.getInventory().remove(itemToSell);

        System.out.println("Succesfully sold: " + itemToSell + " for: " + sellPrice + "$");
    }
}