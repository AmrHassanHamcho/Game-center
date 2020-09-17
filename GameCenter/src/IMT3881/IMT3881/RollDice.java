package IMT3881;


public class RollDice {
    private final int MAX = 6;

    public RollDice() {

    }

    public  int Roll() {
        return (int) ((Math.random() * MAX) + 1);

    }


}