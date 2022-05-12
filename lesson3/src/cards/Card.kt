package cards

import java.util.*


class Card(private val suit: Suit,private val rank: Rank) : Comparable<Card> {

    fun suit(): Suit {
        return suit
    }

    fun rank(): Rank {
        return rank
    }

    /**
     * Является ли текущая карта сильнее другой (масть одинакова).
     *
     * @param card карта
     * @return результат сравнения
     */
    fun checkWeight(card: Card): Boolean {
        require(suit == card.suit) { "Suits not equals" }
        return rank.weight > card.rank.weight
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val card = other as Card
        return suit == card.suit && rank == card.rank
    }

    override fun hashCode(): Int {
        return Objects.hash(suit, rank)
    }

    override fun compareTo(other: Card): Int {
        return if (rank.weight == other.rank().weight) {
            if (suit.weight == other.suit().weight) {
                return 0
            } else if (suit.weight > other.suit().weight) {
                return 1
            }
            -1
        } else if (rank.weight > other.rank().weight) {
            1
        } else {
            -1
        }
    }

    override fun toString(): String {
        return "Card{ suit = ${suit.name} , rank = ${rank.name} }\n"
    }

}