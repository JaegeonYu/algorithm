import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, a[];
	static long dp[][];
	static long ret;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new int[N];
		dp = new long[N][21];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)a[i] = Integer.parseInt(st.nextToken());
		
		
		System.out.println(dfs(0, a[0]));
	}
	private static long dfs(int depth, int sum) {
		if(sum < 0 || sum > 20)return 0 ;
		if(dp[depth][sum] > 0)return dp[depth][sum];
		if(depth == N-2) {
			if(sum == a[N-1]) {
				return 1;
			}
			return 0 ;
		}
		
		dp[depth][sum] += dfs(depth+1, sum + a[depth+1]);
		dp[depth][sum] += dfs(depth+1, sum - a[depth+1]);
		return dp[depth][sum];
		
	}

}