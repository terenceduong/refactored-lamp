package sortingtest;

public class main {
	public static void main(String args[]) {
		Point a = new Point(0,0);
		Point b = new Point(3,4);
		Point c = new Point(1,1);
		Point d = new Point(5,9);
		Point e = new Point(3,3);
		
		Point[] pts = {b,d,e};
		
		sortPoints(a, pts);
		System.out.println(nearest(a, pts));
	}

	
	static double dis(Point a, Point b) {
		double dis;
		
		// sqrt(|x|^2 + |y|^2)
		int x = a.x - b.x;
		int y = a.y - b.y;
		
		dis = Math.sqrt(x*x + y*y);
//		System.out.printf("Distance between (%d,%d) and (%d,%d) is %.2f%n",a.x,a.y,b.x,b.y, dis);
		return dis;
	}
	
	static Point nearest(Point base, Point[] pts) {
		Point nearest = null;
		double dis = Double.MAX_VALUE;
		for (int i = 0; i < pts.length; i++) {
			double thisDis = dis(base, pts[i]);
			if (thisDis < dis) {
				dis = thisDis;
				nearest = pts[i];
			}
		}
		return nearest;
	}
	
	static Point[] sortPoints(Point base, Point[] pts) {
		String space = "";
		for (int i = 0; i < pts.length; i++) {
			System.out.printf("%s[%s, %.2f]", space, pts[i].toString(), dis(base, pts[i]));
			space = ", ";
		}
		System.out.println();
		
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < pts.length - 1; i++) {
				double disI = dis(base, pts[i]);
				double disIplus1 = dis(base,pts[i+1]);
				if (disI > disIplus1) {
					System.out.printf("Switch %d and %d%n", i, i+1);
					Point temp = pts[i];
					pts[i] = pts[i+1];
					pts[i+1] = temp;
					
					sorted = false;
				}
			}
			
			space = "";
			for (int i = 0; i < pts.length; i++) {
				System.out.printf("%s[%s, %.2f]", space, pts[i].toString(), dis(base, pts[i]));
				space = ", ";
			}
			System.out.println();
			
		}
		
		return null;
	}
}

class Point {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return String.format("(%d, %d)", x, y);
	}
}