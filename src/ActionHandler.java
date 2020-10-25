import java.awt.Color;
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
			Var.btntrack1.setVisible(false);
			Var.btntrack2.setVisible(false);
			Var.btntimelapse.setVisible(false);
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
			
			Var.btntimelapse.setVisible(true);
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
			Var.btntrack1.setVisible(true);
			Var.btntrack2.setVisible(true);
			Var.btnmute.setVisible(true);
			Var.btnshop.setVisible(false);
			Var.btnoptions.setVisible(false);
			Var.btnexit.setVisible(false);
			
			KeyHandler.gamepaused = 1;
			Var.jf1.requestFocus();
			
		} else if(e.getSource()==Var.btnexit) {
			
			System.exit(0);
			
		} else if(e.getSource()==Var.btntimelapse) {
			if(Var.coinscollected >= Var.pricetimelapse) {
				Var.coinscollected -= Var.pricetimelapse;
				Var.timelapsesec += Var.addtimelapse;
				if(Var.timelapsems == 0) {
					Var.timelapsems = 999;
				}
			}
			Var.jf1.requestFocus();	
		} else if(e.getSource()==Var.btnlives) {
			if(Var.coinscollected >= Var.pricelife) {
				Var.coinscollected -= Var.pricelife;
				Var.maxlives++;
			}
			
			Var.jf1.requestFocus();	
		} else if(e.getSource()==Var.btnrockets) {
			if(Var.coinscollected >= Var.pricerockets) {
				Var.coinscollected -= Var.pricerockets;
				Var.rockets += Var.addrockets;
			}
			
			Var.jf1.requestFocus();
		} else if(e.getSource()==Var.btnshield) {
			if(Var.coinscollected >= Var.priceshield) {
				Var.coinscollected -= Var.priceshield;
				Var.shieldcharges += Var.addshield;
				Var.shieldactive = true;
			}
			
			Var.jf1.requestFocus();
		} else if(e.getSource()==Var.btnmute) {
			if(Var.stopmusic == false) {
				Var.musicplayer.stopmusic();
				Var.stopmusic = true;
			} else if (Var.stopmusic = true) {
				Var.musicplayer.playmusic();
				Var.stopmusic = false;
			}
			
			Var.jf1.requestFocus();
		} else if(e.getSource()==Var.btntrack1) {
			Var.musicplayer.selecttrack(ResourceLoader.getTrack("molecule_leitmotiv.wav"));
			Var.musicplayer.playmusic();
			Var.activetrack = 1;
			Var.btntrack2.setBackground(Color.BLACK);
			
			Var.jf1.requestFocus();
		} else if(e.getSource()==Var.btntrack2) {
			Var.musicplayer.selecttrack(ResourceLoader.getTrack("Cosmo_and_Kramer-Really-Original.wav"));
			Var.musicplayer.playmusic();
			Var.activetrack = 2;
			Var.btntrack1.setBackground(Color.BLACK);
			
			Var.jf1.requestFocus();
		} else if(e.getSource()==Var.btnstart) {
			Var.btnstart.setVisible(false);
			Var.instartscreen = false;
			Var.gamerunning = true;
			
			Var.jf1.requestFocus();
		}	else if(e.getSource()==Var.btnrestart) {
			Var.victory = false;
			Var.btnrestart.setVisible(false);
			Var.btnclose.setVisible(false);		
			Var.gamerunning = true;
			
			Var.jf1.requestFocus();
		} else if(e.getSource()==Var.btnclose) {
			System.exit(0);
		}					
		
	}

}
