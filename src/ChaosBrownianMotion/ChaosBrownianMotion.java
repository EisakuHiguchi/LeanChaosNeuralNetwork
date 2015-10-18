package ChaosBrownianMotion;

public class ChaosBrownianMotion {
	
	/*
	 * x(t): 時刻tでのブラウン粒子の位置
	 * k: 減衰定数
	 * W0: 周波数
	 * f(t) : カオス的な力
	 * t: 時間間隔
	 * y(n): マップF(y;r)のn回反復
	 * r(n): 分岐パラメータ
	 * b,B: コントロールパラメータ
	 * 
	 * 
	 * a = e^-ut
	 * u = k/2
	 * w = sqrt(w0^2 - u^2)
	 */
	
	protected double K = 0;
	protected double t = 0;
	protected double b = 0;
	protected double B = 0;
	
	protected double xn, yn, vn, w0;
	
	public double Function_r(double xn) {
		return  4 - b + b*Math.exp(-1*B*Math.abs(xn));
	}

	public double Function_F(double x, double v, double y, double w0) {
		double result = 0;
		double u, a, w;
		
		u = getu(K);
		w = getw(w0, u);
		a = geta(u, t);
		
		result = (1 - (u/w * Math.sin(w*t) + Math.cos(w*t) * a) * (K * y / ((w*w + u*u) * Math.sqrt(t))));
		result = result + (u/w * Math.sin(w*t) + Math.cos(w*t) * a*x);
		result = result + Math.sin(w*t)/w * a*v;
		
		return result;
	}
	
	public double Function_G(double x, double v, double y, double w0) {
		double result = 0;
		double u, a, w;
		
		u = getu(K);
		w = getw(w0, u);
		a = geta(u, t);
		
		result = Math.sin(w*t) / w * a*K*y/Math.sqrt(t);
		result = result - w*w+u*u/w * a*x*Math.sin(w*t);
		result = result - (u/w*Math.sin(w*t) - Math.cos(w*t)) * a*v;
		
		return result;
	}	
	
	public double calc_x() {
		return Function_F(xn, yn, vn, w0);
	}
	public double calc_v() {
		return Function_G(xn, yn, vn, w0);
	}
	public double calc_y() {
		return Function_r(xn) * (0.5 - yn) * (0.5 + yn) - 0.5;
	}
	
	public void setNPrm(double xn, double yn, double vn, double w0) {
		this.xn = xn;
		this.yn = yn;
		this.vn = vn;
		this.w0 = w0;
	}
	
	public double getw(double w0, double u) { return Math.sqrt(w0*w0 - u*u); }
	public double geta(double u, double t) { return Math.exp(-1 * u * t); }
	public double getu(double k) { return k/2; }	
	
	public void setB(double B) { this.B = B; }
	public void setb(double b) { this.b = b; }
	public void sett(double t) { this.t = t; }
	public void setK(double K) { this.K = K; }	
	
}
