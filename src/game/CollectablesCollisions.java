package game;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class CollectablesCollisions {

	Timer collide;
	Random rand = new Random();

	public CollectablesCollisions() {
		collide = new Timer();
		collide.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				
				for(int i = 0; i < 3; i++) {
					if(Var.playerpositionX >= Var.crystalsX[i] - 120 && 
							Var.playerpositionX <= Var.crystalsX[i] + 50 && 
							Var.playerpositionY <= Var.crystalsY[i] + 50 && 
							Var.playerpositionY >= Var.crystalsY[i] - 90 ) {
						
						Var.crystalsX[i] = 50 + rand.nextInt(1100);
						Var.crystalsY[i] = -5000;
						Var.crystalscollected++;
						
						if(Var.crystalscollected >= 5 && Var.lives < Var.maxlives) {
							Var.lives++;
							Var.crystalscollected = 0;
						}
						
						if(Var.lives >= Var.maxlives) {
							Var.crystalscollected = 0;
							Var.coinscollected += 2;
						}
					}
				}
				
				for(int i = 0; i < 3; i++) {
					if(Var.playerpositionX >= Var.coinsX[i] - 120 && 
							Var.playerpositionX <= Var.coinsX[i] + 50 && 
							Var.playerpositionY <= Var.coinsY[i] + 50 && 
							Var.playerpositionY >= Var.coinsY[i] - 90 ) {
						
						Var.coinsX[i] = 400 * i + rand.nextInt(400);
						Var.coinsY[i] = -1200;
						Var.coinscollected += 10;
					}
				}
				
			}
			
		}, 0, 12);
	}
	
}
