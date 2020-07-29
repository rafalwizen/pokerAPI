package wizen.rafal.poker.service.winServiceTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import wizen.rafal.poker.model.Card;
import wizen.rafal.poker.service.WinServiceImpl;

class CheckForThreeOfAKind {

	@Test
	void hasThreeOfAKind_three2andKicker12and8_True() {
		WinServiceImpl test = new WinServiceImpl();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(8, 'H'));
		cards.add(new Card(2, 'H'));
		cards.add(new Card(8, 'C'));
		cards.add(new Card(2, 'S'));
		cards.add(new Card(2, 'D'));
		cards.add(new Card(3, 'H'));
		cards.add(new Card(12, 'C'));
		int[] output = test.checkForThreeOfAKind(cards);
		int[] expected = {4, 2, 12, 8};
		assertEquals(expected[0], output[0]);
		assertEquals(expected[1], output[1]);
		assertEquals(expected[2], output[2]);
		assertEquals(expected[3], output[3]);
	}
	
	@Test
	void hasThreeOfAKind_three10andKicker11and3_True() {
		WinServiceImpl test = new WinServiceImpl();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(10, 'H'));
		cards.add(new Card(2, 'H'));
		cards.add(new Card(3, 'C'));
		cards.add(new Card(10, 'S'));
		cards.add(new Card(10, 'D'));
		cards.add(new Card(3, 'H'));
		cards.add(new Card(11, 'C'));
		int[] output = test.checkForThreeOfAKind(cards);
		int[] expected = {4, 10, 11, 3};
		assertEquals(expected[0], output[0]);
		assertEquals(expected[1], output[1]);
		assertEquals(expected[2], output[2]);
		assertEquals(expected[3], output[3]);
	}

	@Test
	void hasThreeOfAKind_three8andKickerAceAnd7_True() {
		WinServiceImpl test = new WinServiceImpl();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(8, 'H'));
		cards.add(new Card(7, 'H'));
		cards.add(new Card(8, 'C'));
		cards.add(new Card(8, 'S'));
		cards.add(new Card(2, 'D'));
		cards.add(new Card(3, 'H'));
		cards.add(new Card(14, 'C'));
		int[] output = test.checkForThreeOfAKind(cards);
		int[] expected = {4, 8, 14, 7};
		assertEquals(expected[0], output[0]);
		assertEquals(expected[1], output[1]);
		assertEquals(expected[2], output[2]);
		assertEquals(expected[3], output[3]);
	}
	
	@Test
	void hasThreeOfAKind_noSame3_False() {
		WinServiceImpl test = new WinServiceImpl();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(8, 'H'));
		cards.add(new Card(2, 'H'));
		cards.add(new Card(14, 'C'));
		cards.add(new Card(7, 'S'));
		cards.add(new Card(2, 'D'));
		cards.add(new Card(3, 'H'));
		cards.add(new Card(12, 'C'));
		int[] output = test.checkForThreeOfAKind(cards);
		assertEquals(0, output[0]);
	}
}
