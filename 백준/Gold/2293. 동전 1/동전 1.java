import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K, dp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[K+1];
		
		dp[0] = 1;
		for(int i=0;i<N;i++) {
			int now = Integer.parseInt(br.readLine());
			for(int j=now;j<=K;j++) {
				dp[j] += dp[j-now];
			}
		
		}
		
		System.out.println(dp[K]);
	}

}