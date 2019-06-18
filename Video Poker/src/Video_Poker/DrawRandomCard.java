package Video_Poker;

import java.util.Random;
import java.util.ArrayList;

public class DrawRandomCard {

	private final static String FullDeck[][] = new String[][] {
		{ "2 of Clubs", "3 of Clubs", "4 of Clubs", "5 of Clubs", "6 of Clubs", "7 of Clubs", "8 of Clubs", "9 of Clubs", "10 of Clubs", "Jack of Clubs", "Queen of Clubs", "King of Clubs", "Ace of Clubs"},
		{ "2 of Spades", "3 of Spades", "4 of Spades", "5 of Spades", "6 of Spades", "7 of Spades", "8 of Spades", "9 of Spades", "10 of Spades", "Jack of Spades", "Queen of Spades", "King of Spades", "Ace of Spades"},
		{ "2 of Diamonds", "3 of Diamonds", "4 of Diamonds", "5 of Diamonds", "6 of Diamonds", "7 of Diamonds", "8 of Diamonds", "9 of Diamonds", "10 of Diamonds", "Jack of Diamonds", "Queen of Diamonds", "King of Diamonds", "Ace of Diamonds"},
		{ "2 of Hearts", "3 of Hearts", "4 of Hearts", "5 of Hearts", "6 of Hearts", "7 of Hearts", "8 of Hearts", "9 of Hearts", "10 of Hearts", "Jack of Hearts", "Queen of Hearts", "King of Hearts", "Ace of Hearts"}
	};
	ArrayList<String> CurrentDeck = new ArrayList<String>();
	private static int NrOfCardsInDeck = 52;
	
	DrawRandomCard () {
		for ( int i = 0; i < 4; i++)
			for ( int j = 0; j < 13; j++)
				CurrentDeck.add(FullDeck[i][j]);
	}
	
	public String DrawACard() { // returns the card that was drawn and removes it from the current deck
		
		int RandomInt = RandomInt(NrOfCardsInDeck);
		String CardDrawn = CurrentDeck.get(RandomInt);
		CurrentDeck.remove(RandomInt);
		NrOfCardsInDeck--;
		return CardDrawn;
	}
	
	public String ReturnOldCardAndGetANewOne (String OldCard) {
		
		CurrentDeck.add(OldCard);
		NrOfCardsInDeck++;
		String NewCard = DrawACard();
		return NewCard;
	}
	
	private static int RandomInt (int CardsLeft) { // gets a random integer in the range of 1 to 52
		
		Random Random = new Random();
		return Random.nextInt(CardsLeft);
	}
}