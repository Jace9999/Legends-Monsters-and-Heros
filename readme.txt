# CS611-<Assignment 3>
## <Legends: Monsters and Heroes>

---------------------------------------------------------------------------
<Jun Zhu>
<zhujun99@bu.edu>
<U78975626>

## Files
---------------------------------------------------------------------------
Main.java
@Description: contains main function for entering game

Game.java
@Description: control the processing of game, initiate map and database first, then start the game.

Entity.java
@Description: each entity has a common attribute which is name

Equipment.java
@Description: parent class for all inventory type, each inventory type has cost and level levelRequirement attribute

Creature.java
@Description: parent class for Hero and Monster, since every creature in this game has some common value

Player.java
@Description: contains a list of hero and current player position

Map.java
@Description: map class, contains the size of map which is able to scalable and a 2D unit array

Unit.java
@Description: represent a unit on the map

Transaction.java
@Description: using to process a transaction between hero and market

BattleWithMonster.java
@Description: processing a battle between heroes and monsters

Database.java
@Description: contains all hardcode data from txt

Inventories.java
@Description: contains four list to store hero's weapon, armor, potion and spell@Description: contains four list to store hero's weapon, armor, potion and spell

Market.java
@Description: market class, each market contains 4 different list to store weapon, armor, potion and spell

Armor.java
@Description: Armor type extends from Equipment

Weapon.java
@Description: Weapon type extends from Equipment

Spell.java
@Description: using to represent spell

Potion.java
@Description: using to store potion

Hero.java
@Description: hero type

Monster.java
@Description: Monster type

ForwardType.java
@Description: Enum for store player movement type

HeroType.java
@Description: enum for separate three different hero type

MonsterType.java
@Description: enum for separate three different monster type

PotionIncreaseType.java
@Description: enum for separate different potion increase type

SpellType.java
@Description: enum for separate different spell type

UnitType.java
@Description: enum for separate different unit type

## Notes
---------------------------------------------------------------------------
The specific implementation of my game follows the instructions pdf given by the professor and all functions are well implemented.
In this game, monsters have the same strength, defense, and agility attributes as heroes, 
which are shared with heroes in the formula for calculating them in battle. 
The hero can buy items in the store, potions are consumable only in the battle and can only be used once.
Weapons, armor, and spells are not consumable. 
However, when the hero defeats an enemy, the weapons and armor equipped by the hero in the battle are automatically returned to the hero's Inventory collection, 
and the next battle will require a new turn to equip the weapon or armor.
In addition, when a hero upgrades, their Strength, Dexterity, and Agility attributes increment rate is affected by the hero's type.
At the same time, spells will not only cause damage to the enemy, and different types of spells will cause different negative effects on the enemy

## How to compile and run
---------------------------------------------------------------------------
## How to compile and run
javac -d bin *.java
java -cp bin Main

## Input/Output Example 1
---------------------------------------------------------------------------
Please enter the size of the map, minimum size is 5 and maximum is 10
Input: 5
Please enter the size of the hero in your team, minimum size is 1 and maximum is 3
Input: 3
------------------------------------
0: Gaerdal_Ironhand   (Warrior)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
1: Sehanine_Monnbow   (Warrior)   Level: 1   Coins: 2500   Strength: 700
      Defense: 0   Dexterity: 500   Agility: 800   Health: 100/100   Mana: 600/600   Exp: 8/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
2: Muamman_Duathall   (Warrior)   Level: 1   Coins: 2546   Strength: 900
      Defense: 0   Dexterity: 750   Agility: 500   Health: 100/100   Mana: 300/300   Exp: 6/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
3: Flandal_Steelskin   (Warrior)   Level: 1   Coins: 2500   Strength: 750
      Defense: 0   Dexterity: 700   Agility: 650   Health: 100/100   Mana: 200/200   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
4: Undefeated_Yoj   (Warrior)   Level: 1   Coins: 2500   Strength: 800
      Defense: 0   Dexterity: 700   Agility: 400   Health: 100/100   Mana: 400/400   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
5: Eunoia_Cyn   (Warrior)   Level: 1   Coins: 2500   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 800   Health: 100/100   Mana: 400/400   Exp: 6/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
6: Rillifane_Rallathil   (Sorcerer)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
7: Segojan_Earthcaller   (Sorcerer)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
8: Reign_Havoc   (Sorcerer)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
9: Reverie_Ashels   (Sorcerer)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
10: Kalabar   (Sorcerer)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
11: Skye_Soar   (Sorcerer)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
12: Parzival   (Paladin)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
13: Sehanine_Moonbow   (Paladin)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
14: Skoraeus_Stonebones   (Paladin)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
15: Garl_Glittergold   (Paladin)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
16: Amaryllis_Astra   (Paladin)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
17: Caliber_Heist   (Paladin)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
------------------------------------

Enter the index of hero to pick this hero to your team, 0 - 17
Pick 1 hero
Input: 0
Enter the index of hero to pick this hero to your team, 0 - 17
Pick 2 hero
Input: 4
Enter the index of hero to pick this hero to your team, 0 - 17
Pick 3 hero
Input: 15
Here are your controls:
      To move around the map, use your W,A,S,D keys!
W -> North, A -> West, S -> South, D -> East
* is the current position of your current in the map, M represents a market position and X represents a position that inaccessible
Enter I at any time to view your team's status. This command works in the midst of a battle tool!
When in battle, you may also enter MI to view monster status.
Enter Q at any time to exit game. However, let's not get try sneaky and use it to escape battle.
Enter H at any time to view this instruction.
Think that should be all! Make sure you read and understand the command thoroughly. Have fun!

* |   |   |   |   | 
M | M |   | M |   | 
M | X |   | X | X | 
  | X |   | M |   | 
  |   |   | M |   | 

Where would you like your team of Heroes to explore? W:North, A:West, D:East, S:south
Input: S

Welcome to market!
Enter the name of hero to select that hero to trade with market, or enter X to exit market
Input: I
Gaerdal_Ironhand   (Warrior)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
Undefeated_Yoj   (Warrior)   Level: 1   Coins: 2500   Strength: 800
      Defense: 0   Dexterity: 700   Agility: 400   Health: 100/100   Mana: 400/400   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
Garl_Glittergold   (Paladin)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0

Inventory list of your hero:
Inventory list of Gaerdal_Ironhand
Gaerdal_Ironhand does not have any weapon
Gaerdal_Ironhand does not have any armor
Gaerdal_Ironhand does not have any potion
Gaerdal_Ironhand does not have any spell
Inventory list of Undefeated_Yoj
Undefeated_Yoj does not have any weapon
Undefeated_Yoj does not have any armor
Undefeated_Yoj does not have any potion
Undefeated_Yoj does not have any spell
Inventory list of Garl_Glittergold
Garl_Glittergold does not have any weapon
Garl_Glittergold does not have any armor
Garl_Glittergold does not have any potion
Garl_Glittergold does not have any spell

Welcome to market!
Enter the name of hero to select that hero to trade with market, or enter X to exit market
Gaerdal_Ironhand

Press S to sell, B to Buy or X to switch hero to transact or exit market
Input: S
Gaerdal_Ironhand does not have any inventory, can not sell any thing!

Press S to sell, B to Buy or X to switch hero to transact or exit market
Input: B

Sell list of current market:
Weapon:
TSwords   Cost: 1400   Level Require: 8   Damage: 1600   
Sword   Cost: 500   Level Require: 1   Damage: 800   
Axe   Cost: 550   Level Require: 5   Damage: 850   
Armor:
Full_Body_Armor   Cost: 1000   Level Require: 8   Damage Reduction: 1100
Guardian_Angel   Cost: 1000   Level Require: 10   Damage Reduction: 1000
Platinum_Shield   Cost: 150   Level Require: 1   Damage Reduction: 200
Potion:
Ambrosia   Cost: 1000   Level Require: 8   Increase Type: All   Increase Amount: 150
Mermaid_Tears   Cost: 850   Level Require: 5   Increase Type: Health/Mana/Strength/Agility   Increase Amount: 100
Magic_Potion   Cost: 350   Level Require: 2   Increase Type: Mana   Increase Amount: 100
Spell:
Lava_Comet   Cost: 800   Level Require: 7   Mana Cost: 550   Spell Type: Fire   Damage: 1000
Hell_Storm   Cost: 600   Level Require: 3   Mana Cost: 600   Spell Type: Fire   Damage: 950
Lightning_Dagger   Cost: 400   Level Require: 1   Mana Cost: 150   Spell Type: Lighting   Damage: 500

Enter the inventory name to buy this item, or enter X to return to the previous menu
Input: Sword
Gaerdal_Ironhand spent 500 money to buy Sword

Sell list of current market:
Weapon:
TSwords   Cost: 1400   Level Require: 8   Damage: 1600   
Axe   Cost: 550   Level Require: 5   Damage: 850   
Armor:
Full_Body_Armor   Cost: 1000   Level Require: 8   Damage Reduction: 1100
Guardian_Angel   Cost: 1000   Level Require: 10   Damage Reduction: 1000
Platinum_Shield   Cost: 150   Level Require: 1   Damage Reduction: 200
Potion:
Ambrosia   Cost: 1000   Level Require: 8   Increase Type: All   Increase Amount: 150
Mermaid_Tears   Cost: 850   Level Require: 5   Increase Type: Health/Mana/Strength/Agility   Increase Amount: 100
Magic_Potion   Cost: 350   Level Require: 2   Increase Type: Mana   Increase Amount: 100
Spell:
Lava_Comet   Cost: 800   Level Require: 7   Mana Cost: 550   Spell Type: Fire   Damage: 1000
Hell_Storm   Cost: 600   Level Require: 3   Mana Cost: 600   Spell Type: Fire   Damage: 950
Lightning_Dagger   Cost: 400   Level Require: 1   Mana Cost: 150   Spell Type: Lighting   Damage: 500

Enter the inventory name to buy this item, or enter X to return to the previous menu
Input: X

Press S to sell, B to Buy or X to switch hero to transact or exit market
Input: S
Inventory list of Gaerdal_Ironhand
Weapon:
Sword   Cost: 500   Level Require: 1   Damage: 800   
Gaerdal_Ironhand does not have any armor
Gaerdal_Ironhand does not have any potion
Gaerdal_Ironhand does not have any spell
Enter the inventory name to sell this item, or enter X to return to previous menu
Input: X

Press S to sell, B to Buy or X to switch hero to transact or exit market
Input: X

Welcome to market!
Enter the name of hero to select that hero to trade with market, or enter X to exit market
Input: Undefeated_Yoj

Press S to sell, B to Buy or X to switch hero to transact or exit market
Input: B

Sell list of current market:
Weapon:
TSwords   Cost: 1400   Level Require: 8   Damage: 1600   
Axe   Cost: 550   Level Require: 5   Damage: 850   
Armor:
Full_Body_Armor   Cost: 1000   Level Require: 8   Damage Reduction: 1100
Guardian_Angel   Cost: 1000   Level Require: 10   Damage Reduction: 1000
Platinum_Shield   Cost: 150   Level Require: 1   Damage Reduction: 200
Potion:
Ambrosia   Cost: 1000   Level Require: 8   Increase Type: All   Increase Amount: 150
Mermaid_Tears   Cost: 850   Level Require: 5   Increase Type: Health/Mana/Strength/Agility   Increase Amount: 100
Magic_Potion   Cost: 350   Level Require: 2   Increase Type: Mana   Increase Amount: 100
Spell:
Lava_Comet   Cost: 800   Level Require: 7   Mana Cost: 550   Spell Type: Fire   Damage: 1000
Hell_Storm   Cost: 600   Level Require: 3   Mana Cost: 600   Spell Type: Fire   Damage: 950
Lightning_Dagger   Cost: 400   Level Require: 1   Mana Cost: 150   Spell Type: Lighting   Damage: 500

Enter the inventory name to buy this item, or enter X to return to the previous menu
Input: Lightning_Dagger
Undefeated_Yoj spent 400 money to buy Lightning_Dagger

Sell list of current market:
Weapon:
TSwords   Cost: 1400   Level Require: 8   Damage: 1600   
Axe   Cost: 550   Level Require: 5   Damage: 850   
Armor:
Full_Body_Armor   Cost: 1000   Level Require: 8   Damage Reduction: 1100
Guardian_Angel   Cost: 1000   Level Require: 10   Damage Reduction: 1000
Platinum_Shield   Cost: 150   Level Require: 1   Damage Reduction: 200
Potion:
Ambrosia   Cost: 1000   Level Require: 8   Increase Type: All   Increase Amount: 150
Mermaid_Tears   Cost: 850   Level Require: 5   Increase Type: Health/Mana/Strength/Agility   Increase Amount: 100
Magic_Potion   Cost: 350   Level Require: 2   Increase Type: Mana   Increase Amount: 100
Spell:
Lava_Comet   Cost: 800   Level Require: 7   Mana Cost: 550   Spell Type: Fire   Damage: 1000
Hell_Storm   Cost: 600   Level Require: 3   Mana Cost: 600   Spell Type: Fire   Damage: 950

Enter the inventory name to buy this item, or enter X to return to the previous menu
Input: X

Press S to sell, B to Buy or X to switch hero to transact or exit market
Input: X

Welcome to market!
Enter the name of hero to select that hero to trade with market, or enter X to exit market
Input: Garl_Glittergold

Press S to sell, B to Buy or X to switch hero to transact or exit market
Input: B

Sell list of current market:
Weapon:
TSwords   Cost: 1400   Level Require: 8   Damage: 1600   
Axe   Cost: 550   Level Require: 5   Damage: 850   
Armor:
Full_Body_Armor   Cost: 1000   Level Require: 8   Damage Reduction: 1100
Guardian_Angel   Cost: 1000   Level Require: 10   Damage Reduction: 1000
Platinum_Shield   Cost: 150   Level Require: 1   Damage Reduction: 200
Potion:
Ambrosia   Cost: 1000   Level Require: 8   Increase Type: All   Increase Amount: 150
Mermaid_Tears   Cost: 850   Level Require: 5   Increase Type: Health/Mana/Strength/Agility   Increase Amount: 100
Magic_Potion   Cost: 350   Level Require: 2   Increase Type: Mana   Increase Amount: 100
Spell:
Lava_Comet   Cost: 800   Level Require: 7   Mana Cost: 550   Spell Type: Fire   Damage: 1000
Hell_Storm   Cost: 600   Level Require: 3   Mana Cost: 600   Spell Type: Fire   Damage: 950

Enter the inventory name to buy this item, or enter X to return to the previous menu
Input: Platinum_Shield
Garl_Glittergold spent 150 money to buy Platinum_Shield

Sell list of current market:
Weapon:
TSwords   Cost: 1400   Level Require: 8   Damage: 1600   
Axe   Cost: 550   Level Require: 5   Damage: 850   
Armor:
Full_Body_Armor   Cost: 1000   Level Require: 8   Damage Reduction: 1100
Guardian_Angel   Cost: 1000   Level Require: 10   Damage Reduction: 1000
Potion:
Ambrosia   Cost: 1000   Level Require: 8   Increase Type: All   Increase Amount: 150
Mermaid_Tears   Cost: 850   Level Require: 5   Increase Type: Health/Mana/Strength/Agility   Increase Amount: 100
Magic_Potion   Cost: 350   Level Require: 2   Increase Type: Mana   Increase Amount: 100
Spell:
Lava_Comet   Cost: 800   Level Require: 7   Mana Cost: 550   Spell Type: Fire   Damage: 1000
Hell_Storm   Cost: 600   Level Require: 3   Mana Cost: 600   Spell Type: Fire   Damage: 950

Enter the inventory name to buy this item, or enter X to return to the previous menu
Input: Full_Body_Armor
Garl_Glittergold does not require level to buy this item

Sell list of current market:
Weapon:
TSwords   Cost: 1400   Level Require: 8   Damage: 1600   
Axe   Cost: 550   Level Require: 5   Damage: 850   
Armor:
Full_Body_Armor   Cost: 1000   Level Require: 8   Damage Reduction: 1100
Guardian_Angel   Cost: 1000   Level Require: 10   Damage Reduction: 1000
Potion:
Ambrosia   Cost: 1000   Level Require: 8   Increase Type: All   Increase Amount: 150
Mermaid_Tears   Cost: 850   Level Require: 5   Increase Type: Health/Mana/Strength/Agility   Increase Amount: 100
Magic_Potion   Cost: 350   Level Require: 2   Increase Type: Mana   Increase Amount: 100
Spell:
Lava_Comet   Cost: 800   Level Require: 7   Mana Cost: 550   Spell Type: Fire   Damage: 1000
Hell_Storm   Cost: 600   Level Require: 3   Mana Cost: 600   Spell Type: Fire   Damage: 950

Enter the inventory name to buy this item, or enter X to return to the previous menu
Input: I
Gaerdal_Ironhand   (Warrior)   Level: 1   Coins: 854   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
Undefeated_Yoj   (Warrior)   Level: 1   Coins: 2100   Strength: 800
      Defense: 0   Dexterity: 700   Agility: 400   Health: 100/100   Mana: 400/400   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
Garl_Glittergold   (Paladin)   Level: 1   Coins: 1204   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0

Inventory list of your hero:
Inventory list of Gaerdal_Ironhand
Weapon:
Sword   Cost: 500   Level Require: 1   Damage: 800   
Gaerdal_Ironhand does not have any armor
Gaerdal_Ironhand does not have any potion
Gaerdal_Ironhand does not have any spell
Inventory list of Undefeated_Yoj
Undefeated_Yoj does not have any weapon
Undefeated_Yoj does not have any armor
Undefeated_Yoj does not have any potion
Spell:
Lightning_Dagger   Cost: 400   Level Require: 1   Mana Cost: 150   Spell Type: Lighting   Damage: 500
Inventory list of Garl_Glittergold
Garl_Glittergold does not have any weapon
Armor:
Platinum_Shield   Cost: 150   Level Require: 1   Damage Reduction: 200
Garl_Glittergold does not have any potion
Garl_Glittergold does not have any spell

Sell list of current market:
Weapon:
TSwords   Cost: 1400   Level Require: 8   Damage: 1600   
Axe   Cost: 550   Level Require: 5   Damage: 850   
Armor:
Full_Body_Armor   Cost: 1000   Level Require: 8   Damage Reduction: 1100
Guardian_Angel   Cost: 1000   Level Require: 10   Damage Reduction: 1000
Potion:
Ambrosia   Cost: 1000   Level Require: 8   Increase Type: All   Increase Amount: 150
Mermaid_Tears   Cost: 850   Level Require: 5   Increase Type: Health/Mana/Strength/Agility   Increase Amount: 100
Magic_Potion   Cost: 350   Level Require: 2   Increase Type: Mana   Increase Amount: 100
Spell:
Lava_Comet   Cost: 800   Level Require: 7   Mana Cost: 550   Spell Type: Fire   Damage: 1000
Hell_Storm   Cost: 600   Level Require: 3   Mana Cost: 600   Spell Type: Fire   Damage: 950

Enter the inventory name to buy this item, or enter X to return to the previous menu
Input: X

Press S to sell, B to Buy or X to switch hero to transact or exit market
Input: X

Welcome to market!
Enter the name of hero to select that hero to trade with market, or enter X to exit market
Input: X
  |   |   |   |   | 
* | M |   | M |   | 
M | X |   | X | X | 
  | X |   | M |   | 
  |   |   | M |   | 

Where would you like your team of Heroes to explore? W:North, A:West, D:East, S:south
Input: W
* |   |   |   |   | 
M | M |   | M |   | 
M | X |   | X | X | 
  | X |   | M |   | 
  |   |   | M |   | 

Where would you like your team of Heroes to explore? W:North, A:West, D:East, S:south
Input: D
  | * |   |   |   | 
M | M |   | M |   | 
M | X |   | X | X | 
  | X |   | M |   | 
  |   |   | M |   | 

Where would you like your team of Heroes to explore? W:North, A:West, D:East, S:south
Input: D

OH NO! Hostile monsters approaching! Prepare for battle!
Here is the current state of heroes:
Gaerdal_Ironhand   (Warrior)   Level: 1   Coins: 854   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
Undefeated_Yoj   (Warrior)   Level: 1   Coins: 2100   Strength: 800
      Defense: 0   Dexterity: 700   Agility: 400   Health: 100/100   Mana: 400/400   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
Garl_Glittergold   (Paladin)   Level: 1   Coins: 1204   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0

Here is the current state of monsters:
BigBad-Wolf   (Exoskeletons)   Level: 1
      Strength: 150   Defense: 250   Agility: 150   Health: 100/100
Desghidorrah   (Dragons)   Level: 3
      Strength: 300   Defense: 400   Agility: 350   Health: 100/100
Casper   (Spirits)   Level: 1
      Strength: 100   Defense: 100   Agility: 500   Health: 100/100

It is Gaerdal_Ironhand round!
Gaerdal_Ironhandmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 1
Sword   Cost: 500   Level Require: 1   Damage: 800   
Please enter the name of weapon or armor to equip
If you select a weapon while you currently have a weapon equipped, it will be swapped
Input: Sword
Gaerdal_Ironhand equip weapon Sword, strength increase 800
It is Undefeated_Yoj round!
Undefeated_Yojmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 3
Lightning_Dagger   Cost: 400   Level Require: 1   Mana Cost: 150   Spell Type: Lighting   Damage: 500
Please enter the name of potion or spell to cast
Input: Lightning_Dagger
Enter the monster name which you wanna cast spell at
Input: Desghidorrah
Undefeated_Yojuse spell Lightning_Dagger to deal 35 damage to monster Desghidorrah
Lightning_Dagger type is Lighting, also reduce 20% target monster's agility
It is Garl_Glittergold round!
Garl_Glittergoldmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 1
Platinum_Shield   Cost: 150   Level Require: 1   Damage Reduction: 200
Please enter the name of weapon or armor to equip
If you select a weapon while you currently have a weapon equipped, it will be swapped
Input: Platinum_Shield
Garl_Glittergold equip armor Platinum_Shield, defense increase 200

It is BigBad-Wolf round!
Monster BigBad-Wolf attack Hero Garl_Glittergold
BigBad-Wolf attack was EFFECTIVE! , but Garl_Glittergold has a higher defense than monster strength, Garl_Glittergold has taken 0 damage

It is Desghidorrah round!
Monster Desghidorrah attack Hero Gaerdal_Ironhand
Desghidorrah attack was EFFECTIVE! Gaerdal_Ironhand has taken 15

It is Casper round!
Monster Casper attack Hero Garl_Glittergold
Casper attack was EFFECTIVE! , but Garl_Glittergold has a higher defense than monster strength, Garl_Glittergold has taken 0 damage
It is Gaerdal_Ironhand round!
Gaerdal_Ironhandmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 2
BigBad-Wolf   (Exoskeletons)   Level: 1
      Strength: 150   Defense: 250   Agility: 150   Health: 100/100
Desghidorrah   (Dragons)   Level: 3
      Strength: 300   Defense: 400   Agility: 280   Health: 65/100
Casper   (Spirits)   Level: 1
      Strength: 100   Defense: 100   Agility: 500   Health: 100/100

Enter the monster name which you wanna attack
Input: Desghidorrah
Hero Gaerdal_Ironhand attack Monster Desghidorrah
Gaerdal_Ironhand attack was EFFECTIVE! Desghidorrah has taken 55
It is Undefeated_Yoj round!
Undefeated_Yojmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 3
Lightning_Dagger   Cost: 400   Level Require: 1   Mana Cost: 150   Spell Type: Lighting   Damage: 500
Please enter the name of potion or spell to cast
Input: BigBad-Wolf
Can not find this name in your potion list or spell list
Please enter the name of potion or spell to cast
Input: Lightning_Dagger
Enter the monster name which you wanna cast spell at
Input: BigBad-Wolf
Undefeated_Yojuse spell Lightning_Dagger to deal 35 damage to monster BigBad-Wolf
Lightning_Dagger type is Lighting, also reduce 20% target monster's agility
It is Garl_Glittergold round!
Garl_Glittergoldmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: MI
BigBad-Wolf   (Exoskeletons)   Level: 1
      Strength: 150   Defense: 250   Agility: 120   Health: 65/100
Desghidorrah   (Dragons)   Level: 3
      Strength: 300   Defense: 400   Agility: 280   Health: 10/100
Casper   (Spirits)   Level: 1
      Strength: 100   Defense: 100   Agility: 500   Health: 100/100

Garl_Glittergoldmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 1
Garl_Glittergold currently equip armor Platinum_Shield
Garl_Glittergolddoes not have any weapon and armor in the inventory list
Garl_Glittergoldmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 3
Garl_Glittergolddoes not have any potion and spell
Garl_Glittergoldmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 2
BigBad-Wolf   (Exoskeletons)   Level: 1
      Strength: 150   Defense: 250   Agility: 120   Health: 65/100
Desghidorrah   (Dragons)   Level: 3
      Strength: 300   Defense: 400   Agility: 280   Health: 10/100
Casper   (Spirits)   Level: 1
      Strength: 100   Defense: 100   Agility: 500   Health: 100/100

Enter the monster name which you wanna attack
Input: BigBad
Can not find this monster
Enter the monster name which you wanna attack
Input: BigBad-Wolf
Hero Garl_Glittergold attack Monster BigBad-Wolf
Garl_Glittergold attack was EFFECTIVE! BigBad-Wolf has taken 22

It is BigBad-Wolf round!
Monster BigBad-Wolf attack Hero Undefeated_Yoj
BigBad-Wolf attack was EFFECTIVE! Undefeated_Yoj has taken 7

It is Desghidorrah round!
Monster Desghidorrah attack Hero Garl_Glittergold
Desghidorrah attack was EFFECTIVE! Garl_Glittergold has taken 5

It is Casper round!
Monster Casper attack Hero Garl_Glittergold
Casper attack was EFFECTIVE! , but Garl_Glittergold has a higher defense than monster strength, Garl_Glittergold has taken 0 damage
It is Gaerdal_Ironhand round!
Gaerdal_Ironhandmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 2
BigBad-Wolf   (Exoskeletons)   Level: 1
      Strength: 150   Defense: 250   Agility: 120   Health: 43/100
Desghidorrah   (Dragons)   Level: 3
      Strength: 300   Defense: 400   Agility: 280   Health: 10/100
Casper   (Spirits)   Level: 1
      Strength: 100   Defense: 100   Agility: 500   Health: 100/100

Enter the monster name which you wanna attack
Input: Desghidorrah
Hero Gaerdal_Ironhand attack Monster Desghidorrah
Gaerdal_Ironhand attack was EFFECTIVE! Desghidorrah has taken 55
Desghidorrah dead!
It is Undefeated_Yoj round!
Undefeated_Yojmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 2
BigBad-Wolf   (Exoskeletons)   Level: 1
      Strength: 150   Defense: 250   Agility: 120   Health: 43/100
Desghidorrah   (Dragons)   Level: 3
      Strength: 300   Defense: 400   Agility: 280   Health: 0/100
Casper   (Spirits)   Level: 1
      Strength: 100   Defense: 100   Agility: 500   Health: 100/100

Enter the monster name which you wanna attack
Input: Casper
Hero Undefeated_Yoj attack Monster Casper
Undefeated_Yoj attack was EFFECTIVE! Casper has taken 35
It is Garl_Glittergold round!
Garl_Glittergoldmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 2
BigBad-Wolf   (Exoskeletons)   Level: 1
      Strength: 150   Defense: 250   Agility: 120   Health: 43/100
Desghidorrah   (Dragons)   Level: 3
      Strength: 300   Defense: 400   Agility: 280   Health: 0/100
Casper   (Spirits)   Level: 1
      Strength: 100   Defense: 100   Agility: 500   Health: 65/100

Enter the monster name which you wanna attack
Input: BigBad
Can not find this monster
Enter the monster name which you wanna attack
Input: BigBad-Wolf
Hero Garl_Glittergold attack Monster BigBad-Wolf
Garl_Glittergold attack was EFFECTIVE! BigBad-Wolf has taken 22

It is BigBad-Wolf round!
Monster BigBad-Wolf attack Hero Gaerdal_Ironhand
BigBad-Wolf attack was EFFECTIVE! Gaerdal_Ironhand has taken 7

It is Casper round!
Monster Casper attack Hero Gaerdal_Ironhand
Casper attack was EFFECTIVE! Gaerdal_Ironhand has taken 5
It is Gaerdal_Ironhand round!
Gaerdal_Ironhandmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 2
BigBad-Wolf   (Exoskeletons)   Level: 1
      Strength: 150   Defense: 250   Agility: 120   Health: 21/100
Desghidorrah   (Dragons)   Level: 3
      Strength: 300   Defense: 400   Agility: 280   Health: 0/100
Casper   (Spirits)   Level: 1
      Strength: 100   Defense: 100   Agility: 500   Health: 65/100

Enter the monster name which you wanna attack
Input: Casper
Hero Gaerdal_Ironhand attack Monster Casper
Gaerdal_Ironhand attack was EFFECTIVE! Casper has taken 70
Casper dead!
It is Undefeated_Yoj round!
Undefeated_Yojmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 2
BigBad-Wolf   (Exoskeletons)   Level: 1
      Strength: 150   Defense: 250   Agility: 120   Health: 21/100
Desghidorrah   (Dragons)   Level: 3
      Strength: 300   Defense: 400   Agility: 280   Health: 0/100
Casper   (Spirits)   Level: 1
      Strength: 100   Defense: 100   Agility: 500   Health: 0/100

Enter the monster name which you wanna attack
Input: Casper
Casper is dead, cant attack!
Enter the monster name which you wanna attack
Input: 2
Can not find this monster
Enter the monster name which you wanna attack
Input: BigBad-Wolf
Hero Undefeated_Yoj attack Monster BigBad-Wolf
Undefeated_Yoj attack was EFFECTIVE! BigBad-Wolf has taken 27
BigBad-Wolf dead!

Congratulation! Monsters has been beaten by your hero!
Garl_Glittergold get 300 gold
Garl_Glittergold get 6 experience
Garl_Glittergold level up! current level is 2
Gaerdal_Ironhand get 300 gold
Gaerdal_Ironhand get 6 experience
Gaerdal_Ironhand level up! current level is 2
Undefeated_Yoj get 300 gold
Undefeated_Yoj get 6 experience
Undefeated_Yoj level up! current level is 2
  |   | * |   |   | 
M | M |   | M |   | 
M | X |   | X | X | 
  | X |   | M |   | 
  |   |   | M |   | 

Where would you like your team of Heroes to explore? W:North, A:West, D:East, S:south
Input: I
Garl_Glittergold   (Paladin)   Level: 2   Coins: 1504   Strength: 1050
      Defense: 50   Dexterity: 900   Agility: 600   Health: 130/130   Mana: 130/130   Exp: 3/20
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
Gaerdal_Ironhand   (Warrior)   Level: 2   Coins: 1154   Strength: 1050
      Defense: 50   Dexterity: 720   Agility: 750   Health: 130/130   Mana: 130/130   Exp: 3/20
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
Undefeated_Yoj   (Warrior)   Level: 2   Coins: 2400   Strength: 1200
      Defense: 50   Dexterity: 840   Agility: 600   Health: 130/130   Mana: 520/520   Exp: 3/20
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0

  |   | * |   |   | 
M | M |   | M |   | 
M | X |   | X | X | 
  | X |   | M |   | 
  |   |   | M |   | 

Where would you like your team of Heroes to explore? W:North, A:West, D:East, S:south
Input: W
Invalid movement position

  |   | * |   |   | 
M | M |   | M |   | 
M | X |   | X | X | 
  | X |   | M |   | 
  |   |   | M |   | 

Where would you like your team of Heroes to explore? W:North, A:West, D:East, S:south
Input: Q
Exit game, See you next time!

Process finished with exit code 0



## Input/Output Example 2
---------------------------------------------------------------------------
Please enter the size of the map, minimum size is 5 and maximum is 10
Input: 8
Please enter the size of the hero in your team, minimum size is 1 and maximum is 3
Input: 1
------------------------------------
0: Gaerdal_Ironhand   (Warrior)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
1: Sehanine_Monnbow   (Warrior)   Level: 1   Coins: 2500   Strength: 700
      Defense: 0   Dexterity: 500   Agility: 800   Health: 100/100   Mana: 600/600   Exp: 8/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
2: Muamman_Duathall   (Warrior)   Level: 1   Coins: 2546   Strength: 900
      Defense: 0   Dexterity: 750   Agility: 500   Health: 100/100   Mana: 300/300   Exp: 6/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
3: Flandal_Steelskin   (Warrior)   Level: 1   Coins: 2500   Strength: 750
      Defense: 0   Dexterity: 700   Agility: 650   Health: 100/100   Mana: 200/200   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
4: Undefeated_Yoj   (Warrior)   Level: 1   Coins: 2500   Strength: 800
      Defense: 0   Dexterity: 700   Agility: 400   Health: 100/100   Mana: 400/400   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
5: Eunoia_Cyn   (Warrior)   Level: 1   Coins: 2500   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 800   Health: 100/100   Mana: 400/400   Exp: 6/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
6: Rillifane_Rallathil   (Sorcerer)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
7: Segojan_Earthcaller   (Sorcerer)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
8: Reign_Havoc   (Sorcerer)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
9: Reverie_Ashels   (Sorcerer)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
10: Kalabar   (Sorcerer)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
11: Skye_Soar   (Sorcerer)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
12: Parzival   (Paladin)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
13: Sehanine_Moonbow   (Paladin)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
14: Skoraeus_Stonebones   (Paladin)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
15: Garl_Glittergold   (Paladin)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
16: Amaryllis_Astra   (Paladin)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
17: Caliber_Heist   (Paladin)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0
------------------------------------

Enter the index of hero to pick this hero to your team, 0 - 17
Pick 1 hero
Input: 4
Here are your controls:
      To move around the map, use your W,A,S,D keys!
W -> North, A -> West, S -> South, D -> East
* is the current position of your current in the map, M represents a market position and X represents a position that inaccessible
Enter I at any time to view your team's status. This command works in the midst of a battle tool!
When in battle, you may also enter MI to view monster status.
Enter Q at any time to exit game. However, let's not get try sneaky and use it to escape battle.
Enter H at any time to view this instruction.
Think that should be all! Make sure you read and understand the command thoroughly. Have fun!

* |   |   |   |   |   |   | M | 
  | X |   | M |   |   |   | M | 
  | M |   | X | M | X | M |   | 
X |   |   |   | X | M |   | M | 
  |   | M |   |   | X |   | M | 
  | X |   | M |   | M |   |   | 
  | X | X | M | X | X | X | M | 
  | M |   | M | M | M |   |   | 

Where would you like your team of Heroes to explore? W:North, A:West, D:East, S:south
Input: S

OH NO! Hostile monsters approaching! Prepare for battle!
Here is the current state of heroes:
Undefeated_Yoj   (Warrior)   Level: 1   Coins: 2500   Strength: 800
      Defense: 0   Dexterity: 700   Agility: 400   Health: 100/100   Mana: 400/400   Exp: 7/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0

Here is the current state of monsters:
Casper   (Spirits)   Level: 1
      Strength: 100   Defense: 100   Agility: 500   Health: 100/100

It is Undefeated_Yoj round!
Undefeated_Yojmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 1
Undefeated_Yojdoes not have any weapon and armor in the inventory list
Undefeated_Yojmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 3
Undefeated_Yojdoes not have any potion and spell
Undefeated_Yojmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 2
Casper   (Spirits)   Level: 1
      Strength: 100   Defense: 100   Agility: 500   Health: 100/100

Enter the monster name which you wanna attack
Input: Casper
Hero Undefeated_Yoj attack Monster Casper
Undefeated_Yoj attack was EFFECTIVE! Casper has taken 35

It is Casper round!
Monster Casper attack Hero Undefeated_Yoj
Casper attack was EFFECTIVE! Undefeated_Yoj has taken 5
It is Undefeated_Yoj round!
Undefeated_Yojmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 2
Casper   (Spirits)   Level: 1
      Strength: 100   Defense: 100   Agility: 500   Health: 65/100

Enter the monster name which you wanna attack
Input: Casper
Hero Undefeated_Yoj attack Monster Casper
Undefeated_Yoj attack was EFFECTIVE! Casper has taken 35

It is Casper round!
Monster Casper attack Hero Undefeated_Yoj
Casper attack was EFFECTIVE! Undefeated_Yoj has taken 5
It is Undefeated_Yoj round!
Undefeated_Yojmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 2
Casper   (Spirits)   Level: 1
      Strength: 100   Defense: 100   Agility: 500   Health: 30/100

Enter the monster name which you wanna attack
Input: Casper
Hero Undefeated_Yoj attack Monster Casper
Undefeated_Yoj attack was EFFECTIVE! Casper has taken 35
Casper dead!

Congratulation! Monsters has been beaten by your hero!
Undefeated_Yoj get 100 gold
Undefeated_Yoj get 2 experience
  |   |   |   |   |   |   | M | 
* | X |   | M |   |   |   | M | 
  | M |   | X | M | X | M |   | 
X |   |   |   | X | M |   | M | 
  |   | M |   |   | X |   | M | 
  | X |   | M |   | M |   |   | 
  | X | X | M | X | X | X | M | 
  | M |   | M | M | M |   |   | 

Where would you like your team of Heroes to explore? W:North, A:West, D:East, S:south
Input: S
  |   |   |   |   |   |   | M | 
  | X |   | M |   |   |   | M | 
* | M |   | X | M | X | M |   | 
X |   |   |   | X | M |   | M | 
  |   | M |   |   | X |   | M | 
  | X |   | M |   | M |   |   | 
  | X | X | M | X | X | X | M | 
  | M |   | M | M | M |   |   | 

Where would you like your team of Heroes to explore? W:North, A:West, D:East, S:south
Input: D

Welcome to market!
Enter the name of hero to select that hero to trade with market, or enter X to exit market
Input: I
Undefeated_Yoj   (Warrior)   Level: 1   Coins: 2600   Strength: 800
      Defense: 0   Dexterity: 700   Agility: 400   Health: 100/100   Mana: 400/400   Exp: 9/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0

Inventory list of your hero:
Inventory list of Undefeated_Yoj
Undefeated_Yoj does not have any weapon
Undefeated_Yoj does not have any armor
Undefeated_Yoj does not have any potion
Undefeated_Yoj does not have any spell

Welcome to market!
Enter the name of hero to select that hero to trade with market, or enter X to exit market
Undefeated_Yoj

Press S to sell, B to Buy or X to switch hero to transact or exit market
Input: S
Undefeated_Yoj does not have any inventory, can not sell any thing!

Press S to sell, B to Buy or X to switch hero to transact or exit market
Input: B

Sell list of current market:
Weapon:
Dagger   Cost: 200   Level Require: 1   Damage: 250   
Sword   Cost: 500   Level Require: 1   Damage: 800   
Axe   Cost: 550   Level Require: 5   Damage: 850   
Armor:
Guardian_Angel   Cost: 1000   Level Require: 10   Damage Reduction: 1000
Full_Body_Armor   Cost: 1000   Level Require: 8   Damage Reduction: 1100
Breastplate   Cost: 350   Level Require: 3   Damage Reduction: 600
Potion:
Healing_Potion   Cost: 250   Level Require: 1   Increase Type: Health   Increase Amount: 100
Ambrosia   Cost: 1000   Level Require: 8   Increase Type: All   Increase Amount: 150
Magic_Potion   Cost: 350   Level Require: 2   Increase Type: Mana   Increase Amount: 100
Spell:
Lava_Comet   Cost: 800   Level Require: 7   Mana Cost: 550   Spell Type: Fire   Damage: 1000
Frost_Blizzard   Cost: 750   Level Require: 5   Mana Cost: 350   Spell Type: Ice   Damage: 850
Snow_Cannon   Cost: 500   Level Require: 2   Mana Cost: 250   Spell Type: Ice   Damage: 650

Enter the inventory name to buy this item, or enter X to return to the previous menu
Input: Dagger
Undefeated_Yoj spent 200 money to buy Dagger

Sell list of current market:
Weapon:
Sword   Cost: 500   Level Require: 1   Damage: 800   
Axe   Cost: 550   Level Require: 5   Damage: 850   
Armor:
Guardian_Angel   Cost: 1000   Level Require: 10   Damage Reduction: 1000
Full_Body_Armor   Cost: 1000   Level Require: 8   Damage Reduction: 1100
Breastplate   Cost: 350   Level Require: 3   Damage Reduction: 600
Potion:
Healing_Potion   Cost: 250   Level Require: 1   Increase Type: Health   Increase Amount: 100
Ambrosia   Cost: 1000   Level Require: 8   Increase Type: All   Increase Amount: 150
Magic_Potion   Cost: 350   Level Require: 2   Increase Type: Mana   Increase Amount: 100
Spell:
Lava_Comet   Cost: 800   Level Require: 7   Mana Cost: 550   Spell Type: Fire   Damage: 1000
Frost_Blizzard   Cost: 750   Level Require: 5   Mana Cost: 350   Spell Type: Ice   Damage: 850
Snow_Cannon   Cost: 500   Level Require: 2   Mana Cost: 250   Spell Type: Ice   Damage: 650

Enter the inventory name to buy this item, or enter X to return to the previous menu
Input: Healing_Potion
Undefeated_Yoj spent 250 money to buy Healing_Potion

Sell list of current market:
Weapon:
Sword   Cost: 500   Level Require: 1   Damage: 800   
Axe   Cost: 550   Level Require: 5   Damage: 850   
Armor:
Guardian_Angel   Cost: 1000   Level Require: 10   Damage Reduction: 1000
Full_Body_Armor   Cost: 1000   Level Require: 8   Damage Reduction: 1100
Breastplate   Cost: 350   Level Require: 3   Damage Reduction: 600
Potion:
Ambrosia   Cost: 1000   Level Require: 8   Increase Type: All   Increase Amount: 150
Magic_Potion   Cost: 350   Level Require: 2   Increase Type: Mana   Increase Amount: 100
Spell:
Lava_Comet   Cost: 800   Level Require: 7   Mana Cost: 550   Spell Type: Fire   Damage: 1000
Frost_Blizzard   Cost: 750   Level Require: 5   Mana Cost: 350   Spell Type: Ice   Damage: 850
Snow_Cannon   Cost: 500   Level Require: 2   Mana Cost: 250   Spell Type: Ice   Damage: 650

Enter the inventory name to buy this item, or enter X to return to the previous menu
Input: Magic_Potion
Undefeated_Yoj does not require level to buy this item

Sell list of current market:
Weapon:
Sword   Cost: 500   Level Require: 1   Damage: 800   
Axe   Cost: 550   Level Require: 5   Damage: 850   
Armor:
Guardian_Angel   Cost: 1000   Level Require: 10   Damage Reduction: 1000
Full_Body_Armor   Cost: 1000   Level Require: 8   Damage Reduction: 1100
Breastplate   Cost: 350   Level Require: 3   Damage Reduction: 600
Potion:
Ambrosia   Cost: 1000   Level Require: 8   Increase Type: All   Increase Amount: 150
Magic_Potion   Cost: 350   Level Require: 2   Increase Type: Mana   Increase Amount: 100
Spell:
Lava_Comet   Cost: 800   Level Require: 7   Mana Cost: 550   Spell Type: Fire   Damage: 1000
Frost_Blizzard   Cost: 750   Level Require: 5   Mana Cost: 350   Spell Type: Ice   Damage: 850
Snow_Cannon   Cost: 500   Level Require: 2   Mana Cost: 250   Spell Type: Ice   Damage: 650

Enter the inventory name to buy this item, or enter X to return to the previous menu
Input: X

Press S to sell, B to Buy or X to switch hero to transact or exit market
Input: X

Welcome to market!
Enter the name of hero to select that hero to trade with market, or enter X to exit market
X
  |   |   |   |   |   |   | M | 
  | X |   | M |   |   |   | M | 
  | * |   | X | M | X | M |   | 
X |   |   |   | X | M |   | M | 
  |   | M |   |   | X |   | M | 
  | X |   | M |   | M |   |   | 
  | X | X | M | X | X | X | M | 
  | M |   | M | M | M |   |   | 

Where would you like your team of Heroes to explore? W:North, A:West, D:East, S:south
Input: D

OH NO! Hostile monsters approaching! Prepare for battle!
Here is the current state of heroes:
Undefeated_Yoj   (Warrior)   Level: 1   Coins: 2150   Strength: 800
      Defense: 0   Dexterity: 700   Agility: 400   Health: 100/100   Mana: 400/400   Exp: 9/10
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0

Here is the current state of monsters:
WickedWitch   (Exoskeletons)   Level: 2
      Strength: 250   Defense: 350   Agility: 250   Health: 100/100

It is Undefeated_Yoj round!
Undefeated_Yojmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 1
Dagger   Cost: 200   Level Require: 1   Damage: 250   
Please enter the name of weapon or armor to equip
If you select a weapon while you currently have a weapon equipped, it will be swapped
Input: Dagger
Undefeated_Yoj equip weapon Dagger, strength increase 250

It is WickedWitch round!
Monster WickedWitch attack Hero Undefeated_Yoj
WickedWitch attack was EFFECTIVE! Undefeated_Yoj has taken 12
It is Undefeated_Yoj round!
Undefeated_Yojmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 2
WickedWitch   (Exoskeletons)   Level: 2
      Strength: 250   Defense: 350   Agility: 250   Health: 100/100

Enter the monster name which you wanna attack
Input: WickedWitch
Hero Undefeated_Yoj attack Monster WickedWitch
Undefeated_Yoj attack was EFFECTIVE! WickedWitch has taken 35

It is WickedWitch round!
Monster WickedWitch attack Hero Undefeated_Yoj
WickedWitch attack was EFFECTIVE! Undefeated_Yoj has taken 12
It is Undefeated_Yoj round!
Undefeated_Yojmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: I
Undefeated_Yoj   (Warrior)   Level: 1   Coins: 2150   Strength: 800
      Defense: 0   Dexterity: 700   Agility: 400   Health: 76/100   Mana: 400/400   Exp: 9/10
Strength increase in the battle: 250   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0

Undefeated_Yojmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 2
WickedWitch   (Exoskeletons)   Level: 2
      Strength: 250   Defense: 350   Agility: 250   Health: 65/100

Enter the monster name which you wanna attack
Input: WickedWitch
Hero Undefeated_Yoj attack Monster WickedWitch
Undefeated_Yoj attack was EFFECTIVE! WickedWitch has taken 35

It is WickedWitch round!
Monster WickedWitch attack Hero Undefeated_Yoj
WickedWitch attack was EFFECTIVE! Undefeated_Yoj has taken 12
It is Undefeated_Yoj round!
Undefeated_Yojmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 2
WickedWitch   (Exoskeletons)   Level: 2
      Strength: 250   Defense: 350   Agility: 250   Health: 30/100

Enter the monster name which you wanna attack
Input: WickedWitch
Hero Undefeated_Yoj attack Monster WickedWitch
Undefeated_Yoj attack was EFFECTIVE! WickedWitch has taken 35
WickedWitch dead!

Congratulation! Monsters has been beaten by your hero!
Undefeated_Yoj get 100 gold
Undefeated_Yoj get 2 experience
Undefeated_Yoj level up! current level is 2
  |   |   |   |   |   |   | M | 
  | X |   | M |   |   |   | M | 
  | M | * | X | M | X | M |   | 
X |   |   |   | X | M |   | M | 
  |   | M |   |   | X |   | M | 
  | X |   | M |   | M |   |   | 
  | X | X | M | X | X | X | M | 
  | M |   | M | M | M |   |   | 

Where would you like your team of Heroes to explore? W:North, A:West, D:East, S:south
Input: I
Undefeated_Yoj   (Warrior)   Level: 2   Coins: 2250   Strength: 1200
      Defense: 50   Dexterity: 840   Agility: 600   Health: 130/130   Mana: 520/520   Exp: 1/20
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0

  |   |   |   |   |   |   | M | 
  | X |   | M |   |   |   | M | 
  | M | * | X | M | X | M |   | 
X |   |   |   | X | M |   | M | 
  |   | M |   |   | X |   | M | 
  | X |   | M |   | M |   |   | 
  | X | X | M | X | X | X | M | 
  | M |   | M | M | M |   |   | 

Where would you like your team of Heroes to explore? W:North, A:West, D:East, S:south
Input: S

OH NO! Hostile monsters approaching! Prepare for battle!
Here is the current state of heroes:
Undefeated_Yoj   (Warrior)   Level: 2   Coins: 2250   Strength: 1200
      Defense: 50   Dexterity: 840   Agility: 600   Health: 130/130   Mana: 520/520   Exp: 1/20
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0

Here is the current state of monsters:
Blinky   (Spirits)   Level: 1
      Strength: 450   Defense: 350   Agility: 350   Health: 100/100

It is Undefeated_Yoj round!
Undefeated_Yojmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 1
Dagger   Cost: 200   Level Require: 1   Damage: 250   
Please enter the name of weapon or armor to equip
If you select a weapon while you currently have a weapon equipped, it will be swapped
Input: Dagger
Undefeated_Yoj equip weapon Dagger, strength increase 250

It is Blinky round!
Monster Blinky attack Hero Undefeated_Yoj
Blinky attack was EFFECTIVE! Undefeated_Yoj has taken 20
It is Undefeated_Yoj round!
Undefeated_Yojmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 2
Blinky   (Spirits)   Level: 1
      Strength: 450   Defense: 350   Agility: 350   Health: 100/100

Enter the monster name which you wanna attack
Input: Blinky
Hero Undefeated_Yoj attack Monster Blinky
Undefeated_Yoj attack was EFFECTIVE! Blinky has taken 55

It is Blinky round!
Monster Blinky attack Hero Undefeated_Yoj
Blinky attack was EFFECTIVE! Undefeated_Yoj has taken 20
It is Undefeated_Yoj round!
Undefeated_Yojmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 2
Blinky   (Spirits)   Level: 1
      Strength: 450   Defense: 350   Agility: 350   Health: 45/100

Enter the monster name which you wanna attack
Input: Blinky
Hero Undefeated_Yoj attack Monster Blinky
Undefeated_Yoj attack was EFFECTIVE! Blinky has taken 55
Blinky dead!

Congratulation! Monsters has been beaten by your hero!
Undefeated_Yoj get 200 gold
Undefeated_Yoj get 2 experience
  |   |   |   |   |   |   | M | 
  | X |   | M |   |   |   | M | 
  | M |   | X | M | X | M |   | 
X |   | * |   | X | M |   | M | 
  |   | M |   |   | X |   | M | 
  | X |   | M |   | M |   |   | 
  | X | X | M | X | X | X | M | 
  | M |   | M | M | M |   |   | 

Where would you like your team of Heroes to explore? W:North, A:West, D:East, S:south
Input: S

Welcome to market!
Enter the name of hero to select that hero to trade with market, or enter X to exit market
Input: Undefeated_Yoj

Press S to sell, B to Buy or X to switch hero to transact or exit market
Input: B

Sell list of current market:
Weapon:
Scythe   Cost: 1000   Level Require: 6   Damage: 1100   
Axe   Cost: 550   Level Require: 5   Damage: 850   
TSwords   Cost: 1400   Level Require: 8   Damage: 1600   
Armor:
Guardian_Angel   Cost: 1000   Level Require: 10   Damage Reduction: 1000
Wizard_Shield   Cost: 1200   Level Require: 10   Damage Reduction: 1500
Breastplate   Cost: 350   Level Require: 3   Damage Reduction: 600
Potion:
Magic_Potion   Cost: 350   Level Require: 2   Increase Type: Mana   Increase Amount: 100
Mermaid_Tears   Cost: 850   Level Require: 5   Increase Type: Health/Mana/Strength/Agility   Increase Amount: 100
Ambrosia   Cost: 1000   Level Require: 8   Increase Type: All   Increase Amount: 150
Spell:
Lightning_Dagger   Cost: 400   Level Require: 1   Mana Cost: 150   Spell Type: Lighting   Damage: 500
Hell_Storm   Cost: 600   Level Require: 3   Mana Cost: 600   Spell Type: Fire   Damage: 950
Snow_Cannon   Cost: 500   Level Require: 2   Mana Cost: 250   Spell Type: Ice   Damage: 650

Enter the inventory name to buy this item, or enter X to return to the previous menu
Input: Magic_Potion
Undefeated_Yoj spent 350 money to buy Magic_Potion

Sell list of current market:
Weapon:
Scythe   Cost: 1000   Level Require: 6   Damage: 1100   
Axe   Cost: 550   Level Require: 5   Damage: 850   
TSwords   Cost: 1400   Level Require: 8   Damage: 1600   
Armor:
Guardian_Angel   Cost: 1000   Level Require: 10   Damage Reduction: 1000
Wizard_Shield   Cost: 1200   Level Require: 10   Damage Reduction: 1500
Breastplate   Cost: 350   Level Require: 3   Damage Reduction: 600
Potion:
Mermaid_Tears   Cost: 850   Level Require: 5   Increase Type: Health/Mana/Strength/Agility   Increase Amount: 100
Ambrosia   Cost: 1000   Level Require: 8   Increase Type: All   Increase Amount: 150
Spell:
Lightning_Dagger   Cost: 400   Level Require: 1   Mana Cost: 150   Spell Type: Lighting   Damage: 500
Hell_Storm   Cost: 600   Level Require: 3   Mana Cost: 600   Spell Type: Fire   Damage: 950
Snow_Cannon   Cost: 500   Level Require: 2   Mana Cost: 250   Spell Type: Ice   Damage: 650

Enter the inventory name to buy this item, or enter X to return to the previous menu
Input: Lightning_Dagger
Undefeated_Yoj spent 400 money to buy Lightning_Dagger

Sell list of current market:
Weapon:
Scythe   Cost: 1000   Level Require: 6   Damage: 1100   
Axe   Cost: 550   Level Require: 5   Damage: 850   
TSwords   Cost: 1400   Level Require: 8   Damage: 1600   
Armor:
Guardian_Angel   Cost: 1000   Level Require: 10   Damage Reduction: 1000
Wizard_Shield   Cost: 1200   Level Require: 10   Damage Reduction: 1500
Breastplate   Cost: 350   Level Require: 3   Damage Reduction: 600
Potion:
Mermaid_Tears   Cost: 850   Level Require: 5   Increase Type: Health/Mana/Strength/Agility   Increase Amount: 100
Ambrosia   Cost: 1000   Level Require: 8   Increase Type: All   Increase Amount: 150
Spell:
Hell_Storm   Cost: 600   Level Require: 3   Mana Cost: 600   Spell Type: Fire   Damage: 950
Snow_Cannon   Cost: 500   Level Require: 2   Mana Cost: 250   Spell Type: Ice   Damage: 650

Enter the inventory name to buy this item, or enter X to return to the previous menu
Input: Snow_Cannon
Undefeated_Yoj spent 500 money to buy Snow_Cannon

Sell list of current market:
Weapon:
Scythe   Cost: 1000   Level Require: 6   Damage: 1100   
Axe   Cost: 550   Level Require: 5   Damage: 850   
TSwords   Cost: 1400   Level Require: 8   Damage: 1600   
Armor:
Guardian_Angel   Cost: 1000   Level Require: 10   Damage Reduction: 1000
Wizard_Shield   Cost: 1200   Level Require: 10   Damage Reduction: 1500
Breastplate   Cost: 350   Level Require: 3   Damage Reduction: 600
Potion:
Mermaid_Tears   Cost: 850   Level Require: 5   Increase Type: Health/Mana/Strength/Agility   Increase Amount: 100
Ambrosia   Cost: 1000   Level Require: 8   Increase Type: All   Increase Amount: 150
Spell:
Hell_Storm   Cost: 600   Level Require: 3   Mana Cost: 600   Spell Type: Fire   Damage: 950

Enter the inventory name to buy this item, or enter X to return to the previous menu
Input: X

Press S to sell, B to Buy or X to switch hero to transact or exit market
Input: X

Welcome to market!
Enter the name of hero to select that hero to trade with market, or enter X to exit market
Input: X
  |   |   |   |   |   |   | M | 
  | X |   | M |   |   |   | M | 
  | M |   | X | M | X | M |   | 
X |   |   |   | X | M |   | M | 
  |   | * |   |   | X |   | M | 
  | X |   | M |   | M |   |   | 
  | X | X | M | X | X | X | M | 
  | M |   | M | M | M |   |   | 

Where would you like your team of Heroes to explore? W:North, A:West, D:East, S:south
Input: W
  |   |   |   |   |   |   | M | 
  | X |   | M |   |   |   | M | 
  | M |   | X | M | X | M |   | 
X |   | * |   | X | M |   | M | 
  |   | M |   |   | X |   | M | 
  | X |   | M |   | M |   |   | 
  | X | X | M | X | X | X | M | 
  | M |   | M | M | M |   |   | 

Where would you like your team of Heroes to explore? W:North, A:West, D:East, S:south
Input: W
  |   |   |   |   |   |   | M | 
  | X |   | M |   |   |   | M | 
  | M | * | X | M | X | M |   | 
X |   |   |   | X | M |   | M | 
  |   | M |   |   | X |   | M | 
  | X |   | M |   | M |   |   | 
  | X | X | M | X | X | X | M | 
  | M |   | M | M | M |   |   | 

Where would you like your team of Heroes to explore? W:North, A:West, D:East, S:south
Input: W

OH NO! Hostile monsters approaching! Prepare for battle!
Here is the current state of heroes:
Undefeated_Yoj   (Warrior)   Level: 2   Coins: 1200   Strength: 1200
      Defense: 50   Dexterity: 840   Agility: 600   Health: 116/130   Mana: 520/520   Exp: 3/20
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0

Here is the current state of monsters:
Andrealphus   (Spirits)   Level: 2
      Strength: 150   Defense: 500   Agility: 400   Health: 100/100

It is Undefeated_Yoj round!
Undefeated_Yojmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 3
Lightning_Dagger   Cost: 400   Level Require: 1   Mana Cost: 150   Spell Type: Lighting   Damage: 500
Snow_Cannon   Cost: 500   Level Require: 2   Mana Cost: 250   Spell Type: Ice   Damage: 650
Healing_Potion   Cost: 250   Level Require: 1   Increase Type: Health   Increase Amount: 100
Magic_Potion   Cost: 350   Level Require: 2   Increase Type: Mana   Increase Amount: 100
Please enter the name of potion or spell to cast
Input: I
Undefeated_Yoj   (Warrior)   Level: 2   Coins: 1200   Strength: 1200
      Defense: 50   Dexterity: 840   Agility: 600   Health: 116/130   Mana: 520/520   Exp: 3/20
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0

Please enter the name of potion or spell to cast
Input: Lightning_Dagger
Enter the monster name which you wanna cast spell at
Input: Andrealphus
Undefeated_Yojuse spell Lightning_Dagger to deal 42 damage to monster Andrealphus
Lightning_Dagger type is Lighting, also reduce 20% target monster's agility

It is Andrealphus round!
Monster Andrealphus attack Hero Undefeated_Yoj
Andrealphus attack was EFFECTIVE! Undefeated_Yoj has taken 5
It is Undefeated_Yoj round!
Undefeated_Yojmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 3
Lightning_Dagger   Cost: 400   Level Require: 1   Mana Cost: 150   Spell Type: Lighting   Damage: 500
Snow_Cannon   Cost: 500   Level Require: 2   Mana Cost: 250   Spell Type: Ice   Damage: 650
Healing_Potion   Cost: 250   Level Require: 1   Increase Type: Health   Increase Amount: 100
Magic_Potion   Cost: 350   Level Require: 2   Increase Type: Mana   Increase Amount: 100
Please enter the name of potion or spell to cast
Input: Snow_Cannon
Enter the monster name which you wanna cast spell at
Input: Andrealphus
Undefeated_Yojuse spell Snow_Cannon to deal 54 damage to monster Andrealphus
Snow_Cannon type is Ice, also reduce 20% target monster's strength

It is Andrealphus round!
Monster Andrealphus attack Hero Undefeated_Yoj
Andrealphus attack was EFFECTIVE! Undefeated_Yoj has taken 3
It is Undefeated_Yoj round!
Undefeated_Yojmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: I
Undefeated_Yoj   (Warrior)   Level: 2   Coins: 1200   Strength: 1200
      Defense: 50   Dexterity: 840   Agility: 600   Health: 108/130   Mana: 120/520   Exp: 3/20
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0

Undefeated_Yojmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 3
Lightning_Dagger   Cost: 400   Level Require: 1   Mana Cost: 150   Spell Type: Lighting   Damage: 500
Snow_Cannon   Cost: 500   Level Require: 2   Mana Cost: 250   Spell Type: Ice   Damage: 650
Healing_Potion   Cost: 250   Level Require: 1   Increase Type: Health   Increase Amount: 100
Magic_Potion   Cost: 350   Level Require: 2   Increase Type: Mana   Increase Amount: 100
Please enter the name of potion or spell to cast
Input: Snow_Cannon
Undefeated_Yoj does not have enough mana to cast this spell
Undefeated_Yojmay either 1: Equip gear [Armor/Weapon], 2: Attack an enemy monster, 3: Use Potion or Case Spell
Please enter 1,2 or 3 corresponding to your choice of action, or enter I or MI to check hero state and monster state: 
Input: 2
Andrealphus   (Spirits)   Level: 2
      Strength: 120   Defense: 500   Agility: 320   Health: 4/100

Enter the monster name which you wanna attack
Input: Andrealphus
Hero Undefeated_Yoj attack Monster Andrealphus
Undefeated_Yoj attack was EFFECTIVE! Andrealphus has taken 35
Andrealphus dead!

Congratulation! Monsters has been beaten by your hero!
Undefeated_Yoj get 200 gold
Undefeated_Yoj get 2 experience
  |   |   |   |   |   |   | M | 
  | X | * | M |   |   |   | M | 
  | M |   | X | M | X | M |   | 
X |   |   |   | X | M |   | M | 
  |   | M |   |   | X |   | M | 
  | X |   | M |   | M |   |   | 
  | X | X | M | X | X | X | M | 
  | M |   | M | M | M |   |   | 

Where would you like your team of Heroes to explore? W:North, A:West, D:East, S:south
Input: I
Undefeated_Yoj   (Warrior)   Level: 2   Coins: 1400   Strength: 1200
      Defense: 50   Dexterity: 840   Agility: 600   Health: 130/130   Mana: 224/520   Exp: 5/20
Strength increase in the battle: 0   Defense increase in the battle: 0   Agility increase in the battle: 0   Dexterity increase in the battle: 0

  |   |   |   |   |   |   | M | 
  | X | * | M |   |   |   | M | 
  | M |   | X | M | X | M |   | 
X |   |   |   | X | M |   | M | 
  |   | M |   |   | X |   | M | 
  | X |   | M |   | M |   |   | 
  | X | X | M | X | X | X | M | 
  | M |   | M | M | M |   |   | 

Where would you like your team of Heroes to explore? W:North, A:West, D:East, S:south
Input: Q
Exit game, See you next time!

Process finished with exit code 0
