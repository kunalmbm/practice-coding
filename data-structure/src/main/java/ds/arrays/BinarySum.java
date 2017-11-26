package ds.arrays;

public class BinarySum {

	
	static int[] binarySum(int[] A, int[] B, int n) {
		int[] C = new int[n+1];
		
		int s = 0, c = 0;
		int i = n-1;
		for(; i>=0; i--) {
			int a = A[i];
			int b = B[i];
			
			//System.out.printf("%d %d %d ",c, a, b);
			
			if(c==0) {
				s=0;
				if(a == 1 && b==1) 
					c = 1;
				else
					s = a+b;
			} else if(c==1) {
				s=1;
				if(a == 0 && b==0)
					c = 0;
				else if(!(a == 1 && b == 1))
					s = 0;
			} 
			
			//System.out.printf("- %d %d \n",c ,s);
			
			C[i+1] = s;
			
		}
		
		C[i+1] = c;
		
		return C;
	}
	
	public static void main(String[] args) {
		
		int[] A = {0, 1, 1, 1};
		int[] B = {0, 1, 1, 1};
		int n = 4;
		
		int[] C = binarySum(A, B, n);
		
		for(int i = 0; i<=n; i++)
			System.out.printf("%d ",C[i]);
		
	}
}
