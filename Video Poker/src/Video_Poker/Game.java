package Video_Poker;

import java.util.Scanner;

public class Game {
	
	static String Cards[] = new String[5];
	static boolean Discard[] = new boolean[5];
	Scanner scanner = new Scanner(System.in);
	
	public void RunGame () {
		
		DrawGame DG = new DrawGame();
		DrawRandomCard DRC = new DrawRandomCard();
		GetResult GR = new GetResult();
		
		for ( int i = 0; i < 5; i++) // draws five cards from the deck
			Cards[i] = DRC.DrawACard();
		
		
		
		DG.DrawPayouts(); // draws the game
		DG.DrawDealtHand(Cards);
		DG.DrawCardChangeQuestion();
		
		DiscardInput(); // asks about discarding cards
		
		for ( int i = 0; i < 5; i++ ) // discards and gets new cards
			if ( Discard[i] == true )
				Cards[i] = DRC.ReturnOldCardAndGetANewOne(Cards[i]);
		
		String result = GR.Result(Cards), prize = GR.Prize(result);
		
		// DG.MoveDown(); // moves the text field down and redraws the second part of the game (currently not used)
		DG.DrawPayouts();
		DG.DrawDealtHand(Cards);
		DG.DrawResult(result, prize);
		PlayAgain();
		scanner.close();
	}
	
	private void DiscardInput () {
		
		boolean finished = false;
		
		switch (scanner.nextLine()) {
			case "1":
				Discard[0] = true;
				break;
			case "2":
				Discard[1] = true;
				break;
			case "3":
				Discard[2] = true;
				break;
			case "4":
				Discard[3] = true;
				break;
			case "5":
				Discard[4] = true;
				break;
			case "finished":
				finished = true;
				break;
			default:
				System.out.println("Invalid input");
		}
		if (finished == false) {
			DiscardInput();
		}
	}

	private void PlayAgain () {
		
		boolean BadInput = false;
		
		switch(scanner.nextLine()) {
			case "yes":
				RunGame();
			case "no":
				break;
			default:
				System.out.println("Invalid input");
				BadInput = true;
		}
		
		if (BadInput == true)
			PlayAgain();
		System.out.print("Thank you for playing!");
	}
}