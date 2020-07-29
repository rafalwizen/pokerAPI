package wizen.rafal.poker.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

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
	// kicker(s) - is a card in a hand that does not itself take part in determining the rank of the hand,
	// but that may be used to break ties between hands of the same rank
	
	private int[] checkForStraightFlush(ArrayList<Card> cards) {
		
		
		int[] result = {0};
		return result;
	}
	
	public int[] checkForFourOfKind(ArrayList<Card> cards) {
		HashMap<Integer, Integer> hand = new HashMap<Integer, Integer>();
		for(Card card : cards) {
			hand.merge(card.getValue(), 1, Integer::sum);
		}
		if(hand.containsValue(4)) {
			int valueOfFourOfKind = 0;
			int kicker = 0;
			for(Entry<Integer,Integer> entry : hand.entrySet()) {
				if(entry.getValue()==4) {
					valueOfFourOfKind = entry.getKey();
				} else {
					kicker = (kicker >= entry.getKey())? kicker : entry.getKey();
				}				
			}
			int[] result = {8, valueOfFourOfKind, kicker};
			return result;
		}
		
		int[] result = {0};
		return result;
	}
	
	private int[] checkForFullHouse(ArrayList<Card> cards) {
		
		
		int[] result = {0};
		return result;
	}
	
	public int[] checkForFlush(ArrayList<Card> cards) {
		HashMap<Character, ArrayList<Card>> hand = new HashMap<Character, ArrayList<Card>>();
		for(Card card : cards) {
			if(hand.get(card.getSuit())==null) {
				hand.put(card.getSuit(), new ArrayList<Card>());
			}
			hand.get(card.getSuit()).add(card);
		}
		for (Entry<Character, ArrayList<Card>> entry : hand.entrySet()) {
		    ArrayList<Card> values = entry.getValue();
		    if(values.size()>=5) {
		    	Collections.sort(values);
		    	if(values.get(values.size()-1).isAce()) {
		    		values.get(values.size()-1).setValue(14);
		    		Collections.sort(values);
		    	}		    	
		    	// 6 is value for flush, also add 5 highest cards
		    	int[] result = {6, values.get(0).getValue(),values.get(1).getValue(),
		    					values.get(2).getValue(),values.get(3).getValue(),values.get(4).getValue()};
		    	return result;
		    }
		}
		int[] result = {0};
		return result;
	}
	
	private int[] checkForStraight(ArrayList<Card> cards) {
		
		
		int[] result = {0};
		return result;
	}
	
	private int[] checkForThreeOfAKind(ArrayList<Card> cards) {
		
		
		int[] result = {0};
		return result;
	}
	
	private int[] checkForTwoPairs(ArrayList<Card> cards) {
		
		
		int[] result = {0};
		return result;
	}
	
	private int[] checkForPair(ArrayList<Card> cards) {
		
		
		int[] result = {0};
		return result;
	}
}
