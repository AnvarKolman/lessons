package cards

import java.util.concurrent.ThreadLocalRandom


class Deck(useJoker: Boolean) {

    private lateinit var cards: MutableList<Card>

    init {
        createDeck(useJoker)
    }

    private fun createDeck(useJoker: Boolean) {
        cards = ArrayList()
        Suit.values().forEach { suit ->
            Rank.values().filter { useJoker || it != Rank.JOKER }.forEach {
                cards.add(Card(suit, it))
            }
        }
    }

    fun randomCard(): Card {
        val randomIndex = ThreadLocalRandom.current().nextInt(0, cards.size)
        return cards.removeAt(randomIndex)
    }

    /**
     * Перемешать колоду.
     */
    fun shuffle() = cards.shuffle()

    /**
     * Отсортировать.
     */
    fun sort() = cards.sortWith(naturalOrder())

    /**
     * Раздать карты.
     *
     * @return 6 карт.
     */
    fun deal(): List<Card> {
        val cardForDeal = cards.take(6)
        cards.removeAll(cardForDeal)
        return cardForDeal
    }

    /**
     * Возврат карты в колоду.
     *
     * @param card карта.
     */
    fun put(card: Card) {
        if (!cards.contains(card)) {
            cards.add(card)
        } else {
            println("rogue!")
        }
    }

    fun empty(): Boolean = cards.isEmpty()

    fun size(): Int = cards.size

    override fun toString(): String {
        return "Deck{" +
                "cards=\n" + cards +
                '}'
    }

}
