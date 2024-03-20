import java.util.*;
import java.math.*;

public class Main {

	public static void main(String[] args) {
		//change these parameters
		int a = 2;
		int b = 1046;
		int p = 3989;
		int s = p / 20;
		CoeffList mList = new CoeffList(s,p);
		CoeffList nList = new CoeffList(s,p);
		//System.out.println(mList.getCoeffs());
		//System.out.println(nList.getCoeffs());
		ArrayList<ZPoint> xValList = new ArrayList<>();
		for (int i = 0; i < s; i++) {
			xValList.add(new ZPoint(a,b,mList.getCoeffs().get(i),
					nList.getCoeffs().get(i),p));
			//System.out.println(xValList.get(i).printZPoint());
		}
		
		//m0 and n0 first "random" coefficients
		int m0 = 5;
		int n0 = 7;
		ZPoint p1 = new ZPoint(a,b,m0,n0,p);
		ZPoint p2 = new ZPoint(a,b,m0,n0,p);
		for (int i = 0; i < 100; i++) {
			p1 = pFunc(p1, xValList, p, s);
			p2 = pFunc(pFunc(p2, xValList, p, s), xValList, p, s);
			if (p1.getxVal() == p2.getxVal()) {
				System.out.println("i: " + i);
				System.out.println("p1: " + p1.printZPoint());
				System.out.println("p2: " + p2.printZPoint());
				break;
			}
		}
	}
	
	
	
	
	
	
	
	
	//applies f(p) = p * l_i
	public static ZPoint pFunc(ZPoint ZP, ArrayList<ZPoint> xValList, int p, int s) {
		int g = ZP.getxVal();
		int e = g % s;
		int m0 = ZP.getm();
		int n0 = ZP.getn();
		int mi = xValList.get(e).getm();
		int ni = xValList.get(e).getn();;
		ZPoint outP = new ZPoint(ZP.geta(),ZP.getb(), m0 + mi, n0 + ni, p);
		
		return outP;
	}
	
	public static int fastDExp(int a, int k, int p) {
		ArrayList<Integer> bin = binaryRep(k);
		int s = bin.size();
		int d = a;
		ArrayList<Integer> expVals = new ArrayList<>();
		expVals.add(a);
		for (int i = 1; i < s; i++) {
			d = (d*d) % p;
			expVals.add(d);
		}
		int prod = 1;
		//System.out.println(expVals);
		for (int j = 0; j < s; j++) {
			if (bin.get(s-j-1) == 1) {
			prod = (prod * expVals.get(j) * bin.get(s-j-1)) % p;
			}
		}
		return prod;
	}
	
	public static int DExp(int a, int k, int p) { //a^k mod p
		int l = 1;
		for (int i = 0; i < k; i++) {
			l = (l*a) % p;
		}
		return l;
	}
	
	////////////////////////////////////////////////////////////////////////////
	
	//puts number in binary in ArrayList
	public static ArrayList<Integer> binaryRep(int k) {
		ArrayList<Integer> bin = new ArrayList<>();
		int n = twoLog(k);
		int a = k;
		for (int i = n; i >= 0; i--) {
			if (a - Math.pow(2, i) >= 0) {
				a -= Math.pow(2, i);
				bin.add(1);
			}
			else {
				bin.add(0);
			}
		}
		return bin;
		
	}
	
	public static int twoLog(int a) {
		int i = 0;
		int n = 1;
		while (n < a) {
			n *= 2;
			i++;
		}
		return i;
	}

}
