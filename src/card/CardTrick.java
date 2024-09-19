package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 * Modifier: John Wesley, 991717865
 */
public class CardTrick {

    public static void main(String[] args) {
        // Array of 7 cards
        Card[] magicHand = new Card[7];
        Random random = new Random();

        // Fill the magicHand with random cards
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1); // Random value between 1 and 13
            c.setSuit(Card.SUITS[random.nextInt(4)]); // Random suit from 0 to 3
            magicHand[i] = c;
        }

        // Ask the user to pick a card
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a card value (1 for Ace, 11 for Jack, 12 for Queen, 13 for King): ");
        int userValue = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.println("Pick a suit (Hearts, Diamonds, Spades, Clubs): ");
        String userSuit = scanner.nextLine();

        // Create the user's card
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);

        // Search for the user's card in the magicHand
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        // Report the result for the user's card
        if (found) {
            System.out.println("Your card is in the magic hand! You win!");
        } else {
            System.out.println("Your card is not in the magic hand. Better luck next time!");
        }

        // Create a hard-coded lucky card (2 of Clubs)
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");

        // Search for the lucky card in the magicHand
        boolean luckyFound = false;
        for (Card card : magicHand) {
            if (card.getValue() == luckyCard.getValue() && card.getSuit().equalsIgnoreCase(luckyCard.getSuit())) {
                luckyFound = true;
                break;
            }
        }

        // Report the result for the lucky card
        if (luckyFound) {
            System.out.println("The lucky card (2 of Clubs) is in the magic hand! You win!");
        } else {
            System.out.println("The lucky card (2 of Clubs) is not in the magic hand. Better luck next time!");
        }
    }
}
