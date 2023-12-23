import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, a[], X, ret;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		a = new int[N];
		StringTokenizer  st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)a[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(a);
		X = Integer.parseInt(br.readLine());
		
		int le = 0;
		int ri = N-1;
		
		while(le < ri) {
			int sum = a[le]+a[ri];
			if(sum > X)ri--;
			else if(sum < X)le++;
			else {
				ret++;
				ri--;
			}
			
		}
		
		System.out.println(ret);
	}

}