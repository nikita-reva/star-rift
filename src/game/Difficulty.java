package game;

import java.util.Timer;
import java.util.TimerTask;

public class Difficulty {
	
	Timer timer;
	public Difficulty() {
		timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				
				if(!Var.timelapse) {
					if(Var.coinscollected >= 0 && Var.coinscollected < 100) {
						Var.enemyspeed[0] = 4;
						Var.enemyspeed[1] = 5;
						Var.enemyspeed[2] = 5;
						Var.enemyspeed[3] = 4;
						Var.enemyspeed[4] = 4;
					} else if(Var.coinscollected >= 100 && Var.coinscollected < 200) {					
						Var.enemyspeed[0] = 6;
						Var.enemyspeed[1] = 4;
						Var.enemyspeed[2] = 6;
						Var.enemyspeed[3] = 5;
						Var.enemyspeed[4] = 4;
					} else if(Var.coinscollected >= 200 && Var.coinscollected < 300) {
						Var.enemyspeed[0] = 7;
						Var.enemyspeed[1] = 5;
						Var.enemyspeed[2] = 6;
						Var.enemyspeed[3] = 7;
						Var.enemyspeed[4] = 6;
					} else if(Var.coinscollected >= 300 && Var.coinscollected < 400) {
						Var.enemyspeed[0] = 8;
						Var.enemyspeed[1] = 7;
						Var.enemyspeed[2] = 6;
						Var.enemyspeed[3] = 8;
						Var.enemyspeed[4] = 7;
					} else if(Var.coinscollected >= 400 && Var.coinscollected < 500) {
						Var.enemyspeed[0] = 8;
						Var.enemyspeed[1] = 9;
						Var.enemyspeed[2] = 7;
						Var.enemyspeed[3] = 8;
						Var.enemyspeed[4] = 7;
					} else if(Var.coinscollected >= 500) {
						Var.enemyspeed[0] = 8;
						Var.enemyspeed[1] = 9;
						Var.enemyspeed[2] = 8;
						Var.enemyspeed[3] = 9;
						Var.enemyspeed[4] = 8;
					}
				}
			}
			
		}, 0, 11);
	}

}
