import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Deck } from './model/deck';
import { CardService } from './service/card.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'test';
  deck$: Observable<Deck[]>;

  constructor(private cardService: CardService) {}

  ngOnInit(): void {
    this.getAllCards();
  }

  getAllCards(): Observable<Deck[]> {
    return (this.deck$ = this.cardService.getAllCards());
  }
}
