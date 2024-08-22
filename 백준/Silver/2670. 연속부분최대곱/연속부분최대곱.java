import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static double a[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new double[N];
		
		for(int i=0;i<N;i++)a[i] = Double.parseDouble(br.readLine());
		
		double temp = a[0];
		double ret = 0;
		for(int i=1;i<N;i++) {
			if(temp * a[i] > a[i]) {
				temp *= a[i];
			}else temp = a[i];
			ret = Math.max(ret, temp);
		}
		
		System.out.printf("%.3f", ret);

	}

}