// Contains all global variables

import java.awt.Image;
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
	static Image ib1, ib2;
	static Image ispaceship;
	static Image iflame1, iflame2;
	static Image ienemy;
	static Image icrystals;
	static Image icoins;
	static Image iexplosion[] = new Image[19];
	static Image iexplosiondamaged[] = new Image[17];
	static Image ishieldgame;
	static Image ilives, irockets, irocketicon, ishield;
	static Image ilogo;
	static Image itimelapse;
	static Image gifenemyexplosion;
	
	static String saveDataPath;
	
	// Music
	static MusicPlayer musicplayer = new MusicPlayer(ResourceLoader.getTrack("molecule_leitmotiv.wav"));
	
	public Var() {
		musicplayer.playmusic();
		
		// Star Rift logo
		ilogo = ResourceLoader.getImage("star_rift_logo.png");
		// Background
		ib1 = ResourceLoader.getImage("star_field_1.png");
		ib2 = ResourceLoader.getImage("star_field_2.png");
		// Space Ship
		ispaceship = ResourceLoader.getImage("space_ship_2.png");
		// Flame
		iflame1 = ResourceLoader.getImage("flame_1.png");
		iflame2 = ResourceLoader.getImage("flame_2.png");
		//Enemies
		ienemy = ResourceLoader.getImage("enemy.png");
		// Collectables
		icrystals = ResourceLoader.getImage("crystals.png");
		icoins = ResourceLoader.getImage("coins.png");
		
		// Explosions
		for(int i = 0; i < 19; i++) {
			iexplosion[i] = ResourceLoader.getImage("exp" + i + ".png");
		}
		for(int i = 0; i < 17; i++) {
			iexplosiondamaged[i] = ResourceLoader.getImage("exp2_" + i + ".png");
		}
		
		// Shop items
		ilives = ResourceLoader.getImage("lives.png");
		irockets = ResourceLoader.getImage("rocket.png");
		irocketicon = ResourceLoader.getImage("rocketicon.png");
		ishield = ResourceLoader.getImage("shield.png");
		ishieldgame = ResourceLoader.getImage("shield_game.png");
		gifenemyexplosion = ResourceLoader.getGif("explosion.gif");
		itimelapse = ResourceLoader.getImage("timelapse.png");
	
		crystalsspeed[0] = 4;
		crystalsspeed[1] = 5;
		crystalsspeed[2] = 6;
		
		coinsspeed[0] = 6;
		coinsspeed[1] = 4;
		coinsspeed[2] = 5;
		
		try {
			saveDataPath = Var.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
			String[] array = new String[10];
			String newPath = "";
			array = saveDataPath.split("/");
			for(int i = 0; i < array.length - 2; i++) {
				newPath = String.join("/", newPath, array[i+1]);

			}
			saveDataPath = newPath;
			// saveDataPath = System.getProperty("user.home") + "\\highscore";
			System.out.println(saveDataPath);
			System.out.println(array[3] + " " + array.length);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
