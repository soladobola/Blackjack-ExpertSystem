package com.app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JLabel;

public class LayoutCustomManager {

	public static void  regular(MainWindow window) {
		ArrayList<Object> arr = new ArrayList<>();
		arr.add(window.dealerCard);
		
		Font font = new Font("TimesRoman", Font.BOLD, 70);
		JLabel dealerLabel = new JLabel();
		dealerLabel.setFont(font);
		dealerLabel.setForeground(Color.yellow);
		dealerLabel.setBackground(Color.black);
		dealerLabel.setText("Dealer: " + window.dealerCard.getValue());
		arr.add(dealerLabel);
		
		
		window.middle.decisionLbl.setText("                       Blackjack");
		arr.add(window.middle);
		
		
		JLabel playerLabel = new JLabel();
		playerLabel.setFont(font);
		playerLabel.setForeground(Color.yellow);
		playerLabel.setBackground(Color.black);
		playerLabel.setText("Player: " + window.pf.getSum());
		arr.add(playerLabel);
		
		arr.add(window.pf);
		
		setElements(window, arr);
		
	}
	
	public static void kieLoad(MainWindow window) {
		window.getContentPane().removeAll();
		JLabel label = new JLabel("    Loading knowledge base...");
		label.setFont(new Font("timesRoman", Font.BOLD, 70));
		window.add(label);
		window.repaint();
		window.validate();
		
	}
	
	public static void dealerChoose(MainWindow window) {
		ArrayList<Object> arr = new ArrayList<>();
		arr.add(window.dealerCard);
		
		Font font = new Font("TimesRoman", Font.BOLD, 70);
		arr.add(window.dealerChooser);
		
		
		arr.add(window.middle);
		
		JLabel playerLabel = new JLabel();
		playerLabel.setFont(font);
		playerLabel.setForeground(Color.yellow);
		playerLabel.setBackground(Color.black);
		playerLabel.setText("Player: " + window.pf.getSum());
		arr.add(playerLabel);
		
		arr.add(window.pf);
		
		setElements(window, arr);
	}
	
	public static void playerChoose(MainWindow window) {
		ArrayList<Object> arr = new ArrayList<>();
		arr.add(window.dealerCard);
		
		Font font = new Font("TimesRoman", Font.BOLD, 70);
		JLabel dealerLabel = new JLabel();
		dealerLabel.setFont(font);
		dealerLabel.setForeground(Color.yellow);
		dealerLabel.setBackground(Color.black);
		dealerLabel.setText("Dealer: " + window.dealerCard.getValue());
		arr.add(dealerLabel);
		
		
		window.middle.clearLabel();
		arr.add(window.middle);
		
		arr.add(window.playerChooser);
		
		arr.add(window.pf);
		
		setElements(window, arr);
	}
	
	
	public static void setElements(MainWindow window, ArrayList<Object> obj ) {
		window.getContentPane().removeAll();
		GridBagConstraints c = new GridBagConstraints();
		window.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 1;
		c.insets = new Insets(0, 0, 0, 0);
		window.add((Component) obj.get(0), c);
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(20, 0, 0, 0);
		window.add((Component)obj.get(1), c);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(10, 0, -20, 0);
		window.add((Component)obj.get(2), c);
		c.gridx = 0;
		c.gridy = 3;
		int top = 10, left = 0, bottom = 20, right = 0;
		Insets i = new Insets(top, left, bottom, right);
		c.insets = i;
		window.add((Component)obj.get(3), c);
		c.insets = new Insets(0, 0, 20, 0);
		c.gridx = 0;
		c.gridy = 4;
		window.add((Component)obj.get(4), c);
		window.repaint();
		window.validate();
		
		window.pf.revalidate();
		
		
		
		
	}
	
}
