package com.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public CardChooser playerChooser;
	public CardChooser dealerChooser;
	public PlayerField pf;
	public CardPlaceholder dealerCard; 
	public MiddleLayer middle;
	
	
	
	public MainWindow(int windowWidth, int windowHeight, String title) {
		super(title);
		this.setSize(new Dimension(windowWidth, windowHeight));
		this.getContentPane().setBackground(Color.black);
		this.middle = new MiddleLayer(this);
		CardPlaceholder cardPlaceholder = null;
		pf = new PlayerField(this.getWidth(), 100);
		try {
			
			
			dealerCard = new CardPlaceholder("choose", 1, this);
			cardPlaceholder = new CardPlaceholder("choose", 0, this);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		pf.addCard(cardPlaceholder);
		dealerChooser = new CardChooser(this.getWidth(), 110, true, this);
		playerChooser = new CardChooser(this.getWidth(), 110, false, this);
		
		LayoutCustomManager.kieLoad(this);
		//LayoutCustomManager.regular(this);
		
		Thread kie = new Thread(new KieLoader(this));
		kie.start();
		
	}
	

}
