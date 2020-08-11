package wizen.rafal.poker.service;

import wizen.rafal.poker.model.Deck;

public interface TableService {

	public void newDeck();
	public Deck getAllCards();
	public String[] getWinner();
	
}
