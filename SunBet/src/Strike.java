public class Strike {
    private final double money, bet;
    private int strike;

    public Strike(double money, double bet, int strike) {
        this.money = money;
        this.bet = bet;
        this.strike = strike;
    }

    public boolean checkStrike() {
        if(bet > money) {
            return true;
        }
        else if(bet < 0.01 && bet > 0) {
            return true;
        }
        else if(bet == 0) {
            return true;
        }
        else if(bet < 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        if(bet > money) {
            strike++;
            return ("Strike " + strike + ": You cannot bet more than what you have!");
        }
        else if(bet < 0.01 && bet > 0) {
            strike++;
            return ("Strike " + strike + ": You cannot bet a value that small!");
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