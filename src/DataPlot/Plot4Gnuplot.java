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
	
	public void writeInit(String name) {
		try {
			FileWriter fw = new FileWriter(path + name, false);
			fw.write("");
			fw.close();
		} catch (Exception e) {
			System.out.println("error : write data ");
		}
	}
	
	public void write(String name) {
		try {
			FileWriter fw = new FileWriter(path + name, true);
			for(String e: buf) fw.write(e + "\n");
			fw.close();
		} catch (Exception e) {
			System.out.println("error : write data ");
		}
	}
	
	public void clearBuf() { buf.clear(); }

}
