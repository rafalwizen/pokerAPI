package wizen.rafal.poker.service.winServiceTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import wizen.rafal.poker.model.Card;
import wizen.rafal.poker.service.WinServiceImpl;

class CheckForTwoPairs {

	@Test
	void hasTwoPairs_two7and4and8asKicker_True() {
		WinServiceImpl test = new WinServiceImpl();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(3, 'H'));
		cards.add(new Card(4, 'H'));
		cards.add(new Card(8, 'C'));
		cards.add(new Card(2, 'S'));
		cards.add(new Card(4, 'D'));
		cards.add(new Card(7, 'H'));
		cards.add(new Card(7, 'C'));
		int[] output = test.checkForTwoPairs(cards);
		int[] expected = {3, 7, 4, 8};
		assertEquals(expected[0], output[0]);
		assertEquals(expected[1], output[1]);
		assertEquals(expected[2], output[2]);
		assertEquals(expected[3], output[3]);
	}

	@Test
	void hasTwoPairs_threePairs11and6and3and3asKicker_True() {
		WinServiceImpl test = new WinServiceImpl();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(3, 'H'));
		cards.add(new Card(6, 'H'));
		cards.add(new Card(3, 'C'));
		cards.add(new Card(6, 'S'));
		cards.add(new Card(11, 'D'));
		cards.add(new Card(11, 'H'));
		cards.add(new Card(2, 'C'));
		int[] output = test.checkForTwoPairs(cards);
		int[] expected = {3, 11, 6, 3};
		assertEquals(expected[0], output[0]);
		assertEquals(expected[1], output[1]);
		assertEquals(expected[2], output[2]);
		assertEquals(expected[3], output[3]);
	}
	
	@Test
	void hasTwoPairs_threePairs11and6and3and9asKicker_True() {
		WinServiceImpl test = new WinServiceImpl();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(3, 'H'));
		cards.add(new Card(6, 'H'));
		cards.add(new Card(3, 'C'));
		cards.add(new Card(6, 'S'));
		cards.add(new Card(11, 'D'));
		cards.add(new Card(11, 'H'));
		cards.add(new Card(9, 'C'));
		int[] output = test.checkForTwoPairs(cards);
		int[] expected = {3, 11, 6, 9};
		assertEquals(expected[0], output[0]);
		assertEquals(expected[1], output[1]);
		assertEquals(expected[2], output[2]);
		assertEquals(expected[3], output[3]);
	}
	
	@Test
	void hasTwoPairs_noTwoPairs_False() {
		WinServiceImpl test = new WinServiceImpl();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(3, 'H'));
		cards.add(new Card(11, 'H'));
		cards.add(new Card(8, 'C'));
		cards.add(new Card(2, 'S'));
		cards.add(new Card(4, 'D'));
		cards.add(new Card(7, 'H'));
		cards.add(new Card(7, 'C'));
		int[] output = test.checkForTwoPairs(cards);
		assertEquals(0, output[0]);
	}
}
