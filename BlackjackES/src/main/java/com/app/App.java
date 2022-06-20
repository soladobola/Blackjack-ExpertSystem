package com.app;

import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


public class App {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			 @Override
	            public void run() {

	                MainWindow window = new MainWindow(1000, 800, "Blackjack Expert by Mladen");
	                window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	                window.setVisible(true);      
	                
	            }	
		});
		
	}
		
}
