import java.util.Timer;
import java.util.TimerTask;


public class Failed {
	Timer failed;
	
	public Failed() {
		failed = new Timer();
		failed.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				
				if(Var.failed) {
					for(int i = 0; i < 5; i++) {
						Var.enemyY[i] = -4000;
					}
					
					for(int i = 0; i < 3; i++) {
						Var.crystalsY[i] = -4000;
					}
					
					for(int i = 0; i < 3; i++) {
						Var.coinsY[i] = -4000;
					}

					Var.lives = 3;
					Var.coinscollected -= 100;
					if(Var.coinscollected < 0) {
						Var.coinscollected = 0;
					}
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Var.failed = false;
				}
				
			}
			
		}, 0, 15);
		
	}

}
