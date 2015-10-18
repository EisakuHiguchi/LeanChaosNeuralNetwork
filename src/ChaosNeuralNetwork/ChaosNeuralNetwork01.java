package ChaosNeuralNetwork;

import java.util.ArrayList;

import ChaosBrownianMotion.ChaosBrownianMotion;

public class ChaosNeuralNetwork01 extends ChaosBrownianMotion {
	
	/*
	 * z(n) = Zh*x(n)
	 * 
	 * 
	 */
	
	ArrayList<? extends ChaosNeuralNetwork01> list;
	ArrayList<Double> V;
	
	public ChaosNeuralNetwork01() {
		list = new ArrayList<>();
		V = new ArrayList<>();
	}
	
	public double Function_z() {
		double res = 0;
		for(int i = 0; i < list.size(); i++) {
			ChaosNeuralNetwork01 nn = list.get(i);
			res += nn.calc_h(i) * nn.calc_x();
		}
		return res;
	}
	
	public double Function_h(int j) { 
		double res = 0;
		ChaosNeuralNetwork01 nn = list.get(j);
		for(int i = 0; i < V.size(); i++) {
			res += (2 * V.get(i) - 1) * (2 * nn.getV().get(i) - 1);
		}
		return res;
	}
	
	public double calc_h(int j) {
		return Function_h(j);
	}
	
	public double calc_z() {
		return Function_z();
	}
	
	public void addV(double V) { this.V.add(V); }
	public ArrayList<Double> getV() { return V;}
}
