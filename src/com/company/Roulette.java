package com.company;

/*
Players will be able to enter in the amount of money they want to bet and the type of bet they will be placing.
The types of bets include:
Red: You are betting that the next roll will come up red.
Black: You are betting that the next roll will come up black.
Even: This is wagering that the ball will land on an even number between 1-36.
Odd: This is wagering that the ball will land on an odd number between 1-36.
Low: This is a bet that the next number will be between 1 and 18.
High: This is a bet that the next number will be between 19 and 36.
The program will then randomly generate a number between 1-36 and a color (red or black).
You will then double the player's amount if they won, or deduct their money if they lost.
Allow the user to play as many games as they want until they want to quit.
At the end of the program, print out the net amount of money they've earned, whether that's positive or negative.
In addition, also print out the number of games they have won and lost.
*/

import java.util.Scanner;
import java.util.Random;


public class Roulette {

    private static String random_color() {
        Random spin = new Random();
        String color = "";
        int num = spin.nextInt(2);
        switch (num){
            case 0:
                color = "red";
                break;
            case 1:
                color = " black";
        }
        return color;
    }

    private static boolean check_win(String spin_color, int spin_num, String bet) {
        if (bet.equalsIgnoreCase(spin_color))
            return true;
        else if ( ((spin_num % 2) == 0) && (bet.equalsIgnoreCase("even"))  )
            return true;
        else if ( ((spin_num % 2) == 1) && (bet.equalsIgnoreCase("odd"))  )
            return true;
        else if ( (spin_num >= 1 ) && (spin_num <= 18) && (bet.equalsIgnoreCase("low"))  )
            return true;
        else if ( (spin_num >= 19 ) && (spin_num <= 36) && (bet.equalsIgnoreCase("high"))  )
            return true;
        else return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        String bet_type = "";
        int bet_amount = 0;

        int spin_Number = 0;
        String spin_Color = "";

        int money_amount = 0;
        boolean win = false;

        int won = 0;
        int lost = 0;
        String another = "";
        boolean another_option = false;
        boolean valid_option = false;
        boolean stop_loop = false;

        System.out.println("\nWelcome! Let's play some Roulette! ");

        do {

            System.out.println("\nEnter the type of bet you would like to place (red|black|even|odd|high|low): ");
            bet_type = scanner.next();

            valid_option = false;

         while (!valid_option)
         {
            if
            (
            (bet_type.equalsIgnoreCase("red")) ||
            (bet_type.equalsIgnoreCase("black")) ||
            (bet_type.equalsIgnoreCase("even")) ||
            (bet_type.equalsIgnoreCase("odd")) ||
            (bet_type.equalsIgnoreCase("high")) ||
            (bet_type.equalsIgnoreCase("low"))
            )
            {
                valid_option = true;
            }
          else {
                System.out.println("Invalid bet.  Please re-enter the type of bet you would like to place (red|black|even|odd|high|low): ");
                bet_type = scanner.next();
            }
          }

            System.out.println("\nEnter in your bet amount: ");
            bet_amount = scanner.nextInt();

            spin_Color = random_color();
            spin_Number = 1 + rand.nextInt(36);

            System.out.println("\nThe ball landed on " + spin_Number + " " + spin_Color);

            win = check_win(spin_Color, spin_Number, bet_type);

            if (win) {
                money_amount = money_amount + (bet_amount*2);
                won++;
                System.out.println("Congratulations, you've won.");
            }
            else {
                money_amount = money_amount - bet_amount;
                lost++;
                System.out.println("Sorry, you've lost this bet.");
            }

            System.out.println("\nYou currently have: $" + money_amount);


             System.out.print("\nWould you like to play again? (y/n or yes/no) \n");
             another = scanner.next();

            while (!stop_loop) {
                if
                (
                        (another.equalsIgnoreCase("y")) ||
                        (another.equalsIgnoreCase("yes"))
                ) {
                    another_option = true;
                    stop_loop = true;
                }
                else if
                    (
                            (another.equalsIgnoreCase("n")) ||
                            (another.equalsIgnoreCase("no"))
                    ) {

                             stop_loop = true;

                    }

                else
                {
                System.out.println("Invalid input. Would you like to play again? (y/n or yes/no)   ");
                another = scanner.next();
                }
            }

            if
            (
                    (another.equalsIgnoreCase("n")) ||
                            (another.equalsIgnoreCase("no"))
            ) {
                another_option = false;
            }

        } while (another_option);


        System.out.println("\n\nThank you for playing!");
        System.out.println("This is how much money you have remaining: $" + money_amount);
        System.out.println("You've won " + won + " game(s) and lost " + lost + " game(s).");
    }
}
