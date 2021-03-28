package com.br.practice.track.basic;

public class Bitmanipulation {

	public static int count(int n) {
		int c = 0;
		while(n>0) {
			if((n & 1) == 1)
				c++;
			System.out.println(n);
			n >>= 1;
		}
		return c;
	}
	
	/*
	 * Na operacao and entre X e X-1
	 * o bit mais a direita desses 2 numeros
	 * sao trocados
	 * 
	 * Exemplo
	 * 10 -> 1010, 9 1001
	 * 8 -> 1000, 7 -> 0111
	 * 6 -> 0110, 5 -> 0101
	 * 
	 * Assim, ao realizar a operacao 'and' x & (x-1)
	 * e armazenando o resultado novamente em x
	 * nos reduzimos a quantidade de 1's do numero
	 * original
	 * 
	 * 
	 * */
	public static int otherCount(int n) {
		int c = 0;
		while(n>0) {
			n &= (n-1);
			c++;
			System.out.println(n);
		}
		return c;
	}
	
	public static void run() {
		System.out.printf("%d %d"
			,count(10)
			,otherCount(10)
		);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//run();
		otherCount(127);
		count(127);
	}

}
