package wizen.rafal.poker.service.winServiceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import wizen.rafal.poker.model.Card;
import wizen.rafal.poker.service.WinServiceImpl;

class CheckForFlush {

	@Test
	void hasFlush_fiveHeartCards_True() {
		WinServiceImpl test = new WinServiceImpl();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(8, 'H'));
		cards.add(new Card(7, 'H'));
		cards.add(new Card(7, 'C'));
		cards.add(new Card(5, 'H'));
		cards.add(new Card(2, 'H'));
		cards.add(new Card(3, 'H'));
		cards.add(new Card(12, 'C'));
		int[] output = test.checkForFlush(cards);
		int[] expected = {6, 8, 7, 5, 3, 2};
		assertEquals(expected[0], output[0]);
		assertEquals(expected[1], output[1]);
		assertEquals(expected[2], output[2]);
		assertEquals(expected[3], output[3]);
		assertEquals(expected[4], output[4]);
		assertEquals(expected[5], output[5]);
	}

	@Test
	void hasFlush_noColorHasFive_False() {
		WinServiceImpl test = new WinServiceImpl();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(8, 'S'));
		cards.add(new Card(7, 'H'));
		cards.add(new Card(7, 'C'));
		cards.add(new Card(5, 'H'));
		cards.add(new Card(2, 'H'));
		cards.add(new Card(3, 'H'));
		cards.add(new Card(12, 'C'));
		int[] output = test.checkForFlush(cards);
		assertEquals(0, output[0]);		
	}
	
	@Test
	void hasFlush_sevenClubCards_True() {
		WinServiceImpl test = new WinServiceImpl();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(8, 'C'));
		cards.add(new Card(7, 'C'));
		cards.add(new Card(10, 'C'));
		cards.add(new Card(11, 'C'));
		cards.add(new Card(2, 'C'));
		cards.add(new Card(3, 'C'));
		cards.add(new Card(5, 'C'));
		int[] output = test.checkForFlush(cards);
		int[] expected = {6, 11, 10, 8, 7, 5};
		assertEquals(expected[0], output[0]);
		assertEquals(expected[1], output[1]);
		assertEquals(expected[2], output[2]);
		assertEquals(expected[3], output[3]);
		assertEquals(expected[4], output[4]);
		assertEquals(expected[5], output[5]);	
	}
	
	@Test
	void hasFlush_fiveSpadesCardsAndHighestAce_True() {
		WinServiceImpl test = new WinServiceImpl();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(1, 'S'));
		cards.add(new Card(1, 'C'));
		cards.add(new Card(10, 'S'));
		cards.add(new Card(11, 'S'));
		cards.add(new Card(2, 'S'));
		cards.add(new Card(3, 'S'));
		cards.add(new Card(5, 'H'));
		int[] output = test.checkForFlush(cards);
		int[] expected = {6, 14, 11, 10, 3, 2};
		assertEquals(expected[0], output[0]);
		assertEquals(expected[1], output[1]);
		assertEquals(expected[2], output[2]);
		assertEquals(expected[3], output[3]);
		assertEquals(expected[4], output[4]);
		assertEquals(expected[5], output[5]);	
	}
}
