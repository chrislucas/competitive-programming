package com.br.test;

public class ShiftMatrix {

	static int [][] matrix;
	static int col, line;
	static int[] shiftLine, shiftCol;
	
	
	static void init(int col, int line) {
		matrix = new int[col][line];
		shiftLine = new int[line];
		shiftCol = new int [col];
		ShiftMatrix.col = col;
		ShiftMatrix.line = line;
		add();
	}
	
	private static void add() {
		int value = 1;
		for(int i=0; i<line; i++) {
			for(int j=0; j<col; j++) {
				matrix[i][j] = value++;
			}
		}
		for(int i=0; i<line; i++)
			shiftLine[i] = i;
		
		for(int i=0; i<col; i++)
			shiftCol[i] = i;
	}
	
	static void shiftAllLine(int line, int shift) {
		for(int idx = 0; idx < ShiftMatrix.line; idx++) {
			shiftLine[(idx + shift) % ShiftMatrix.line] = idx; 
		}
	}
	
	static void shiftAllCol(int col, int shift) {
		for(int idx = 0; idx < ShiftMatrix.col; idx++) {
			shiftCol[(idx + shift) % ShiftMatrix.col] = idx;
		}
		
	}
	
	static void printMatrix(boolean shifted) {
		if( ! shifted ) {
			for(int i=0; i<line; i++) {
				for(int j=0; j<col; j++) {
					String fmt = j > 0 ? " %d" : "%d";
					System.out.printf(fmt, matrix[i][j]);
				}
				System.out.println("");
			}
		} else {
			for(int i=0; i<line; i++) {
				for(int j=0; j<col; j++) {
					String fmt = j > 0 ? " %d" : "%d";
					System.out.printf(fmt, matrix[shiftLine[i]][shiftCol[j]]);
				}
				System.out.println("");
			}
		}
	}
	
	public static void main(String[] args) {
		init(3, 3);
		shiftAllLine(1, 3);
		shiftAllCol(1, 1);
		printMatrix(true);

	}

}
