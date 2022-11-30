import Enums.ForwardType;
import Enums.HeroType;

import java.util.*;

import static Enums.UnitType.*;

/**
 * @Author: Jun Zhu
 * @Date: 10/30/2022 12:22 PM
 * @Description: control the processing of game, initiate map and database first, then start the game.
 */
public class Game {
    private Player player;
    private Map map;

    private int boardSize;

    //record the previous position type of moving position
    private String previousPositionType;

    private int[][] direction = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    private int currentHighestHeroLevel;

    private boolean gameOver;

    public static int heroNum;

    private static final double BASE_INCREASE_RATE = 1.2;
    private static final double FAVORED_INCREASE_RATE = 1.5;

    public Game(){
        initiate();
    }

    public void initiate(){
        // initiate database, in order to ensure program is able to read data from it
        gameOver = false;
        currentHighestHeroLevel = 1;
        new Database();
        previousPositionType = Common_Type.getSymbol();
        Scanner scanner = new Scanner(System.in);
        boolean validBoardSize = false;
        while(!validBoardSize){
            System.out.println("Please enter the size of the map, minimum size is 5 and maximum is 10");
            String boardSize = scanner.nextLine();
            if (boardSize.matches("[5-9]|10")){
                //regex to ensure correct input
                this.boardSize = Integer.parseInt(boardSize);
                validBoardSize = true;
            }
        }
        this.map = new Map(boardSize,new Unit[boardSize][boardSize]);
        boolean validHeroSize = false;
        while (!validHeroSize){
            System.out.println("Please enter the size of the hero in your team, minimum size is 1 and maximum is 3");
            String heroSize = scanner.nextLine();
            if (heroSize.matches("[1-3]")){
                heroNum = Integer.parseInt(heroSize);
                validHeroSize = true;
            }
        }
        this.player = new Player(new ArrayList<>(),0,0);
        startGame();
    }

    public void startGame(){
        playGame();
    }

    public void playGame(){
        String currentPositionType = null;
        Database.printHelpMenu();
        while(true){
            map.printMap();
            System.out.println("Where would you like your team of Heroes to explore? W:North, A:West, D:East, S:south" );
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            switch (userInput){
                case "I":
                    player.checkHeroesState();
                    break;
                case "Q":
                    System.out.println("Exit game, See you next time!");
                    return;
                case "H":
                    Database.printHelpMenu();
                    break;
                default:
                    currentPositionType = movement(userInput);
                    if(currentPositionType != null){
                        if(currentPositionType.equals(Market_Type.getSymbol())){
                            enterMarket();
                            if (this.gameOver){
                                System.out.println("Exit game, See you next time!");
                                return;
                            }
                        }else{
                            Random random = new Random();
                            int randomNum = random.nextInt(2);
                            if(randomNum % 2 == 0){
                                battleMonster();
                                if(gameOver){
                                    System.out.println("Exit game, See you next time!");
                                    return;
                                }
                            }
                        }
                    }
                    break;
            }
        }
    }

    public void enterMarket(){
        int positionCol = player.getPositionCol();
        int positionRow = player.getPositionRow();
        Market market = this.map.getBoardArray()[positionRow][positionCol].getMarket();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println();
            System.out.println("Welcome to market!");
            System.out.println("Enter the name of hero to select that hero to trade with market, or enter X to exit market");
            String userInput = scanner.nextLine();
            if (userInput.equals("X")){
                return;
            }else if(userInput.equals("I")){
                player.checkHeroesState();
                player.printHeroInventory();
            }else if(userInput.equals("H")){
                Database.printHelpMenu();
            } else if(userInput.equals("Q")){
                this.gameOver = true;
                return;
            }else {
                Hero hero = player.searchHeroByName(userInput);
                if (hero==null){
                    System.out.println("Can not find this hero in your team");
                }else{
                    Transaction transaction = new Transaction(hero, market, this.player);
                    boolean exitGame = transaction.processTransaction();
                    if (exitGame){
                        this.gameOver = true;
                        return;
                    }
                }
            }
        }
    }

    /*
     * @Author Jun Zhu
     * @Date  11/9/2022
     * @Param []
     * @return void
     * @Description //process battle with monster, if all heroes dead return 0, if player quit game return 2, unless return 1
     **/
    public void battleMonster(){
        int positionCol = player.getPositionCol();
        int positionRow = player.getPositionRow();
        Unit currentUnit = this.map.getBoardArray()[positionRow][positionCol];
        currentUnit.initiateMonster(currentHighestHeroLevel);
        System.out.println();
        System.out.println("OH NO! Hostile monsters approaching! Prepare for battle!");
        BattleWithMonster bw = new BattleWithMonster(player.getHeroes(),currentUnit.getMonsters(),this.player);
        int battleResult = bw.battleWithMonster();
        if (battleResult == 0){
            System.out.println("All of your hero dead, game over.");
            gameOver = true;
        }else if (battleResult == 1){
            System.out.println();
            System.out.println("Congratulation! Monsters has been beaten by your hero!");
            int monsterSize = player.getHeroes().size();
            for (Hero hero:player.getHeroes()){
                Armor currentWearArmor = hero.getCurrentWearArmor();
                Weapon currentWearWeapon = hero.getCurrentWearWeapon();
                if (currentWearWeapon!=null){
                    hero.getInventories().getWeapons().add(currentWearWeapon);
                }
                if (currentWearArmor!=null){
                    hero.getInventories().getArmors().add(currentWearArmor);
                }
                //reset the gain buff form battle
                hero.setCurrentWearArmor(null);
                hero.setCurrentWearWeapon(null);
                hero.setStrengthIncreaseInBattle(0);
                hero.setDefenseIncreaseInBattle(0);
                hero.setDexterityIncreaseInBattle(0);
                hero.setAgilityIncreaseInBattle(0);
                if (hero.isDyingState()){
                    // dying hero only recover half of mp and hp
                    hero.setCurrentHp((int) (hero.getMaxHp() * 0.5));
                    hero.setCurrentMp((int) (hero.getMaxMp() * 0.5));
                }else{
                    int getGold = hero.getLevel() * monsterSize * 100;
                    hero.setGold(hero.getGold() + getGold);
                    System.out.println(hero.getName() + " get " + getGold + " gold");
                    int getExperience = 2 * monsterSize;
                    hero.setExperience(hero.getExperience() + getExperience);
                    System.out.println(hero.getName() + " get " + getExperience + " experience");
                    if (hero.getExperience() >= hero.getExperienceToUpLevel()){
                        // Level up
                        hero.setLevel(hero.getLevel() + 1);
                        currentHighestHeroLevel = Math.max(currentHighestHeroLevel, hero.getLevel());
                        System.out.println(hero.getName() + " level up! current level is " + hero.getLevel());
                        hero.setExperience(hero.getExperience() - hero.getExperienceToUpLevel());
                        hero.setExperienceToUpLevel(hero.getLevel() *  10);
                        hero.setMaxHp((int) (hero.getMaxHp() * 1.3));
                        hero.setMaxMp((int) (hero.getMaxMp() * 1.3));
                        hero.setCurrentHp(hero.getMaxHp());
                        hero.setCurrentMp(hero.getMaxMp());
                        if (hero.getHeroType().equals(HeroType.Warrior.getTypeName())){
                            hero.setStrength((int) (hero.getStrength() * FAVORED_INCREASE_RATE));
                            hero.setDexterity((int) (hero.getDexterity() * BASE_INCREASE_RATE));
                            hero.setAgility((int) (hero.getAgility() * FAVORED_INCREASE_RATE));
                        }else if(hero.getHeroType().equals(HeroType.Sorcerer.getTypeName())){
                            hero.setStrength((int) (hero.getStrength() * BASE_INCREASE_RATE));
                            hero.setDexterity((int) (hero.getDexterity() * FAVORED_INCREASE_RATE));
                            hero.setAgility((int) (hero.getAgility() * FAVORED_INCREASE_RATE));
                        }else{
                            hero.setStrength((int) (hero.getStrength() * FAVORED_INCREASE_RATE));
                            hero.setDexterity((int) (hero.getDexterity() * FAVORED_INCREASE_RATE));
                            hero.setAgility((int) (hero.getAgility() * BASE_INCREASE_RATE));
                        }
                        hero.setDefense(hero.getDefense() + 50);
                    }else{
                        int hp = (int) (hero.getCurrentHp() + (hero.getMaxHp() * 0.2));
                        if (hero.getMaxHp() <= hp){
                            hero.setCurrentHp(hero.getMaxHp());
                        }else{
                            hero.setCurrentHp(hp);
                        }
                        int mana = (int) (hero.getCurrentMp() + (hero.getMaxMp() * 0.2));
                        if (hero.getMaxMp() <= mana){
                            hero.setCurrentMp(hero.getMaxMp());
                        }else{
                            hero.setCurrentMp(mana);
                        }
                    }
                }
                hero.setDyingState(false);
            }
        }else {
            this.gameOver = true;
        }
    }

    public String movement(String keyboard){
        int forwardTypeByKeyboard = ForwardType.getForwardTypeByKeyboard(keyboard);
        if(forwardTypeByKeyboard == ForwardType.None.getForwardType()){
            System.out.println("Invalid key input");
            System.out.println();
            return null;
        }
        Unit[][] boardArray = this.map.getBoardArray();
        int positionRow = this.player.getPositionRow();
        int positionCol = this.player.getPositionCol();
        int newPositionRow=positionRow + this.direction[forwardTypeByKeyboard][0];
        int newPositionCol=positionCol + this.direction[forwardTypeByKeyboard][1];
        if(newPositionCol <0 || newPositionCol==boardSize || newPositionRow <0 || newPositionRow==boardSize ||
                boardArray[newPositionRow][newPositionCol].getSymbol().equals(Inaccessible_Type.getSymbol())){
            System.out.println("Invalid movement position");
            System.out.println();
            return null;
        }
        boardArray[positionRow][positionCol].setSymbol(previousPositionType);
        this.player.setPositionRow(newPositionRow);
        this.player.setPositionCol(newPositionCol);
        String currentPositionType = boardArray[newPositionRow][newPositionCol].getSymbol();
        previousPositionType = boardArray[newPositionRow][newPositionCol].getSymbol();
        boardArray[newPositionRow][newPositionCol].setSymbol(Player_Position.getSymbol());
        return currentPositionType;
    }

}
