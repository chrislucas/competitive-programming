package com.br.practice.ml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/*
 * https://www.hackerearth.com/practice/machine-learning/prerequisites-of-machine-learning/basic-probability-models-and-rules/tutorial/
 * DONE
 * 
 * */

public class BasicProb {

	public static double solver(double pA, double pB, double pRain) {
		return pRain*(pB*(1.0-pA) + pA*(1.0-pB));
	}
	
	public static void main(String[] args) {
		DecimalFormat decFmt = (DecimalFormat) NumberFormat.getInstance(Locale.US);
		/*
		 * http://tutorials.jenkov.com/java-internationalization/decimalformat.html
		 * https://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html
		 * */
		decFmt.applyPattern("0.000000");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			double pmb = Double.parseDouble(reader.readLine());	// probabilidade de mike pegar um onibus
			double pma = Double.parseDouble(reader.readLine());	// probabilidade de alice pegar um onibus
			double pmi = Double.parseDouble(reader.readLine());	// probabilidade de chover
			/*
			 * 1 - pmb = probabilidade de mike pegar o trem
			 * 1 - pma = o mesmo para a Alice
			 * */
			double ans = solver(pma, pmb, pmi);
			System.out.println(decFmt.format(ans));
		} catch(IOException ioex) {}
	}
}
