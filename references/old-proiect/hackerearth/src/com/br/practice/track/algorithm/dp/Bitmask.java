package com.br.practice.track.algorithm.dp;

/*
 * https://www.hackerearth.com/practice/algorithms/dynamic-programming/bit-masking/tutorial/
 * */

public class Bitmask {

	
	public static int setNthBit(int n, int k) {
		//return n | (1 << k);
		return n | 1 << k;
	}
	
	public static int unsetNthBit(int n, int k) {		
		return n & (~(1 << k));
	}
	
	public static boolean isSetNthBit(int n, int k) {
		return (n & (1 << k)) > 0;
	}
	
	public static int flipNthBit(int n, int k) {
		// se o bit estiver setado ? unset : set
		// return (n & (1 << k)) > 0 ? n & (~(1 << k)) : n | (1 << k);
		/*
		 * toggle a bit
		 * http://stackoverflow.com/questions/47981/how-do-you-set-clear-and-toggle-a-single-bit-in-c-c
		 * */
		return n ^ (1 << k);
	}
	
	/*
	 * troca de base
	 * trocando todas as bases para base 10
	 * 
	 * log m base -> n =
	 * log m base -> c // log n -> base c
	 * 
	 * */
	public static double log(int m, int n) {
		return Math.log10(m) / Math.log10(n);
	}
	public static int lenBin(int n) {
		return (int)log(n, 2) + 1;
	}
	
	public static String tobin(int n) {
		StringBuilder sb = new StringBuilder(); 
		while(n>0) {
			sb.append( (n & 1) == 0 ? "0" : "1");
			n >>=1;
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	
	public static void runTestLog() {
		System.out.println(log(100, 2));
	}
	
	public static void runTestSetNhtBit() {
		// 14 -> 01110
		// setando o kth bit ficaria
		int n = 14, k = 10;
		/*
		System.out.printf("tamanho em binario: %d,  setando o %d bit fica %d\n"
			,lenBin(n)
			,k
			,setNthBit(n, k)
		);
		n = 9;
		k = 1;
		System.out.printf("tamanho em binario: %d,  setando o %d bit fica %d\n"
			,lenBin(n)
			,k
			,setNthBit(n, k)
		);
		*/
		//
		n = 127; k = 6;
		/*
		System.out.printf("%d\nUnset %d-th bit de %d = %d"
			,7 & ~(1 << 2)
			,k
			,n
			,unsetNthBit(n, k)
		);
		*/
		System.out.printf("%s\n%s\n%s\n"
			,isSetNthBit(10, 3)
			,isSetNthBit(10, 3)
			,isSetNthBit(127,4)
		);
	}
	
	public static void runTestFlipBit() {
		//System.out.println(flipNthBit(10, 1));
		/*
		 * flipando 2th bit
		 * 0x0A xor 0x02
		 * 1010 xor 0010 => 1000 = 8
		 * 
		 * flipando 2th bit
		 * 127(0x7F) xor 0x02 =
		 * 01111111  xor 00000010 => 01111100 = 125
		 * 
		 * flipando 3th bit
		 * 127(0x7F) xor 0x03 =
		 * 01111111  xor 00000011 => 01111100 = 124
		 * 
 		 * flipando 4th bit
		 * 127(0x7F) xor 0x04 =
		 * 01111111  xor 00000100 => 01111011 = 123
		 * */
		System.out.printf("%d %d %d %d\n"
			,0x0A ^ 0x02
			,0x7F ^ 0x02
			,0x7F ^ 0x03
			,0x7F ^ 0x04
		);
	
		/*
		 * ~(10) = 0101
		 * (1 << 2) - 1 = 3 = 0011
		 * 0101 & 0011 = 0001
		 * */
		int mask [] = {
			 (1<<0)-1
			,(1<<1)-1
			,(1<<2)-1
			,(1<<3)-1
		};
		System.out.printf("%d\n"
			,~(10) & mask[3]
		);
	}
	
	/*
	 * quantos conjutos com n elementos
	 * eh possivel formar tal que a soma dos n elementos seja maior ou igual
	 * a um valor p qualquer
	 * */
	public static int subset(int [] set, int p) {
		int n = 0;
		int s = set.length;
		for(int i=0; i<(1<<s); i++) {
			int acc = 0;
			for(int j=0; j<s; j++) {
			//for(int j = s-1; j>=0; j--) {
				if(isSetNthBit(i, j))
					acc += set[j];
			}
			if(acc >= p)
				n++;
		}
		return n;
	}
	
	public static void table(int k) {
		for(int i=0; i<(1<<k); i++) {
			for(int j = k-1; j>=0; j--) {
				System.out.printf("%s", isSetNthBit(i, j) ? "1" : "0");
			}
			System.out.println();
		}
	}
	
	public static void testSubset() {
		int set [][] = {
			{1,2,4}
			,{5,7,11,15,32}
		};
		System.out.printf("%d"
			,subset(set[1], 37)
		);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//runTestSetNhtBit();
		//tobin(32);
		//runTestFlipBit();
		//table(5);
		testSubset();
		
	}

}
