package seletiva.adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SPOJ8305 {
	public static BufferedReader buffer;
	public static PrintWriter writer;
	
	public static void main(String[] args) {
		buffer = new BufferedReader(new InputStreamReader(System.in));
		writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		
		try {
			int cases;
			while( (cases = Integer.parseInt(buffer.readLine())) != 0) {
				char [] alternatives = {'A', 'B', 'C', 'D', 'E'};
				while(cases>0) {
					int idx = 0, i = 0;
					String question = buffer.readLine();
					StringTokenizer tokenizer = new StringTokenizer(question, " ");
					// {-1, 0, 1}
					// -1 caso nenhum resposta tenha sido escolhida
					//  0 para uma unica resposta escolhida
					//  1 para mais de uma resposta escolhida
					int uniqueQuestion = -1;
					while(tokenizer.hasMoreTokens()) {
						int number = Integer.parseInt(tokenizer.nextToken());
						if(number < 128 && uniqueQuestion == -1) {
							uniqueQuestion = 0;
							idx = i;
						} else if(number < 128 && uniqueQuestion == 0) {
							uniqueQuestion = 1;
						}
						i++;
					}
					writer.printf("%c\n", uniqueQuestion == 0 ? alternatives[idx] : '*');
					cases--;
				}
			}
		} catch(IOException ioex) {}
	}
}
