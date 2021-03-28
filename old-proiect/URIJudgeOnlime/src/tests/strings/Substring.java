package tests.strings;

import java.io.PrintWriter;
import java.util.Stack;

public class Substring {
	static final PrintWriter out = new PrintWriter(System.out, true);
	// existem 2 ^ n substrings de uma string M
	public static void allSubstr(String str) {
		int n = str.length();
		char[] ch = new char[n];
		for(int i=1; i<1<<n; i++) {
			int idx = 0;
			for(int j=0; j<n; j++) {
				if( (i & (1<<j)) != 0) {
					ch[idx++] = str.charAt(j);
				}
			}
			//ch[idx] = '\0';
			out.printf("%s\n", new String(ch, 0, idx));
		}
	}
	
	public static int LCSBruteForce(String a, String b) {
		int n = a.length();
		char[] ch = new char[n];
		int max = 0;
		String ans = "";
		for(int i=1; i< 1<<n; i++) {
			int idx = 0, count = 0;
			for(int j=0; j<n; j++) {
				if( (i & (1<<j)) != 0)
					ch[idx++] = a.charAt(j);
			}
			String sub = new String(ch, 0, idx);
			
			for(int j=0; j<b.length() && count<sub.length(); j++) {
				if(b.charAt(j) == sub.charAt(count))
					count++;
			}
			if(count>max) {
				max = count;
				ans = sub;
			}
		}
		out.println(ans);
		return max;
	}
	
	public static int[][] LCS(String A, String B) {
		return null;
	}
	//marathoncode
	public static int[][] PDLCS(String A, String B) {
		int max = 0, i, j;
		int la = A.length(), lb = B.length();
		int ans[][] = new int[la+1][lb+1];
		for(i=0; i<=la; i++)
			ans[i][0] = 0;
		for(j=0; j<=lb; j++)
			ans[0][j] = 0;
		for(i=1; i<=la; i++) {
			for(j=1; j<=lb; j++) {
				if(A.charAt(i-1) == B.charAt(j-1)) {
					ans[i][j] = ans[i-1][j-1] + 1;
				}
				else
					ans[i][j] = ans[i-1][j] > ans[i][j-1] ? ans[i-1][j] : ans[i][j-1];
			}
			if(max < ans[i-1][j-1]) {
				max = ans[i-1][j-1];
			}
		}
		return ans;
	}
	
	public static int[][] subProblemLCS(String s1, String s2) {
		return null;
	}
	
	public static String getString(String A, String B, int[][] mat) {
		Stack<Character> stack = new Stack<>();
		int s1 = A.length(), s2 = B.length(), i = s1, j = s2;
		while(i>0 && j>0) {
			char a = A.charAt(i-1), b = B.charAt(j-1);
			// se os caracteres forem iguals adicione o caracter a pilha
			if(a == b) {
				stack.push(a);
				j--;	// remove o ultimo caracter se S2
				i--;	// idem S1
				// assim passamos a analisar o subproblema LCS(s1[i-1], s2[j-1])
			}
			// Se o (i-1)-esimo caracter de S1 estiver mais vezes na LCS do que o (j-1)esimo
			else if(mat[i-1][j] > mat[i][j-1])
				i--;
			else
				j--;
		}
		char ans[] = new char[stack.size()];
		i=0;
		while(!stack.empty()) {
			ans[i++] = stack.pop();
		}
		return new String(ans);
	}

	public static void main(String[] args) {
		String A = "ABCBDAB", B = "BDCABA";
		A = "BDCABA"; B = "ABCBDAB";
		/*
		 * A = "ABCB"; B = "BDCAB";
		 *	A = "AB"; B = "BD";
			A = "abcdefghijklmnzyxwvutsrqpo"; B = "opqrstuvwxyzabcdefghijklmn";
			A = "ABCBD"; B = "BD";
			A = "abcdefghijklmnopqrstuvwxyz"; B = "a0b0c0d0e0f0g0h0i0j0k0l0m0n0o0p0q0r0s0t0u0v0w0x0y0z0";
		*/
		//allSubstr("BCBD");
		//out.println(LCSBruteForce(A, B));
		int ans[][] = PDLCS(A, B);
		out.printf("%d %s", ans[A.length()][B.length()], getString(A, B, ans));
	}

}
