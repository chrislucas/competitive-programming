import java.io.Serializable;


public class TutorialCharSequence {
	// All Known Implementing Classes: CharBuffer, Segment, String, StringBuffer, StringBuilder
	interface ITest extends Serializable, Cloneable {
		int test();
	}
	// a classe deve ser static pois sera usada num escopo dum metodo static
	static class Test implements ITest {
		public int test() {return 0x101 & 0x100;}
	}
	
	public static void test() {
		//CharSequence cs = new String ("String implementa CharSequence");
		//System.out.println(testReplace(cs.toString(), "S", "P"));
		//System.out.println(testSubstring(cs.toString(), cs.length()-1));
		ITest t = new Test();
		System.out.println(t.test());
	}
	
	public static String testReplace(String str, CharSequence p, CharSequence q) {
		return str.replace(p.toString().charAt(0), q.toString().charAt(0));
	}
	
	public static String testSubstring(String str, int s) {
		return str.substring(s);
	}
	
	
	public static void main(String[] args) {
		test();
	}

}
