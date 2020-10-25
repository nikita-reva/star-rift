import java.util.Timer;
import java.util.TimerTask;

public class ExplosionDamaged {
	Timer exp;
	private int temp = 0; 
	public ExplosionDamaged() {
		exp = new Timer();
		exp.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if(Var.collided) {
					Var.expanimation2 = temp;
					temp++;
					if(temp == 17) {
						Var.expanimation2 = 0;
						Var.collided = false;
						if(Var.shieldcharges == 0) {
							Var.shieldactive = false;
						}
						temp = 0;
					}	
				} 
			}
			
		}, 0, 40);
	}

}
