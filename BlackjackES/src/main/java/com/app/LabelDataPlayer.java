package com.app;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabelDataPlayer extends JPanel{

	private int height;
	private Font font = new Font("TimesRoman", Font.BOLD, 70);
	private JLabel label;
	private ArrayList<CardPlaceholder> cards;
	public LabelDataPlayer(int height, ArrayList<CardPlaceholder> cards) {
		this.height = height;
		this.cards = cards;
		this.label = new JLabel("Player SUM: 0");
		label.setFont(font);
		this.add(label);
	}
	
	public void revalidate() {
		
	}
	
	@Override
	   public Dimension getPreferredSize() {
	      return new Dimension(700, this.height);
	   }
	
}
