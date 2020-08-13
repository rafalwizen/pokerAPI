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

	//Deck deck = Deck.getInstance();
	
	@Override
	public String[] winCheck(Deck deck) {
		HashMap <String, int[]> valuesOfHands = new HashMap <String, int[]>();
		
		int[] valueOfPlayersHand;
		ArrayList<Card> playersCards = new ArrayList<Card>();
		playersCards.addAll(deck.getCommunityCards());
		playersCards.addAll(deck.getPlayersPocket());
		valueOfPlayersHand = checkHandAndValue(playersCards);
		valuesOfHands.put("player", valueOfPlayersHand);
		
		int[][] valueOfOpponentsHands = new int[deck.getOpponentsPocket().size()][6];

		for (int i = 0; i < deck.getOpponentsPocket().size(); i++) {
			ArrayList<Card> opponentCards = new ArrayList<Card>();
			opponentCards.addAll(deck.getCommunityCards());
			opponentCards.addAll(deck.getOpponentsPocket().get(i));
			valueOfOpponentsHands[i] = checkHandAndValue(opponentCards);
			valuesOfHands.put("opponent " + (i+1), valueOfOpponentsHands[i]);
		}
		
		int[] bestHand = {0, 0, 0, 0, 0, 0};
		String[] bestPlayer = new String[6];
		int numberOfTies = 0;
		for (Entry <String, int[]> entry : valuesOfHands.entrySet()) {
			int temp[] = entry.getValue();
			for(int i = 0; i < 6; i++) {
				if (temp[i] > bestHand[i]) {
					numberOfTies = 0;
					Arrays.fill(bestPlayer, "");
					bestHand = temp;
					bestPlayer[0] = entry.getKey();
					break;
				} else if (temp[i] < bestHand[i]) {
					break;
				}
				if(i == 5) {
					numberOfTies++;
					bestPlayer[numberOfTies] = entry.getKey();
				}
			}
		}
		Arrays.sort(bestPlayer, Collections.reverseOrder());
		
		// for tests purposes
//		for( int temp : bestHand) {
//			System.out.println(temp);
//		}
		return bestPlayer;
	}
	
	private int[] checkHandAndValue(ArrayList<Card> cards) {
		int[] result;
		result = checkForStraightFlush(cards);
		if (result[0] != 0) return result;
		result = checkForFourOfAKind(cards);
		if (result[0] != 0) return result;
		result = checkForFullHouse(cards);
		if (result[0] != 0) return result;
		result = checkForFlush(cards);
		if (result[0] != 0) return result;
		result = checkForStraight(cards);
		if (result[0] != 0) return result;
		result = checkForThreeOfAKind(cards);
		if (result[0] != 0) return result;
		result = checkForTwoPairs(cards);
		if (result[0] != 0) return result;
		result = checkForOnePair(cards);
		if (result[0] != 0) return result;
		result = checkForHeighestCard(cards);	
		return result;
	}
	
	// methods for check each possible variant
	// every private method returns table of integers with size 6.
	
	// kicker(s) - is a card in a hand that does not itself take part in determining the rank of the hand,
	// but that may be used to break ties between hands of the same rank
	
	private int[] checkForStraightFlush(ArrayList<Card> cards) {
		boolean loopBreaker = false; // no more than 2 iterations if we have more than 1 Ace in hand
		do {
			if(loopBreaker) {cards.get(0).setValue(1);} // only if first card was Ace - change value to 1 for check small StraightFlush
			loopBreaker = !loopBreaker;
			Collections.sort(cards);
			int counter = 0;
			int highestCard = 0;
			for(int i = 0; i < cards.size()-1; i ++) {
				if(cards.get(i).getValue()-1 == cards.get(i+1).getValue()
				   && cards.get(i).getSuit() == cards.get(i+1).getSuit()) {
					highestCard = (counter==0) ? cards.get(i).getValue() : highestCard;
					counter++;
				
				} else {
					counter = 0;
				}
				if(counter==4) {
					// 9 is value for straight flush, also add heighest card and 4x 0 to get same size of methods results
					int[] result = {9, highestCard, 0, 0, 0, 0};
					return result;
				}
			}
		} while(cards.get(0).isAce() && loopBreaker);
		if(cards.get(6).isAce()) {cards.get(6).setValue(14);}
		int[] result = {0};
		return result;
	}
	
	private int[] checkForFourOfAKind(ArrayList<Card> cards) {
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
			// 8 is value for four of a kind, also add value and 1 kicker and 3x 0 to get same size of methods results
			int[] result = {8, valueOfFourOfAKind, kicker, 0, 0, 0};
			return result;
		}
		
		int[] result = {0};
		return result;
	}
	
	private int[] checkForFullHouse(ArrayList<Card> cards) {
		HashMap <Integer, Integer> hand = new HashMap <Integer, Integer>();
		for (Card card : cards) {
			hand.merge(card.getValue(), 1, Integer::sum);
		}
		int tree1 = 0;
		int tree2 = 0; // always lower than tree1
		int pair = 0;
		for (Entry<Integer, Integer> entry : hand.entrySet()) {
			if(entry.getValue() == 3) {
				if(entry.getKey() > tree1 && tree1 != 0) {
					tree2 = tree1;
					tree1 = entry.getKey();
				} else if (entry.getKey() > tree1) {
					tree1 = entry.getKey();
				} else if (entry.getKey() < tree1) {
					tree2 = entry.getKey();
				}
			}			
			if(entry.getValue() == 2) {
				pair = (pair > entry.getKey()) ? pair : entry.getKey();
			}
		}
		// 7 is value for full house, also add 3 and 2 best cards and 3x 0 to get same size of methods results
		if(tree1 !=0 && tree2 != 0) {
			int[] result = {7, tree1, tree2, 0, 0, 0};
			return result;
		} else if (tree1 != 0 && pair != 0) {
			int[] result = {7, tree1, pair, 0, 0, 0};
			return result;
		}
		
		int[] result = {0};
		return result;
	}
	
	private int[] checkForFlush(ArrayList<Card> cards) {
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
	
	private int[] checkForStraight(ArrayList<Card> cards) {
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
				} else if (cards.get(i).getValue() == cards.get(i+1).getValue()) {
					continue;
				} else {
					counter = 0;
				}
				if(counter==4) {
					// 5 is value for straight, also add heighest card and 4x 0 to get same size of methods results
					int[] result = {5, highestCard, 0, 0, 0, 0};
					return result;
				}
			}			
		} while(cards.get(0).isAce() && loopBreaker); 
		if(cards.get(6).isAce()) {cards.get(6).setValue(14);}
		int[] result = {0};	
		return result;
	}
	
	private int[] checkForThreeOfAKind(ArrayList<Card> cards) {
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
			// 4 is value for three of a kind, also add 2 kickers and 2x 0 to get same size of methods results
			int[] result = {4, valueOfThreeOfAKind, kicker1, kicker2, 0, 0};
			return result;
		}
		
		int[] result = {0};
		return result;
	}
	
	private int[] checkForTwoPairs(ArrayList<Card> cards) {
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
			// 3 is value for two pairs, also add kicker and 2x 0 to get same size of methods results
			int[] result = {3, pair1, pair2, kicker, 0, 0};
			return result;
		}
		int[] result = {0};
		return result;
	}
	
	private int[] checkForOnePair(ArrayList<Card> cards) {
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
			// 2 is value for pair, also add 3 kickers and 1x 0 to get same size of methods results
			int[] result = {2, pair, kicker1, kicker2, kicker3, 0};
			return result;
		}
		int[] result = {0};
		return result;
	}
	
	private int[] checkForHeighestCard(ArrayList<Card> cards) {
		Collections.sort(cards);
		// 1 is value for highest pair also add 5 best cards
		int[] result = {1, cards.get(0).getValue(), cards.get(1).getValue(), cards.get(2).getValue(),
						   cards.get(3).getValue(), cards.get(4).getValue()};

		return result;
	}
}
