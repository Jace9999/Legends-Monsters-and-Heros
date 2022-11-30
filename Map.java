import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Enums.UnitType.*;
import static Enums.UnitType.Market_Type;

/**
 * @Author: Jun Zhu
 * @Date: 10/29/2022 5:01 PM
 * @Description: map class, contains the size of map which is able to scalable and a 2D unit array
 */
public class Map {
    private int boardSize;

    private Unit boardArray[][];

    public Map(int boardSize, Unit[][] boardArray) {
        this.boardSize = boardSize;
        this.boardArray = boardArray;
        initiateMap();
    }

    private void initiateMap(){
        List<Integer> mapList = new ArrayList<>();
        Unit[][] boardArray = this.boardArray;
        for(int i=1;i<boardSize*boardSize;i++){
            mapList.add(i);
            boardArray[i/boardSize][i%boardSize] = new Unit(Common_Type.getSymbol(),null,new ArrayList<>());
        }
        boardArray[0][0] = new Unit(Player_Position.getSymbol(),null,new ArrayList<>());
        Random random = new Random();
        //initiateMap for inaccessible
        for(int i=0;i<boardSize*boardSize/10*2;i++){
            int positionNum  = initiateMap(boardSize, boardArray, random);
            boardArray[positionNum/boardSize][positionNum%boardSize].setSymbol(Inaccessible_Type.getSymbol());
        }
        //initiateMap for market
        for(int i=0;i<boardSize*boardSize/10*3;i++){
            int positionNum  = initiateMap(boardSize, boardArray, random);
            boardArray[positionNum/boardSize][positionNum%boardSize].setSymbol(Market_Type.getSymbol());
            Market market = new Market();
            market.initiateMarket();
            boardArray[positionNum/boardSize][positionNum%boardSize].setMarket(market);
        }
    }

    private int initiateMap(int boardSize, Unit[][] boardArray, Random random) {
        boolean validRandomNum = false;
        int positionNum = 0;
        while (!validRandomNum){
            positionNum = random.nextInt(boardSize*boardSize);
            if(boardArray[positionNum/boardSize][positionNum%boardSize].getSymbol().equals(Common_Type.getSymbol())){
                validRandomNum = true;
            }
        }
        return positionNum;
    }

    public void printMap(){
        for(int row = 0;row<boardSize;row++){
            for(int col = 0;col<boardSize;col++){
                System.out.print(boardArray[row][col].getSymbol());
                System.out.print(" | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public Unit[][] getBoardArray() {
        return boardArray;
    }

    public void setBoardArray(Unit[][] boardArray) {
        this.boardArray = boardArray;
    }

}
