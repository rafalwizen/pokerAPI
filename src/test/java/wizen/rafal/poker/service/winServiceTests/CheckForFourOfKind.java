package wizen.rafal.poker.service.winServiceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import wizen.rafal.poker.model.Card;
import wizen.rafal.poker.service.WinServiceImpl;

class CheckForFourOfKind {

	@Test
	void hasFourOfKind_four2andkicker12_True() {
		WinServiceImpl test = new WinServiceImpl();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(8, 'H'));
		cards.add(new Card(2, 'H'));
		cards.add(new Card(2, 'C'));
		cards.add(new Card(2, 'S'));
		cards.add(new Card(2, 'D'));
		cards.add(new Card(3, 'H'));
		cards.add(new Card(12, 'C'));
		int[] output = test.checkForFourOfKind(cards);
		int[] expected = {8, 2, 12};
		assertEquals(expected[0], output[0]);
		assertEquals(expected[1], output[1]);
		assertEquals(expected[2], output[2]);
	}
	
	@Test
	void hasFourOfKind_noSame4_False() {
		WinServiceImpl test = new WinServiceImpl();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(8, 'H'));
		cards.add(new Card(2, 'H'));
		cards.add(new Card(1, 'C'));
		cards.add(new Card(2, 'S'));
		cards.add(new Card(2, 'D'));
		cards.add(new Card(3, 'H'));
		cards.add(new Card(12, 'C'));
		int[] output = test.checkForFourOfKind(cards);
		assertEquals(0, output[0]);
	}

}
