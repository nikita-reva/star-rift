package game;

import java.util.Timer;
import java.util.TimerTask;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@SuppressWarnings("unchecked")
public class Highscore {
	Timer timer;
	public Highscore() {
		JSONParser parser = new JSONParser();
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				
				try {
					Object obj = parser.parse(new FileReader("highscore.json"));
					JSONObject jsonobj = (JSONObject) obj;
					long highscore = (long) jsonobj.get("highscore");
					Var.highscore = highscore;
					if(Var.coinscollected > highscore) {
						Var.highscore = Var.coinscollected;
						jsonobj.put("highscore", Var.coinscollected);
						try(FileWriter file = new FileWriter("highscore.json")) {
							file.write(jsonobj.toString());
							file.flush();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
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
			
		}, 0, 10);
	}

}
