import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	static int gamepaused = 0;
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			Var.moveup = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			Var.movedown = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			Var.moveleft = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Var.moveright = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if(Var.gamerunning && Var.rockets > 0 && Var.rocketfired == false) {
				Var.rocketfired = true;
				Var.rocketposX = Var.playerpositionX + Var.playerwidth/2 - 10;
				Var.rocketposY = Var.playerpositionY;
				Var.rockets--;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_T) {
			if(Var.gamerunning  && Var.timelapsesec > 0) {
				Var.timelapse = true;
			}
		}
		
		if(gamepaused == 0) {
			// Menue
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				Var.gamerunning = false;
				Var.inmenue = true;
				Var.inshop = false;
				Var.inoptions = false;
				Var.btnresume.setVisible(true);
				Var.btnshop.setVisible(true);
				Var.btnoptions.setVisible(true);
				Var.btnexit.setVisible(true);
				Var.moveup = false;
				Var.movedown = false;
				Var.moveleft = false;
				Var.moveright = false;
				Var.timelapse = false;
				gamepaused++;
			} else if(e.getKeyCode() == KeyEvent.VK_S) {
				Var.gamerunning = false;
				Var.inmenue = false;
				Var.inshop = true;
				Var.inoptions = false;
				Var.btntimelapse.setVisible(true);
				Var.btnlives.setVisible(true);
				Var.btnrockets.setVisible(true);
				Var.btnshield.setVisible(true);
				Var.moveup = false;
				Var.movedown = false;
				Var.moveleft = false;
				Var.moveright = false;
				Var.timelapse = false;
				gamepaused++;
			}
		} else if(gamepaused == 1) {
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE || e.getKeyCode() == KeyEvent.VK_S) {
				Var.gamerunning = true;
				Var.inmenue = false;
				Var.inshop = false;
				Var.inoptions = false;
				Var.btnresume.setVisible(false);
				Var.btnshop.setVisible(false);
				Var.btnoptions.setVisible(false);
				Var.btnexit.setVisible(false);
				Var.btntimelapse.setVisible(false);
				Var.btnlives.setVisible(false);
				Var.btnrockets.setVisible(false);
				Var.btnshield.setVisible(false);
				Var.btnmute.setVisible(false);
				Var.btntrack1.setVisible(false);
				Var.btntrack2.setVisible(false);

				gamepaused--;
				Refresh.temprefresh = 0;
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			Var.moveup = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			Var.movedown = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			Var.moveleft = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Var.moveright = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_T) {
			Var.timelapse = false;
		}
		
	}

}
