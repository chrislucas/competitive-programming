package com.br.algo;

import java.io.*;

public class IO {

    private static final BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

    private static final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

    private static int readInt() throws IOException {
        return Integer.parseInt(buffer.readLine());
    }

    private static int [] readIntValues() throws IOException {
        return readIntValues(" ");
    }

    private static int [] readIntValues(String delimiter) throws IOException {
        String[] memory = buffer.readLine().split(delimiter);
        int [] values = new int[memory.length];
        for (int i = 0; i < memory.length; i++)
            values[i] = Integer.parseInt(memory[i]);
        return values;
    }


    public static void main(String[] args) {
        System.out.println(0xff);
    }
}
