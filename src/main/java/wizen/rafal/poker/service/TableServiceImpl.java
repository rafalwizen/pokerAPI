package wizen.rafal.poker.service;

import org.springframework.stereotype.Service;

import wizen.rafal.poker.model.Deck;

@Service
public class TableServiceImpl implements TableService {

	Deck deck = Deck.getInstance();
	
	@Override
	public void newDeck() {
		deck.newDeal();
	}
	
	@Override
	public Deck getAllCards() {
		
		return deck;
	}

	

}
