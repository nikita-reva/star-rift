import java.util.Timer;
import java.util.TimerTask;

public class Refresh {
	Timer refresh;
	static int temprefresh = 0;
	public Refresh() {
		refresh = new Timer();
		refresh.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				
				if(Var.inmenue) {
					if(temprefresh == 0) {
						Var.btnresume.requestFocus();
						Var.btnshop.requestFocus();
						Var.btnoptions.requestFocus();
						Var.btnexit.requestFocus();
						temprefresh++;
					} else if(temprefresh == 1) {
						Var.jf1.requestFocus();
					}
				}
				
			}
			
		}, 0, 50);
	}

}
