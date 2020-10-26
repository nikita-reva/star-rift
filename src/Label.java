import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class Label extends JLabel {
	private static final long serialVersionUID = 1L;
	
	protected void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		
		if(Var.gamerunning) {
			
			g.drawImage(Var.ib1, 0, Var.backgroundY1, Var.screenwidth, Var.screenheight, null);
			g.drawImage(Var.ib2, 0, Var.backgroundY2, Var.screenwidth, Var.screenheight, null);
			
			for (int i = 0; i < 3; i++) {
				g.drawImage(Var.icrystals, Var.crystalsX[i], Var.crystalsY[i], Var.collectsize, Var.collectsize, null);
				g.drawImage(Var.icoins, Var.coinsX[i], Var.coinsY[i], Var.collectsize, Var.collectsize, null);
			}
			
			for (int i = 0; i < 5; i++) {
				g.drawImage(Var.ienemy, Var.enemyX[i], Var.enemyY[i], Var.enemywidth, Var.enemyheight, null);
			}
			
			if(Var.rocketfired) {
				g.drawImage(Var.irockets, Var.rocketposX, Var.rocketposY, 20, 40, null);
			}
			
			if(Var.enemyhit) {
				g.drawImage(Var.gifenemyexplosion, Var.enemyexpposX, Var.enemyexpposY, 100, 100, null);
			}
			
			if(!Var.failed) {
				if(Var.flameanimation == 0) {
					g.drawImage(Var.iflame1, Var.playerpositionX + Var.playerwidth/2 - 30, Var.playerpositionY + Var.playerheight, 60, 75, null);
				}
				else if(Var.flameanimation == 1) {
					g.drawImage(Var.iflame2, Var.playerpositionX + Var.playerwidth/2 - 30, Var.playerpositionY + Var.playerheight, 60, 75, null);
				}
				
				g.drawImage(Var.ispaceship, Var.playerpositionX, Var.playerpositionY, Var.playerwidth, Var.playerheight, null);
				
				if(Var.shieldcharges > 0) {
					g.drawImage(Var.ishieldgame, Var.playerpositionX - (Var.shieldwidth - Var.playerwidth)/2, Var.playerpositionY - 40, Var.shieldwidth, Var.shieldheight, null);
				}
			}
			
			if(Var.collided) {
				if(Var.shieldcharges > 0) {
					for(int i = 0; i < 17; i++) {
						if(Var.expanimation2 == i) {
							g.drawImage(Var.iexplosiondamaged[i], Var.playerpositionX - 10, Var.playerpositionY - 90, 120, 120, null);
						}
					}
				} else {
					if(Var.shieldactive == true && Var.shieldcharges == 0) {
						for(int i = 0; i < 17; i++) {
							if(Var.expanimation2 == i) {
								g.drawImage(Var.iexplosiondamaged[i], Var.playerpositionX - 10, Var.playerpositionY - 90, 120, 120, null);
							}
						}
					} else {
						for(int i = 0; i < 17; i++) {
							if(Var.expanimation2 == i) {
								g.drawImage(Var.iexplosiondamaged[i], Var.playerpositionX - 10, Var.playerpositionY - 50, 120, 120, null);
							}
						}
						g.setColor(new Color(230, 0, 0, 45));
						g.fillRect(0, 0, Var.screenwidth, Var.screenheight);
					}
				}
			}
			
			if(Var.failed) {
				for(int i = 0; i < 19; i++) {
					if(Var.expanimation == i) {
						g.drawImage(Var.iexplosion[i], Var.playerpositionX - 40, Var.playerpositionY - 50, 200, 200, null);
					}
				}
				g.setColor(new Color(250, 50, 50));
				g.setFont(new Font("Arial", Font.BOLD, 50));
				g.drawString("You have failed!", 410, 350);
			}	
			else {
				g.setColor(new Color(0, 230, 115));
				g.setFont(new Font("Arial", Font.BOLD, 25));
				g.drawString("Coins:", 1000, 750);
				g.drawString(""+ Var.coinscollected, 1120, 750);
				g.drawString("Crystals:", 1000, 780);
				g.drawString("" + Var.crystalscollected, 1120, 780);
				g.setColor(new Color(230, 120, 80));
				g.setFont(new Font("Arial", Font.BOLD, 25));
				g.drawString("Lives:", 1000, 810);
				g.drawString("" + Var.lives, 1120, 810);
				
				g.setColor(new Color(0, 230, 115));
				g.setFont(new Font("Arial", Font.BOLD, 30));
				
				g.drawImage(Var.itimelapse, 50, 655, 50, 50, null);
				g.drawString("" + (Var.timelapsesec == 0 ? Var.timelapsesec : Var.timelapsesec - 1) + "s", 120, 690);
				g.drawString("" + Var.timelapsems + "ms", 180, 690);
				
				g.drawImage(Var.irocketicon, 50, 715, 50, 50, null);
				g.drawString("" + Var.rockets, 120, 750);
				g.drawImage(Var.ishield, 50, 775, 50, 50, null);
				g.drawString("" + Var.shieldcharges, 120, 810);
			}
			
			if(Var.timelapse) {
				g.setColor(new Color(120, 20, 150, 50));
				g.fillRect(0, 0, Var.screenwidth, Var.screenheight);
			}
			
			repaint();
			
		} else if(Var.inmenue || Var.inshop || Var.inoptions) {
			
			g.drawImage(Var.ib1, 0, Var.backgroundY1, Var.screenwidth, Var.screenheight, null);
			g.drawImage(Var.ib2, 0, Var.backgroundY2, Var.screenwidth, Var.screenheight, null);
			
			for (int i = 0; i < 3; i++) {
				g.drawImage(Var.icrystals, Var.crystalsX[i], Var.crystalsY[i], Var.collectsize, Var.collectsize, null);
				g.drawImage(Var.icoins, Var.coinsX[i], Var.coinsY[i], Var.collectsize, Var.collectsize, null);
			}
			
			for (int i = 0; i < 5; i++) {
				g.drawImage(Var.ienemy, Var.enemyX[i], Var.enemyY[i], 100, 100, null);
			}
			
			if(Var.flameanimation == 0) {
				g.drawImage(Var.iflame1, Var.playerpositionX + Var.playerwidth/2 - 30, Var.playerpositionY + Var.playerheight, 60, 75, null);
			}
			else if(Var.flameanimation == 1) {
				g.drawImage(Var.iflame2, Var.playerpositionX + Var.playerwidth/2 - 30, Var.playerpositionY + Var.playerheight, 60, 75, null);
			}
			g.drawImage(Var.ispaceship, Var.playerpositionX, Var.playerpositionY, Var.playerwidth, Var.playerheight, null);
			
			if(Var.rocketfired) {
				g.drawImage(Var.irockets, Var.rocketposX, Var.rocketposY, 20, 40, null);
			}
			
			if(Var.enemyhit) {
				g.drawImage(Var.gifenemyexplosion, Var.enemyexpposX, Var.enemyexpposY, 100, 100, null);
			}
			
			g.setColor(new Color(200, 200, 200, 80));
			g.fillRect(0, 0, Var.screenwidth, Var.screenheight);
			
			g.setColor(new Color(0, 230, 115));
			g.setFont(new Font("Arial", Font.BOLD, 25));
			g.drawString("Coins:", 1000, 750);
			g.drawString(""+ Var.coinscollected, 1120, 750);
			g.drawString("Crystals:", 1000, 780);
			g.drawString("" + Var.crystalscollected, 1120, 780);
			g.setColor(new Color(230, 120, 80));
			g.setFont(new Font("Arial", Font.BOLD, 25));
			g.drawString("Lives:", 1000, 810);
			g.drawString("" + Var.lives, 1120, 810);
			
			g.setColor(new Color(0, 230, 115));
			g.setFont(new Font("Arial", Font.BOLD, 30));
			
			g.drawString("Highscore: " + Var.highscore, 50, 50);
			g.drawString("Fastest Time: " + Var.fastestTime, 50, 80);
			g.drawString("Elapsed Time: " + Var.elapsingTime, 50, 110);
			
			g.drawImage(Var.itimelapse, 50, 655, 50, 50, null);
			g.drawString("" + (Var.timelapsesec == 0 ? Var.timelapsesec : Var.timelapsesec - 1) + "s", 120, 690);
			g.drawString("" + Var.timelapsems + "ms", 180, 690);
			
			g.drawImage(Var.irockets, 65, 715, 20, 50, null);
			g.drawString(""+ Var.rockets, 120, 750);
			g.drawImage(Var.ishield, 50, 775, 50, 50, null);
			g.drawString("" + Var.shieldcharges, 120, 810);
			
			if(Var.inshop) {
				g.setColor(new Color(0, 230, 115));
				g.setFont(new Font("Arial", Font.BOLD, 50));
				g.drawImage(Var.itimelapse, 300, 180, 100, 100, null);
				g.drawString("Price: " + Var.pricetimelapse, 430, 250);
				g.drawImage(Var.ilives, 300, 300, 100, 100, null);
				g.drawString("Price: " + Var.pricelife, 430, 370);
				g.drawImage(Var.irocketicon, 300, 420, 100, 100, null);
				g.drawString("Price: " + Var.pricerockets, 430, 490);
				g.drawImage(Var.ishield, 300, 540, 100, 100, null);
				g.drawString("Price: " + Var.priceshield, 430, 610);
			}
			
			repaint();
		} else if(Var.instartscreen) {
			g.drawImage(Var.ib1, 0, Var.backgroundY1, Var.screenwidth, Var.screenheight, null);
			g.drawImage(Var.ib2, 0, Var.backgroundY2, Var.screenwidth, Var.screenheight, null);
			g.drawImage(Var.ilogo, 100, 100, 1000, 500, null);
			
			
			g.drawImage(Var.ispaceship, Var.playerpositionX, Var.playerpositionY, Var.playerwidth, Var.playerheight, null);
			
			repaint();
		} else if(Var.victory) {
			g.drawImage(Var.ib1, 0, Var.backgroundY1, Var.screenwidth, Var.screenheight, null);
			g.drawImage(Var.ib2, 0, Var.backgroundY2, Var.screenwidth, Var.screenheight, null);
			
			g.drawImage(Var.ispaceship, Var.playerpositionX, Var.playerpositionY, Var.playerwidth, Var.playerheight, null);
			
			
			g.setFont(new Font("Arial", Font.BOLD, 40));
			g.setColor(new Color(220, 220, 240));
			g.drawString("Best Time: " + Var.fastestTime, 390, 200);
			if(Var.besttime) {
				g.setColor(new Color(30, 200, 60));
			} else {
				g.setColor(new Color(200, 30, 60));
			}
			g.drawString("Your Time: " + Var.elapsedTime, 390, 250);
			g.setColor(new Color(120, 30, 180));
			g.setFont(new Font("Arial", Font.BOLD, 80));
			g.drawString("Victory!", 455, 350);

			
			repaint();
		}
		
		
	}
}