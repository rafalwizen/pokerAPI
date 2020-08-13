package wizen.rafal.poker.service.winServiceTests;

import java.util.ArrayList;

import wizen.rafal.poker.model.Card;
import wizen.rafal.poker.model.Deck;

public class DeckForTests extends Deck {


//	protected ArrayList<Card> deck;
//	protected ArrayList<Card> communityCards;
//	protected ArrayList<Card> playersPocket;
//	protected ArrayList<ArrayList<Card>> opponentsPocket;
//	protected int numberOfOpponents = 5;
	
	public DeckForTests( ArrayList<Card>communityCards, ArrayList<Card> playerPocket,
			 ArrayList<ArrayList<Card>> opponentsPocket) {
		this.communityCards = communityCards;
		this.playersPocket = playerPocket;
		this.opponentsPocket = opponentsPocket;		
	}	
}
