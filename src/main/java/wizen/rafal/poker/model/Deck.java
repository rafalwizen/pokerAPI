package wizen.rafal.poker.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Deck {

	private ArrayList<Card> deck;
	private ArrayList<Card> communityCards;
	private ArrayList<Card> playersHand;
	private ArrayList<ArrayList<Card>> opponentsHands;
	private int numberOfOpponents = 5;
	
	private Deck() {
		newDeal();
	}
	
	private static final Deck INSTANCE = new Deck();
	
	public static Deck getInstance() {
		return INSTANCE;
	}
	
	public void newDeal() {
		newDeck();
		dealCards();
		dealFlop();
		dealTurn();
		dealRiver();
	}
	
	public void newDeck() {
		deck = new ArrayList<Card>();
		for(int i = 1; i <= 13; i++) {
			deck.add(new Card(i , 'H'));
			deck.add(new Card(i , 'S'));
			deck.add(new Card(i , 'D'));
			deck.add(new Card(i , 'C'));
		}
	}
	
	public void dealCards() {
		playersHand = new ArrayList<Card>();
		// two cards for player
		playersHand.add(getCardFromDeck());
		playersHand.add(getCardFromDeck());
		//two cards for each of opponents
		opponentsHands = new ArrayList<ArrayList<Card>>();
		for(int i =0; i < numberOfOpponents; i++) {
			ArrayList<Card> tempList = new ArrayList<Card>();
			tempList.add(getCardFromDeck());
			tempList.add(getCardFromDeck());
			opponentsHands.add(tempList);
		}
	}
	
	private Card getCardFromDeck() {
		int random = (int)(Math.random() * deck.size());
		Card temp = deck.get(random);
		deck.remove(temp);
		return temp;
	}

	private void dealFlop() {
		communityCards = new ArrayList<Card>();
		communityCards.add(getCardFromDeck());
		communityCards.add(getCardFromDeck());
		communityCards.add(getCardFromDeck());
	}
	
	private void dealTurn() {
		communityCards.add(getCardFromDeck());
	}
	
	private void dealRiver() {
		communityCards.add(getCardFromDeck());
	}
}
