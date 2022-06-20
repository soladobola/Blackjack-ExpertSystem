package com.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class KieLoader implements Runnable, ActionListener {
	
	
	private MainWindow window;
	private int delay = 500;
    private Timer timer;
    private int count = 0;
    
    public Timer getTimer() {
    	return this.timer;
    }
    
	public KieLoader(MainWindow window) {
		this.window = window;
		timer = new Timer(delay, this);
	}

	@Override
	public void run() {
		
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(count == 2) {
		KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
    	KieSession kSession = kContainer.newKieSession("ksession-rules");
    	LayoutCustomManager.regular(window);
    	timer.stop();
		} else {
			count++;
		}
    	
    	
		
	}
	
}
