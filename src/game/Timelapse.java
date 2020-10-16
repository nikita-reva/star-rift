package game;

import java.util.Timer;
import java.util.TimerTask;

public class Timelapse {
	Timer tl;
	private int tltemp = 0;
	
	public Timelapse() {
		tl = new Timer();
		tl.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				
				if(Var.timelapse) {
					
					Var.enemyspeed[0] = 2;
					Var.enemyspeed[1] = 2;
					Var.enemyspeed[2] = 2;
					Var.enemyspeed[3] = 2;
					Var.enemyspeed[4] = 2;
					
					tltemp++;
					
					if(tltemp % 1000 == 0  && Var.timelapsesec > 0) {
						Var.timelapsesec -= 1;
					}
					if(tltemp % 1 == 0  && Var.timelapsesec > 0) {
						Var.timelapsems -= 1;
						if(Var.timelapsems == 0) {
							Var.timelapsems = 999;
						}
					}
					if(Var.timelapsesec == 0) {
						Var.timelapse = false;
						Var.timelapsems = 0;
					}
					
				}
				
			}}, 0, 1);
	}

}
