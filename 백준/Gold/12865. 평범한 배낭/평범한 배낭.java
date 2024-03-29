
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N, K;
	static int[][] products, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		products = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			products[i][0] = Integer.parseInt(st.nextToken());
			products[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N+1][K+1];
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<K+1;j++) {
				if(products[i-1][0] > j) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(products[i-1][1] + dp[i-1][j-products[i-1][0]], dp[i-1][j]);
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}
