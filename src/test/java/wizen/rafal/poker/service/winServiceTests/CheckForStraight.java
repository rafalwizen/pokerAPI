package wizen.rafal.poker.service.winServiceTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import wizen.rafal.poker.model.Card;
import wizen.rafal.poker.service.WinServiceImpl;

class CheckForStraight {

	@Test
	void checkForStraight_14_13_12_11_10_True() {
		WinServiceImpl test = new WinServiceImpl();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(10, 'H'));
		cards.add(new Card(3, 'H'));
		cards.add(new Card(14, 'C'));
		cards.add(new Card(12, 'S'));
		cards.add(new Card(11, 'D'));
		cards.add(new Card(9, 'H'));
		cards.add(new Card(13, 'C'));
		int[] output = test.checkForStraight(cards);
		int[] expected = {5, 14};
		assertEquals(expected[0], output[0]);
		assertEquals(expected[1], output[1]);
	}

	@Test
	void checkForStraight_5_4_3_2_1_True() {
		WinServiceImpl test = new WinServiceImpl();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(10, 'H'));
		cards.add(new Card(3, 'H'));
		cards.add(new Card(4, 'C'));
		cards.add(new Card(5, 'S'));
		cards.add(new Card(14, 'D'));
		cards.add(new Card(2, 'H'));
		cards.add(new Card(11, 'C'));
		int[] output = test.checkForStraight(cards);
		int[] expected = {5, 5};
		assertEquals(expected[0], output[0]);
		assertEquals(expected[1], output[1]);
	}
	
	@Test
	void checkForStraight_DoubleAce_5_4_3_2_1_True() {
		WinServiceImpl test = new WinServiceImpl();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(14, 'H'));
		cards.add(new Card(3, 'H'));
		cards.add(new Card(4, 'C'));
		cards.add(new Card(5, 'S'));
		cards.add(new Card(14, 'D'));
		cards.add(new Card(2, 'H'));
		cards.add(new Card(5, 'C'));
		int[] output = test.checkForStraight(cards);
		int[] expected = {5, 5};
		assertEquals(expected[0], output[0]);
		assertEquals(expected[1], output[1]);
	}
	
	@Test
	void checkForStraight_6_5_4_3_2_True() {
		WinServiceImpl test = new WinServiceImpl();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(14, 'H'));
		cards.add(new Card(3, 'H'));
		cards.add(new Card(4, 'C'));
		cards.add(new Card(6, 'S'));
		cards.add(new Card(14, 'D'));
		cards.add(new Card(2, 'H'));
		cards.add(new Card(5, 'C'));
		int[] output = test.checkForStraight(cards);
		int[] expected = {5, 6};
		assertEquals(expected[0], output[0]);
		assertEquals(expected[1], output[1]);
	}
	
	@Test
	void checkForStraight_noStraight_False() {
		WinServiceImpl test = new WinServiceImpl();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(10, 'H'));
		cards.add(new Card(3, 'H'));
		cards.add(new Card(14, 'C'));
		cards.add(new Card(2, 'S'));
		cards.add(new Card(11, 'D'));
		cards.add(new Card(9, 'H'));
		cards.add(new Card(13, 'C'));
		int[] output = test.checkForStraight(cards);
		assertEquals(0, output[0]);
	}
	
	
}
