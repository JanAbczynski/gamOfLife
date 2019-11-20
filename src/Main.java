import game.Board;

import java.util.concurrent.TimeUnit;

public class Main {

    static int sizeX = 20;
    static int sizeY = 55;
    static int startFactor = 12;
    static boolean simulate = true;


    public static void main(String[] args) throws InterruptedException {
        Board board = new Board();
        board.createBoard(sizeX, sizeY);
        board.addCells(startFactor);
        while(simulate){

            Thread.sleep(200);
            System.out.println(" ");
            Display.printBoard(board, sizeX, sizeY);
            board.createNextStep();

        }



    }

}
