package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==Var.btnresume) {
			
			Var.gamerunning = true;
			Var.inmenue = false;
			Var.inshop = false;
			Var.inoptions = false;
			
			Var.btnresume.setVisible(false);
			Var.btnshop.setVisible(false);
			Var.btnoptions.setVisible(false);
			Var.btnexit.setVisible(false);
			Var.btnmute.setVisible(false);
			Var.btnlives.setVisible(false);
			Var.btnrockets.setVisible(false);
			Var.btnshield.setVisible(false);
			
			KeyHandler.gamepaused = 0;
			Refresh.temprefresh = 0;
			Var.jf1.requestFocus();
			
		} else if(e.getSource()==Var.btnshop) {
			
			Var.gamerunning = false;
			Var.inmenue = false;
			Var.inshop = true;
			Var.inoptions = false;
			
			Var.btnresume.setVisible(true);
			Var.btnshop.setVisible(false);
			Var.btnoptions.setVisible(false);
			Var.btnexit.setVisible(false);
			
			Var.btnlives.setVisible(true);
			Var.btnrockets.setVisible(true);
			Var.btnshield.setVisible(true);
			
			KeyHandler.gamepaused = 1;
			Var.jf1.requestFocus();

		} else if(e.getSource()==Var.btnoptions) {
			Var.gamerunning = false;
			Var.inmenue = false;
			Var.inshop = false;
			Var.inoptions = true;
			
			Var.btnresume.setVisible(true);
			Var.btnmute.setVisible(true);
			Var.btnshop.setVisible(false);
			Var.btnoptions.setVisible(false);
			Var.btnexit.setVisible(false);
			
			KeyHandler.gamepaused = 1;
			Var.jf1.requestFocus();
			
		} else if(e.getSource()==Var.btnexit) {
			
			System.exit(0);
			
		} else if(e.getSource()==Var.btnlives) {
			if(Var.coinscollected >= Var.pricelife) {
				Var.coinscollected -= Var.pricelife;
				Var.maxlives++;
			}
			
			Var.jf1.requestFocus();	
		} else if(e.getSource()==Var.btnrockets) {
			if(Var.coinscollected >= Var.pricerockets) {
				Var.coinscollected -= Var.pricerockets;
				Var.rockets += 20;
			}
			
			Var.jf1.requestFocus();
		} else if(e.getSource()==Var.btnshield) {
			if(Var.coinscollected >= Var.priceshield) {
				Var.coinscollected -= Var.priceshield;
				Var.shieldcharges += 5;
				Var.shieldactive = true;
			}
			
			Var.jf1.requestFocus();
		} else if(e.getSource()==Var.btnmute) {
			if(Var.stopmusic == false) {
				Var.musicplayer.stopmusic();
				Var.stopmusic = true;
			} else if (Var.stopmusic = true) {
				Var.musicplayer.startmusic();
				Var.stopmusic = false;
			}
			
			Var.jf1.requestFocus();
		} else if(e.getSource()==Var.btnstart) {
			Var.btnstart.setVisible(false);
			Var.instartscreen = false;
			Var.gamerunning = true;
			
			Var.jf1.requestFocus();
		}		
		
	}

}
