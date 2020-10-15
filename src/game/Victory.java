package game;

import java.util.Timer;
import java.util.TimerTask;


public class Victory {
	Timer victory;
	
	public Victory() {
		victory = new Timer();
		victory.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				
				if(Var.coinscollected >= 500) {
					Var.gamerunning = false;
					Var.victory = true;
				}
				if(Var.victory) {
					for(int i = 0; i < 5; i++) {
						Var.enemyY[i] = -4000;
					}
					
					for(int i = 0; i < 3; i++) {
						Var.crystalsY[i] = -4000;
					}
					
					for(int i = 0; i < 3; i++) {
						Var.coinsY[i] = -4000;
					}
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Var.victory = false;
				}
				
			}
			
		}, 0, 15);
		
	}

}
