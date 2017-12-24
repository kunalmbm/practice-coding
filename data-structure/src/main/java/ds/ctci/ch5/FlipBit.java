package ds.ctci.ch5;

public class FlipBit {

	static int flip(int num) {
		int mask = 1, max = 0, zero = 0, prevOne = 0, curOne = 0;
		boolean bit = false, prevBit = false;

		int i = 0;
		do {

			bit = (num & mask) != 0;
			i++;

			if (bit) {
				if (!prevBit) {
					prevOne = curOne;
					curOne = 0;
				}
				curOne++;
			} else {
				if (prevBit) {
					max = max(prevOne, zero, curOne, max);
					zero = 1;
				} else
					zero++;
			}
			//System.out.printf("###### %d : %b : %d - %d - %d\n",i,bit,prevOne,zero,curOne);
			mask = mask << 1;
			prevBit = bit;
		} while (mask != 0);
		
		if(prevBit)
			max = max(prevOne, zero, curOne, max);

		return max;
	}

	private static int max(int prevOne, int zero, int curOne, int max) {

		System.out.printf("### %d - %d - %d - %d -> ",prevOne,zero,curOne,max);
		int x = 0;

		if (zero > 1)
			x = Math.max(prevOne, curOne) + 1;
		else // z ==1 || z == 0
			x = prevOne + zero + curOne;

		max = Math.max(x, max);
		System.out.printf("%d \n",max);
		return max;
	}

	static String toBinary(int num) {

		char[] chars = new char[32];
		for (int i = 31; i >= 0; i--) {
			chars[i] = ((num & 1) == 0) ? '0' : '1';
			num >>>= 1;
		}

		return String.valueOf(chars);
	}

	public static void main(String[] args) {

		
		int num = Integer.parseInt("1111011100011100", 2);
		int max = flip(num);
		System.out.printf("num = %s -> %d\n\n", toBinary(num), max);

		num = Integer.parseInt("011111100111011", 2);
		max = flip(num);
		System.out.printf("num = %s -> %d\n\n", toBinary(num), max);

		num = Integer.parseInt("111111100111011", 2);
		max = flip(num);
		System.out.printf("num = %s -> %d\n\n", toBinary(num), max);
	}

}
