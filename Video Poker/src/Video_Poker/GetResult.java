package Video_Poker;

import java.util.ArrayList;

public class GetResult {
	
	private static String CardRank[] = new String[5];
	private static String CardSuit[] = new String[5];
	private static int RankInt[] = new int[5];
	private static int max1, max2; // how many ranks match (first and second pairs)
	
	String Result (String Cards[]) {
		
		for ( int i = 0; i < 5; i++) {
			String[] parts = Cards[i].split(" of ", 2);
			CardRank[i] = parts[0];
			CardSuit[i] = parts[1];
		}
		
		SortByRank();
		SameRanks();
		
		if(Flush() == true)
			if(Straight() == true)
				if(CardRank[4] == "Ace")
					return "Royal Flush";
				else
					return "Straight Flush";
			else
				return "Flush";
		else 
			if(Straight() == true)
				return "Straight";
		
		if (max1 == 4)
			return "Four of a kind";
		if (max1 == 3)
			if (max2 == 2)
				return "Full house";
			else
				return "Three of a kind";
		
		if((max1 == 2) && (max2 == 2))
			return "Two Pair";
		
		if(RankInt[4] >= 11)
			return "Jacks or Better";
		
		return "Nothing";
	}
	
	String Prize (String Result) {
		
		String prize = "0";
		switch (Result) {
			case "Royal Flush":
				prize = "800";
				break;
			case "Straight Flush":
				prize = "50";
				break;
			case "Four of a kind":
				prize = "25";
				break;
			case "Full House":
				prize = "9";
				break;
			case "Flush":
				prize = "6";
				break;
			case "Straight":
				prize = "4";
				break;
			case "Three of a kind":
				prize = "3";
				break;
			case "Two Pair":
				prize = "2";
				break;
			case "Jacks or Better":
				prize = "1";
				break;
		}
		return prize;
	}

	private boolean Flush () {
		if((CardSuit[0] == CardSuit[1]) && (CardSuit[0] == CardSuit[2]) && (CardSuit[0] == CardSuit[3]) && (CardSuit[0] == CardSuit[4]))
			return true;
		else
			return false;
	}
	
	private boolean Straight () {
		if((RankInt[0] + 1 == RankInt[1]) && (RankInt[1] + 1 == RankInt[2]) && (RankInt[2] + 1 == RankInt[3]) && (RankInt[3] + 1 == RankInt[4]))
			return true;
		else
			return false;
	}
	
	private void SameRanks () {
		
		ArrayList<Integer> uniqueRanks = new ArrayList<Integer>();
		uniqueRanks.add(RankInt[0]);
		boolean unique = true;
		
		for ( int i = 1; i < 5; i++) { // adds all unique ranks into an arraylist
			for(int j = 0; j < uniqueRanks.size(); j++) {
				if(RankInt[i] == uniqueRanks.get(j))
					unique = false;
			}
			if(unique == true)
				uniqueRanks.add(RankInt[i]);
			else
				unique = true;
		}
		
		max1 = 0;
		max2 = 0;
		int count = 0;
		
		for ( int i = 0; i < uniqueRanks.size(); i++) {
			for ( int j = 0; j < 5; j++) {
				if(RankInt[j] == uniqueRanks.get(i))
					count++;
			}
			if(count > max1) {
				max2 = max1;
				max1 = count;
			}
			else if (count > max2)
				max2 = count;
			count = 0;
		}
	}
	
	private void SortByRank () {
		
		for ( int i = 0; i < 5; i++) {
			switch(CardRank[i]) {
				case "Jack":
					RankInt[i] = 11;
					break;
				case "Queen":
					RankInt[i] = 12;
					break;
				case "King":
					RankInt[i] = 13;
					break;
				case "Ace":
					RankInt[i] = 14;
					break;
				default:
					RankInt[i] = Integer.parseInt(CardRank[i]);
			}
		}
		
		int min, CurInt;
		String holdRank, holdSuit;
		
		for ( int i = 0; i < 4; i++) {
			min = i;
			for ( int j = i + 1; j < 5; j++) {
				if (RankInt[j] < RankInt[min])
					min = j;
			}
			CurInt = RankInt[i];
			RankInt[i] = RankInt[min];
			RankInt[min] = CurInt;
			
			holdRank = CardRank[i];
			CardRank[i] = CardRank[min];
			CardRank[min] = holdRank;
			
			holdSuit = CardSuit[i];
			CardSuit[i] = CardSuit[min];
			CardSuit[min] = holdSuit;
		}
	}
}
