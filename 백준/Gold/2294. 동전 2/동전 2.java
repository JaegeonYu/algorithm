import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, K, dp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dp = new int[100004];
		Arrays.fill(dp, 100004);
		for(int i=0;i<N;i++) {
			int now  = Integer.parseInt(br.readLine());
			dp[now] = 1;
			for(int j=now;j<=K;j++) {
				dp[j] = Math.min(dp[j], dp[j-now]+1);
			}
		}
//		System.out.println(Arrays.toString(dp));
		if(dp[K] == 100004)System.out.println(-1);
		else System.out.println(dp[K]);
		
	}

}