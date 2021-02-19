
public class KnapsackDynamisch {
	
	public static void main(String [] args) {
		
		int [] g = {4,5,6,2,2};
		int [] w = {6,4,5,3,6};
		int rc = 10;
		loesen(g,w,rc);
	}
	
	public static void print (int [][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println();
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] < 10) {
					System.out.print(arr[i][j] + "  ");
				} else {
					System.out.print(arr[i][j] + " ");
				}
					
			}
		}
	}
	
	public static void loesen (int [] g, int [] w, int rc) {
		int [][] loesung = new int [g.length+1][rc+1]; //Erstelle Loesungsfeld
		// f(i,rc) = max {f(i+1, rc} , f(i+1, rc - g) + w}
		
		boolean [] gegenstaende = new boolean[g.length];
		
		for (int i = 1; i < loesung.length; i++) {
			
			
			for (int j = 0; j < loesung[i].length; j++) {
				if (g[i-1] <= j) { //Wenn Gegenstand reinpasst
					if (j-g[i-1] < 0) {
						loesung[i][j] = loesung[i-1][j];
					} else {
						loesung[i][j] = max (loesung[i-1][j], loesung[i-1][j-g[i-1]] + w[i-1]);
					}

				}
			}
		}
		print(loesung);

		System.out.println(("\nLoesung: " + loesung[loesung.length-1][loesung[0].length-1]));
		
	}
	
	
	
	public static int max (int a, int b) {
		if (a > b) {
			return a;
		}
		return b;
	}
	
}
