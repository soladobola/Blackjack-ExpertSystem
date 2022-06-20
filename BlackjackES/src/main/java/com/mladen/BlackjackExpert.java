package com.mladen;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class BlackjackExpert {

	public static String whatNext(Player player, Dealer dealer) {
		KieServices ks = KieServices.Factory.get();
	    KieContainer kContainer = ks.getKieClasspathContainer();
    	KieSession kSession = kContainer.newKieSession("ksession-rules");
    	
    	Solution s = new Solution();
    	
    	try {
    	kSession.insert(player);
        kSession.insert(dealer);
        kSession.insert(s);
        kSession.fireAllRules(); 
    	} 
    	finally {
    		kSession.dispose();
    	}
    	
        
        return s.getAction();
	}
}
