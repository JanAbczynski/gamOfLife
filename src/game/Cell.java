package game;

import java.util.Random;

public class Cell {

    boolean toBeorNotToBe;
    String sign;
//    int Xpos;
//    int Ypos;

    Cell(int startFactor){
//        this.Xpos = x;
//        this.Ypos = y;
        Random random = new Random();
        int chanceToBe = random.nextInt(100);
        if (chanceToBe < startFactor){
            toBeorNotToBe = true;
        } else {
            toBeorNotToBe = false;
        }
        setSign(toBeorNotToBe);
    }

    Cell(boolean isAlive){
        toBeorNotToBe = isAlive;
    }

    public void setSign(boolean status) {
        if (toBeorNotToBe){
            this.sign = "O";
        } else {
            this.sign = ".";
        }
    }

    public String getSign() {
        return sign;
    }

    public boolean isToBeorNotToBe() {
        return toBeorNotToBe;
    }

    public void createCell(){


    }


}
