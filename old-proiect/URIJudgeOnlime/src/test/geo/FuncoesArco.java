package test.geo;

public class FuncoesArco {
	
	/**
	 * https://en.wikipedia.org/wiki/Inverse_trigonometric_functions
	 * 
	 * atan2
	 * http://gamedev.stackexchange.com/questions/14602/what-are-atan-and-atan2-used-for-in-games
	 * 
	 * */
	
	public static void symmetric(String f) {
		for(int i=0; i<=360; i+=5) {
			if(f.equals("asin")) {
				double rSin = Math.sin( i * Math.PI / 180);
				double rASin = Math.asin(rSin);
				System.out.printf("%d %f %f\n", i, rSin, rASin * 180 / Math.PI);
			}
			else if(f.equals("acos")) {
				double rCos = Math.cos( i * Math.PI / 180);
				double rACos = Math.acos(rCos);
				System.out.printf("%d %f %f\n", i, rCos, rACos * 180 / Math.PI);
			} else if(f.equals("atan")) {
				double rTan = Math.tan( i * Math.PI / 180);
				double rATan = Math.atan(rTan);
				System.out.printf("%d %f %f\n", i, rTan, rATan * 180 / Math.PI);
			}
		}
	}

	public static void main(String[] args) {
		symmetric("atan");

	}

}
