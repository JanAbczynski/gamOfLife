package game;

import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;

public class Board {

    private Cell[][] boardField;
    private Cell[][] nextStepBoard;
    private int boardSizeX;
    private int boardSizeY;

    public void createBoard(int sizeX, int sizeY){
        this.boardSizeX = sizeX;
        this.boardSizeY = sizeY;
        boardField = new Cell[boardSizeX][boardSizeY];
        nextStepBoard = boardField;
    }

    public void addCells(int startFactor){
        for(int x = 0; x < boardSizeX; x ++){
            for(int y = 0; y < boardSizeY; y++){
                boardField[x][y] = new Cell(startFactor);
            }
        }

    }

    public Cell[][] getBoardField() {
        return boardField;
    }

    public void createNextStep(){
        for(int x = 0; x < boardSizeX; x ++){
            for(int y = 0; y < boardSizeY; y++){
                countNeighbor(x, y);
            }
        }
    }

    private void countNeighbor(int cellX, int cellY){

        int neighborCounter = 0;
        int neighborXMin = cellX - 1;
        int neighborXMax = cellX + 1;
        int neighborYMin = cellY - 1;
        int neighborYMax = cellY + 1;

        for(int neighborX = neighborXMin; neighborX <= neighborXMax; neighborX++){
            for ( int neighborY = neighborYMin; neighborY <= neighborYMax; neighborY++){

//                System.out.println(" " + "field : " + cellX + " / " + cellY + ", neighbor: " + neighborX + " / " + neighborY);
                if((neighborX >= 0 && neighborY >= 0)
                && (neighborX < boardSizeX && neighborY < boardSizeY)
                && !(neighborX == cellX && neighborY == cellY)){

                    if(boardField[neighborX][neighborY].isToBeorNotToBe()){
                        neighborCounter ++;
//                        System.out.println("trutrue: " + neighborCounter);

                    }

//                    System.out.println("liczymy");
                } else {
//                    System.out.println("nie liczymy");
                }

            }
        }

        putSign(cellX, cellY, neighborCounter);
    }

    private void putSign(int cellX, int cellY, int neighborCounter) {
        if (neighborCounter == 3 && !boardField[cellX][cellY].isToBeorNotToBe()) {
            nextStepBoard[cellX][cellY] = new Cell(true);
        } else if (neighborCounter >= 2 && neighborCounter <= 3 && boardField[cellX][cellY].isToBeorNotToBe()) {
            nextStepBoard[cellX][cellY] = new Cell(true);
        } else {
            nextStepBoard[cellX][cellY] = new Cell(false);
        }

        boardField = nextStepBoard;
    }
}
