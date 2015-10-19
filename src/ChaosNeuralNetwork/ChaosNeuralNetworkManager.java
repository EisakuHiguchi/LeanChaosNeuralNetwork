package ChaosNeuralNetwork;

import java.util.ArrayList;

public class ChaosNeuralNetworkManager {
	
	ChaosNeuralNetwork02[] cnn;
	double x, y, v, w0, t;
	
	public ChaosNeuralNetworkManager(double x, double y, double v, double w0) {
		this.x = x;
		this.y = y;
		this.v = v;
		this.w0 = w0;
	}
	
	public void create(double K, double t, double b, double u, int size) {
		cnn = new ChaosNeuralNetwork02[16];
		for(int i = 0; i < cnn.length; i++) {
			cnn[i] = new ChaosNeuralNetwork02();
			cnn[i].setBasicPrm(K, t, b, u);
			cnn[i].setNPrm(x, y, v, w0);
		}
		
		for(int i = 0; i < cnn.length; i++) {
			for(int j = 0; j < cnn.length; j++) cnn[i].addNN(cnn[j]);
		}
	}
	
	public void calc() {
		for(int i = 0; i < cnn.length; i++) {
			cnn[i].calc_x();
			cnn[i].calc_y();
			cnn[i].calc_v();
			cnn[i].calc_z();
		}
		
		for(int i = 0; i < cnn.length; i++) cnn[i].nextStep();
	}
	
	public ArrayList<double[]> getData() {
		ArrayList<double[]> result = new ArrayList<>();
		for(int i = 0; i < cnn.length; i++) {
			result.add(cnn[i].getData());
		}
		return result;
	}
	
	public void setData(int[] data) { for(int i = 0; i < cnn.length; i++) cnn[i].addV(data[i]); }
	public ChaosNeuralNetwork02[] getCNN() { return cnn; }
}
