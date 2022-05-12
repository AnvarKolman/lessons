package cards

enum class Suit(val weight: Int) {

    SPADES(1),
    HEARTS(2),
    DIAMONDS(3),
    CLUBS(4);

    companion object {
        private val map = Suit.values().associateBy(Suit::weight)
        fun fromInt(value: Int) = map[value]
    }
}