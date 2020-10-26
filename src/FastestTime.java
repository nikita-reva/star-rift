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
public class FastestTime {
	Timer timer;
	Object obj;
	JSONObject jsonobj;
	JSONParser parser;
	String ftfilename = "fastesttime.json";
	
	private void createSaveData() {
		try {
			jsonobj = new JSONObject();
			jsonobj.put("fastestMS", Var.fastestMS);
			jsonobj.put("fastestTime", Var.fastestTime);
			File file = new File(Var.saveDataPath, ftfilename);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(jsonobj.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void loadFastestTime() {
		try {
			File file = new File(Var.saveDataPath, ftfilename);
			if(!file.isFile()) {
				createSaveData();
			}
			parser = new JSONParser();
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			obj = parser.parse(reader);
			jsonobj = (JSONObject) obj;
			long fastestMS = (long) jsonobj.get("fastestMS");
			String fastestTime = (String) jsonobj.get("fastestTime");
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
	
	private void setFastestTime() {
		
		jsonobj.put("fastestMS", Var.fastestMS);
		jsonobj.put("fastestTime", Var.fastestTime);
		
		File file = new File(Var.saveDataPath, ftfilename);
		
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
	
	public FastestTime() {
		timer = new Timer();
		loadFastestTime();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				
				Var.elapsedMS = (System.nanoTime() - Var.startTime) / 1000000;
				Var.elapsingTime = formatTime(Var.elapsedMS);
				
				if(Var.victory) {
					setFastestTime();
				}
				
			}
			
		}, 0, 10);
	}

}
