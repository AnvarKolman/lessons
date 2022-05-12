package cards

fun main() {
    val deck = Deck(true)
    deck.deal()
    val cardOne = deck.randomCard()
    val cardTwo = deck.randomCard()
    deck.put(cardOne)
    deck.put(cardOne)
    println(deck.toString())
    deck.shuffle()
    println(deck.toString())
    deck.sort()
    println(deck.toString())
}