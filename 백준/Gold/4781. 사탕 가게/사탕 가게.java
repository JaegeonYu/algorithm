import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = (int) (Float.parseFloat(st.nextToken()) * 100 +0.5);

			if(N == 0 && M == 0)break;
			dp = new int[M+1];
		
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int cal = Integer.parseInt(st.nextToken());
				int val = (int) (Float.parseFloat(st.nextToken()) * 100+0.5);
				dp[val] = Math.max(dp[val], cal);
				for(int j = val;j<=M;j++) {
					dp[j] = Math.max(dp[j], dp[j-val] + cal);
				}
			}
			System.out.println(dp[M]);
					
		}
		

	}

}