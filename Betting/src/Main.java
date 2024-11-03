import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        double cash = 100.00;
        double bet;
        int chance = (int) (Math.random() * 10);
        String risk = "Betting all your money is risky!";
        int strike = 0;
        String currency;

        System.out.println("\nCan you try to get to $1,000,000?\n");

        while(cash < 1000000 && cash != 0) {

            if(cash >= 1)
            {
                currency = "dollar(s)";
            }
            else {
                currency = "cent(s)";
            }

            if(strike != 3) {
                System.out.println("You have " + cash + " " + currency);
                System.out.println("How much are you betting?");
            }
            else {
                System.out.println("3 Strikes reached, session has ended!");
                System.exit(0);
            }

            bet = scan.nextDouble();

            if(bet == 0) {
                strike++;
                System.out.println("Strike: " + strike + " - You have to bet an amount!\n");
            }

            if(bet < 0.01 && bet > 0) {
                strike++;
                System.out.println("Strike: " + strike + " - You cannot bet numbers that small!\n");
            }

            if(bet < 0) {
                strike++;
                System.out.println("Strike: " + strike + " - You cannot bet negative numbers!\n");
            }

            if(bet > cash) {
                strike++;
                System.out.println("Strike: " + strike + " - You cannot bet more than you have!\n");
            }

            if(bet <= cash) {

                int gamble = rand.nextInt(3);

                if(gamble == 0) {
                    if(bet == cash) {
                        System.out.println(risk);
                    }
                    cash += bet;
                    System.out.print("\n");
                }
                if(gamble == 1) {
                    if(bet == cash) {
                        System.out.println(risk);
                    }
                    cash -= bet;
                    System.out.print("\n");
                }
                if(gamble == 2) {
                    int push = rand.nextInt(5);
                    if(push == 0 || push == 1) {
                        if(bet == cash) {
                            System.out.println(risk);
                        }
                        cash += bet;
                        System.out.print("\n");
                    }
                    if(push == 2 || push == 3) {
                        if(bet == cash) {
                            System.out.println(risk);
                        }
                        cash -= bet;
                        System.out.print("\n");
                    }
                    if(push == 4) {
                        if(bet == cash) {
                            System.out.println(risk);
                        }
                        System.out.println("Push: Bet gets refunded!\n");
                    }
                }
            }
        }

        if(cash == 0) {
            if(chance == 0) {
                System.out.println("This is why you shouldn't gamble!");
            }
            else {
                System.out.println("You lost all your money, please play again!");
            }
            System.exit(0);
        }

        if(cash >= 1000000) {
            if(chance == 0) {
                System.out.println("You got $" + cash + ", that's just beginners luck!");
            }
            else {
                System.out.println("Congrats, you got $" + cash + " please play again!");
            }
            System.exit(0);
        }
    }
}