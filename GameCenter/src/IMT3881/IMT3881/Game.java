package IMT3881;

import javax.swing.*;

public class Game {

private int count;

public Game() {
this.count=0;
    }

/**
 * @return returns count
 * */
    public int getCounter(){
        this.count++;
        return this.count;
    }
    /**
     * @param count
     * */
    public void setCounter(int count){
        this.count=count;

    }

}
