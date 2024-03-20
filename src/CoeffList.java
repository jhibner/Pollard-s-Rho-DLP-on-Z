import java.util.*;
import java.math.*;

public class CoeffList {
	ArrayList<Integer> els;
	
	public CoeffList(int s, int p) {
		Random rand = new Random();
		ArrayList<Integer> construct = new ArrayList<>();
		for (int i = 0; i < s; i++) {
			construct.add(rand.nextInt(p));
		}
		els = construct;
	}
	
	public ArrayList<Integer> getCoeffs() {
		return els;
	}
}
