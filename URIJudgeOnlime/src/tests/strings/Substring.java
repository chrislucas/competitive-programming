package tests.strings;

import java.io.PrintWriter;

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
				//out.println(sub);
			}
		}
		out.println(ans);
		return max;
	}
	
	public static int PDLCS(String A, String B) {
		int max = 0, i, j;
		int la = A.length(), lb = B.length();
		int ans[][] = new int[la+1][lb+1];
		for(i=0; i<=la; i++)
			ans[i][0] = 0;
		for(j=0; j<=lb; j++)
			ans[0][j] = 0;
		
		for(i=1; i<=la; i++) {
			String s = "";
			for(j=1; j<=lb; j++) {
				if(A.charAt(i-1) == B.charAt(j-1)) {
					ans[i][j] = ans[i-1][j-1] + 1;
					s = s.concat(Character.toString(A.charAt(i-1)));
				}
				else
					ans[i][j] = ans[i-1][j] > ans[i][j-1] ? ans[i-1][j] : ans[i][j-1];
			}
			if(max < ans[i-1][j-1]) {
				max = ans[i-1][j-1];
				out.println(s);
			}
		}
		
		return ans[la-1][lb-1];
	}

	public static void main(String[] args) {
		//allSubstr("BCBD");
		//out.println(LCSBruteForce("ABCBDAB", "BDCABA"));
		out.println(PDLCS("ABCBDAB", "BDCABA"));
	}

}
