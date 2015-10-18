package ChaosNeuralNetwork;

import java.util.ArrayList;

public class ChaosNeuralNetwork02 {

	protected double K = 0;
	protected double t = 0;
	protected double b = 0;
	protected double u = 0;
	
	protected double xn, yn, vn, w0;
	
	protected ArrayList<ChaosNeuralNetwork02> list;
	ArrayList<Double> V;
	
	public ChaosNeuralNetwork02() {
		list = new ArrayList<>();
		V = new ArrayList<>();
	}
	
	public void setNPrm(double xn, double yn, double vn, double w0) {
		this.xn = xn;
		this.yn = yn;
		this.vn = vn;
		this.w0 = w0;
	}
	
	public void setBasicPrm(double K, double t, double b, double u) {
		this.K = K;
		this.t = t;
		this.b = b;
		this.u = u;
	}
	
	public double calc_z() {
		double res = 0;
		for(int i = 0; i < list.size(); i++) {
			ChaosNeuralNetwork02 nn = list.get(i);
			res += nn.calc_h(nn.getV()) * nn.calc_x();
		}
		return res;
	}
	
	public double calc_h(ArrayList<Double> Vj) { 
		double res = 0;
		for(int i = 0; i < V.size(); i++) {
			res += (2 * V.get(i) - 1) * (2 * Vj.get(i) - 1);
		}
		return res;
	}
	
	public double calc_y() {
		return calc_r() * (0.5 - yn) * (0.5 + yn) - 0.5;
	}
	
	public double calc_r() {
		return 4 - b + b * Math.exp(-1 * Math.abs(xn));
	}
	
	public double calc_v() {
		double u, a;

		u = getu(K);
		a = geta(u, t);
		
		return -1 * a * vn;
	}
	
	public double calc_x() {
		double u, a, w;
		
		u = getu(K);
		w = getw(w0, u);
		a = geta(u, t);
		
		return (1 - a) * K*yn/((w*w + u*u) * Math.sqrt(t)) + a*xn;
	}
	
	public double getw(double w0, double u) { return Math.sqrt(w0*w0 - u*u); }
	public double geta(double u, double t) { return Math.exp(-1 * u * t); }
	public double getu(double k) { 
//		return k/2;
		return u;
	}	
	
	public void addV(double V) { this.V.add(V); }
	public ArrayList<Double> getV() { return V; }
	public void addNN(ChaosNeuralNetwork02 nn) { list.add(nn); }
}
