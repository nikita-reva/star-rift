import java.util.Timer;
import java.util.TimerTask;

public class PlayerMovement {
Timer movement;

	public PlayerMovement() {
		movement = new Timer();
		movement.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if(Var.gamerunning) {
					
					if(Var.moveup) {
						if(Var.playerpositionY > 0) {
							Var.playerpositionY -= Var.speedup;
						}
					}
					else if(Var.movedown) {
						if(Var.playerpositionY <= 720) {
							Var.playerpositionY += Var.speeddown;
						}
					}	
					else if(Var.moveleft) {
						if(Var.playerpositionX > 0) {
							Var.playerpositionX -= Var.speedleft;
						}
					}
					else if(Var.moveright) {
						if(Var.playerpositionX <= 1100) {
							Var.playerpositionX += Var.speedright;
						}
					}
					
				}
			}
			
		}, 0, 10);
		
	}

}
