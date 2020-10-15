package game;

import java.util.Timer;
import java.util.TimerTask;

public class Background {
	Timer back;
	
	public Background() {
		back = new Timer();
		back.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if(Var.gamerunning) {
					
					if(Var.backgroundY1 < 890) {
						Var.backgroundY1 += 1;
					}
					else {
						Var.backgroundY1 = -900;
					}
					
					if(Var.backgroundY2 < 890) {
						Var.backgroundY2 += 1;
					}
					else {
						Var.backgroundY2 = -900;
					}
					
				}
			}			
		}, 0, Var.backgroundspeed);
		
	}

}
