
public class TutorialStrings {

	
	public static String testReplace(String str, char p, char q) {
		str =  str.replace(p, q);// new String (str.replace(p, q));
		return str;
	}
	
	public static String testReplace(String str, char q, int pos) {
		return str.length() < pos ? str : str.replace(str.charAt(pos), q);
	}
	
	// dominio [s, length str]
	public static String testSubstring(String str, int s, int e) {
		return str.substring(s, e); //s > -1 && e < str.length()+1 ? str.substring(s, e) : str;
	}
	// dominio [s, e)
	public static String testSubstring(String str, int s) {
		return s < str.length() && s > -1 ? str.substring(s) : str;
	}
	
	public static String changeChar(String str, char q, int pos) {
		return str.replace(str.substring(pos, pos+1).charAt(0), q);
	}
	
	public static void testConcat() {
		String test = "rkkr";
		long s = System.currentTimeMillis();
		int limit = 100000;
		for(int i=0; i<limit; i++)
			test += "1010";
		System.out.printf("%d Length %d\n", System.currentTimeMillis() - s, test.length());
		test = "rkkr";
		s = System.currentTimeMillis();
		for(int i=0; i<limit; i++)
			test = test.concat("1010");
		System.out.printf("%d Length %d\n", System.currentTimeMillis() - s, test.length());
		s = System.currentTimeMillis();
		StringBuilder sbuilder = new StringBuilder("rkkr");
		for(int i=0; i<limit; i++)
			sbuilder.append("1010");
		System.out.printf("%d Length %d\n", System.currentTimeMillis() - s, sbuilder.length());
		s = System.currentTimeMillis();
		StringBuffer sbuffer = new StringBuffer("rkkr");
		for(int i=0; i<limit; i++)
			sbuffer.append("1010");
		System.out.printf("%d Length %d\n", System.currentTimeMillis() - s, sbuffer.length());
		return;
	}
	// retorna o indice da primeira ocorrencia de um char ou String dentro da String, ou -1
	public static int testIndexOf(String str, char ch) { return str.indexOf(ch); }
	public static int testIndexOf(String str, char ch, int startSearch) { return str.indexOf(ch, startSearch); }
	
	public static void main(String[] args) {
		
		String test = "Christoffer";
		/*
		test = testReplace(test, 'k', 'r');
		System.out.println(test);
		test = testReplace(test, 'k', 3);
		System.out.println(test);
		testConcat();
		System.out.println(testSubstring(test, 1));
		System.out.println(testSubstring(test, 1, 2));
		System.out.println(changeChar(test, 'f', 6));
		*/
		System.out.println(testIndexOf(test, 'f'));
		System.out.println(testIndexOf(test, 'f', 10));
	}

}
