import java.awt.Desktop;
import java.net.URI;
import java.util.Scanner;
@SuppressWarnings("all")

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Currency typeOfMoney;
        int money = 100, bet = 0, lossOrGainCheck, strike = 0;
        boolean validAmount;
        Chance chance;
        Strike numStrikes;

        try {
            if(Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                URI uri = new URI("https://bit.ly/SunBetCurrencies");
                desktop.browse(uri);
            }
            else {
                System.out.println("Desktop is not supported on this system.");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        System.out.print("Enter currency: ");
        String nameCurrency = scan.nextLine();

        typeOfMoney = new Currency(nameCurrency);
        String currencySymbol = typeOfMoney.getCurrencyType();
        String currencyName = typeOfMoney.getCurrencyName();
        String plural = typeOfMoney.getPlural();;

        System.out.print("\n");
        while((money > 0 && money <= 1000000) && strike < 3) {
            validAmount = false;

            while(!validAmount) {
                System.out.println("You have " + currencySymbol + money + " " + currencyName + plural + ". How much are you willing to bet?");
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
                    System.out.println("\nCongrats, you earned " + currencySymbol + bet + "!");
                }
                else if(money < lossOrGainCheck) {
                    System.out.println("\nUh oh, you lost " + currencySymbol + bet + "!");
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
        }
        else if(money >= 1000000) {
            System.out.println("Congrats, you got " + currencySymbol + money + "! Can you get even more?");
        }
        else if(strike == 3) {
            System.out.println("3 strikes reached, session ended. Try again next time!");
        }

        System.exit(0);
    }
}
