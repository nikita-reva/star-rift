import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class ResourceLoader {

	static ResourceLoader rl = new ResourceLoader();
	
	public static Image getImage(String fileName) {
		return Toolkit.getDefaultToolkit().getImage(rl.getClass().getResource("images/" + fileName));
	};
	
	public static Image getGif(String fileName) {
		return Toolkit.getDefaultToolkit().createImage(rl.getClass().getResource("images/" + fileName));
	}
	
	public static URL getTrack(String fileName) {
		return rl.getClass().getResource("audio/" + fileName);
	}

}
