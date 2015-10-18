package DataPlot;

import ChaosNeuralNetwork.ChaosNeuralNetwork02;

public class Main {
	
	public static void main(String[] args) {
		
		ChaosNeuralNetwork02 cnn = new ChaosNeuralNetwork02();
		ChaosNeuralNetwork02 cnn2 = new ChaosNeuralNetwork02();
		
		double x = 0.3;
		double y = 0.3;
		double v = 0.3;
		double z;
		double w0 = Math.PI;
		double xn, yn, vn;
		double t = 0.01;
		
		cnn.setBasicPrm(1.0, t, 1.0, 0.01);
		cnn2.setBasicPrm(1.0, t, 1.0, 0.01);
		
		cnn.setNPrm(0.1, 0.1, 0.1, Math.PI);
		cnn.addV(1);
		cnn.addNN(cnn2);
		
		Plot4Gnuplot plot = new Plot4Gnuplot("C:\\\\work\\\\Data\\\\");
		for(int i = 0; i < 2; i++) {
			cnn.setNPrm(x, y, v, w0);
			xn = cnn.calc_v();
			yn = cnn.calc_y();
			vn = cnn.calc_v();
			z = cnn.calc_z();
			x = xn;
			y = yn;
			v = vn;
			plot.apend(x + " " + y + " " + z);
		}
		plot.write();
		
		System.out.println("fin");
	}

}
