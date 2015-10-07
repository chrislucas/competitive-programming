package string;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


// DOONE em cpp por que Java nao Passa

public class URI1239 {
	public static final InputStream in = new BufferedInputStream(System.in, 4096);
	public static final BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
	public static final PrintWriter out = new PrintWriter(System.out, true);
	
	public static void process(String str) {	
		StringTokenizer tokennizer = new StringTokenizer(str, " ");
		//StringBuilder  ans = new StringBuilder();
		int limit = tokennizer.countTokens();
		for(int i=0;i<limit; i++) {
			String token = tokennizer.nextToken();
			token = search(token);
			if(i>0)
				token = " ".concat(token);				
			System.out.print(token);
			//ans.append(token);
		}
		System.out.println("");
		//return ans.toString();
	}
	
	public static String solution(String str) {
		boolean iTag = true, bTag = true;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c == '_') {
				sb.append(iTag ? "<i>" : "</i>");
				iTag = !iTag;
			} else if (c == '*') {
				sb.append(bTag ? "<b>" : "</b>");
				bTag = !bTag;
			} else {
				sb.append(Character.toString(c));
			}
		}
		return sb.toString();
	}
	
	public static String search(String str) {
		String old = str;
		int limit = old.length();
		boolean iTag = true, bTag = true;
		char[] tag = null;
		int begin = 0;
		for(int i=0; i<limit; i++) {
			char c = old.charAt(i);
			if(c == '_') {
				if(iTag)
					tag = new char[] {'<','i','>'};
				else
					tag = new char[] {'<','/','i','>'};
				str = addTag(str, begin, begin+1, tag);
				iTag = ! iTag;
				begin += tag.length; 
			} else if(c == '*') {
				if(bTag)
					tag = new char[] {'<','b','>'};
				else
					tag = new char[] {'<','/','b','>'};
				str = addTag(str, begin, begin+1, tag);
				bTag = ! bTag;
				begin += tag.length; 
			} else {
				begin++;
			}
		}
		return str;
	}
	
	public static String addTag(String str, int inf, int sup, char[] ctag) {
		String tag = new String(ctag);
		String ans = str.substring(0, inf);
		str = str.substring(sup, str.length());
		ans = ans.concat(tag).concat(str);
		//string old = str.substring(inf, sup);
		//string ans = str.replaceFirst(old, stag);
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		String in;
		StringBuilder sb = new StringBuilder();
		while( (in = buffer.readLine()) != null)  {
			sb.append(solution(in));
		}
		out.println(sb.toString());
	}
}