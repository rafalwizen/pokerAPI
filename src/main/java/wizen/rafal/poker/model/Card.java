package wizen.rafal.poker.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Card implements Comparable<Card> {

	private int value; // 1-13, 1 - Ace, 11 - Jack, 12 - Queen, 13 - King
	private char suit; // H - heart, S - spades, D - diamonds, C - clubs
	private boolean isAce;
	
	public Card(int value, char suit) {
		this.value = value;
		this.suit = suit;
		this.isAce = (value == 1);
	}

	@Override
	public int compareTo(Card compareCard) {
		int compareValue = (compareCard).getValue();
		return compareValue - this.value;
	}
	
}
