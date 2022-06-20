package com.app;

import com.mladen.BlackjackExpert;
import com.mladen.Player;
import com.mladen.Card;
import com.mladen.Dealer;

public class ExpertAdapter {

	private MainWindow window;
	public ExpertAdapter(MainWindow window) {
		this.window = window;
	}
	
	public String whatNext() throws Exception {
		
		if(window.pf.getCards().size() == 1 && window.pf.getCards().get(0).getSymbol().equals("choose")) {
			return "Choose card/s for player";
		}
		
		// conversion
		Player player = new Player();
		for(CardPlaceholder card : window.pf.getCards()) {
			if(!card.getSymbol().equals("choose"))
				player.addCard(new Card(card.getSymbol()));
		}
		
		if(window.dealerCard.getSymbol().equals("choose")) {
			return "Choose card for dealer";
		}
		
		Card dcard = new Card(window.dealerCard.getSymbol());
		Dealer dealer = new Dealer(dcard);
		
		
		
		return BlackjackExpert.whatNext(player, dealer);
					
	}
}
