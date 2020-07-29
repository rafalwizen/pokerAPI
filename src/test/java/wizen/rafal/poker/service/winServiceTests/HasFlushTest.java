package wizen.rafal.poker.service.winServiceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import wizen.rafal.poker.model.Card;
import wizen.rafal.poker.service.WinServiceImpl;

class HasFlushTest {

	@Test
	void test1() {
		WinServiceImpl test = new WinServiceImpl();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(1, 'H'));
		cards.add(new Card(7, 'H'));
		cards.add(new Card(7, 'C'));
		cards.add(new Card(5, 'H'));
		cards.add(new Card(2, 'H'));
		cards.add(new Card(3, 'H'));
		cards.add(new Card(12, 'C'));
		boolean output = test.hasFlush(cards);
		assertEquals(true, output);		
	}

	@Test
	void test2() {
		WinServiceImpl test = new WinServiceImpl();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(1, 'S'));
		cards.add(new Card(7, 'H'));
		cards.add(new Card(7, 'C'));
		cards.add(new Card(5, 'H'));
		cards.add(new Card(2, 'H'));
		cards.add(new Card(3, 'H'));
		cards.add(new Card(12, 'C'));
		boolean output = test.hasFlush(cards);
		assertEquals(false, output);		
	}
}
