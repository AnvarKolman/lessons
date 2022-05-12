package cards

enum class Rank(val weight: Int) {

    TWO(2),
    TREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14),
    JOKER(100);

    companion object {
        private val map = Rank.values().associateBy(Rank::weight)
        fun fromInt(value: Int) = map[value]
    }

}