package math;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class URI1163 {
	static final InputStream in = new BufferedInputStream(System.in, 1<<16);
	static final PrintWriter out = new PrintWriter(System.out, true);
	static final BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	
	
	static void trigometric() {
		double tan = Math.tan(Math.toRadians(45));
		out.println(tan);
		// 180 = PI, angle = ? -> angle * PI / 180
		out.printf("%f, %f\n", Math.toRadians(60), 60*Math.PI/180);
		// PI = 180, radians = ? -> radisns * angle / PI
		out.printf("%f, %f\n", Math.toDegrees(Math.toRadians(60)), 180*(60*Math.PI/180)/Math.PI );
	}
	
	static double missileRange(double angle, double speed, double h) {
		double g = 9.80665, pi = 3.14159;
		double radians = angle * pi / 180.0;	// angle to radians
		double z = g * h / (speed * speed);
		double cosAlpha = Math.cos(radians);
		double sinAlpha = Math.sin(radians);
		double sin2Alpha = sinAlpha * sinAlpha;
		double c = Math.sqrt(sin2Alpha + 2.0*z) + sinAlpha;
		return ((speed * speed) / g) * c * cosAlpha;
	}
	
	static double timeFly(double angle, double speed, double h) {
		return 0.0;
	}
	
	
	public static void main(String[] args) {
		//trigometric();
		String in, enter[];
		DecimalFormat df = (DecimalFormat) NumberFormat.getCurrencyInstance(Locale.US);;
		df.applyPattern("#.#####");
		try {
			double h;
			double ini, fim;
			int tentativas;
			while( (in = reader.readLine()) != null ) {
				h = Double.parseDouble(in);
				enter = reader.readLine().split(" ");
				ini = Double.parseDouble(enter[0]);
				fim = Double.parseDouble(enter[1]);
				in = reader.readLine();
				tentativas = Integer.parseInt(in);
				while(tentativas > 0) {
					double angle, speed;
					enter = reader.readLine().split(" ");
					angle = Double.parseDouble(enter[0]);
					speed = Double.parseDouble(enter[1]);
					double alcance = missileRange(angle, speed, h);			
					out.printf("%s -> %s\n" , df.format(alcance), alcance > ini && alcance < fim ? "DUCK" :"NUCK");
					tentativas--;
				}
			}
		} catch(IOException e) {}		
	}
}
