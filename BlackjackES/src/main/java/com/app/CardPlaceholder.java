package com.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class CardPlaceholder extends JPanel {


	private static final long serialVersionUID = 1234L;
	private static String symbols[] = {"2", "3", "4", "5", 
		       "6", "7", "8",
			   "9", "10", "A",
			   "J", "Q", "K", "choose"};
	
	private Image background;
	private String symbol = "";
	private int ownerID; // 0 -> player, 1 -> Dealer
	private MainWindow window;
	private int value;
	
	public int getValue() {
		return value;
	}
	
	
	public CardPlaceholder(String symbol, int ownerID, MainWindow window) throws IOException {
		background = ImageIO.read(new File("images\\card" + symbol + ".png"));
		background = background.getScaledInstance(120, 200, Image.SCALE_SMOOTH);
		this.ownerID = ownerID;
		this.window = window;
		this.symbol = symbol;
		
		if(symbol.equals("J") || symbol.equals("Q") || symbol.equals("K")) {
			this.value = 10;
		} else if (symbol.equals("A")){
			this.value = 11;
		} else if(symbol.equals("choose")) {
			this.value = 0;
		}
		else {
			this.value = Integer.parseInt(symbol);
		}
		
		
		// problem
				this.repaint();
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				// logika za postavljanje karte
				if(ownerID == 0) {
					if(!(symbol.equals("choose"))) {
						window.playerChooser.setReference((CardPlaceholder)e.getSource());
					} else window.playerChooser.setReference(null); 
					
					LayoutCustomManager.playerChoose(window);
				} else {
					LayoutCustomManager.dealerChoose(window);
					try {
						
						background = ImageIO.read(new File("images\\card" + symbol + ".png"));
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
					background = background.getScaledInstance(120, 200, Image.SCALE_SMOOTH);
					((JPanel)e.getSource()).setSize(new Dimension(background.getWidth(null), background.getHeight(null)));
					repaint();
				}
				
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
				// TODO Auto-generated method stub
				try {
					background = ImageIO.read(new File("images\\card" + symbol + ".png"));
					background = background.getScaledInstance(200, 280, Image.SCALE_SMOOTH);
					((JPanel)e.getSource()).setSize(new Dimension(background.getWidth(null), background.getHeight(null)));
					repaint();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					background = ImageIO.read(new File("images\\card" + symbol + ".png"));
					background = background.getScaledInstance(120, 200, Image.SCALE_SMOOTH);
					((JPanel)e.getSource()).setSize(new Dimension(background.getWidth(null), background.getHeight(null)));
					repaint();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		
		
		}
		
	@Override
	   public Dimension getPreferredSize() {
	      if (background != null) {
	         return new Dimension(background.getWidth(null), background.getHeight(null));
	      }
	      return super.getPreferredSize();
	   }
	
	
	
	@Override
	   protected void paintComponent(Graphics g) {
	      super.paintComponent(g);
	      g.setColor(Color.black);
		  g.fillRect(0, 0, this.getWidth(), this.getHeight());
	      g.drawImage(background, 0, 0, this);
	      
	      
	}
	
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

}
