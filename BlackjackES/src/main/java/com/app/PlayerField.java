package com.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.mladen.Card;


public class PlayerField extends JPanel {

	private ArrayList<CardPlaceholder> cards;
	private int width, height;
	
	public ArrayList<CardPlaceholder> getCards() {
		return cards;
	}

	public void setCards(ArrayList<CardPlaceholder> cards) {
		this.cards = cards;
	}
	
	public int getSum() {
		ArrayList<CardPlaceholder> aces = new ArrayList<>();
		int sum = 0;
		for(CardPlaceholder c : cards) {
			String symbol = c.getSymbol();
			if(!symbol.equals("A")) {
				sum += c.getValue();
			} else {
				aces.add(c);
			}
		}
		
		if(aces.isEmpty()) return sum;
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
		
		return sum;
	}
	
	

	public PlayerField(int width, int height) {
		super();
		this.setSize(width, height);
		GridLayout gridlayout = new GridLayout(1, 0);
		gridlayout.setHgap(0);
		this.setLayout(gridlayout);
		this.cards = new ArrayList<CardPlaceholder>();
		this.width = width;
		this.height = height;
		
	}
	
	public void addCard(CardPlaceholder card) {
		this.cards.add(card);
		this.add(card);
	}
	
	@Override
	   public Dimension getPreferredSize() {
	      return new Dimension(700, this.height);
	   }
	
	@Override
    public void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 g.setColor(Color.black);
		 g.fillRect(0, 0, this.getWidth(), this.getHeight());
		 for(CardPlaceholder c : cards) {
			 c.repaint();
		 }
		 
	 }
}
