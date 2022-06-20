package com.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MiddleLayer extends JPanel {

	private MainWindow window;
	private MiddleLayer selfRefrence = this;
	public JLabel decisionLbl;
	
	public MiddleLayer(MainWindow window) {
		this.window = window;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JButton clearAlltBtn = new JButton("Clear all");
		clearAlltBtn.setBackground(Color.red);
		clearAlltBtn.setForeground(Color.black);
		clearAlltBtn.setPreferredSize(new Dimension(120, 50));
	//	this.add(clearAlltBtn);
		
		JButton askExpertBtn = new JButton("Ask an Expert!");
		askExpertBtn.setBackground(Color.green);
		askExpertBtn.setForeground(Color.black);
		askExpertBtn.setPreferredSize(new Dimension(120, 50));
	//	this.add(askExpertBtn);
		
		decisionLbl = new JLabel("Blackjack");
		decisionLbl.setFont(new Font("timesRoman", Font.BOLD, 44));
		decisionLbl.setBackground(Color.black);
		decisionLbl.setForeground(Color.white);
	//	decisionLbl.setPreferredSize(new Dimension(450, 70));
		decisionLbl.setPreferredSize(new Dimension(700, 70));
		
		
		JPanel row1panel = new JPanel();
		row1panel.setLayout(new FlowLayout());
		row1panel.setPreferredSize(new Dimension(700, 60));
		row1panel.add(clearAlltBtn);
		row1panel.add(askExpertBtn);
		row1panel.setBackground(Color.black);
		
		
		JPanel row2panel = new JPanel();
		row2panel.setLayout(new FlowLayout());
		row2panel.setPreferredSize(new Dimension(700, 60));
		row2panel.add(decisionLbl);
		row2panel.setBackground(Color.black);
		
		
		this.add(row1panel);
		this.add(row2panel);
		
		
		clearAlltBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				window.pf.getCards().clear();
				try {
					CardPlaceholder chooseCard = new CardPlaceholder("choose", 0, window);
					
					window.dealerCard = new CardPlaceholder("choose", 1, window);
					window.pf.removeAll();
					window.pf.addCard(chooseCard);
					
					LayoutCustomManager.regular(window);
				
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		
		askExpertBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				ExpertAdapter expert = new ExpertAdapter(window);
				String s = null;
				
				try {
					 
					s = expert.whatNext();
					String spaces = "";
					if(s == "Hit") spaces = "                  ";
					else if(s.equals("Stand")) spaces = "                ";
					else if(s.equals("Double")) spaces = "               ";
					else if(s.equals("Split")) spaces = "                 ";
					else if(s.equals("Surrender")) spaces = "            ";
					else if(s.equals("You Lost") || s.equals("You Won")) spaces = "            ";
					 decisionLbl.setText( spaces + "You should: " + s);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			//	JOptionPane.showMessageDialog(null, s, "You should:", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
		
	}
	
	
	public void clearLabel() {
		this.decisionLbl.setText("");
	}
	
	
	@Override
	   public Dimension getPreferredSize() {
	      return new Dimension(700, 100);
	   }
	
	@Override
    public void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 g.setColor(Color.black);
		 g.fillRect(0, 0, this.getWidth(), this.getHeight());
		 
	 }
	
}
