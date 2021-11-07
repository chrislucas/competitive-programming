package src.com.br.oj.icpckattis.adhoc;


import java.io.*;
import java.util.Arrays;

/*
* https://open.kattis.com/problems/beehouseperimeter
* */
public class BeeHousePerimeter {

    private static final BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

    private static final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
    
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

    private static int[][] createHoneycombGrid(int k) {
        int [][] grid = new int[k][k];
        int counter = 1;
        int j = 2;
        int limit = 5;

        for (int i = 0; i < k ; i++) {
            int aux = j;
            while (aux < limit) {
                grid[i][aux] = counter++;
                aux+=1;
            }

            if (i  < k / 2) {
                j-=1;
                limit+=1;
            } else {
                j+=1;
                limit-=1;
            }
        }
        return grid;
    }

    public static void main(String[] args) throws IOException {
        int [] values = readIntValues();
        int r = values[0];
        int k = values[1];
        values = readIntValues();
        Arrays.sort(values);

        int [][] grid = createHoneycombGrid(r + 3);
    }
}
