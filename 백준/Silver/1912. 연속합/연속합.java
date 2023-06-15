
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, a[], sum, ret = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		a = new int[n+1];
	
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=1;i<=n;i++) {
			a[i] = Integer.parseInt(st.nextToken());
			sum += a[i];
			ret = Math.max(ret, sum);
			if(sum <0) sum = 0;
		}

		System.out.println(ret);
	}

}
