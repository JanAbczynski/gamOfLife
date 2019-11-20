import game.Board;

class Display {

    static void printBoard(Board board, int sizeX, int sizeY){

        createLine(board, sizeX, sizeY);
    }

    private static void createLine(Board board, int sizeX, int sizeY){

        for(int x = 0; x < sizeX; x++){
            StringBuilder line = new StringBuilder();
            for (int y = 0; y < sizeY; y ++){

                boolean cellStatus = board.getBoardField()[x][y].isToBeorNotToBe();
                if (cellStatus){
                    line.append("O");
                } else {
                    line.append(".");
                }

            }
            String oneLine = line.toString();
            displayLine(oneLine);
        }

    }

    private static void displayLine(String oneLine){
        System.out.println(oneLine);
    }
}
