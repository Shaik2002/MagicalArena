import java.util.Random;

public class Dice {
    private static final int SIDES = 6;
    private final Random random = new Random();

    public int roll() {
        return random.nextInt(SIDES) + 1;
    }
}
