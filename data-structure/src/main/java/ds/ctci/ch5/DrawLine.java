package ds.ctci.ch5;

public class DrawLine {
	
	static void drawLine(byte[] screen, int w, int x1, int x2, int y) {
		
		int h = (screen.length) / (w/8);
		validate(x1,x2,y,h,w);
		
		int si = y * (w/8);
		int i =0, j =0;
		//byte mask = (byte)0xFF;
		
		System.out.printf("w = %d, x1 = %d, x2 = %d, y = %d \n",w,x1,x2,y);
		
		while((i+1)*8 <= x1) i++;
		
		screen[si+i] |= (0xFF >>> (x1-i*8));
		j = i;
		
		//System.out.printf("screen[%d] = %d, %d \n",(si+i),screen[si+i], (byte)(mask >>> 4));
		while((i+1)*8 <= x2){
			if(i!=j)
				screen[si+i] = (byte)0xFF;
			
			//System.out.printf("screen[%d] = %d \n",(si+i),screen[si+i]);
			i++;
		}
		
		if(i==j)
			screen[si+i] &= (0xFF << ((i+1)*8-x2-1));
		else
			screen[si+i] |= (0xFF << ((i+1)*8-x2-1));
		
	}
	
	private static void validate(int x1, int x2, int y, int h, int w) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		
		int x1 = 30, x2 = 31, w = 32, y=1, i, j;
		byte[] screen = new byte[16];

		drawLine(screen, w, x1, x2, y);
		
		for(i = 0; i < 4 ; i++) {
			for(j = 0; j < 4 ; j++)
				System.out.print(screen[i*4+j] + ", ");
			System.out.println();
			
		}
		
		byte mask = -1; // same as 0xFF
		System.out.println(Integer.toHexString((mask >> 4)));
		System.out.println(Integer.toHexString((mask >>> 4)));
		//System.out.printf("mask = %d\n",(mask >>> 4));
		
		int p = 0xFFFF;
		System.out.println(Integer.toBinaryString(p));
		p = 0x7FFF >> 4;
		System.out.println(Integer.toBinaryString(p));
		
		float f = 2.2f;
	}

}
