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
	
	private boolean checkForStraightFlush(ArrayList<Card> cards) {
		
		
//		for(Card card : cards) {
//			card.getSuit();
//		}
		return false;
	}
	
	private boolean checkForFourOfKind(ArrayList<Card> cards) {
		return false;
	}
	
	private boolean checkForFullHouse(ArrayList<Card> cards) {
		return false;
	}
	
	public int[] checkForFlush(ArrayList<Card> cards) {
		HashMap<Character, ArrayList<Card>> colors = new HashMap<Character, ArrayList<Card>>();
		for(Card card : cards) {
			if(colors.get(card.getSuit())==null) {
				colors.put(card.getSuit(), new ArrayList<Card>());
			}
			colors.get(card.getSuit()).add(card);
		}
		for (Entry<Character, ArrayList<Card>> temp : colors.entrySet()) {
		    ArrayList<Card> values = temp.getValue();
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
	
	private boolean checkForStraight(ArrayList<Card> cards) {
		return false;
	}
	
	private boolean checkForThreeOfAKind(ArrayList<Card> cards) {
		return false;
	}
	
	private boolean checkForTwoPairs(ArrayList<Card> cards) {
		return false;
	}
	
	private boolean checkForPair(ArrayList<Card> cards) {
		return false;
	}
}
