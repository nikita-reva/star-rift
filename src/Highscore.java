import java.util.Timer;
import java.util.TimerTask;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@SuppressWarnings("unchecked")
public class Highscore {
	Timer timer;
	Object obj;
	JSONObject jsonobj;
	JSONParser parser;
	String hsfilename = "highscore.json";
	
	private void createSaveData() {
		try {
			jsonobj = new JSONObject();
			jsonobj.put("highscore", 0);
			File file = new File(Var.saveDataPath, hsfilename);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(jsonobj.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void loadHighscore() {
		try {
			File file = new File(Var.saveDataPath, hsfilename);
			if(!file.isFile()) {
				createSaveData();
			}
			parser = new JSONParser();
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			obj = parser.parse(reader);
			jsonobj = (JSONObject) obj;
			long highscore = (long) jsonobj.get("highscore");
			Var.highscore = highscore;
			reader.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ParseException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void setHighscore() {
		Var.highscore = Var.coinscollected;

		jsonobj.put("highscore", Var.highscore);
		
		File file = new File(Var.saveDataPath, hsfilename);
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			writer.write(jsonobj.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Highscore() {
		timer = new Timer();
		loadHighscore();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				
				if(Var.coinscollected > Var.highscore) {
					setHighscore();
				}
				
			}
			
		}, 0, 10);
	}

}
