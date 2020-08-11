package wizen.rafal.poker.service.winServiceTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import wizen.rafal.poker.model.Card;
import wizen.rafal.poker.service.WinServiceImpl;

class CheckForStraightFlush {
	
//	@Test
//	void checkForStraightFlush_14_13_12_11_10_H_True() {
//		WinServiceImpl test = new WinServiceImpl();
//		ArrayList<Card> cards = new ArrayList<Card>();
//		cards.add(new Card(10, 'H'));
//		cards.add(new Card(3, 'D'));
//		cards.add(new Card(14, 'H'));
//		cards.add(new Card(12, 'H'));
//		cards.add(new Card(11, 'H'));
//		cards.add(new Card(9, 'H'));
//		cards.add(new Card(13, 'H'));
//		int[] output = test.checkForStraightFlush(cards);
//		int[] expected = {9, 14};
//		assertEquals(expected[0], output[0]);
//		assertEquals(expected[1], output[1]);
//	}
//
//	@Test
//	void checkForStraightFlush_13_12_11_10_9_H_True() {
//		WinServiceImpl test = new WinServiceImpl();
//		ArrayList<Card> cards = new ArrayList<Card>();
//		cards.add(new Card(10, 'H'));
//		cards.add(new Card(3, 'D'));
//		cards.add(new Card(14, 'C'));
//		cards.add(new Card(12, 'H'));
//		cards.add(new Card(11, 'H'));
//		cards.add(new Card(9, 'H'));
//		cards.add(new Card(13, 'H'));
//		int[] output = test.checkForStraightFlush(cards);
//		int[] expected = {9, 13};
//		assertEquals(expected[0], output[0]);
//		assertEquals(expected[1], output[1]);
//	}
//	
//	@Test
//	void checkForStraightFlush_5_4_3_2_1_D_True() {
//		WinServiceImpl test = new WinServiceImpl();
//		ArrayList<Card> cards = new ArrayList<Card>();
//		cards.add(new Card(5, 'D'));
//		cards.add(new Card(3, 'D'));
//		cards.add(new Card(14, 'D'));
//		cards.add(new Card(2, 'D'));
//		cards.add(new Card(4, 'D'));
//		cards.add(new Card(9, 'H'));
//		cards.add(new Card(13, 'H'));
//		int[] output = test.checkForStraightFlush(cards);
//		int[] expected = {9, 5};
//		assertEquals(expected[0], output[0]);
//		assertEquals(expected[1], output[1]);
//	}
//	
//	@Test
//	void checkForStraightFlush_noStraightFlush1_True() {
//		WinServiceImpl test = new WinServiceImpl();
//		ArrayList<Card> cards = new ArrayList<Card>();
//		cards.add(new Card(10, 'H'));
//		cards.add(new Card(3, 'D'));
//		cards.add(new Card(14, 'C'));
//		cards.add(new Card(12, 'C'));
//		cards.add(new Card(11, 'H'));
//		cards.add(new Card(9, 'H'));
//		cards.add(new Card(13, 'H'));
//		int[] output = test.checkForStraightFlush(cards);
//		assertEquals(0, output[0]);
//	}
//	
//	@Test
//	void checkForStraightFlush_noStraightFlush2_True() {
//		WinServiceImpl test = new WinServiceImpl();
//		ArrayList<Card> cards = new ArrayList<Card>();
//		cards.add(new Card(10, 'C'));
//		cards.add(new Card(3, 'D'));
//		cards.add(new Card(14, 'C'));
//		cards.add(new Card(12, 'C'));
//		cards.add(new Card(11, 'C'));
//		cards.add(new Card(9, 'C'));
//		cards.add(new Card(13, 'H'));
//		int[] output = test.checkForStraightFlush(cards);
//		assertEquals(0, output[0]);
//	}
}
