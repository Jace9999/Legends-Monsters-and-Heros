package Enums;

/**
 * @Author: Jun Zhu
 * @Date: 10/30/2022 11:02 AM
 * @Description: enum for separate different unit type
 */
public enum UnitType {
    Inaccessible_Type(1, "X"),
    Market_Type(2, "M"),
    Common_Type(3," "),
    Player_Position(9,"*");


    private String symbol;
    private int typeNum;

    public static String getSymbolByIndex(int index){
        for(UnitType symbol : UnitType.values()){
            if(index == symbol.getTypeNum()){
                return symbol.getSymbol();
            }
        }
        return "";
    }

    UnitType(int typeNum, String symbol) {
        this.symbol = symbol;
        this.typeNum = typeNum;
    }

    public static int getTypeNumBySymbol(String symbol){
        for(UnitType type : UnitType.values()){
            if(type.getSymbol().equals(symbol)){
                return type.getTypeNum();
            }
        }
        return 99;
    }
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getTypeNum() {
        return typeNum;
    }

    public void setTypeNum(int typeNum) {
        this.typeNum = typeNum;
    }
}
