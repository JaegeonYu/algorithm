import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, w[][], dp[][], ret = Integer.MAX_VALUE;
	static boolean vis[];
	 private static final int INF = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		vis = new boolean[N];
		w = new int[N][N];
		dp = new int[N][1 << N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			
			}
		}
		
		for(int i=0;i<N;i++)Arrays.fill(dp[i], -1);
	
		System.out.println(tsp(0, 1));
	}
	private static int tsp(int here, int visited) {
		if(visited == (1 << N) -1) {
			return w[here][0] != 0 ? w[here][0] : INF;
		}
		
		if(dp[here][visited] != -1)return dp[here][visited];
		
		dp[here][visited] =  INF;
		for(int i=0;i<N;i++) {
			if((visited & (1<< i)) != 0)continue;
			if(w[here][i] == 0)continue;
			dp[here][visited] = Math.min(dp[here][visited], tsp(i, visited | (1<<i)) + w[here][i]);
		}
		return dp[here][visited];
	}


}