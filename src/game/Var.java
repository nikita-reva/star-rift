// Contains all global variables

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
	static Label lbl1;
	
	// Buttons
	static JButton btnstart, btnresume, btnshop, btnoptions, btnexit;
	static JButton btnmute, btntrack1, btntrack2;
	static JButton btntimelapse, btnlives, btnrockets, btnshield;
	static JButton btnrestart, btnclose;
	
	// Objects
	static int enemyX[] = new int[5], enemyY[] = new int[5];
	static int crystalsX[] = new int[3], crystalsY[] = new int[3];
	static int coinsX[] = new int[3], coinsY[] = new int[3];
	
	// Sizes
	static int screenwidth = 1200;
	static int screenheight = 900;
	static int backgroundY1 = 0, backgroundY2 = -900, backgroundspeed = 3;
	static int playerwidth = 80, playerheight = 130;
	static int enemywidth = 100, enemyheight = 100;
	static int collectsize = 50;
	static int shieldwidth = 120, shieldheight = 80;
	
	// Positions
	static int playerpositionX = Var.screenwidth/2 - Var.playerwidth/2, playerpositionY = 680;
	static int enemyexpposX, enemyexpposY;
	static int rocketposX, rocketposY;
	
	// Speeds
	static int speedup = 6, speeddown = 4, speedleft = 5, speedright = 5;
	static int enemyspeed[] = new int[5];
	static int crystalsspeed[] = new int[3];
	static int coinsspeed[] = new int[3];
	static int rocketspeed = 5;
	
	// Counters and Constants (integers)
	static int lives = 3, maxlives = 5;
	static int crystalscollected = 0, coinscollected = 0;
	static int expanimation, expanimation2;
	static int flame = 1, flameanimation;
	static int timelapsesec = 10, rockets = 10, shieldcharges = 0;
	static int pricetimelapse = 20, pricelife = 30, pricerockets = 40, priceshield = 50;
	static int addtimelapse = 5, addrockets = 10, addshield = 5;
	static int timelapsems = 999;
	static int activetrack = 1;
	static long highscore = 0;
	
	// Flags (booleans)
	static boolean gamerunning = false, instartscreen = true, inmenue = false, inoptions = false, inshop = false;
	static boolean victory = false;
	static boolean moveup = false, movedown = false, moveleft = false, moveright = false;
	static boolean collided = false, failed = false, exploded;
	static boolean shieldactive = false;
	static boolean rocketfired = false, enemyhit = false;
	static boolean stopmusic = false;
	static boolean timelapse = false;
	
	// Images
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
	static BufferedImage ilogo;
	static BufferedImage itimelapse;
	static Image gifenemyexplosion;
	
	// Music
	static MusicPlayer musicplayer = new MusicPlayer("audio/molecule_leitmotiv.wav");
	
	public Var() {
		musicplayer.playmusic();
		
		try {
			// Star Rift logo
			ilogo = ImageIO.read(new File("rsc/star_rift_logo.png"));
			// Background
			ib1 = ImageIO.read(new File("rsc/star_field_1.png"));
			ib2 = ImageIO.read(new File("rsc/star_field_2.png"));
			// Space Ship
			ispaceship = ImageIO.read(new File("rsc/space_ship_2.png"));
			// Flame
			iflame1 = ImageIO.read(new File("rsc/flame_1.png"));
			iflame2 = ImageIO.read(new File("rsc/flame_2.png"));
			//Enemies
			ienemy = ImageIO.read(new File("rsc/enemy.png"));
			// Collectables
			icrystals = ImageIO.read(new File("rsc/crystals.png"));
			icoins = ImageIO.read(new File("rsc/coins.png"));
			
			// Explosions
			for(int i = 0; i < 19; i++) {
				iexplosion[i] = ImageIO.read(new File("rsc/exp" + i + ".png"));
			}
			for(int i = 0; i < 17; i++) {
				iexplosiondamaged[i] = ImageIO.read(new File("rsc/exp2_" + i + ".png"));
			}
			
			// Shop items
			ilives = ImageIO.read(new File("rsc/lives.png"));
			irockets = ImageIO.read(new File("rsc/rocket.png"));
			irocketicon = ImageIO.read(new File("rsc/rocketicon.png"));
			ishield = ImageIO.read(new File("rsc/shield.png"));
			ishieldgame = ImageIO.read(new File("rsc/shield_game.png"));
			gifenemyexplosion = Toolkit.getDefaultToolkit().createImage("rsc/explosion.gif");
			itimelapse = ImageIO.read(new File("rsc/timelapse.png"));
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
