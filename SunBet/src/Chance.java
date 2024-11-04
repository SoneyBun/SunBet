import java.lang.Math;

public class Chance {
    private final int bet;

    public Chance(int bet) {
        this.bet = bet;
    }

    public int betMoney() {
        int chance = (int) (Math.random() * 7);

        if(chance <= 2) {
            return bet;
        }
        else if(chance <= 5) {
            return (bet * -1);
        }
        return 0;
    }
}
