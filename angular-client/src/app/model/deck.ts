import { Card } from './card';

export interface Deck {
  deck: Array<Card>;
  communityCards: Array<Card>;
  playersPocket: Array<Card>;
  opponentsPocket: Array<Array<Card>>;
  numberOfOpponents: number;
}
