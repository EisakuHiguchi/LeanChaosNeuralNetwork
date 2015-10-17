package DataPlot;

import java.io.FileWriter;
import java.util.ArrayList;

public class Plot4Gnuplot {
	
	ArrayList<Double> buf;
	String path;
	
	public Plot4Gnuplot(String path) {
		
		this.path = path;
		buf = new ArrayList<>();
	}
	
	public void apend(double data) { buf.add(data); }
	
	public void write() {
		try {
			FileWriter fw = new FileWriter(path);
			for(double e: buf) fw.write(e + " ");
			fw.close();
		} catch (Exception e) {
			System.out.println("error : write data ");
		}
	}

}
