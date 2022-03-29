package cards;

public class Main {
    public static void main(String[] args) {
        Deck deck = Deck.createDeckWithoutJoker();
        Card one = deck.getRandomCard();
        Card two = deck.getRandomCard();
        Card three = deck.getRandomCard();
        Card four = deck.getRandomCard();
        deck.putCard(three);
        deck.putCard(four);
        deck.putCard(four);
        System.out.println(deck);

        deck.shuffleDeck();
        System.out.println(deck);

        deck.sort();
        System.out.println(deck);

        while (!deck.isEmpty()) {
            deck.getRandomCard();
        }
        System.out.println(deck);
    }
}
