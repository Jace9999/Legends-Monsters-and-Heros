import Enums.HeroType;

import java.util.List;

import static Enums.HeroType.Warrior;

/**
 * @Author: Jun Zhu
 * @Date: 10/30/2022 10:45 AM
 * @Description: hero type
 */
public class Hero extends Creature{
    private int experience;
    private int experienceToUpLevel;
    private int maxHp;
    private int currentMp;
    private int maxMp;
    private int dexterity;
    private int gold;
    private Inventories inventories;
    private String heroType;

    private Weapon currentWearWeapon;

    private Armor currentWearArmor;

    private int strengthIncreaseInBattle;

    private int agilityIncreaseInBattle;

    private int dexterityIncreaseInBattle;

    private int defenseIncreaseInBattle;

    private boolean dyingState;

    public Hero(String name, int level, int experience, int experienceToUpLevel, int currentHp,int maxHp, int currentMp,  int maxMp,int strength, int defense,  int agility,
                int dexterity, int gold, String heroType, Inventories inventories,  Weapon currentWearWeapon, Armor currentWearArmor,
                int strengthIncreaseInBattle,int agilityIncreaseInBattle,int dexterityIncreaseInBattle,int defenseIncreaseInBattle, boolean dyingState) {
        super(name, level, strength, defense, agility, currentHp);
        this.experience = experience;
        this.experienceToUpLevel = experienceToUpLevel;
        this.maxHp = maxHp;
        this.currentMp = currentMp;
        this.maxMp = maxMp;
        this.dexterity = dexterity;
        this.gold = gold;
        this.inventories = inventories;
        this.heroType = heroType;
        this.currentWearWeapon = currentWearWeapon;
        this.currentWearArmor = currentWearArmor;
        this.strengthIncreaseInBattle = strengthIncreaseInBattle;
        this.agilityIncreaseInBattle = agilityIncreaseInBattle;
        this.dexterityIncreaseInBattle = dexterityIncreaseInBattle;
        this.defenseIncreaseInBattle = defenseIncreaseInBattle;
        this.dyingState = dyingState;
    }

    public boolean isDyingState() {
        return dyingState;
    }

    public void setDyingState(boolean dyingState) {
        this.dyingState = dyingState;
    }

    public int getStrengthIncreaseInBattle() {
        return strengthIncreaseInBattle;
    }

    public void setStrengthIncreaseInBattle(int strengthIncreaseInBattle) {
        this.strengthIncreaseInBattle = strengthIncreaseInBattle;
    }

    public int getAgilityIncreaseInBattle() {
        return agilityIncreaseInBattle;
    }

    public void setAgilityIncreaseInBattle(int agilityIncreaseInBattle) {
        this.agilityIncreaseInBattle = agilityIncreaseInBattle;
    }

    public int getDexterityIncreaseInBattle() {
        return dexterityIncreaseInBattle;
    }

    public void setDexterityIncreaseInBattle(int dexterityIncreaseInBattle) {
        this.dexterityIncreaseInBattle = dexterityIncreaseInBattle;
    }

    public int getDefenseIncreaseInBattle() {
        return defenseIncreaseInBattle;
    }

    public void setDefenseIncreaseInBattle(int defenseIncreaseInBattle) {
        this.defenseIncreaseInBattle = defenseIncreaseInBattle;
    }

    public Weapon getCurrentWearWeapon() {
        return currentWearWeapon;
    }

    public void setCurrentWearWeapon(Weapon currentWearWeapon) {
        this.currentWearWeapon = currentWearWeapon;
    }

    public Armor getCurrentWearArmor() {
        return currentWearArmor;
    }

    public void setCurrentWearArmor(Armor currentWearArmor) {
        this.currentWearArmor = currentWearArmor;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperienceToUpLevel() {
        return experienceToUpLevel;
    }

    public void setExperienceToUpLevel(int experienceToUpLevel) {
        this.experienceToUpLevel = experienceToUpLevel;
    }

    public int getCurrentMp() {
        return currentMp;
    }

    public void setCurrentMp(int currentMp) {
        this.currentMp = currentMp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public void setMaxMp(int maxMp) {
        this.maxMp = maxMp;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Inventories getInventories() {
        return inventories;
    }

    public void setInventories(Inventories inventories) {
        this.inventories = inventories;
    }

    public String getHeroType() {
        return heroType;
    }

    public void setHeroType(String heroType) {
        this.heroType = heroType;
    }

    public void printInventories(){
        List<Weapon> weapons = this.inventories.getWeapons();
        List<Armor> armors = this.inventories.getArmors();
        List<Potion> potions = this.inventories.getPotions();
        List<Spell> spells = this.inventories.getSpells();
        System.out.println("Inventory list of " + getName());
        if (weapons.size() == 0){
            System.out.println(getName() + " does not have any weapon");
        }else{
            System.out.println("Weapon:");
            inventories.printWeapon();
        }
        if (armors.size() == 0){
            System.out.println(getName() + " does not have any armor");
        }else{
            System.out.println("Armor:");
            inventories.printArmor();
        }
        if(potions.size() == 0){
            System.out.println(getName() + " does not have any potion");
        }else{
            System.out.println("Potion:");
            inventories.printPotion();
        }
        if (spells.size() == 0){
            System.out.println(getName() + " does not have any spell");
        }else{
            System.out.println("Spell:");
            inventories.printSpell();
        }
    }

    public void printHeroState(){
        System.out.println(getName() + "   (" + getHeroType() +")" + "   " + "Level: " + getLevel() + "   " + "Coins: " + getGold()
        + "   " + "Strength: " +getStrength());
        System.out.println("      " + "Defense: " + getDefense() + "   " + "Dexterity: " + getDexterity()
        +"   " + "Agility: " + getAgility() + "   " + "Health: " + getCurrentHp() + "/" + getMaxHp() + "   " + "Mana: " + getCurrentMp() + "/" + getMaxMp()
        +"   " + "Exp: " + getExperience() + "/" + getExperienceToUpLevel());
        System.out.println("Strength increase in the battle: " + getStrengthIncreaseInBattle() + "   "
                + "Defense increase in the battle: " + getDefenseIncreaseInBattle() + "   " +
                 "Agility increase in the battle: " + getAgilityIncreaseInBattle()+ "   "
                + "Dexterity increase in the battle: " + getDexterityIncreaseInBattle());
    }

    public Weapon searchWeaponByName(String name){
        for (Weapon weapon: inventories.getWeapons()){
            if(weapon.getName().equals(name)){
                return weapon;
            }
        }
        return null;
    }

    public Armor searchArmorByName(String name){
        for (Armor armor: inventories.getArmors()){
            if(armor.getName().equals(name)){
                return armor;
            }
        }
        return null;
    }

    public Potion searchPotionByName(String name){
        for (Potion potion: inventories.getPotions()){
            if(potion.getName().equals(name)){
                return potion;
            }
        }
        return null;
    }

    public Spell searchSpellByName(String name){
        for (Spell spell: inventories.getSpells()){
            if(spell.getName().equals(name)){
                return spell;
            }
        }
        return null;
    }
}
