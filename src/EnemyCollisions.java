import java.util.Random;

import java.util.Timer;
import java.util.TimerTask;

public class EnemyCollisions {
	Random rand = new Random();
	Timer collide;
	private int temp = 0;

	public EnemyCollisions() {
		collide = new Timer();
		collide.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				
				for(int i = 0; i < 5; i++) {
					if(temp == 0) {
						
						if(Var.shieldcharges > 0) {
							if(Var.playerpositionX >= Var.enemyX[i] - (Var.playerwidth - 5) && 
									Var.playerpositionX <= Var.enemyX[i] + (Var.enemywidth - 5) && 
									Var.playerpositionY <= Var.enemyY[i] + (Var.enemyheight - 30) && 
									Var.playerpositionY >= Var.enemyY[i] - (Var.playerheight - 50) ) {
								
								Var.collided = true;
								Var.enemyY[i] = -200 - rand.nextInt(200);;
								Var.enemyX[i] = 240*i + rand.nextInt(140);
								Var.shieldcharges--;
							} 
						} else {
							if(Var.playerpositionX >= Var.enemyX[i] - (Var.playerwidth - 10) && 
									Var.playerpositionX <= Var.enemyX[i] + (Var.enemywidth - 10) && 
									Var.playerpositionY <= Var.enemyY[i] + (Var.enemyheight - 30) && 
									Var.playerpositionY >= Var.enemyY[i] - (Var.playerheight - 50) ) {
								
								Var.collided = true;
								Var.enemyY[i] = -200 - rand.nextInt(200);
								Var.enemyX[i] = 240*i + rand.nextInt(140);
								Var.coinscollected -= 20;
								if(Var.coinscollected < 0) {
									Var.coinscollected = 0;
								}
								
								if(Var.lives >= 1) {
									Var.lives--;
								}
								if(Var.lives == 0) {
									Var.failed = true;
								}
								else if(Var.lives > 0) {
									Var.failed = false;
								}
								
								temp++;
							}
						}
					}
				}
				
				if(temp >= 1 && temp <= 65) {
					temp++;
				}
				else if(temp == 66) {
					temp = 0;
				}
				
			}
			
		}, 0, 12);
	}

}
