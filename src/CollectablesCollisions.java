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
					if(Var.playerpositionX >= Var.crystalsX[i] - Var.playerwidth && 
							Var.playerpositionX <= Var.crystalsX[i] + Var.collectsize && 
							Var.playerpositionY <= Var.crystalsY[i] + (Var.collectsize - 10) && 
							Var.playerpositionY >= Var.crystalsY[i] - (Var.playerheight - 10) ) {
						
						Var.crystalsX[i] = 383*i + rand.nextInt(333);
						Var.crystalsY[i] = -3000 - rand.nextInt(3000);
						Var.crystalsspeed[i] = 5 + rand.nextInt(5);
						Var.crystalscollected++;
						
						if(Var.crystalscollected >= 5 && Var.lives < Var.maxlives) {
							Var.lives++;
							Var.crystalscollected = 0;
						}
						
						if(Var.lives >= Var.maxlives) {
							Var.crystalscollected = 0;
							Var.coinscollected += 2;
							if(Var.coinscollected >= Var.coinstovictory) {
								Var.victory = true;
							}
						}
					}
				}
				
				for(int i = 0; i < 3; i++) {
					if(Var.playerpositionX >= Var.coinsX[i] - Var.playerwidth && 
							Var.playerpositionX <= Var.coinsX[i] + Var.collectsize && 
							Var.playerpositionY <= Var.coinsY[i] + (Var.collectsize - 10) && 
							Var.playerpositionY >= Var.coinsY[i] - (Var.playerheight - 10) ) {
						
						Var.coinsspeed[i] = 5 + rand.nextInt(5);
						Var.coinsX[i] = 333 * i + rand.nextInt(333);
						Var.coinsY[i] = -2000 - rand.nextInt(4000);
						Var.coinscollected += 10;
						
						if(Var.coinscollected >= Var.coinstovictory) {
							Var.victory = true;
						}
					}
				}
				
			}
			
		}, 0, 8);
	}
	
}
