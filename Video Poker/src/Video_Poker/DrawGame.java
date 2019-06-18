package Video_Poker;

public class DrawGame {

	void DrawPayouts() { // draws the payout table
		
		System.out.println("╔═════════════════╦═══════╦═════════════════════════╗");
		System.out.println("║ Hand            ║ Prize ║                         ║");
		System.out.println("╠═════════════════╬═══════╬═════════════════╦═══════╣");
		System.out.println("║ Royal Flush     ║  800  ║ Straight Flush  ║   50  ║");
		System.out.println("║ Four of a kind  ║   25  ║ Full House      ║    9  ║");
		System.out.println("║ Flush           ║    6  ║ Straight        ║    4  ║");
		System.out.println("║ Three of a kind ║    3  ║ Two Pair        ║    2  ║");
		System.out.println("║ Jacks or Better ║    1  ║ All Other       ║    0  ║");
		System.out.println("╚═════════════════╩═══════╩═════════════════╩═══════╝");
	}
	
	void DrawDealtHand(String Cards[]) { // draws the drawn card table
		
		System.out.print("\n╔"); // draws the top third of the table
		for ( int i = 0; i < 5; i++) {
			System.out.print("════╦");
			for ( int j = 0; j < Cards[i].length() + 2; j++)
				System.out.print("═");
			if( i<4)
				System.out.print("╦");
			else
				System.out.println("╗");
		}
		
		System.out.print("║"); // draws the middle third of the table
		for ( int i = 1; i < 6; i ++)
			System.out.print( " " + i + ". ║ " + Cards[i-1] + " ║");
		
		System.out.print("\n╚"); // draws the bottom third of the table
		for ( int i = 0; i < 5; i++) {
			System.out.print("════╩");
			for ( int j = 0; j < Cards[i].length() + 2; j++)
				System.out.print("═");
			if( i<4) 
				System.out.print("╩");
			else
				System.out.println("╝");
		}
	}
	
	void DrawCardChangeQuestion () { // draws the question box
		
		System.out.println();
		System.out.println("╔═══════════════════════════════════════════════════╗");
		System.out.println("║ If you wish to discard and draw new cards type in ║");
		System.out.println("║ the coresponding number next to them, one by one. ║");
		System.out.println("║            When done type in finished.            ║");
		System.out.println("╚═══════════════════════════════════════════════════╝\n");
	}
	
	void DrawResult (String result, String prize) {
		System.out.print("╔");
		for( int i = 0; i < result.length() + 11; i++)
			System.out.print("═");
		System.out.print("╦");
		for( int i = 0; i < prize.length() + 17; i++)
			System.out.print("═");
		System.out.println("╦══════════════════════════╗");
		System.out.print  ("║ You got: " + result + " ║ Your prize is: " + prize + " ║ Play again? Type: yes/no ║\n");
		System.out.print("╚");
		for( int i = 0; i < result.length() + 11; i++)
			System.out.print("═");
		System.out.print("╩");
		for( int i = 0; i < prize.length() + 17; i++)
			System.out.print("═");
		System.out.println("╩══════════════════════════╝");
	}
	
	void MoveDown () { // shifts the text down 50 lines
		
		for (int i = 0; i < 50; ++i)
			System.out.println();
    }
}
