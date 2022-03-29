package cards;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Card implements Comparable<Card> {

    private final Integer suit;
    private final Integer rank;
    public static final Map<Integer, String> STANDARD_SUITS = new HashMap<>();
    public static final Map<Integer, String> STANDARD_RANKS = new HashMap<>();

    static {
        STANDARD_RANKS.put(2, "2");
        STANDARD_RANKS.put(3, "3");
        STANDARD_RANKS.put(4, "4");
        STANDARD_RANKS.put(5, "5");
        STANDARD_RANKS.put(6, "6");
        STANDARD_RANKS.put(7, "7");
        STANDARD_RANKS.put(8, "8");
        STANDARD_RANKS.put(9, "9");
        STANDARD_RANKS.put(10, "10");
        STANDARD_RANKS.put(11, "Jack");
        STANDARD_RANKS.put(12, "Queen");
        STANDARD_RANKS.put(13, "King");
        STANDARD_RANKS.put(14, "Ace");
        STANDARD_RANKS.put(100, "Joker");

        STANDARD_SUITS.put(1, "Clubs");
        STANDARD_SUITS.put(2, "Diamonds");
        STANDARD_SUITS.put(3, "Spades");
        STANDARD_SUITS.put(4, "Hearts");
    }

    public Card(Integer suit, Integer rank) {
        this.suit = checkSuit(suit);
        this.rank = rank;
    }

    private int checkSuit(Integer suit) {
        if (suit >= 1 && suit <= 4) {
            return suit;
        } else {
            throw new IllegalArgumentException("Suit is not valid");
        }
    }

    public Integer getSuit() {
        return suit;
    }

    public Integer getRank() {
        return rank;
    }

    /**
     * Проверить принадлежность стандартной колоде (54 карты).
     *
     * @return принадлежность стандартной колоде.
     */
    public boolean inStandardDeck() {
        return STANDARD_SUITS.containsKey(suit) && !STANDARD_RANKS.containsKey(rank);
    }

    /**
     * Является ли текущая карта сильнее другой (масть одинакова).
     *
     * @param card карта
     * @return результат сравнения
     */
    public boolean checkWeight(Card card) {
        Objects.requireNonNull(card, "Card is null");
        if (!Objects.equals(this.suit, card.suit)) {
            throw new IllegalArgumentException("Suits not equals");
        }
        return suit > card.suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(suit, card.suit) && Objects.equals(rank, card.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }

    @Override
    public int compareTo(Card o) {
        if (Objects.equals(this.rank, o.getRank())) {
            if (Objects.equals(suit, o.getSuit())) {
                return 0;
            } else if (this.suit > o.getSuit()) {
                return 1;
            }
            return -1;
        } else if (this.rank > o.getRank()) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + STANDARD_SUITS.getOrDefault(suit, String.valueOf(suit)) +
                ", rank=" + STANDARD_RANKS.getOrDefault(rank, String.valueOf(rank)) +
                '}';
    }
}
