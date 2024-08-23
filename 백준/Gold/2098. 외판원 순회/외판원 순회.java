import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int MAX_N = 16;
	static int INF = 987654321;
	static int N, a[][], dp[][] = new int[MAX_N][1 << MAX_N];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i=0;i<N;i++)Arrays.fill(dp[i], -1);
		
		System.out.println(tsp(0, 1));
		
		
	}
	private static int tsp(int here, int visited) {
		if(visited == (1 << N) - 1) {
			return a[here][0] != 0? a[here][0] : INF;
		}
		
		if(dp[here][visited] != -1) {
			return dp[here][visited];
		}
		
		dp[here][visited] = INF;
		for(int i=0;i<N;i++) {
			if((visited & ( 1<< i)) != 0)continue;
			if(a[here][i] == 0)continue;
			
			dp[here][visited] = Math.min(dp[here][visited], tsp(i, visited | (1 << i))+a[here][i]);
		}
		return dp[here][visited];
	}

}