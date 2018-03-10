package ds.ctci.ch5;

public class PairwiseSwap {

	static int pairwiseSwap(int num) {
		
		int even = 0x55555555;
		int odd = 0xAAAAAAAA;
		
		return ((num & odd) >>> 1) | ((num & even) << 1);
		
	}
	
	static int pairwiseSwap2(int num) {
		
		int mask = 0xC0000000;
		while(mask!=0) {
			if( (num&mask)!=0 && (num&mask)!=mask)
				num ^= mask;
			
			mask >>>= 2;
		}
		
		return num;
		
	}
	
	public static void main(String[] args) {
		int num = 0x000000D2;
		int ans = pairwiseSwap2(num);
		System.out.println("num = " + Integer.toBinaryString(num));
		System.out.println("ans = " + Integer.toBinaryString(ans));

	}

}
