package com.mladen;

import java.util.ArrayList;

public class Player {
	private ArrayList<Card> cards;
	private boolean soft = false;
	private int cardSum;
	private boolean canSplit = false;
	public Player() {}
	public Player(Card c1, Card c2) {
		cards = new ArrayList<>();
		cards.add(c1); 
		cards.add(c2);
		calculateSum();
	}
	
	public Player(String c1, String c2) throws Exception {
		cards = new ArrayList<>();
		cards.add(new Card(c1)); 
		cards.add(new Card(c2));
		calculateSum();
	}
	
	
	public void addCard(Card card) {
		if(cards == null) {
			cards = new ArrayList<>();
		}
		
		cards.add(card);
		calculateSum();
	}
	
	public void addCard(String card) throws Exception {
		if(cards == null) {
			cards = new ArrayList<>();
		}
		
		cards.add(new Card(card));
		calculateSum();
	}
	
	public void calculateSum() {
		ArrayList<Card> aces = new ArrayList<>();
		int sum = 0;
		for(Card c : cards) {
			String symbol = c.getSymbol();
			if(!symbol.equals("A")) {
				sum += c.getValue();
			} else {
				aces.add(c);
			}
		}
		
		if(aces.isEmpty()) this.cardSum = sum;
		else {
			
			for(int aInd = 0; aInd < aces.size(); aInd++)
			{
			
				if(sum + 11 < 22 - aces.size() + aInd + 1) {
					sum += 11;
				} else {
					sum += 1;
				}
				
			}
			
		}
		
		this.cardSum = sum;
	}
	
	@Override
	public String toString() {
		String str = "Player cards: ";
		for(Card c : cards) {
			str += c.getSymbol() + " ";
		}
		return str;
	}
	
	public boolean isSoft() {
		return soft;
	}
	
	public void setSoft(boolean soft) {
		this.soft = soft;
	}
	public int getCardSum() {
		return cardSum;
	}
	public void setCardSum(int cardSum) {
		this.cardSum = cardSum;
	}
	public ArrayList<Card> getCards() {
		return cards;
	}
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	public boolean isCanSplit() {
		return canSplit;
	}
	public void setCanSplit(boolean canSplit) {
		this.canSplit = canSplit;
	}
	
	// Add-ons for Table version -- SECTION BEGIN
	
		public boolean isPair(String symbol) {
			if(cards.size() == 2) {
				for(Card c : cards) {
					if(!c.getSymbol().equals(symbol)) {
						return false;
					}
				}
				
				return true;
				
			} else {
				return false;
			}
		}
		
		
		public boolean isSoftSum(String arg) {
			// for all aces valued 1, check if temp sum is greater!
			int numOfAces = 0;
			int sumWithoutAces = 0;
			for(Card c : cards) {
				if(c.getSymbol() == "A") {
					numOfAces++;
				} else {
					sumWithoutAces += c.getValue();
				}
			}
			
			int hardSum = sumWithoutAces + numOfAces;
			if(hardSum < this.getCardSum()) {
				if(arg.equals("yes"))
					return true;
				else return false;
				
			} else {
				if(arg.equals("yes"))
				return false;
				else return true;
			}
			
			
		}
	
		
	// Add-on for Table version -- SECTION END
		
		
	
	
	
}
