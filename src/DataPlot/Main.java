package DataPlot;

import ChaosNeuralNetwork.ChaosNeuralNetworkManager;

public class Main {
	
	public static void main(String[] args) {
		
		int[] data1 = {
				0,1,1,1, 1,0,0,0, 1,1,1,0, 1,0,0,0
			};
		int[] data2 = {
				0,1,1,0, 1,0,0,1, 1,0,0,0, 0,1,1,1
		};
		int[] data3 = {
				1,0,0,0, 1,0,0,1, 1,1,1,1, 0,0,0,1
		};
		
		double K = 1.0;
		double t = 0.1;
		double b = 1.0;
		double u = 0.01;
		
		double x = 0.1;
		double y = 0.1;
		double v = 0.1;
		double w0 = Math.PI;
		
		int size = 16;
		int loop = 100;
		
		ChaosNeuralNetworkManager cnnm = new ChaosNeuralNetworkManager(x, y, v, w0);
		cnnm.create(K, t, b, u, size);
		cnnm.setData(data1);
		cnnm.setData(data2);
		cnnm.setData(data3);
		
		PlotGnuPlot_Ex01 plot = new PlotGnuPlot_Ex01("C:\\\\work\\\\Data\\\\", size);
		
		for(int i = 0; i < loop; i++) {
			cnnm.calc();
			plot.write(cnnm.getData());
		}
		
		System.out.println("fin");
	}

}
