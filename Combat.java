public class Combat{
    public static boolean fight(Enemy enemy, Player player){
    while (player.getHp() > 0 && enemy.getHp() > 0){
        int damage = player.dealDamage();
        enemy.takeDamage(damage);
        System.out.println(player.getName() + " dealt " + damage + " damage to " + enemy.getName() + "!");
        if (enemy.getHp() <= 0){
            System.out.println(player.getName() + " has defeated the " + enemy.getName() + "!");
            player.gainXp(enemy.getXp());
            System.out.println("You have gained " + enemy.getXp() + " xp!");
            player.gainGold(enemy.getGold());
            System.out.println("You have gained " + enemy.getGold() + " gold!");
            return true;
        }
        damage = enemy.dealDamage();
        player.takeDamage(damage);
        System.out.println("The enemy " + enemy.getName() + " dealt " + damage + " Damage toyou!");
        if (player.getHp() <= 0){
            System.out.println(player.getName() + " was defeated by " + enemy.getName() + "!");
            return false;
        }
    }
    return false;
}
}