import java.util.Timer;
import java.util.TimerTask;


public class Victory {
	Timer victory;
	
	public Victory() {
		victory = new Timer();
		victory.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				
				if(Var.victory) {
					if(Var.gamerunning) {
						Var.elapsedTime = Var.elapsingTime;
						if(Var.elapsedMS < Var.fastestMS) {
							Var.besttime = true;
							Var.fastestMS = Var.elapsedMS;
							Var.fastestTime = FastestTime.formatTime(Var.elapsedMS);
						} else {
							Var.besttime = false;
						}
					}
					Var.gamerunning = false;
					Var.btnrestart.setVisible(true);
					Var.btnclose.setVisible(true);
					
					Var.coinscollected = 0;
					Var.crystalscollected = 0;
					Var.shieldcharges = 0;
					Var.timelapsesec = 10;
					Var.timelapsems = 999;
					Var.rockets = 10;
					Var.lives = 3;
					Var.maxlives = 5;
					
					for(int i = 0; i < 5; i++) {
						Var.enemyY[i] = -2000;
					}
					
					for(int i = 0; i < 3; i++) {
						Var.crystalsY[i] = -2000;
					}
					
					for(int i = 0; i < 3; i++) {
						Var.coinsY[i] = -2000;
					}
				}
				
			}
			
		}, 0, 15);
		
	}

}
