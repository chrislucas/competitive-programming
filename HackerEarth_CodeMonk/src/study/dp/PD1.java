package study.dp;

public class PD1 {
	
	// algoritmo que retorna de quantas formas um numero N pode ser escrito
	// dado um conjunto S de numeros {S1, S2, S3, SN}
	// PD FACIL
	// https://www.hackerearth.com/notes/dynamic-programming-for-beginners-part-2-1-d/
	public static int waysToWriteNumber(int number) {
		int [] pd = new int[number+1];
		pd[0] = 0;
		pd[1] = 1;
		pd[2] = 2;
		pd[3] = 4;
		for(int i=4; i<=number; i++) {
			pd[i] = pd[i-1] + pd[i-2] + pd[i-3];
		}
		return pd[number];
	}

	public static void main(String[] args) {
		System.out.println(waysToWriteNumber(5));

	}

}
