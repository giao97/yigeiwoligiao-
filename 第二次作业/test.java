package text;

public class test {

	public static void main(String[] args) {
	      Card[] c1={new Card(Rank.ACE,Suit.DIAMOND),new Card(Rank.JACK,Suit.DIAMOND),new Card(Rank.KING,Suit.DIAMOND),
	                new Card(Rank.TEN,Suit.DIAMOND),new Card(Rank.QUEEN,Suit.DIAMOND)};
	        Card[] c2={new Card(Rank.ACE,Suit.DIAMOND),new Card(Rank.ACE,Suit.DIAMOND),new Card(Rank.ACE,Suit.DIAMOND),
	                new Card(Rank.TWO,Suit.CLUB),new Card(Rank.TWO,Suit.SPADE)};
	        Card[] c3={new Card(Rank.ACE,Suit.DIAMOND),new Card(Rank.TEN,Suit.DIAMOND),new Card(Rank.THREE,Suit.DIAMOND),
	                new Card(Rank.NINE,Suit.CLUB),new Card(Rank.SIX,Suit.SPADE)};
	        Card[] c4={new Card(Rank.ACE,Suit.DIAMOND),new Card(Rank.ACE,Suit.DIAMOND),new Card(Rank.THREE,Suit.DIAMOND),
	                new Card(Rank.THREE,Suit.CLUB),new Card(Rank.SIX,Suit.SPADE)};
	        CardSet cs1=new CardSet(c1);
	        CardSet cs2=new CardSet(c2);
	        CardSet cs3=new CardSet(c3);
	        CardSet cs4=new CardSet(c4);
	        System.out.println(cs1.getPoints());
	        System.out.println(cs2.getPoints());
	        System.out.println(cs3.getPoints());
	        System.out.println(cs4.getPoints());
	        System.out.println(cs1.compareTo(cs2));
	        System.out.println(cs2.compareTo(cs3));
	        System.out.println(cs3.compareTo(cs1));
	        System.out.println(cs2.compareTo(cs4));
	    }
	}
