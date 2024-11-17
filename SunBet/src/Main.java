import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int money = 100, bet = 0, lossOrGainCheck, strike = 0;
        boolean validAmount;
        Chance chance;
        Strike numStrikes;

        while((money > 0 && money <= 1000000) && strike < 3) {
            validAmount = false;

            while(!validAmount) {
                System.out.println("You have $" + money + ". How much are you willing to bet?");
                try {
                    bet = Integer.parseInt(scan.nextLine());
                    validAmount = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount.");
                }
            }

            numStrikes = new Strike(money, bet, strike);

            if(!numStrikes.checkStrike()) {
                if(bet == money) {
                    System.out.println("Betting all of your money is risky!");
                }
                chance = new Chance(bet);

                lossOrGainCheck = money;
                money += chance.betMoney();

                if(money > lossOrGainCheck) {
                    System.out.println("\nCongrats, you earned $" + bet + "!");
                }
                else if(money < lossOrGainCheck) {
                    System.out.println("\nUh oh, you lost $" + bet + "!");
                }
                else {
                    System.out.println("\nYour bet got pushed!");
                }
            }
            else {
                System.out.println(numStrikes);
                strike = numStrikes.getStrikes();
            }
        }

        if(money <= 0) {
            System.out.println("Oh no, you lost all your money. There's always next time!");
            System.exit(0);
        }
        else if(money >= 1000000) {
            System.out.println("Congrats, you got $" + money + "! Can you get even more?");
        }
        else if(strike == 3) {
            System.out.println("3 strikes reached, session ended. Try again next time!");
        }
    }
}
