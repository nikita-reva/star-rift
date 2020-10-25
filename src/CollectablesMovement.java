import java.util.Random;

import java.util.Timer;
import java.util.TimerTask;

public class CollectablesMovement {
	Timer movement;
	Random rand = new Random();

	public CollectablesMovement() {
		
		for(int i = 0; i < 3; i++) {
			Var.crystalsX[i] = 383*i + rand.nextInt(333);
			Var.crystalsY[i] = -200 - rand.nextInt(300);
		}
		
		for(int i = 0; i < 3; i++) {
			Var.coinsX[i] = 383*i + rand.nextInt(333);
			Var.coinsY[i] = -200 - rand.nextInt(500) ;
		}
		
		movement = new Timer();
		movement.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if(Var.gamerunning) {
					
					for(int i = 0; i < 3; i++) {
						Var.crystalsY[i] += Var.crystalsspeed[i];
						Var.coinsY[i] += Var.coinsspeed[i];
						if(Var.crystalsY[i] >= Var.screenheight) {
							Var.crystalsX[i] = 383*i + rand.nextInt(333);
							Var.crystalsY[i] = -2000 - rand.nextInt(3000);
							Var.crystalsspeed[i] = 5 + rand.nextInt(5);
						}
					}
					
					for(int i = 0; i < 3; i++) {
						if(Var.coinsY[i] >= Var.screenheight) {
							Var.coinsX[i] = 383*i + rand.nextInt(333);
							Var.coinsY[i] = -2000 - rand.nextInt(3000);
							Var.coinsspeed[i] = 5 + rand.nextInt(5);
						}
					}
				}
			
			}
			
		}, 0, 9);
		
	}
}
