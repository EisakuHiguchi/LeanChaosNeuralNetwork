package DataPlot;

import java.io.FileWriter;
import java.util.ArrayList;

public class Plot4Gnuplot {
	
	ArrayList<String> buf;
	String path;
	
	public Plot4Gnuplot(String path) {
		
		this.path = path;
		buf = new ArrayList<>();
	}
	
	public void apend(String data) { buf.add(data); }
	
	public void write() {
		try {
			FileWriter fw = new FileWriter(path + "data.txt");
			for(String e: buf) fw.write(e + "\n");
			fw.close();
		} catch (Exception e) {
			System.out.println("error : write data ");
		}
	}

}
