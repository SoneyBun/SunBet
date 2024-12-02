public class Strike {
    private final int money, bet;
    private int strike;

    public Strike(int money, int bet, int strike) {
        this.money = money;
        this.bet = bet;
        this.strike = strike;
    }

    public boolean checkStrike() {
        return bet > money || bet <= 0;
    }

    public String toString() {
        if(bet > money) {
            strike++;
            return ("Strike " + strike + ": You cannot bet more than what you have!");
        }
        else if(bet == 0) {
            strike++;
            return ("Strike " + strike + ": You cannot bet a value of zero!");
        }
        else if(bet < 0) {
            strike++;
            return ("Strike " + strike + ": You cannot bet a negative value!");
        }
        return "";
    }

    public int getStrikes() {
        return strike;
    }
}
