import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		long f, n;
		long [] arr = new long[1000001];
		arr[0] = 1;
		n = 1;
		for(int i=1; i<1000001; i++) {
			n *= i;
			while(n%10 == 0) {
				n /= 10;
			}
			n%=1000000000;
			arr[i] = n % 10;
		}
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		String str;
		int instancia = 1;
		while((str = buffer.readLine()) != null) {
			int x = Integer.parseInt(str);
			System.out.println("Instancia "+instancia+"\n"+arr[x]);
			instancia++;
		}
	}
}