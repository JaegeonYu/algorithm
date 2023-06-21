import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static double a[], ret=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		a = new double[n];
		for(int i=0;i<n;i++) {
			a[i] = Double.parseDouble(bf.readLine());
		}
		double b = a[0];
		for(int i=1;i<n;i++) {
			if(a[i] > b * a[i]) b = a[i];
			else b *= a[i];
			ret = Math.max(b, ret);
		}
		
		System.out.printf("%.3f", ret);
	}



}
