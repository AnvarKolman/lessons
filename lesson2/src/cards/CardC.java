package cards;

public class CardC {

    private Integer suit;
    private Integer rank;
    private static int maxRank;

    public CardC(Integer suit, Integer rank) {
        this.suit = suit;
        this.rank = rank;
        if (maxRank < rank) {
            maxRank = rank;
        }
    }

    public CardC(Integer suit) {
        this.suit = suit;
        maxRank = 5;
        this.rank = maxRank;
    }

}
