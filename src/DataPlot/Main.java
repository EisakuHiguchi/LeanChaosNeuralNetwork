package DataPlot;

import ChaosBrownianMotion.ChaosBrownianMotion;

public class Main {
	
	public static void main(String[] args) {
		
		ChaosBrownianMotion cbm = new ChaosBrownianMotion();
		cbm.setb(0.1);
		cbm.setB(0.1);
		cbm.setK(0.1);
		cbm.sett(0.01);
		
		double x = 0.3;
		double y = 0.3;
		double v = 0.3;
		double w0 = Math.PI;
		
		x = cbm.calc_v(x, y, v, w0);
		y = cbm.calc_y(cbm.Function_r(x), y, x);
		v = cbm.calc_v(x, y, v, w0);
		
		System.out.println("x: " + x + " y: " + y + " v: " + v);
	}

}
