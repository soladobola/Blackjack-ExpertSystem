package com.mladen;

public class Dealer {

	private Card card;
	private int cardSum = 0;
	public Dealer() {}
	public Dealer(Card card) {
		this.card = card;
		this.cardSum = card.getValue();
	}
	public Dealer(String c) throws Exception {
		this.card = new Card(c);
		this.cardSum = card.getValue();
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
		this.cardSum = card.getValue();
	}
	public int getCardSum() {
		return cardSum;
	}
	public void setCardSum(int cardSum) {
		this.cardSum = cardSum;
	}
	
}
