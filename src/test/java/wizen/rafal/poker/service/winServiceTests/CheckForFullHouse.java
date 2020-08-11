package wizen.rafal.poker.service.winServiceTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import wizen.rafal.poker.model.Card;
import wizen.rafal.poker.service.WinServiceImpl;

class CheckForFullHouse {

//	@Test
//	void checkForFullHouse_tree10_pair8_True() {
//		WinServiceImpl test = new WinServiceImpl();
//		ArrayList<Card> cards = new ArrayList<Card>();
//		cards.add(new Card(10, 'H'));
//		cards.add(new Card(3, 'H'));
//		cards.add(new Card(10, 'C'));
//		cards.add(new Card(10, 'S'));
//		cards.add(new Card(8, 'D'));
//		cards.add(new Card(9, 'H'));
//		cards.add(new Card(8, 'C'));
//		int[] output = test.checkForFullHouse(cards);
//		int[] expected = {7, 10, 8};
//		assertEquals(expected[0], output[0]);
//		assertEquals(expected[1], output[1]);
//		assertEquals(expected[2], output[2]);
//	}
//	
//	@Test
//	void checkForFullHouse_tree2_pair14_True() {
//		WinServiceImpl test = new WinServiceImpl();
//		ArrayList<Card> cards = new ArrayList<Card>();
//		cards.add(new Card(10, 'H'));
//		cards.add(new Card(3, 'H'));
//		cards.add(new Card(14, 'C'));
//		cards.add(new Card(14, 'S'));
//		cards.add(new Card(2, 'D'));
//		cards.add(new Card(2, 'H'));
//		cards.add(new Card(2, 'C'));
//		int[] output = test.checkForFullHouse(cards);
//		int[] expected = {7, 2, 14};
//		assertEquals(expected[0], output[0]);
//		assertEquals(expected[1], output[1]);
//		assertEquals(expected[2], output[2]);
//	}
//	
//	@Test
//	void checkForFullHouse_tree10_tree8_True() {
//		WinServiceImpl test = new WinServiceImpl();
//		ArrayList<Card> cards = new ArrayList<Card>();
//		cards.add(new Card(10, 'H'));
//		cards.add(new Card(8, 'H'));
//		cards.add(new Card(10, 'C'));
//		cards.add(new Card(10, 'S'));
//		cards.add(new Card(8, 'D'));
//		cards.add(new Card(9, 'H'));
//		cards.add(new Card(8, 'C'));
//		int[] output = test.checkForFullHouse(cards);
//		int[] expected = {7, 10, 8};
//		assertEquals(expected[0], output[0]);
//		assertEquals(expected[1], output[1]);
//		assertEquals(expected[2], output[2]);
//	}
//	
//	@Test
//	void checkForFullHouse_tree11_pair4_pair7_True() {
//		WinServiceImpl test = new WinServiceImpl();
//		ArrayList<Card> cards = new ArrayList<Card>();
//		cards.add(new Card(11, 'H'));
//		cards.add(new Card(4, 'H'));
//		cards.add(new Card(4, 'C'));
//		cards.add(new Card(7, 'S'));
//		cards.add(new Card(11, 'D'));
//		cards.add(new Card(7, 'H'));
//		cards.add(new Card(11, 'C'));
//		int[] output = test.checkForFullHouse(cards);
//		int[] expected = {7, 11, 7};
//		assertEquals(expected[0], output[0]);
//		assertEquals(expected[1], output[1]);
//		assertEquals(expected[2], output[2]);
//	}
//
//	@Test
//	void checkForFullHouse_noFullHouse_False() {
//		WinServiceImpl test = new WinServiceImpl();
//		ArrayList<Card> cards = new ArrayList<Card>();
//		cards.add(new Card(10, 'H'));
//		cards.add(new Card(3, 'H'));
//		cards.add(new Card(14, 'C'));
//		cards.add(new Card(2, 'S'));
//		cards.add(new Card(11, 'D'));
//		cards.add(new Card(9, 'H'));
//		cards.add(new Card(13, 'C'));
//		int[] output = test.checkForFullHouse(cards);
//		assertEquals(0, output[0]);
//	}
}
