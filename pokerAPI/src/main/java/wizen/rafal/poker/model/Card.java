package wizen.rafal.poker.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Card implements Comparable<Card> {

	private int value; // 2-10 numeric cards,  11 - Jack, 12 - Queen, 13 - King, 14 - Ace
	private char suit; // H - heart, S - spades, D - diamonds, C - clubs
	private boolean isAce;
	
	public Card(int value, char suit) {
		this.value = value;
		this.suit = suit;
		this.isAce = (value == 14);
	}

	@Override
	public int compareTo(Card compareCard) {
		int compareValue = (compareCard).getValue();
		return compareValue - this.value;
	}
	
}
