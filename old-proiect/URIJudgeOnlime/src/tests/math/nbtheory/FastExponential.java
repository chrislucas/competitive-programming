package tests.math.nbtheory;


/*
 * Pela descima quinta vez escrevendo
 * exponential by squaring
 * 
 * http://eli.thegreenplace.net/2009/03/21/efficient-integer-exponentiation-algorithms/
 * 
 * 
 * */

/*
 * 
 * The efficent exponentiation algo is based on the simple observation that
 * 
 * for an even number 'b' -> a^b = a^(b/2) * a^(b/2)
 * for an odd number 'b' -> a^b = a * a ^(b-1)
 * 
 * Now we can compute a ^b doing only log(b) squaring and log(b) multiplication
 * instead of 'b' multiplication
 * for a large 'b' it is a large improvement
 * 
 * */

public class FastExponential {
	
	/*
	 * Utilizando o principio citado no comentario acima sobre
	 * exponential by squaring, podemos escrever um algorimto iterativo
	 * e recursivo que explora essa abordagem
	 * 
	 * Abaixo segue uma explicação matemática
	 * expoente exp = ti*2^i + ti-1*2^(i-1) + ... t02^0
	 * onde os ti's sao o bits (0 ou 1) de exp na base 2
	 * 
	 * exemplo: 3 ^ 10
	 * 10 = 1010 base 2 -> bits 3,1 estao 'ligados'
	 * 3 ^ (1*2^3) * 3 (1*2^1) = 3 ^ 8 * 3 ^ 2 = 3 ^ 10
	 * esse algoritmo analisa os bits da direita para esquerda
	 * base = 3, y = 1
	 * 10 	= 1010 & 1 = 0 entao 10 / 2 = 5 -> base = 3 * 3 = 9
	 * 5 	= 101 & 1 = 1 entao (5-1) / 2 = 2 -> y = y * base = 9, base = base * base = 81
	 * 2	= 10 & 1 = 0 entao 2/2 = 1
	 * 
	 * Como dito acima, ao converter exp em binario, dividindo-o por 2
	 * verificamos se o i-esimo bit esta 'ligado' da direita para esquerda
	 * 1010 & 1 = 0, 101 & 1 = 1, 10 & 1 = 0, 1 & 1 = 1
	 * */
	static double expBySqrIteative(double base, double exp) {
		if(exp < 0) {
			base = 1/base;
			exp = -exp;
		}
		else if(exp == 0)
			return 1;
		else if(exp == 1)
			return base;
		double acc = 1.0;
		// se a condicao for exp > 1 retorna base * acc
		// se a condicao for exp >= 1 retornar acc
		while(exp>=1) {
			// aqui avaliamos se o i-esimo bit esta ligado
			// ou se exp eh par. Quando um numero eh par
			// o bit menos signigicativo eh 0
			// verificamos da direira para esquerda
			if(((int)exp & 1) == 0) {
				exp /=  2; 
			} else {
				acc *= base;
				exp = (int)(exp-1)/2;
			}
			base *= base;
		}
		return acc;
		//return base * acc;
	}
	
	/*
	 * uma ideia similar a de cima, verificar se o bit menos significa-
	 * tivo, esta ligado
	 * */
	public static double expBinRL(double b, double e) {
		if(e < 0) {
			b = 1/b;
			e = -e;
		}
		else if(e == 0) return 1;
		else if(e == 1) return b;
		double ans = 1.0;
		while(e>=1) {
			if(((int)e & 1) == 1) {
				ans *= b;
			}
			e = (int) e >> 1;
			b *= b;
		}
		return ans;
	}
	
	
	/*
	 * Usando o principio de reescrever o expoente (double e)
	 * na base binaria, implementamos um algorimo recursivo de
	 * exponenciacao rapida
	 * */
	static double expBySqrRecursive(double acc, double b, double e) {
		if(e < 0) return expBySqrRecursive(acc, 1/b, -e);
		else if(e == 0) return acc;
		else if(e == 1) return acc*b;
		else {
			acc = ((int)e & 1) == 0 ? acc : acc * b;
			e	= ((int)e & 1) == 0 ? e/2 : (int)(e-1)/2;
			return expBySqrRecursive(acc, b * b, e);
		}
	}
	
	/*
	 * MSB de most significant bit
	 * MSB to LSB Least significant bit 
	 * */
	public static double expBinLR(double b, double e) {
		if(e<0) {
			e = -e;
			b = 1/b;
		}
		else if(e == 0) {return 1;}
		else if(e == 1) {return b;}
		double ans = 1.0;
		byte [] bin = decTobin((int) e);
		for(byte bit : bin) {
			ans *= ans;
			if(bit == 1) {
				ans *= b;
			}
		}
		return ans;
	}
	/*
	 * http://www.tutorbrasil.com.br/estudo_matematica_online/logaritmos/logaritmos_05_consequencias_definicao.php
	 * propriedade de troca de base do logaritmo
	 * No caso de termos uma base da qual não sabemos calcular
	 * o logaritmo, podemmos trocar essa base. Por exemplo
	 * log m, base n -> onde nao sabemos calcular com a base m
	 * Entao -> log m, base n ->  log m, base x / log n, base x
	 * */
	public static double log(double m, double n) {
		return Math.log10(m) /  Math.log10(n);
	}
	
	public static byte [] decTobin(int n) {
		int sz = (int)log(n, 2) + 1;
		byte [] bin = new byte[sz];
		for(int i=sz-1; i>-1; i--) {
			bin[i] = (byte) ((n & 1) == 0 ? 0 : 1);
			n = n >> 1;
		}
		return bin;
	}
	
	public static void runTest() {
		// um teste a parte para verificar o principio matemático
		System.out.printf("%f\n", expBySqrIteative(5, 7));
		System.out.printf("%f\n", expBinRL(5, 7));
		System.out.printf("%f\n", expBinLR(5, 7));
		/*
		System.out.printf("%f %f\n%f %f\n %f %f\n",
				expBySqrIteative(3, 5)
				,expBySqrRecursive(1, 3, 5)
				,expBySqrIteative(3, -10)
				,expBySqrRecursive(1, 3, -10)
				,expBySqrIteative(3, 10)
				,expBySqrRecursive(1, 3, 10));
		*/
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runTest();
		/*
		 * Propriedade interessante
		 * 
		 * Log x ^ M base x ^ N = M/N
		 * Log 10 ^ 3 base 10 ^ 4 = 3/4
		 * Log 3  base 3^ 4 = 1/4
		 * */
		//System.out.printf("%f\n%f\n", log(1000, 10000), log(3, 81));
	}

}
