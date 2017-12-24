package ds.ctci.ch5;

public class Insertion {

	static int insert(int n, int m, int i, int j) {
		// clear i -to j bits of n
		
		int mask = 0;
		for(int k = i; k <=j; k++)
			mask |= (1<<k);
		
		mask = ~mask;
		n = n & mask;
		m = m<<i;
		
		return (n|m);
	}
	
	static String toBinary(int num) {
		
		char[] chars = new char[32];
		for(int i=31; i>=0; i--) {
			chars[i] = ((num & 1) == 0) ? '0' : '1';
			num >>>= 1;
		}

		return String.valueOf(chars);
	}
	
	public static void main(String[] args) {
		
		int n = 56789, m = 456, i = 2, j = 10;
		System.out.printf("N: %14d -> %s\n", n, toBinary(n));
		System.out.printf("M: %14d -> %s\n", m, toBinary(m));
		System.out.printf("i = %d, j = %d\n", i, j);
		n = insert(n, m, i,j);
		System.out.printf("New N: %10d -> %s\n\n\n", n, toBinary(n));

		n = 56791; m = 0; i = 2; j = 10;
		System.out.printf("N: %14d -> %s\n", n, toBinary(n));
		System.out.printf("M: %14d -> %s\n", m, toBinary(m));
		System.out.printf("i = %d, j = %d\n", i, j);
		n = insert(n, m, i,j);
		System.out.printf("New N: %10d -> %s\n\n\n", n, toBinary(n));

	}
	
	
}
