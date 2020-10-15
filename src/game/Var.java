package game;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
	
public class Var {
	
	static JFrame jf1;
	static int screenwidth = 1200;
	static int screenheight = 900;
	static int backgroundY1 = 0, backgroundY2 = -900, backgroundspeed = 3;
	
	static int playerpositionX = 540, playerpositionY = 680;
	static int playerwidth = 120, playerheight = 90;
	static int lives = 3, maxlives = 5;
	static int crystalscollected = 0, coinscollected = 0;
	static int expanimation, expanimation2;
	
	static int speedup = 6, speeddown = 4, speedleft = 5, speedright = 5;

	static int flame = 1, flameanimation;
	
	static JButton btnstart, btnresume, btnshop, btnoptions, btnexit;
	static JButton btnmute;
	
	static Label lbl1;
	
	static JButton btnlives, btnrockets, btnshield;
	static int rockets = 20;
	static int rocketposX, rocketposY;
	static int shield = 0, shieldcharges = 0;
	static int pricelife = 30, pricerockets = 40, priceshield = 50;
	
	static int enemyX[] = new int[5], enemyY[] = new int[5];
	static int enemyspeed[] = new int[5];
	static int enemyexpposX, enemyexpposY;
	
	static int crystalsX[] = new int[3], crystalsY[] = new int[3];;
	static int crystalsspeed[] = new int[3];
	
	static int coinsX[] = new int[3], coinsY[] = new int[3];;
	static int coinsspeed[] = new int[3];
	
	static boolean gamerunning = false, instartscreen = true, inmenue = false, inoptions = false, inshop = false;
	static boolean victory = false;
	static boolean moveup = false, movedown = false, moveleft = false, moveright = false;
	static boolean collided = false, failed = false, exploded;
	static boolean shieldactive = false;
	static boolean rocketfired = false, enemyhit = false;
	static boolean stopmusic = false;
	
	static BufferedImage ib1, ib2;
	static BufferedImage ispaceship;
	static BufferedImage iflame1, iflame2;
	static BufferedImage ienemy;
	static BufferedImage icrystals;
	static BufferedImage icoins;
	static BufferedImage iexplosion[] = new BufferedImage[19];
	static BufferedImage iexplosiondamaged[] = new BufferedImage[17];
	static BufferedImage ishieldgame;
	static BufferedImage ilives, irockets, irocketicon, ishield;
	
	static Image gifenemyexplosion;
	static MusicPlayer musicplayer = new MusicPlayer("audio/Cosmo_and_Kramer-Really-Original.wav");
	
	public Var() {
		musicplayer.playmusic();
		
		try {
			// Background
			ib1 = ImageIO.read(new File("rsc/star_field_1.png"));
			ib2 = ImageIO.read(new File("rsc/star_field_2.png"));
			// Space Ship
			ispaceship = ImageIO.read(new File("rsc/space_ship.png"));
			// Flame
			iflame1 = ImageIO.read(new File("rsc/flame_1.png"));
			iflame2 = ImageIO.read(new File("rsc/flame_2.png"));
			ienemy = ImageIO.read(new File("rsc/enemy.png"));
			icrystals = ImageIO.read(new File("rsc/crystals.png"));
			icoins = ImageIO.read(new File("rsc/coins.png"));
			for(int i = 0; i < 19; i++) {
				iexplosion[i] = ImageIO.read(new File("rsc/exp" + i + ".png"));
			}
			for(int i = 0; i < 17; i++) {
				iexplosiondamaged[i] = ImageIO.read(new File("rsc/exp2_" + i + ".png"));
			}
			ilives = ImageIO.read(new File("rsc/lives.png"));
			irockets = ImageIO.read(new File("rsc/rocket.png"));
			irocketicon = ImageIO.read(new File("rsc/rocketicon.png"));
			ishield = ImageIO.read(new File("rsc/shield.png"));
			ishieldgame = ImageIO.read(new File("rsc/shield_game.png"));
			gifenemyexplosion = Toolkit.getDefaultToolkit().createImage("rsc/explosion.gif");
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("Images could not be loaded.");
		}
		
		crystalsspeed[0] = 4;
		crystalsspeed[1] = 5;
		crystalsspeed[2] = 6;
		
		coinsspeed[0] = 6;
		coinsspeed[1] = 4;
		coinsspeed[2] = 5;
		
	}
	
}
