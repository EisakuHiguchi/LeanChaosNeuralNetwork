package ChaosNeuralNetwork;

import java.util.ArrayList;

public class ChaosNeuralNetwork02 {

	protected double K = 0;
	protected double t = 0;
	protected double b = 0;
	protected double u = 0;
	
	protected double xn, yn, vn, zn, w0;
	protected double x, y, v, z, h, r;
	
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
		z = 0;
		for(int i = 0; i < list.size(); i++) {
			ChaosNeuralNetwork02 nn = list.get(i);
			z += nn.calc_h(nn.getV()) * nn.getXn();
		}
		return z;
	}
	
	public double calc_h(ArrayList<Double> Vj) { 
		h = 0;
		for(int i = 0; i < V.size(); i++) {
			h += (2 * V.get(i) - 1) * (2 * Vj.get(i) - 1);
		}
		return h;
	}
	
	public double calc_y() {
		y = calc_r() * (0.5 - yn) * (0.5 + yn) - 0.5;
		return y;
	}
	
	public double calc_r() {
		r = 4 - b + b * Math.exp(-1 * Math.abs(xn));
		return r;
	}
	
	public double calc_v() {
		double u, a;
		u = getu(K);
		a = geta(u, t);
		v = -1 * a * vn;
		return v;
	}
	
	public double calc_x() {
		double u, a, w;
		
		u = getu(K);
		w = getw(w0, u);
		a = geta(u, t);
		x = (1 - a) * K*yn/((w*w + u*u) * Math.sqrt(t)) + a*xn;
		return x;
	}
	
	public double getw(double w0, double u) { return Math.sqrt(w0*w0 - u*u); }
	public double geta(double u, double t) { return Math.exp(-1 * u * t); }
	public double getu(double k) { return u; }	
	public double getXn() { return xn; }
	
	public void addV(double V) { this.V.add(V); }
	public ArrayList<Double> getV() { return V; }
	public void addNN(ChaosNeuralNetwork02 nn) { list.add(nn); }
	
	public void nextStep() {
		this.xn = x;
		this.yn = y;
		this.vn = v;
		this.zn = z;
	}
	
	public void setData(double xn, double yn, double vn, double z) {
		this.xn = xn;
		this.yn = yn;
		this.vn = vn;
		this.zn = z;
	}
	
	public double[] getData() {
		double[] result = new double[4];
		result[0] = x;
		result[1] = y;
		result[2] = v;
		result[3] = z;
		return result;
	}
}
