
public class ZPoint {
	int a;
	int b;
	int m;
	int n;
	int xVal;
	
	//Stores point a^m * b^n
	public ZPoint(int a, int b, int m, int n, int p) {
		this.a = a;
		this.b = b;
		this.m = m;
		this.n = n;
		this.xVal = (Main.fastDExp(a,m,p) * Main.fastDExp(b,n,p)) % p;
	}
	
	public int getxVal() {
		return xVal;
	}
	
	public int geta() {
		return a;
	}
	
	public int getb() {
		return b;
	}
	
	
	public int getm() {
		return m;
	}
	
	public int getn() {
		return n;
	}
	
	public String printZPoint() {
		String s = "m = " + m + ", n = " + n + ", xVal = " + xVal;
		return s;
	}
}
