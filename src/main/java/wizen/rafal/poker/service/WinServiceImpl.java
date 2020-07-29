package wizen.rafal.poker.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import wizen.rafal.poker.model.Card;
import wizen.rafal.poker.model.Deck;

@Service
public class WinServiceImpl implements WinService {

	Deck deck = Deck.getInstance();
	
	private int[] valueOfPlayersHand;
	private int[] valueOfOpponentsHand;
	
	@Override
	public void winCheck() {
		// TODO Auto-generated method stub
		
	}
	
	private int[] checkHandAndValue(ArrayList<Card> cards) {
		int[] tempValue = new int[6];
	
		return tempValue;
	}
	
	// methods for check each possible variant
	
	private boolean hasStraightFlush(ArrayList<Card> cards) {
		
		
//		for(Card card : cards) {
//			card.getSuit();
//		}
		return false;
	}
	
	private boolean hasFourOfKind(ArrayList<Card> cards) {
		return false;
	}
	
	private boolean hasFullHouse(ArrayList<Card> cards) {
		return false;
	}
	
	public boolean hasFlush(ArrayList<Card> cards) {
		HashMap<Character, Integer> colors = new HashMap<Character, Integer>();
		for(Card card : cards) {
			colors.merge(card.getSuit(), 1, Integer::sum);
		}
		return (colors.containsValue(5));
	}
	
	private boolean hasStraight(ArrayList<Card> cards) {
		return false;
	}
	
	private boolean hasThreeOfAKind(ArrayList<Card> cards) {
		return false;
	}
	
	private boolean hasTwoPairs(ArrayList<Card> cards) {
		return false;
	}
	
	private boolean hasPair(ArrayList<Card> cards) {
		return false;
	}
}
