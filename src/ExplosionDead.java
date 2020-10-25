import java.util.Timer;
import java.util.TimerTask;

public class ExplosionDead {
	Timer exp;
	private int temp = 0; 
	public ExplosionDead() {
		exp = new Timer();
		exp.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if(Var.failed) {
					Var.expanimation = temp;
					temp++;
					if(temp == 19) {
						Var.expanimation = 0;
						temp = 0;
					}	
				} 
			}
			
		}, 0, 107);
	}

}
