package com.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class CardChooser extends JPanel {
	
	private int height;
	private MainWindow mwindow;
	ArrayList<ChooserItem> lista;
	public CardChooser(int width, int height, boolean flip, MainWindow mwindow) {
		this.setSize(width, height);
		this.height = height;
		this.setLayout(new GridLayout(1, 13));
		lista = new ArrayList<>();
		lista.add(new ChooserItem("2", flip, mwindow));
		lista.add(new ChooserItem("3", flip, mwindow));
		lista.add(new ChooserItem("4", flip, mwindow));
		lista.add(new ChooserItem("5", flip, mwindow));
		lista.add(new ChooserItem("6", flip, mwindow));
		lista.add(new ChooserItem("7", flip, mwindow));
		lista.add(new ChooserItem("8", flip, mwindow));
		lista.add(new ChooserItem("9", flip, mwindow));
		lista.add(new ChooserItem("10", flip, mwindow));
		lista.add(new ChooserItem("A", flip, mwindow));
		lista.add(new ChooserItem("J", flip, mwindow));
		lista.add(new ChooserItem("Q", flip, mwindow));
		lista.add(new ChooserItem("K", flip, mwindow));
		lista.add(new ChooserItem("[X]", flip, mwindow));
		
		for(ChooserItem i : lista) {
			this.add(i);
		}
	}
	
	public void setReference(CardPlaceholder cardRef) {
		for(ChooserItem i : lista) {
			i.setReference(cardRef);
		}
	}
	
	@Override
	   public Dimension getPreferredSize() {
	     // take a look!
	      return new Dimension(700, this.height);
	   }
	
}
