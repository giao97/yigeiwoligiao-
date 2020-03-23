package text;

import java.util.Arrays;
import java.util.Comparator;

public class CardSet implements Comparable {
    private Card[] cards = new Card[5];

    public CardSet(Card[] cards) {
        this.cards = cards;
        Arrays.sort(cards, new cmp());//升序排序
    }

	public int getHigh() {
        int max = 0;
        for (Card c : cards) {
            if (c.getRank().getR() > max)
                max = c.getRank().getR();
            if (c.getRank().getR() == 1)
                max = 14;
        }
        return max;
    }

    /**
     * create by: ZeshawnXiao
     * description:get the pair nums of cardset
     * create time: 1:23 2018/11/23
     */
    public int getPair() {
        int res = 0;
        for(int i=0;i<5;i++){
            for(int j=i+1;j<5;j++){
                if(cards[i].getRank()==cards[j].getRank())
                    res++;
            }
        }
        return res;
    }

    /**
     * create by: ZeshawnXiao
     * description:if the cardset has "three of kind" return true
     * create time: 1:30 2018/11/23
     */
    public boolean isThree() {
        return (getPair()==3);
    }

    /**
     * create by: ZeshawnXiao
     * description:return 1 when cardset is normal Straight,return 2 when 10 J Q K A
     * create time: 1:40 2018/11/23
     */
    public int isStraight() {
        int a = cards[4].getRank().getR() - cards[3].getRank().getR();
        int b = cards[3].getRank().getR() - cards[2].getRank().getR();
        int c = cards[2].getRank().getR() - cards[1].getRank().getR();
        int d = cards[1].getRank().getR() - cards[0].getRank().getR();
        if (a == b && b == c && c == d) {
            return 1;
        } else if (a == b && b == c && d == 9) {
            return 2;
        }
        return 0;
    }

    /**
     * create by: ZeshawnXiao
     * description:return true if cardset is Flush
     * create time: 1:42 2018/11/23
     */
    public boolean isFlush() {
        for (int i = 0; i < 4; i++) {
            if (cards[i].getSuit() != cards[i + 1].getSuit())
                return false;
        }
        return true;
    }

    /**
     * create by: ZeshawnXiao
     * description:return true if cardset is FullHouse
     * create time: 1:43 2018/11/23
     */
    public boolean isFullHouse() {
        return (getPair() == 4);
    }

    /**
     * create by: ZeshawnXiao
     * description:return true if cardset has four of a kind
     * create time: 1:46 2018/11/23
     */
    public boolean isFour() {
        return (getPair()==6);
    }

    public boolean isStraightFlush() {
        return (isStraight() == 1) && isFlush();
    }

    public boolean isRoyal() {
        return (isStraight() == 2) && isFlush();
    }
	//按牌型给出points 若无特殊牌型则给出最大一张牌的rank
    public int getPoints() {
        if (isRoyal())
            return 100;
        else if (isStraightFlush())
            return 90;
        else if (isFour())
            return 80;
        else if (isFullHouse())
            return 70;
        else if (isFlush())
            return 60;
        else if (isStraight() != 0)
            return 50;
        else if (isThree())
            return 40;
        else if (getPair() == 2)
            return 30;
        else if (getPair() == 1)
            return 20;
        else
            return getHigh();

    }

    @Override
    public int compareTo(Object o) {
        if (this.getPoints() != ((CardSet) o).getPoints()) {
            if (this.getPoints() > ((CardSet) o).getPoints())
                return 1;
            else
                return -1;
        } else
            return 0;
    }
    
	//排序比较器
    class cmp implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            Card c1 = (Card) o1;
            Card c2 = (Card) o2;
            if (c1.getRank().getR() != c2.getRank().getR())
                return c1.getRank().getR() > c2.getRank().getR() ? 1 : -1;
            else
                return 0;
        }
    }
}