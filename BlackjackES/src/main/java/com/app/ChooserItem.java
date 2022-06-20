package com.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class ChooserItem extends JPanel {

	private String symbol;
	private int fontSize;
	private boolean flip = false;
	
	// add reference to card!
	private CardPlaceholder cardRef;
	
	
	
	private static MainWindow window;
	
	
	
	public CardPlaceholder getCardRef() {
		return cardRef;
	}

	public void setCardRef(CardPlaceholder cardRef) {
		this.cardRef = cardRef;
	}

	public boolean isFlip() {
		return flip;
	}

	public void setFlip(boolean flip) {
		this.flip = flip;
	}

	public ChooserItem(String symbol, boolean flip, MainWindow window) {
		this.symbol = symbol;
		this.fontSize = 30;
		this.flip = flip;
		if(this.window == null) this.window = window;
		this.setPreferredSize(new Dimension(70, 100));
		repaint();
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!flip) {
					if(!symbol.equals("[X]")) {
						
						try {
							
							if(cardRef == null) {
							CardPlaceholder card = new CardPlaceholder(symbol, 0, window);
							window.pf.addCard(card);
							card.invalidate();
							} else {
								// check this, maybe drawing problem!
								int currInd = window.pf.getCards().indexOf(cardRef);
								window.pf.getCards().remove(currInd);
								cardRef = new CardPlaceholder(symbol, 0, window);
								window.pf.getCards().add(currInd, cardRef);
								window.pf.removeAll();
								for(CardPlaceholder p : window.pf.getCards()) {
									window.pf.add(p);
								}
								
							}
							
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
					}
					// set new layout!!
					LayoutCustomManager.regular(window);
				} else {
						
					if(!symbol.equals("[X]")) {
						
						try {
							window.dealerCard = new CardPlaceholder(symbol, 1, window);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
					}
					// set new layout
					LayoutCustomManager.regular(window);
				}
				
				fontSize = 30;
				//window.pf.repaint();
				
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fontSize = 40;
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				fontSize = 30;
				repaint();
			}
			 
		 });
		
	}
	
	public void setReference(CardPlaceholder card) {
		this.cardRef = card;
	}
	
	 @Override
     public void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 g.setColor(Color.black);
		 g.fillRect(0, 0, this.getWidth(), this.getHeight());
		 g.setColor(Color.yellow);
		 g.setFont(new Font("TimesRoman", Font.BOLD, fontSize));
		 if(flip == false) {
		 g.drawString(this.symbol, 15, 150 - fontSize*2);
		 g.setColor(Color.red);
		 g.fillOval(5, 150-fontSize, this.getWidth(), this.getHeight());
		 } else {
			 g.drawString(this.symbol, 15, 30 + fontSize*2);
			 g.setColor(Color.red);
			 g.fillOval(5, -150 + fontSize, this.getWidth(), this.getHeight());
		 }
	 }
	 
	 @Override
	   public Dimension getPreferredSize() {
	      return new Dimension(fontSize, fontSize);
	   }
	
}
