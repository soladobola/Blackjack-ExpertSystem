package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

//import com.mladen.Card;
import com.mladen.Dealer;
import com.mladen.Player;
import com.mladen.Solution;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

	public static void print(Player p, Dealer d, Solution s) {
		System.out.println(p.toString());
		System.out.println("Dealer card: " + d.getCard().getSymbol());
		System.out.print("You should: ");
		System.out.println(s.getAction());
		System.out.println("------------------------------");
	}
	
	
	public static void blackJackSession(Player p, Dealer d) {
		KieServices ks = KieServices.Factory.get();
	    KieContainer kContainer = ks.getKieClasspathContainer();
    	KieSession kSession = kContainer.newKieSession("ksession-rules");
    	
    	Solution s = new Solution();
    	
    	kSession.insert(p);
        kSession.insert(d);
        kSession.insert(s);
        kSession.fireAllRules();
        
        print(p, d, s);
    	
        kSession.dispose();
	}
	
    public static final void main(String[] args) {
        try {
         
            Player p = new Player("4", "4");
            Dealer d = new Dealer("4");
           
            blackJackSession(p, d);
           
            /*
            p = new Player("7", "8");
            d = new Dealer("A");
            blackJackSession(p, d);
           
            p = new Player("3", "7");
            p.addCard("Q");
            d = new Dealer("J");
            blackJackSession(p, d);
            
            p = new Player("10", "5");
            d = new Dealer("J");
            blackJackSession(p, d);
            
            p = new Player("3", "6");
            d = new Dealer("5");
            blackJackSession(p, d); 
            */
            
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    

}
