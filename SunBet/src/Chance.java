import java.lang.Math;

public class Chance {
    private final double  bet;

    public Chance(double bet) {
        this.bet = bet;
    }

    public double betMoney() {
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