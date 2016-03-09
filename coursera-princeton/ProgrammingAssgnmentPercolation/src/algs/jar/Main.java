package algs.jar;

import edu.princeton.cs.algs4.BinaryIn;
import edu.princeton.cs.algs4.BinaryOut;

import java.io.BufferedInputStream;
import java.io.PrintStream;

import edu.princeton.cs.algs4.BinaryIn;
import edu.princeton.cs.algs4.BinaryOut;;

public class Main {
	
	public static void main(String[] args) {
	
		//BufferedOutputStream out = new BufferedOutputStream(new PrintStream(System.out, true));
		BinaryOut out = new BinaryOut(new PrintStream(System.out, true));
		BinaryIn  in = new BinaryIn(new BufferedInputStream(System.in, 4096));
		
		String s = in.readString();
		out.write(s);
	}

}
