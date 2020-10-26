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
			jsonobj.put("fastestMS", Var.fastestMS);
			jsonobj.put("fastestTime", Var.fastestTime);
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
			if(!file.exists()) {
				createSaveData();
			}
			parser = new JSONParser();
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			obj = parser.parse(reader);
			jsonobj = (JSONObject) obj;
			long highscore = (long) jsonobj.get("highscore");
			long fastestMS = (long) jsonobj.get("fastestMS");
			String fastestTime = (String) jsonobj.get("fastestTime");
			Var.highscore = highscore;
			Var.fastestMS = fastestMS;
			Var.fastestTime = fastestTime;
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
		if(Var.coinscollected > Var.highscore) {
			Var.highscore = Var.coinscollected;
		}
		jsonobj.put("highscore", Var.highscore);
		jsonobj.put("fastestMS", Var.fastestMS);
		jsonobj.put("fastestTime", Var.fastestTime);
		
		File file = new File(Var.saveDataPath, hsfilename);

		try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			writer.write(jsonobj.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static String formatTime(long millis) {
		String hourFormat = "";
		String minuteFormat;
		String secondFormat;
		String millisecondFormat;
		
		int hours = (int) millis / 3600000;
		if(hours > 0) {
			millis = millis - hours * 3600000;
			if(hours < 10) {
				hourFormat = "0" + hours;
			} else {
				hourFormat = "" + hours;
			}
			hourFormat += ":";
		}
		
		int minutes = (int) millis / 60000;
		if(minutes > 0) {
			millis = millis - minutes * 60000;
			if(minutes < 10) {
				minuteFormat = "0" + minutes;
			} else {
				minuteFormat = "" + minutes;
			}
		} else {
			minuteFormat = "00";
		}
		
		int seconds = (int) millis / 1000;
		if(seconds > 0) {
			millis = millis - seconds * 1000;
			if(seconds < 10) {
				secondFormat = "0" + seconds;
			} else {
				secondFormat = "" + seconds;
			}
		} else {
			secondFormat = "00";
		}
		
		int milliseconds = (int) millis;
		if(milliseconds > 0) {
			if(milliseconds < 10) {
				millisecondFormat = "00" + milliseconds;
			} else if(milliseconds < 100) {
				millisecondFormat = "0" + milliseconds;
			} else {
				millisecondFormat = "" + milliseconds;
			}
		} else {
			millisecondFormat = "000";
		}
		
		return hourFormat + minuteFormat + ":" + secondFormat + ":" + millisecondFormat; 
	}
	
	public Highscore() {
		timer = new Timer();
		loadHighscore();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				
				Var.elapsedMS = (System.nanoTime() - Var.startTime) / 1000000;
				Var.elapsingTime = formatTime(Var.elapsedMS);
				
				if(Var.coinscollected > Var.highscore || ((Var.elapsedMS < Var.fastestMS) && Var.victory)) {
					setHighscore();
				}
				
			}
			
		}, 0, 10);
	}

}