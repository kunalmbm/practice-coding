package ds.ctci.ch5;

public class Conversion {

	static int conversion(int A, int B) {
	
		int X = A ^ B, c = 0;
		while(X!=0) {
			c += X & 1;
			X >>>= 1;
		}
		
		return c;
	}
	
	static int conversion2(int A, int B) {
		
		int X = A ^ B, c = 0;
		while(X!=0) {
			c++;
			X = X & (X-1);
		}
		
		return c;
	}
	
	public static void main(String[] args) {
		

		int A = 0x000000F7;
		int B = 0x00000005;
		System.out.println(conversion2(A, B));


	}

}
