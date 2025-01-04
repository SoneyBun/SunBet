import java.lang.Math;
import java.util.Scanner;
@SuppressWarnings("all")

public class Chance {
    private final int bet;
    private static int choice;
    private final static Scanner scan = new Scanner(System.in);
    private static boolean valid;

    public Chance(int bet) {
        this.bet = bet;
    }

    public static void prompt() {
        valid = false;

        while (!valid) {
            System.out.println("\nSelect a game:\n(1) - Dice Roll (3x)\n(2) - Coin Flip (1x)\n(3) - Wheel Spin (2x)\n(4) - Classic Bet (3x)");

            try {
                choice = Integer.parseInt(scan.nextLine());
                if (choice >= 1 && choice <= 4) {
                    valid = true;
                } else {
                    System.out.println("Invalid input.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }
        }
    }

    public int betMoney() {
        valid = false;
        String oLet = "";
        int gDice = 0, aDice;
        String flip = "";
        int gFlip = 0, aFlip;
        int gCol = 0, aCol;
        int chance;

        switch (choice) {
            case 1 :
                while (!valid) {
                    System.out.println("Enter your guess (1-6):");
                    try {
                        gDice = Integer.parseInt(scan.nextLine());
                        if (gDice >= 1 && gDice <= 6) {
                            valid = true;
                        } else {
                            System.out.println("Invalid guess.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid guess.");
                    }
                }
                aDice = (int) (Math.random() * 6) + 1;
                System.out.println("Dice rolled: " + aDice);
                if (gDice == aDice) {
                    return 3 * bet;
                } else {
                    return -bet;
                }

            case 2 :

                while (!valid) {
                    System.out.println("Enter your guess (T/H):");
                    oLet = scan.nextLine().toUpperCase();
                    oLet = oLet.substring(0, 1);
                    if (oLet.equals("T") || oLet.equals("H")) {
                        valid = true;
                    } else {
                        System.out.println("Invalid guess.");
                    }
                }
                if(oLet.equals("T")) {
                    gFlip = 0;
                }
                else {
                    gFlip = 1;
                }
                aFlip = (int) (Math.random() * 2);
                if(aFlip == 0) {
                    flip = "Tails";
                }
                else {
                    flip = "Heads";
                }
                System.out.println("You flipped a " + flip);
                if (gFlip == aFlip) {
                    return bet;
                } else {
                    return -bet;
                }

            case 3 :
                while (!valid) {
                    System.out.println("Guess the Color:\n(R) - Red\n(G) - Green\n(B) - Blue\n(Y) - Yellow");
                    oLet = scan.nextLine().toUpperCase();
                    oLet = oLet.substring(0, 1);
                    if (oLet.equals("R") || oLet.equals("G") || oLet.equals("B") || oLet.equals("Y")) {
                        valid = true;
                    } else {
                        System.out.println("Invalid guess.");
                    }
                }
                if (oLet.equals("R")) {
                    gCol = 0;
                } else if (oLet.equals("G")) {
                    gCol = 1;
                } else if (oLet.equals("B")) {
                    gCol = 2;
                } else if (oLet.equals("Y")) {
                    gCol = 3;
                }
                aCol = (int) (Math.random() * 4);
                String[] colors = {"Red", "Green", "Blue", "Yellow"};
                System.out.println("You spun a " + colors[aCol]);
                if (gCol == aCol) {
                    return 2 * bet;
                } else {
                    return -bet;
                }

            case 4 :
                chance = (int) (Math.random() * 7);
                if (chance <= 2) {
                    return 3 * bet;
                } else if (chance <= 5) {
                    return -bet;
                } else {
                    return 0;
                }

            default :
                System.out.println("Invalid game choice.");
                return 0;
        }
    }
}
