import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, K, dp[];
	static Set<Integer> set = new HashSet<>();
	public static void main(String[] args) throws IOException {BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[K+1];
		
		Arrays.fill(dp, 987654321);
		dp[0] = 0;
		for(int i=0;i<N;i++) {
			int now = Integer.parseInt(br.readLine());
			for(int j=now;j<=K;j++) {
				dp[j] = Math.min(dp[j], dp[j-now]+1);
			}
		}
		
		if(dp[K] == 987654321)System.out.println(-1);
		else System.out.println(dp[K]);

	}

}