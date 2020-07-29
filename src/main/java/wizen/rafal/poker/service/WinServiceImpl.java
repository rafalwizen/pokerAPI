package wizen.rafal.poker.service;

import java.util.ArrayList;
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
	
	public int[] checkForFourOfAKind(ArrayList<Card> cards) {
		HashMap<Integer, Integer> hand = new HashMap<Integer, Integer>();
		for(Card card : cards) {
			hand.merge(card.getValue(), 1, Integer::sum);
		}
		if(hand.containsValue(4)) {
			int valueOfFourOfAKind = 0;
			int kicker = 0;
			for(Entry<Integer, Integer> entry : hand.entrySet()) {
				if(entry.getValue()==4) {
					valueOfFourOfAKind = entry.getKey();
				} else {
					kicker = (kicker >= entry.getKey())? kicker : entry.getKey();
				}				
			}
			// 8 is value for four of a kind, also add value and 1 kicker
			int[] result = {8, valueOfFourOfAKind, kicker};
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
		    	// 6 is value for flush, also add 5 highest cards
		    	int[] result = {6, values.get(0).getValue(),values.get(1).getValue(),
		    					values.get(2).getValue(),values.get(3).getValue(),values.get(4).getValue()};
		    	return result;
		    }
		}
		int[] result = {0};
		return result;
	}
	
	public int[] checkForStraight(ArrayList<Card> cards) {
		boolean loopBreaker = false; // no more than 2 iterations if we have more than 1 Ace in hand
		do {
			if(loopBreaker) {cards.get(0).setValue(1);} // only if first card was Ace - change value to 1 for check small Straight
			loopBreaker = !loopBreaker;
			Collections.sort(cards);
			int counter = 0;
			int highestCard = 0;
			for(int i = 0; i < cards.size()-1; i ++) {
				if(cards.get(i).getValue()-1 == cards.get(i+1).getValue()){
					highestCard = (counter==0) ? cards.get(i).getValue() : highestCard;
					counter++;
				} else {
					counter = 0;
				}
				if(counter==4) {
					// 5 is value for straight, also add heighest card
					int[] result = {5, highestCard};
					return result;
				}
			}			
		} while(cards.get(0).isAce() && loopBreaker); 
		int[] result = {0};
		return result;
	}
	
	public int[] checkForThreeOfAKind(ArrayList<Card> cards) {
		HashMap<Integer, Integer> hand = new HashMap<Integer, Integer>();
		for(Card card : cards) {
			hand.merge(card.getValue(), 1, Integer::sum);
		}
		if(hand.containsValue(3)) {
			int valueOfThreeOfAKind = 0;
			int kicker1 = 0;
			int kicker2 = 0; // always lower than kicker1
			for(Entry<Integer, Integer> entry : hand.entrySet()) {
				if(entry.getValue()==3) {
					valueOfThreeOfAKind = (valueOfThreeOfAKind > entry.getKey()) ? valueOfThreeOfAKind : entry.getKey();
				} else {
					if(kicker1<entry.getKey()) {
						kicker2 = kicker1;
						kicker1 = entry.getKey();
					} else if(kicker2<entry.getKey()) {
						kicker2 = entry.getKey();
					}
				}
			}
			// 4 is value for three of a kind, also add 2 kickers
			int[] result = {4, valueOfThreeOfAKind, kicker1, kicker2};
			return result;
		}
		
		int[] result = {0};
		return result;
	}
	
	public int[] checkForTwoPairs(ArrayList<Card> cards) {
		HashMap<Integer, Integer> hand = new HashMap<Integer, Integer>();
		for(Card card : cards) {
			hand.merge(card.getValue(), 1, Integer::sum);
		}
		int pair1 = 0;
		int pair2 = 0; // always lower than pair1
		int pair3 = 0; // possible only in some cases
		int kicker = 0;
		for(Entry<Integer, Integer> entry : hand.entrySet()) {
			if(entry.getValue()==2) {
				if(pair1 < entry.getKey()) {
					pair3 = pair2;
					pair2 = pair1;
					pair1 = entry.getKey();
				} else if(pair2 < entry.getKey()) {
					pair3 = pair2;
					pair2 = entry.getKey();
				} 
			} else {
				kicker = entry.getKey();
			}
		}
		kicker = (kicker > pair3) ? kicker : pair3;
		if(pair2 != 0) {
			// 3 is value for two pairs, also add kicker
			int[] result = {3, pair1, pair2, kicker};
			return result;
		}
		int[] result = {0};
		return result;
	}
	
	public int[] checkForOnePair(ArrayList<Card> cards) {
		HashMap<Integer, Integer> hand = new HashMap<Integer, Integer>();
		for(Card card : cards) {
			hand.merge(card.getValue(), 1, Integer::sum);
		}
		int pair = 0;
		int kicker1 = 0;
		int kicker2 = 0; // always lower or equal to kicker1
		int kicker3 = 0; // always lower or equal to kicker2
		for(Entry<Integer, Integer> entry : hand.entrySet()) {
			if(entry.getValue()==2) {
				pair = entry.getKey();
			} else if (kicker1 < entry.getKey()){
				kicker3 = kicker2;
				kicker2 = kicker1;
				kicker1 = entry.getKey();
			} else if(kicker2 < entry.getKey()) {
				kicker3 = kicker2;
				kicker2 = entry.getKey();
			} else if (kicker3 < entry.getKey()) {
				kicker3 = entry.getKey();
			}
		}
		if(pair!=0) {
			// 2 is value for pair, also add 3 kickers
			int[] result = {2, pair, kicker1, kicker2, kicker3};
			return result;
		}
		int[] result = {0};
		return result;
	}
	
	public int[] checkForHeighestCard(ArrayList<Card> cards) {
		Collections.sort(cards);
		// 1 is value for highest pair
		int[] result = {1, cards.get(0).getValue(), cards.get(1).getValue(), cards.get(2).getValue(),
						   cards.get(3).getValue(), cards.get(4).getValue()};

		return result;
	}
}
