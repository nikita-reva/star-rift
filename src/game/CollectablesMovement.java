package game;

import java.util.Random;

import java.util.Timer;
import java.util.TimerTask;

public class CollectablesMovement {
	Timer movement;
	Random rand = new Random();

	public CollectablesMovement() {
		
		for(int i = 0; i < 3; i++) {
			Var.crystalsX[i] = 50 + rand.nextInt(1100);
			Var.crystalsY[i] = -400 ;
		}
		
		Var.coinsX[0] = 0 + rand.nextInt(400);
		Var.coinsY[0] = -200 + rand.nextInt(500);
		
		Var.coinsX[1] = 400 + rand.nextInt(400);
		Var.coinsY[1] = -200 + rand.nextInt(500);
		
		Var.coinsX[2] = 800 + rand.nextInt(350);
		Var.coinsY[2] = -200 + rand.nextInt(500);
		
		movement = new Timer();
		movement.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if(Var.gamerunning) {
					
					for(int i = 0; i < 3; i++) {
						Var.crystalsY[i] += Var.crystalsspeed[i];
						Var.coinsY[i] += Var.coinsspeed[i];
						if(Var.crystalsY[i] >= Var.screenheight) {
							Var.crystalsX[i] = 50 + rand.nextInt(1100);
							Var.crystalsY[i] = -1000;
						}
					}
					
					if(Var.coinsY[0] >= Var.screenheight) {
						Var.coinsY[0] = -1200;
						Var.coinsX[0] = 0 + rand.nextInt(400);
					}
					else if(Var.coinsY[1] >= Var.screenheight) {
						Var.coinsY[1] = -1200;
						Var.coinsX[1] = 400 + rand.nextInt(400);
					}
					else if(Var.coinsY[2] >= Var.screenheight) {
						Var.coinsY[2] = -1200;
						Var.coinsX[2] = 800 + rand.nextInt(350);
					}
				}
			
			}
			
		}, 0, 9);
		
	}
}
