import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: Jun Zhu
 * @Date: 10/30/2022 11:27 AM
 * @Description: contains a list of hero and current player position
 */
public class Player {
    private List<Hero> heroes;
    private int positionRow;
    private int positionCol;

    public void checkHeroesState(){
        for (Hero hero:heroes){
            hero.printHeroState();
        }
        System.out.println();
    }
    public Player(List<Hero> heroes, int positionRow, int positionCol) {
        this.heroes = heroes;
        this.positionRow = positionRow;
        this.positionCol = positionCol;
        initiateHero();
    }

    public void initiateHero(){
        Database.showDBHeroList();
        Scanner scanner = new Scanner(System.in);
        Set<String> checkDuplicate = new HashSet<>();
        for(int i = 1;i<=Game.heroNum;i++){
            boolean validInput =false;
            int heroNum = 0;
            while (!validInput){
                System.out.println("Enter the index of hero to pick this hero to your team, 0 - 17");
                System.out.println("Pick " + i + " hero");
                String userIndex = scanner.nextLine();
                if (userIndex.matches("[0-9]|(1[0-7])") && !checkDuplicate.contains(userIndex)){
                    checkDuplicate.add(userIndex);
                    heroNum = Integer.parseInt(userIndex);
                    validInput = true;
                }
            }
            this.heroes.add(Database.heroes.get(heroNum));
        }
    }

    public int getPositionRow() {
        return positionRow;
    }

    public void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public int getPositionCol() {
        return positionCol;
    }

    public void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public void printHeroInventory(){
        System.out.println("Inventory list of your hero:");
        for(Hero hero : heroes){
            hero.printInventories();
        }
    }

    public Hero searchHeroByName(String name){
        for (Hero hero:heroes){
            if(hero.getName().equals(name)){
                return hero;
            }
        }
        return null;
    }

}
