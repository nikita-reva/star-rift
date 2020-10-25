import java.util.Timer;
import java.util.TimerTask;

public class RedScreen {
	Timer red;
	public RedScreen() {
		red = new Timer();
		red.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if(Var.collided) {
					if(!Var.failed) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					else {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}, 0, 10);
	}

}
