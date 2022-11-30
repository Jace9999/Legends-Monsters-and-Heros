import Enums.SpellType;

import java.sql.SQLOutput;
import java.util.*;

/**
 * @Author: Jun Zhu
 * @Date: 11/7/2022 9:15 PM
 * @Description: processing a battle between heroes and monsters
 */
public class BattleWithMonster {
    private List<Hero> heroList;
    private List<Monster> monsterList;

    private Player player;

    private boolean gameOver;
    private int liveHeroNum;

    private int liveMonsterNum;

    private static final double DODGE_RATE = 0.02;

    private static final double ATTACK_RATE = 0.05;

    private static final double SPELL_RATE = 0.0001;

    public BattleWithMonster(List<Hero> heroList, List<Monster> monsterList, Player player) {
        gameOver=false;
        liveMonsterNum = heroList.size();
        liveHeroNum = heroList.size();
        this.heroList = heroList;
        this.monsterList = monsterList;
        this.player = player;
        System.out.println("Here is the current state of heroes:");
        player.checkHeroesState();
        System.out.println("Here is the current state of monsters:");
        printMonsterInfo();
    }

    public int battleWithMonster(){
        while(liveMonsterNum > 0 && liveHeroNum > 0){
            for(int i=0;i<heroList.size();i++){
                Hero hero = heroList.remove(0);
                heroList.add(hero);
                if (!hero.isDyingState()){
                    heroRound(hero);
                }
                if (gameOver){
                    return 2;
                }
                if (liveMonsterNum==0){
                    break;
                }
            }
            if (liveMonsterNum==0){
                break;
            }
            for(int i=0;i<monsterList.size();i++){
                Monster monster = monsterList.remove(0);
                monsterList.add(monster);
                if (!monster.isDead()){
                    monsterRound(monster);
                }
            }
        }
        if (liveHeroNum == 0){
            return 0;
        }
        return 1;
    }

    public void heroRound(Hero hero){
        Scanner scanner = new Scanner(System.in);
        System.out.println("It is " + hero.getName() + " round!");
        boolean invalidInput = false;
        while(!invalidInput) {
            System.out.println(hero.getName() + "may either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell");
            System.out.println("Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: ");
            String input = scanner.nextLine();
            if(input.equals("Q")) {
                this.gameOver = true;
                return;
            }else if(input.equals("H")){
                Database.printHelpMenu();
            }
            else if (input.equals("1")){
                if (hero.getCurrentWearArmor()!=null){
                    System.out.println(hero.getName() + " currently equip armor " + hero.getCurrentWearArmor().getName());
                }
                if(hero.getCurrentWearWeapon() !=null){
                    System.out.println(hero.getName() + " currently equip weapon " + hero.getCurrentWearWeapon().getName());
                }
                List<Weapon> weapons = hero.getInventories().getWeapons();
                List<Armor> armors = hero.getInventories().getArmors();
                if (weapons.size() == 0 && armors.size() == 0){
                    System.out.println(hero.getName() + "does not have any weapon and armor in the inventory list");
                }else{
                    boolean validEquipmentName = false;
                    while(!validEquipmentName){
                        hero.getInventories().printWeapon();
                        hero.getInventories().printArmor();
                        while(true){
                            System.out.println("Please enter the name of weapon or armor to equip");
                            System.out.println("If you select a weapon while you currently have a weapon equipped, it will be swapped");
                            String inventoryName = scanner.nextLine();
                            if (inventoryName.equals("I")){
                                player.checkHeroesState();
                            }else if (inventoryName.equals("H")){
                                Database.printHelpMenu();
                            }else if (inventoryName.equals("Q")){
                                this.gameOver = true;
                                return;
                            }else if (inventoryName.equals("MI")){
                                printMonsterInfo();
                            }else {
                                Armor armor = hero.searchArmorByName(inventoryName);
                                Weapon weapon = hero.searchWeaponByName(inventoryName);
                                if (armor != null){
                                    hero.getInventories().getArmors().remove(armor);
                                    Armor currentWearArmor = hero.getCurrentWearArmor();
                                    if (hero.getCurrentWearArmor()!=null){
                                        hero.getInventories().getArmors().add(currentWearArmor);
                                        hero.setDefenseIncreaseInBattle(hero.getDefenseIncreaseInBattle() - currentWearArmor.getDamageReduction());
                                        System.out.println(hero.getName() + " swap current armor " + currentWearArmor.getName() + " to new armor " + armor.getName());
                                    }
                                    hero.getInventories().getArmors().remove(armor);
                                    hero.setCurrentWearArmor(armor);
                                    hero.setDefenseIncreaseInBattle(hero.getDefenseIncreaseInBattle() + armor.getDamageReduction());
                                    System.out.println(hero.getName() + " equip armor " + armor.getName() + ", defense increase " + armor.getDamageReduction());
                                    invalidInput = true;
                                    validEquipmentName = true;
                                    break;
                                }else if (weapon != null){
                                    hero.getInventories().getWeapons().remove(weapon);
                                    Weapon currentWearWeapon = hero.getCurrentWearWeapon();
                                    if (hero.getCurrentWearWeapon()!=null){
                                        hero.getInventories().getWeapons().add(hero.getCurrentWearWeapon());
                                        hero.setStrengthIncreaseInBattle(hero.getStrengthIncreaseInBattle() - currentWearWeapon.getDamage());
                                    }
                                    hero.getInventories().getWeapons().remove(weapon);
                                    hero.setCurrentWearWeapon(weapon);
                                    hero.setStrengthIncreaseInBattle(hero.getStrengthIncreaseInBattle() + weapon.getDamage());
                                    System.out.println(hero.getName() + " equip weapon " + weapon.getName() + ", strength increase " + weapon.getDamage());
                                    validEquipmentName = true;
                                    invalidInput = true;
                                    break;
                                }else{
                                    System.out.println("Can not find this name in your weapon list or armor list");
                                    break;
                                }
                            }
                        }
                    }
                }
            }else if (input.equals("2")){
                boolean validMonsterName = false;
                while(!validMonsterName){
                    printMonsterInfo();
                    while (true){
                        System.out.println("Enter the monster name which you wanna attack");
                        String monsterName = scanner.nextLine();
                        if (monsterName.equals("I")){
                            player.checkHeroesState();
                        }else if (monsterName.equals("H")){
                            Database.printHelpMenu();
                        }else if (monsterName.equals("Q")){
                            this.gameOver = true;
                            return;
                        }else if (monsterName.equals("MI")) {
                            printMonsterInfo();
                        }else {
                            Monster monster = searchAliveMonsterByName(monsterName);
                            if (monster==null){
                                System.out.println("Can not find this monster");
                            }else {
                                if (monster.isDead()){
                                    System.out.println(monster.getName() + " is dead, cant attack!");
                                }else{
                                    int dodgeChance = (int) ((monster.getAgility() + hero.getAgilityIncreaseInBattle()) * DODGE_RATE);
                                    Random random = new Random();
                                    int randomVal = random.nextInt(100);
                                    System.out.println("Hero " + hero.getName() + " attack Monster " + monster.getName());
                                    if(randomVal <= dodgeChance){
                                        System.out.println(hero.getName() + " attack was MISSING!");
                                    }else {
                                        int attackDamage = (int) (((hero.getStrength()+hero.getStrengthIncreaseInBattle()) - monster.getDefense()) * ATTACK_RATE);
                                        System.out.println(hero.getName() + " attack was EFFECTIVE! "+ monster.getName() + " has taken " + attackDamage);
                                        if(monster.getCurrentHp() - attackDamage <= 0){
                                            System.out.println(monster.getName() + " dead!");
                                            monster.setCurrentHp(0);
                                            liveMonsterNum--;
                                            monster.setDead(true);
                                        }else{
                                            monster.setCurrentHp(monster.getCurrentHp() - attackDamage);
                                        }
                                    }
                                    validMonsterName=true;
                                    break;
                                }
                            }
                        }
                    }
                }
                invalidInput = true;
            }else if (input.equals("3")){
                List<Potion> potions = hero.getInventories().getPotions();
                List<Spell> spells = hero.getInventories().getSpells();
                if (potions.size() == 0 && spells.size() == 0){
                    System.out.println(hero.getName() + "does not have any potion and spell");
                }else{
                    boolean validName = false;
                    while(!validName){
                        hero.getInventories().printSpell();
                        hero.getInventories().printPotion();
                        while (true){
                            System.out.println("Please enter the name of potion or spell to cast");
                            String inputName = scanner.nextLine();
                            if (inputName.equals("I")){
                                player.checkHeroesState();
                            }else if (inputName.equals("H")){
                                Database.printHelpMenu();
                            }else if (inputName.equals("Q")){
                                this.gameOver = true;
                                return;
                            }else if (inputName.equals("MI")) {
                                printMonsterInfo();
                            }else{
                                Potion potion = hero.searchPotionByName(inputName);
                                Spell spell = hero.searchSpellByName(inputName);
                                if (potion != null){
                                    String increaseType = potion.getIncreaseType();
                                    hero.getInventories().getPotions().remove(potion);
                                    switch (increaseType){
                                        case "Health":
                                            useHealthPotion(hero, potion);
                                            break;
                                        case "Strength":
                                            System.out.println(hero.getName() + " uses potion " + potion.getName() + " to increase strength");
                                            hero.setStrengthIncreaseInBattle(hero.getStrengthIncreaseInBattle() + potion.getIncreaseAmount());
                                            break;
                                        case "Mana":
                                            useManaPotion(hero,potion);
                                            break;
                                        case "Agility":
                                            System.out.println(hero.getName() + " uses potion " + potion.getName() + " to increase agility");
                                            hero.setAgilityIncreaseInBattle(hero.getAgilityIncreaseInBattle() + potion.getIncreaseAmount());
                                            break;
                                        case "Health/Mana/Strength/Agility":
                                            useHealthPotion(hero, potion);
                                            useManaPotion(hero,potion);
                                            System.out.println(hero.getName() + " uses potion " + potion.getName() + " to increase strength");
                                            hero.setStrengthIncreaseInBattle(hero.getStrengthIncreaseInBattle() + potion.getIncreaseAmount());
                                            System.out.println(hero.getName() + " uses potion " + potion.getName() + " to increase agility");
                                            hero.setAgilityIncreaseInBattle(hero.getAgilityIncreaseInBattle() + potion.getIncreaseAmount());
                                            break;
                                        default:
                                            useHealthPotion(hero, potion);
                                            useManaPotion(hero,potion);
                                            System.out.println(hero.getName() + " uses potion " + potion.getName() + " to increase strength");
                                            hero.setStrengthIncreaseInBattle(hero.getStrengthIncreaseInBattle() + potion.getIncreaseAmount());
                                            System.out.println(hero.getName() + " uses potion " + potion.getName() + " to increase agility");
                                            hero.setAgilityIncreaseInBattle(hero.getAgilityIncreaseInBattle() + potion.getIncreaseAmount());
                                            System.out.println(hero.getName() + " uses potion " + potion.getName() + " to increase dexterity");
                                            hero.setDexterityIncreaseInBattle(hero.getDexterityIncreaseInBattle() + potion.getIncreaseAmount());
                                            System.out.println(hero.getName() + " uses potion " + potion.getName() + " to increase defense");
                                            hero.setDefenseIncreaseInBattle(hero.getDefenseIncreaseInBattle() + potion.getIncreaseAmount());
                                            break;
                                    }
                                    invalidInput = true;
                                    validName = true;
                                    break;
                                }else if (spell != null){
                                    if (hero.getCurrentMp() < spell.getManaCost()){
                                        System.out.println(hero.getName() + " does not have enough mana to cast this spell");
                                        validName = true;
                                        break;
                                    }else{
                                        boolean validMonsterName = false;
                                        hero.setCurrentMp(hero.getCurrentMp() - spell.getManaCost());
                                        while(!validMonsterName){
                                            while (true){
                                                System.out.println("Enter the monster name which you wanna cast spell at");
                                                String monsterName = scanner.nextLine();
                                                if (monsterName.equals("I")){
                                                    player.checkHeroesState();
                                                }else if (monsterName.equals("H")){
                                                    Database.printHelpMenu();
                                                }else if (monsterName.equals("Q")){
                                                    this.gameOver = true;
                                                    return;
                                                }else if (monsterName.equals("MI")) {
                                                    printMonsterInfo();
                                                }else{
                                                    Monster monster = searchAliveMonsterByName(monsterName);
                                                    if (monster==null){
                                                        System.out.println("Can not find this monster");
                                                    }else {
                                                        if (monster.isDead()){
                                                            System.out.println(monster.getName() + " is dead, cant attack!");
                                                        }else{
                                                            int damage = (int) ((hero.getDexterity() + hero.getDexterityIncreaseInBattle()) * SPELL_RATE * spell.getDamage());
                                                            System.out.println(hero.getName() + "use spell " + spell.getName() + " to deal " + damage + " damage to monster " + monster.getName());
                                                            if (spell.getSpellType().equals(SpellType.Ice.getTypeName())){
                                                                System.out.println(spell.getName() + " type is " + spell.getSpellType() + ", also reduce 20% target monster's strength");
                                                                monster.setStrength((int) (monster.getStrength() * 0.8));
                                                            }else if(spell.getSpellType().equals(SpellType.Fire.getTypeName())){
                                                                System.out.println(spell.getName() + " type is " + spell.getSpellType() + ", also reduce 20% target monster's defense");
                                                                monster.setDefense((int) (monster.getDefense() * 0.8));
                                                            }else{
                                                                System.out.println(spell.getName() + " type is " + spell.getSpellType() + ", also reduce 20% target monster's agility");
                                                                monster.setAgility((int) (monster.getAgility() * 0.8));
                                                            }
                                                            if(monster.getCurrentHp() <= damage){
                                                                monster.setCurrentHp(0);
                                                                System.out.println(monster.getName() + " dead!");
                                                                liveMonsterNum--;
                                                                monster.setDead(true);
                                                            }else{
                                                                monster.setCurrentHp(monster.getCurrentHp() - damage);
                                                            }
                                                            validMonsterName=true;
                                                            invalidInput = true;
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    validName = true;
                                    break;
                                }else{
                                    System.out.println("Can not find this name in your potion list or spell list");
                                }
                            }
                        }
                    }
                }
            }else if(input.equals("I")){
                player.checkHeroesState();
            }else if (input.equals("MI")){
                printMonsterInfo();
            }
            else{
                System.out.println("Invalid input");
            }
        }
    }

    public void printMonsterInfo(){
        for (Monster monster : monsterList){
            System.out.println(monster.getName() + "   (" + monster.getMonsterType() + ")   Level: " +monster.getLevel() );
            System.out.println("      Strength: " + monster.getStrength() + "   Defense: " + monster.getDefense() + "   Agility: " + monster.getAgility()
            +"   Health: " + monster.getCurrentHp() + "/100");
        }
        System.out.println();
    }

    public Monster searchAliveMonsterByName(String name){
        for (Monster monster:monsterList){
            if (monster.getName().equals(name)) {
                return monster;
            }
        }
        return null;
    }

    public void useHealthPotion(Hero hero, Potion potion){
        int hp = hero.getCurrentHp()+ potion.getIncreaseAmount();
        System.out.println(hero.getName() + " uses potion " + potion.getName() + " to recover hp");
        if(hp > hero.getMaxHp()){
            hero.setCurrentHp(hero.getMaxHp());
        }else{
            hero.setCurrentHp(hp);
        }
        System.out.println(hero.getName() + " current hp is " + hero.getCurrentHp());
    }

    public void useManaPotion(Hero hero, Potion potion){
        int mana = hero.getCurrentMp()+ potion.getIncreaseAmount();
        System.out.println(hero.getName() + " uses potion " + potion.getName() + " to recover mana");
        if(mana > hero.getMaxMp()){
            hero.setCurrentMp(hero.getMaxMp());
        }else{
            hero.setCurrentMp(mana);
        }
        System.out.println(hero.getName() + " current mana is " + hero.getCurrentMp());
    }

    public void monsterRound(Monster monster){
        if (liveHeroNum==0){
            return;
        }
        System.out.println();
        Hero hero = heroList.get(randomPickLiveHero());
        int dodgeChance = (int) (hero.getAgility() * DODGE_RATE);
        Random random = new Random();
        int randomVal = random.nextInt(100);
        System.out.println("It is " + monster.getName() + " round!");
        System.out.println("Monster " + monster.getName() + " attack Hero " + hero.getName());
        if(randomVal <= dodgeChance){
            System.out.println(monster.getName() + " attack was MISSING!");
        }else {
            int attackDamage = (int) ((monster.getStrength() - (hero.getDefense()+hero.getDefenseIncreaseInBattle())) * ATTACK_RATE);
            if (attackDamage > 0){
                System.out.println(monster.getName() + " attack was EFFECTIVE! "+ hero.getName() + " has taken " + attackDamage);
                if(hero.getCurrentHp() - attackDamage <= 0){
                    System.out.println(hero.getName() + " enters a near-death state.");
                    hero.setCurrentHp(0);
                    hero.setDyingState(true);
                    liveHeroNum--;
                }else{
                    hero.setCurrentHp(hero.getCurrentHp() - attackDamage);
                }
            }else{
                System.out.println(monster.getName() + " attack was EFFECTIVE! "+ ", but " + hero.getName() + " has a higher defense than monster strength, " + hero.getName() + " has taken 0 damage");
            }
        }
    }

    public int randomPickLiveHero(){
        int res = 0;
        Random random = new Random();
        boolean validNum = false;
        while(!validNum){
            int num = random.nextInt(heroList.size());
            Hero hero = heroList.get(num);
            if (!hero.isDyingState()){
                res = num;
                validNum = true;
            }
        }
        return res;
    }
}
