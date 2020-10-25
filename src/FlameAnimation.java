import java.util.Timer;
import java.util.TimerTask;

public class FlameAnimation {
	Timer flame;
	private int temp = 0;
	
	public FlameAnimation() {
		flame = new Timer();
		flame.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if(Var.gamerunning) {

					if(temp == 0) {
						Var.flameanimation = 0;
						temp++;
					}
					else if(temp == 1) {
						Var.flameanimation = 1;
						temp--;
					}
					
				}
				
			}
				
		}, 0, 150);
	}

}
