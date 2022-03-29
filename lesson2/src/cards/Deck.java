package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static cards.Card.STANDARD_SUITS;

/**
 * Колода карт.
 */
public class Deck {

    private List<Card> cards;

    private Deck(boolean useJoker) {
        createDeck(useJoker);
    }

    private void createDeck(boolean useJoker) {
        this.cards = new ArrayList<>();
        STANDARD_SUITS.keySet().forEach(suit -> {
            IntStream.rangeClosed(2, 14).forEach(weight -> {
                cards.add(new Card(suit, weight));
            });
        });
        if (useJoker) {
            cards.add(new Card(1, 100));
            cards.add(new Card(2, 100));
        }
    }

    public Card getRandomCard() {
        return cards.isEmpty() ? null : randomCard();
    }

    private Card randomCard() {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, cards.size());
        return cards.remove(randomIndex);
    }

    /**
     * Перемешать колоду.
     */
    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    /**
     * Отсортировать.
     */
    public void sort() {
        this.cards.sort(Comparator.naturalOrder());
    }

    /**
     * Раздать карты.
     *
     * @return 6 карт.
     */
    public List<Card> dealCards() {
        return cards.stream().limit(6).collect(Collectors.toList());
    }

    /**
     * Возврат карты в колоду.
     *
     * @param card карта.
     */
    public void putCard(Card card) {
        if (card == null) return;
        if (!cards.contains(card)) {
            cards.add(card);
        } else {
            System.out.println("rogue!");
        }
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    /**
     * Создать колоду без Джокера.
     *
     * @return колода карт без Джокреа
     */
    public static Deck createDeckWithoutJoker() {
        return new Deck(false);
    }

    /**
     * Создать колоду с Джокером.
     *
     * @return колода карт с Джокером
     */
    public static Deck createDeckWithJoker() {
        return new Deck(false);
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }
}
