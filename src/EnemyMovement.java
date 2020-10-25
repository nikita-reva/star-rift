import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class EnemyMovement {
	Timer movement;
	Random rand = new Random();
	private int temp = 0;

	public EnemyMovement() {
		
		for(int i = 0; i < 5; i++) {
			Var.enemyX[i] = 40 + temp;
			Var.enemyY[i] = -100 - temp;
			
			temp += 240;
		}
		
		movement = new Timer();
		movement.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if(Var.gamerunning) {
				
					for(int i = 0; i < 5; i++) {
						Var.enemyY[i] += Var.enemyspeed[i];
						if(Var.enemyY[i] >= Var.screenheight) {
							Var.enemyY[i] = -100 - rand.nextInt(200);
							Var.enemyX[i] = 240*i + rand.nextInt(140);
						}
					}
					
				}
			}
			
		}, 0, 9);
		
	}
}
