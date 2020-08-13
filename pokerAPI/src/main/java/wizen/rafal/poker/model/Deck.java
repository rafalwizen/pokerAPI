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

	protected ArrayList<Card> deck;
	protected ArrayList<Card> communityCards;
	protected ArrayList<Card> playersPocket;
	protected ArrayList<ArrayList<Card>> opponentsPocket;
	protected int numberOfOpponents = 5;
	
	// in future it's going to be probably a singleton - already all logic methods has to be tested
	public Deck() {
		newDeal();
	}
	
//	private Deck() {
//		newDeal();
//	}
//	
//	private static final Deck INSTANCE = new Deck();
//	
//	public static Deck getInstance() {
//		return INSTANCE;
//	}
	
	public void newDeal() {
		newDeck();
		dealCards();
		dealFlop();
		dealTurn();
		dealRiver();
	}
	
	private void newDeck() {
		deck = new ArrayList<Card>();
		for(int i = 2; i <= 14; i++) {
			deck.add(new Card(i , 'H'));
			deck.add(new Card(i , 'S'));
			deck.add(new Card(i , 'D'));
			deck.add(new Card(i , 'C'));
		}
	}
	
	private void dealCards() {
		playersPocket = new ArrayList<Card>();
		// two cards for player
		playersPocket.add(getCardFromDeck());
		playersPocket.add(getCardFromDeck());
		//two cards for each of opponents
		opponentsPocket = new ArrayList<ArrayList<Card>>();
		for(int i =0; i < numberOfOpponents; i++) {
			ArrayList<Card> tempList = new ArrayList<Card>();
			tempList.add(getCardFromDeck());
			tempList.add(getCardFromDeck());
			opponentsPocket.add(tempList);
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
