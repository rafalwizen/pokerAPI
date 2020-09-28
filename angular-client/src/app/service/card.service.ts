import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Deck } from './../model/deck';

@Injectable({
  providedIn: 'root',
})
export class CardService {
  constructor(private http: HttpClient) {}

  getAllCards(): Observable<Deck[]> {
    return this.http.get<Deck[]>('http://localhost:8080/cards');
  }
}
