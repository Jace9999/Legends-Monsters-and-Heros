import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: Jun Zhu
 * @Date: 10/29/2022 5:04 PM
 * @Description: represent a unit on the map
 */
public class Unit {

    private String symbol;

    private Market market;

    private List<Monster> monsters;

    public Unit(String symbol, Market market, List<Monster> monsters) {
        this.symbol = symbol;
        this.market = market;
        this.monsters = monsters;
    }

    public void initiateMonster(int  currentHighestHeroLevel){
        Random random = new Random();
        List<Monster> monsterList;
        if(currentHighestHeroLevel <=3){
            monsterList = Database.lowLevelMonsters;
        }else if(currentHighestHeroLevel <=6){
            monsterList = Database.mediumLevelMonsters;
        }else{
            monsterList = Database.highLevelMonsters;
        }
        monsters = new ArrayList<>();
        for(int i=0;i<Game.heroNum;i++){
            int monsterIndex = random.nextInt(monsterList.size());
            monsters.add(monsterList.get(monsterIndex));
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }
}