package text;

public enum Suit{
    SPADE(1),HEART(2),CLUB(3),DIAMOND(4);
    private int index;

    public int getIndex() {
        return index;
    }

    Suit(int index){
        this.index=index;
    }
}

