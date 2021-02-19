
public class CoinChangeProblem {
	
	public static void main(String[] args) 
	{
		int [] coins = {1,2,5};
		int betrag = 127;
		System.out.println("Minimale Anzahl an Muenzen: " + loese(betrag, coins));
		
	}
	
	
	public static int loese(int betrag, int [] coins) 
	{
		int [] loesung = new int[betrag + 1];
		
		for (int i = 1; i < loesung.length; i++) {
			loesung[i] = betrag + 1;
		}
		
		for (int i = 1; i < loesung.length; i++) {
			for (int x = 0; x < coins.length; x++){
				if (i - coins[x] >= 0) {
					loesung[i] = min(loesung[i], loesung[i-coins[x]] + 1);
				}
			}
		}
		
		int end = loesung.length - 1;
		return loesung[end];
		
	}
	
	
	public static int min(int a, int b) {
		return Math.min(a, b);
	}
	
	
	
	
}
