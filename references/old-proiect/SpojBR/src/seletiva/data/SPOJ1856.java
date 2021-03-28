package seletiva.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * http://br.spoj.com/problems/PREEMPOS/
 * */

public class SPOJ1856 {
	
	public static BufferedReader buffer;
	public static PrintWriter writer;
	
	public static class Tree {
		public char value;
		public Tree left, right;
		public Tree() {}
		public Tree(char value) { this.value = value; }
	}
	
	public static void postOrder(Tree root) {
		if(root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		writer.printf("%c",root.value);
	}

	public static Tree build(char[] ino, char[] pre, int sIno, int eIno, int sPre, int ePre) {
		if(sIno > eIno)
			return null;
		SPOJ1856.Tree node = new SPOJ1856.Tree(pre[sPre]);
		if(sIno == eIno)
			return node;
		int idx;
		for(idx = sIno; idx<eIno; idx++) {
			if(pre[idx] == ino[idx])
				break;
		}
		// a subarvore a esquerda usa a metada do array inorder ate o elemento mais a esquerda
		// inorder[0 .. inorder/2]
		node.left 	= build(ino, pre, sIno, idx-1, sPre+1, sPre+(idx-sIno));
		// inorder[inorder/2+1 .. // inorder-1]
		node.right 	= build(ino, pre, idx+1, eIno, sPre+(idx-sIno)+1, ePre);
		return node;
	}
	
	public static void main(String[] args) throws IOException {
		buffer = new BufferedReader(new InputStreamReader(System.in));
		writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		
		try {
			String enter = buffer.readLine();
			int tests = Integer.parseInt(enter);
			StringTokenizer token;
			while(tests > 0) {
				enter = buffer.readLine();
				String [] values = new String[2];
				token = new StringTokenizer(enter, " ");
				int node = Integer.parseInt(token.nextToken());
				values[0] = token.nextToken();
				values[1] = token.nextToken();
				char [] pre = values[0].toCharArray();
				char [] ino = values[1].toCharArray();
				SPOJ1856.Tree root = build(ino, pre, 0, ino.length-1, 0, pre.length-1);
				postOrder(root);
				writer.printf("\n");
				tests--;
			}
		} catch(IOException ioex){}
		
	}

}
