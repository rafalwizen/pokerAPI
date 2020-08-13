package wizen.rafal.poker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wizen.rafal.poker.model.Deck;

@Service
public class TableServiceImpl implements TableService {

	Deck deck = new Deck();
	//Deck deck = Deck.getInstance();
	
	@Autowired
	WinService winService;
	
	@Override
	public void newDeck() {
		deck.newDeal();
	}
	
	@Override
	public Deck getAllCards() {
		
		return deck;
	}

	@Override
	public String[] getWinner() {
		return winService.winCheck(deck);
	}

	

}
