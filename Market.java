import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: Jun Zhu
 * @Date: 11/5/2022 12:25 PM
 * @Description: market class, each market contains 4 different list to store weapon, armor, potion and spell
 */
public class Market {
    private Inventories inventories;

    public void initiateMarket(){
        List<Weapon> weaponList = new ArrayList<>();
        List<Armor> armorList = new ArrayList<>();
        List<Potion> potionList = new ArrayList<>();
        List<Spell> spellList = new ArrayList<>();
        Random random = new Random();
        while(weaponList.size()<3){
            int monsterIndex = random.nextInt(Database.weapons.size());
            if(!weaponList.contains(Database.weapons.get(monsterIndex))){
                weaponList.add(Database.weapons.get(monsterIndex));
            }
        }
        while(armorList.size()<3){
            int monsterIndex = random.nextInt(Database.armors.size());
            if(!armorList.contains(Database.armors.get(monsterIndex))){
                armorList.add(Database.armors.get(monsterIndex));
            }
        }
        while(potionList.size()<3){
            int monsterIndex = random.nextInt(Database.potions.size());
            if(!potionList.contains(Database.potions.get(monsterIndex))){
                potionList.add(Database.potions.get(monsterIndex));
            }
        }
        while(spellList.size()<3){
            int monsterIndex = random.nextInt(Database.spells.size());
            if(!spellList.contains(Database.spells.get(monsterIndex))){
                spellList.add(Database.spells.get(monsterIndex));
            }
        }
        this.inventories = new Inventories(weaponList,armorList,potionList,spellList);
    }

    public void printSellItem(){
        System.out.println();
        System.out.println("Sell list of current market:");
        System.out.println("Weapon:");
        for(Weapon weapon : inventories.getWeapons()){
            weapon.printWeaponInfo();
        }
        System.out.println("Armor:");
        for(Armor armor :inventories.getArmors()){
            armor.printArmorInfo();
        }
        System.out.println("Potion:");
        for(Potion potion : inventories.getPotions()){
            potion.printPotionInfo();
        }
        System.out.println("Spell:");
        for (Spell spell :inventories.getSpells()){
            spell.printSpellInfo();
        }
        System.out.println();
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
    public Inventories getInventories() {
        return inventories;
    }

    public void setInventories(Inventories inventories) {
        this.inventories = inventories;
    }

    public Market() {
        initiateMarket();
    }
}
