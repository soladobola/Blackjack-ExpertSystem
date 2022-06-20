package com.mladen;

import java.util.Arrays;

public class Card {
	private String symbol;
	private int value;
	private static String symbols[] = {"2", "3", "4", "5", 
								       "6", "7", "8",
									   "9", "10", "A",
									   "J", "Q", "K"};
	
	public Card(String symbol) throws Exception {
		if(Arrays.stream(symbols).anyMatch(x -> x.equals(symbol))) {
			this.symbol = symbol;
			if(symbol.equals("J") || symbol.equals("Q") || symbol.equals("K")) {
				this.value = 10;
			} else if (symbol.equals("A")){
				this.value = 11;
			} else {
				this.value = Integer.parseInt(symbol);
			}
			
		} else {
			throw new Exception("Wrong symbol for card.");
		}
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
	
}
