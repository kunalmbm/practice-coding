package ds.ctci.ch5;

public class NextNumber {
	
	static int next(int num) {
		int c0 = 0, c1 = 0;
		int p = 1;
		while((num & p) == 0){
			c0++;
			p <<= 1;
		}
		
		while((num & p) != 0){
			c1++;
			p <<= 1;
		}
		
		if((c1+c0) == 32)
			return -1;
		
		num |= p;
		num &= ~(p-1);
		num |= ((1 << (c1-1))-1);
		
		return num;
	}
	
	static int prev(int num) {
		int c0 = 0, c1 = 0;
		int p = 1;
		while((num & p) != 0){
			c1++;
			p <<= 1;
		}
		while((num & p) == 0){
			c0++;
			p <<= 1;
		}

		if((c1+c0) == 32)
			return -1;
		
		num &= ~p;
		num |= (p-1);
		num &= ~((1 << (c0-1))-1);
		
		return num;
	}

	public static void main(String[] args) {
		int num =0x0002870;
		int ans = prev(num);
		
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.toBinaryString(ans));

	}

}
