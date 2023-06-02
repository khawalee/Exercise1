package exercise1;

/**
 * A class that fills a hand of 7 cards with random Card Objects and then asks the user to pick a card.
 * It then searches the array of cards for the match to the user's card. 
 * To be used as starting code in Exercise
 *
 * @author dancye
 * @author Paul Bonenfant Jan 25, 2022 
 * Updated by: Waleed Khan May 26th, 2023.
 */

import java.util.Random;
import java.util.Scanner;

public class CardTrick {

    public static void main(String[] args) {
        Card[] hand = new Card[7];

        for (int i = 0; i < hand.length; i++) {
            Card card = new Card();
            card.setValue(getRandomNumber());
            card.setSuit(Card.SUITS[getRandomNumber(4)]);
            hand[i] = card;
        }

        Card userCard = getUserCard();

        boolean cardFound = searchForCard(hand, userCard);

        if (cardFound) {
            printInfo();
        } else {
            System.out.println("Sorry, your card is not in the hand.");
        }
    }

    private static Card getUserCard() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick a card:");
        System.out.print("Enter the value (1-10, 11 for Jack, 12 for Queen, 13 for King): ");
        int value = scanner.nextInt();

        System.out.print("Enter the suit (1 for Hearts, 2 for Diamonds, 3 for Clubs, 4 for Spades): ");
        int suit = scanner.nextInt();

        Card userCard = new Card();
        userCard.setValue(value);
        userCard.setSuit(Card.SUITS[suit - 1]);

        return userCard;
    }

    private static boolean searchForCard(Card[] hand, Card card) {
        for (Card c : hand) {
            if (c.getValue() == card.getValue() && c.getSuit().equals(card.getSuit())) {
                return true;
            }
        }
        return false;
    }

    //I'm Done !!!
    private static void printInfo() {
        System.out.println("Congratulations, you guessed right!");
        System.out.println();

        System.out.println("My name is Waleed Khan");
        System.out.println();

        System.out.println("My career ambitions:");
        System.out.println("-- Software Engineer");
        System.out.println("-- Investment Banker");
        System.out.println();

        System.out.println("My hobbies:");
        System.out.println("-- FootBall");
        System.out.println("-- Movies");
        System.out.println("-- Sight-Seeing");
        System.out.println("-- Piano");

        System.out.println();
    }

    private static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(11);
    }

    private static int getRandomNumber(int limit) {
        Random random = new Random();
        return random.nextInt(limit);
    }

    static class Card {
        public static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
        private int value;
        private String suit;

        public void setValue(int value) {
            this.value = value;
        }

        public void setSuit(String suit) {
            this.suit = suit;
        }

        public int getValue() {
            return value;
        }

        public String getSuit() {
            return suit;
        }
    }
}


