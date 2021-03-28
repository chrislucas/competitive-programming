package com.br.tutorial.io.jenkov;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;



public class CompFileIO {
	public static void main(String[] args) {
		/**
		 * 	The BufferedReader class provides buffering to your Reader's.
		 * 	Buffering can speed up IO a bit. Rather than (ao invez de)
		 * 	read one character at a time from the network or disk,
		 * 	you read a larger block at a time
		 * 	The main difference among BufferedReader and BufferedInputStream
		 * 	is that Reader's work on character and InputStream's works on raw Bytes
		 * 
		 */
		
		 /**
		  * If you need to read a file you can use FileInputStream or FileReader, depeding
		  * on whether you want to read the file as binary or textual data.
		  * Both classes lets you read a file one by or character at at time from the start
		  * to the end of file, or read the bytes into an array of byte or char
		  * 
		  * */
		try {

			Reader reader1 = new InputStreamReader(new FileInputStream("/app/workspace-algorithm/IO/src/links"));
			long s = System.currentTimeMillis();
			int n;
			while((n = reader1.read()) != -1) {
				//System.out.print((char)n);
			}
			System.out.println(System.currentTimeMillis() - s);
			reader1.close();
			
			s = System.currentTimeMillis();
 			Reader reader2 = new BufferedReader(new FileReader("/app/workspace-algorithm/IO/src/links"), 1<<13);
			while(((BufferedReader)reader2 ).readLine() != null) {
				//System.out.println(((BufferedReader)reader2 ).readLine());
			}
			System.out.println(System.currentTimeMillis() - s);
			reader2 .close();
			// BufferedInputStream eh mais rapido
			s = System.currentTimeMillis();
			InputStream is = new BufferedInputStream(new FileInputStream("/app/workspace-algorithm/IO/src/links"), 1<<13);
			while((n = is.read()) != -1) {
				//System.out.print((char)n);
			}
			System.out.println(System.currentTimeMillis() - s);
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
