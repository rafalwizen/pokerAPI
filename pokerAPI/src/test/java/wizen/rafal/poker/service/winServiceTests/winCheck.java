package wizen.rafal.poker.service.winServiceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import wizen.rafal.poker.model.Card;
import wizen.rafal.poker.model.Deck;
import wizen.rafal.poker.service.WinServiceImpl;

class winCheck {

	ArrayList<Card> communityCards;
	ArrayList<Card> playerPocket;
	ArrayList<ArrayList<Card>> opponentsPocket;
	int numberOfOpponents;
	
	@Test
	void winCheck_playerWin_FullHouse_True() {
		WinServiceImpl test = new WinServiceImpl();
		communityCards = new ArrayList<Card>();
		playerPocket = new ArrayList<Card>();
		opponentsPocket = new ArrayList<ArrayList<Card>>();
		numberOfOpponents = 5;
		
		// add community cards
		communityCards.add(new Card(8, 'H'));
		communityCards.add(new Card(7, 'H'));
		communityCards.add(new Card(7, 'C'));
		communityCards.add(new Card(5, 'H'));
		communityCards.add(new Card(2, 'C'));
		
		// add player cards
		playerPocket.add(new Card(8, 'D'));
		playerPocket.add(new Card(8, 'C'));
		
		// add opponent 1 cards
		ArrayList<Card> tempList = new ArrayList<Card>();
		tempList.add(new Card(14, 'H'));
		tempList.add(new Card(10, 'H'));
		opponentsPocket.add(tempList);
		
		// add opponent 2 cards
		tempList = new ArrayList<Card>();
		tempList.add(new Card(2, 'D'));
		tempList.add(new Card(3, 'D'));
		opponentsPocket.add(tempList);
				
		// add opponent 3 cards
		tempList = new ArrayList<Card>();
		tempList.add(new Card(2, 'H'));
		tempList.add(new Card(3, 'H'));
		opponentsPocket.add(tempList);
		
		// add opponent 4 cards
		tempList = new ArrayList<Card>();
		tempList.add(new Card(4, 'H'));
		tempList.add(new Card(5, 'H'));
		opponentsPocket.add(tempList);
				
		// add opponent 5 cards
		tempList = new ArrayList<Card>();
		tempList.add(new Card(6, 'H'));
		tempList.add(new Card(9, 'H'));
		opponentsPocket.add(tempList);

		Deck deck = new DeckForTests(communityCards, playerPocket, opponentsPocket);
		
		String[] output = test.winCheck(deck);
		String[] expected = {"player"};
		
		assertEquals(expected[0], output[0]);
	}

	@Test
	void winCheck_playerAndOpp2Win_Straight_True() {
		WinServiceImpl test = new WinServiceImpl();
		communityCards = new ArrayList<Card>();
		playerPocket = new ArrayList<Card>();
		opponentsPocket = new ArrayList<ArrayList<Card>>();
		numberOfOpponents = 5;
		
		// add community cards
		communityCards.add(new Card(8, 'S'));
		communityCards.add(new Card(7, 'S'));
		communityCards.add(new Card(12, 'C'));
		communityCards.add(new Card(5, 'H'));
		communityCards.add(new Card(2, 'C'));
		
		// add player cards
		playerPocket.add(new Card(6, 'D'));
		playerPocket.add(new Card(9, 'C'));
		
		// add opponent 1 cards
		ArrayList<Card> tempList = new ArrayList<Card>();
		tempList.add(new Card(14, 'H'));
		tempList.add(new Card(10, 'H'));
		opponentsPocket.add(tempList);
		
		// add opponent 2 cards
		tempList = new ArrayList<Card>();
		tempList.add(new Card(9, 'D'));
		tempList.add(new Card(6, 'C'));
		opponentsPocket.add(tempList);
				
		// add opponent 3 cards
		tempList = new ArrayList<Card>();
		tempList.add(new Card(2, 'H'));
		tempList.add(new Card(3, 'H'));
		opponentsPocket.add(tempList);
		
		// add opponent 4 cards
		tempList = new ArrayList<Card>();
		tempList.add(new Card(4, 'H'));
		tempList.add(new Card(5, 'H'));
		opponentsPocket.add(tempList);
				
		// add opponent 5 cards
		tempList = new ArrayList<Card>();
		tempList.add(new Card(14, 'H'));
		tempList.add(new Card(9, 'H'));
		opponentsPocket.add(tempList);

		Deck deck = new DeckForTests(communityCards, playerPocket, opponentsPocket);
		
		String[] output = test.winCheck(deck);
		String[] expected = {"player", "opponent 2"};
		
		assertEquals(expected[0], output[0]);
		assertEquals(expected[1], output[1]);
	}
	
	// specific test case
	// best hand is straight 5, 6, 7, 8, 9 but on table we have 2x 7
	// there was an error at first time here - fixed checkForStraight method
	@Test
	void winCheck_playerAndOpp2AndOpp3Win_Straight_True() {
		WinServiceImpl test = new WinServiceImpl();
		communityCards = new ArrayList<Card>();
		playerPocket = new ArrayList<Card>();
		opponentsPocket = new ArrayList<ArrayList<Card>>();
		numberOfOpponents = 5;
		
		// add community cards
		communityCards.add(new Card(8, 'S'));
		communityCards.add(new Card(7, 'S'));
		communityCards.add(new Card(7, 'C')); 
		communityCards.add(new Card(5, 'H'));
		communityCards.add(new Card(2, 'C'));
		
		// add player cards
		playerPocket.add(new Card(6, 'D'));
		playerPocket.add(new Card(9, 'C'));
		
		// add opponent 1 cards
		ArrayList<Card> tempList = new ArrayList<Card>();
		tempList.add(new Card(14, 'H'));
		tempList.add(new Card(10, 'H'));
		opponentsPocket.add(tempList);
		
		// add opponent 2 cards
		tempList = new ArrayList<Card>();
		tempList.add(new Card(9, 'D'));
		tempList.add(new Card(6, 'C'));
		opponentsPocket.add(tempList);
				
		// add opponent 3 cards
		tempList = new ArrayList<Card>();
		tempList.add(new Card(6, 'H'));
		tempList.add(new Card(9, 'H'));
		opponentsPocket.add(tempList);
		
		// add opponent 4 cards
		tempList = new ArrayList<Card>();
		tempList.add(new Card(4, 'H'));
		tempList.add(new Card(5, 'H'));
		opponentsPocket.add(tempList);
				
		// add opponent 5 cards
		tempList = new ArrayList<Card>();
		tempList.add(new Card(14, 'H'));
		tempList.add(new Card(9, 'H'));
		opponentsPocket.add(tempList);

		Deck deck = new DeckForTests(communityCards, playerPocket, opponentsPocket);
		
		String[] output = test.winCheck(deck);
		String[] expected = {"player", "opponent 3", "opponent 2"};
		
		assertEquals(expected[0], output[0]);
		assertEquals(expected[1], output[1]);
		assertEquals(expected[2], output[2]);
	}
	
	@Test
	void winCheck_Opp3Win_StraightFlush_True() {
		WinServiceImpl test = new WinServiceImpl();
		communityCards = new ArrayList<Card>();
		playerPocket = new ArrayList<Card>();
		opponentsPocket = new ArrayList<ArrayList<Card>>();
		numberOfOpponents = 5;
		
		// add community cards
		communityCards.add(new Card(8, 'S'));
		communityCards.add(new Card(7, 'S'));
		communityCards.add(new Card(7, 'C')); 
		communityCards.add(new Card(5, 'S'));
		communityCards.add(new Card(2, 'C'));
		
		// add player cards
		playerPocket.add(new Card(6, 'D'));
		playerPocket.add(new Card(9, 'C'));
		
		// add opponent 1 cards
		ArrayList<Card> tempList = new ArrayList<Card>();
		tempList.add(new Card(14, 'H'));
		tempList.add(new Card(10, 'H'));
		opponentsPocket.add(tempList);
		
		// add opponent 2 cards
		tempList = new ArrayList<Card>();
		tempList.add(new Card(9, 'D'));
		tempList.add(new Card(6, 'C'));
		opponentsPocket.add(tempList);
				
		// add opponent 3 cards
		tempList = new ArrayList<Card>();
		tempList.add(new Card(6, 'S'));
		tempList.add(new Card(4, 'S'));
		opponentsPocket.add(tempList);
		
		// add opponent 4 cards
		tempList = new ArrayList<Card>();
		tempList.add(new Card(4, 'H'));
		tempList.add(new Card(5, 'H'));
		opponentsPocket.add(tempList);
				
		// add opponent 5 cards
		tempList = new ArrayList<Card>();
		tempList.add(new Card(14, 'H'));
		tempList.add(new Card(9, 'H'));
		opponentsPocket.add(tempList);

		Deck deck = new DeckForTests(communityCards, playerPocket, opponentsPocket);
		
		String[] output = test.winCheck(deck);
		String[] expected = {"opponent 3"};
		
		assertEquals(expected[0], output[0]);
	}
}
