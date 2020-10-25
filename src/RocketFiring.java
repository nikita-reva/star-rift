import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class RocketFiring {
	
	Timer timer;
	private int temp = 0;
	
	public RocketFiring() {
		
		timer = new Timer();
		Random rand = new Random();
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if(Var.gamerunning) {
					if(Var.rocketfired) {
						Var.rocketposY -= Var.rocketspeed;
					}
					
					for(int i = 0; i < 5; i++) {
						if(Var.rocketposX >= Var.enemyX[i] - 20 && 
								Var.rocketposX <= Var.enemyX[i] + 100 && 
								Var.rocketposY <= Var.enemyY[i] + 60 ) {
							Var.rocketfired = false;
							Var.enemyhit = true;
							Var.coinscollected += 2;
							
							Var.rocketposX = Var.screenwidth + 200;
							
							Var.enemyexpposX = Var.enemyX[i];
							Var.enemyexpposY = Var.enemyY[i];
							
							Var.enemyX[i] = 240*i + rand.nextInt(140);
							Var.enemyY[i] = -250;
						}
					}
					
					if(Var.rocketposY <= 0) {
						Var.rocketfired = false;
						Var.rocketposX = Var.screenwidth + 200;
					}
					
					if(Var.enemyhit) {
						if(temp < 112) {
							temp++;
						} else if(temp == 112) {
							Var.enemyhit = false;
							Var.gifenemyexplosion.flush();
							
							temp = 0;
						}
					}
				}
			}
			
		}, 0, 8);
		
	}

}

