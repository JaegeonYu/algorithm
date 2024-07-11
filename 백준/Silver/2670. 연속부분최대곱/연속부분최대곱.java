import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static double a[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new double[N];
		
		
		for(int i=0;i<N;i++) {
			a[i] = Double.parseDouble(br.readLine());
		}
		double b = a[0];
		
		double ret = 0;
		for(int i=1;i<N;i++) {
			if(a[i] * b > a[i])b *= a[i];
			else b = a[i];
			ret = Math.max(ret, b);
			
		}
		System.out.printf("%.3f", ret);
	}

}