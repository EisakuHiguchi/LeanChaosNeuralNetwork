package DataPlot;

import java.io.FileWriter;
import java.util.ArrayList;

public class PlotGnuPlot_Ex01 extends Plot4Gnuplot {

	int size;
	public PlotGnuPlot_Ex01(String path, int size) {
		super(path);
		writeInit(size);
		this.size = size;
		script();
	}
	
	public void script() {
		try {
			for(int i = 0; i < size; i++) {
				FileWriter fw = new FileWriter(path + "script" + i + ".txt");
				fw.write("plot \"" + path + "data" + i + ".txt\"" + " u 1 w l\n");
				fw.write("replot \"" + path + "data" + i + ".txt\"" + " u 2 w l\n");
				fw.write("replot \"" + path + "data" + i + ".txt\"" + " u 3 w l\n");
				fw.write("replot \"" + path + "data" + i + ".txt\"" + " u 4 w l\n");
				fw.close();
			}
		} catch(Exception e) {
			
		}
	}
	
	public void write(ArrayList<double[]> list) {
		for(int i = 0; i < list.size(); i++ ) {
			double[] temp = list.get(i);
			for(int j = 0; j < temp.length; j++) {
				apend(temp[0] + " " + temp[1] + " " + temp[2] + " " + temp[3]);
			}
			write("data" + i + ".txt");
			clearBuf();
		}
	}
	
	public void writeInit(int size) {
		for(int i = 0; i < size; i++ ) writeInit("data" + i + ".txt");
	}

}
