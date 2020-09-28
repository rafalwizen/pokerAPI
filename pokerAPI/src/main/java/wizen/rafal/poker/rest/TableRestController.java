package wizen.rafal.poker.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wizen.rafal.poker.model.Deck;
import wizen.rafal.poker.service.TableService;

@RestController
@RequestMapping("/")
@CrossOrigin("http://localhost:4200")
public class TableRestController {

	@Autowired
	TableService tableService;
	
	@GetMapping("/newDeck")
	public void newDeck() {
		tableService.newDeck();
	}
	
	@GetMapping("/cards")
	public Deck getAllCards() {
		return tableService.getAllCards();
	}
	
	@GetMapping("/winner")
	public String[] getWinner() {
		return tableService.getWinner();
	} 
}
