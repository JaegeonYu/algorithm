import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, a[][], dp[][], ret;
	static boolean vis[][];
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		a = new int[N][M];
		dp = new int[N][M];
		
		vis = new boolean[N][M];
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			for(int j=0;j<M;j++) {
				char now = tmp.charAt(j);
				if(now == 'H')a[i][j] = -1;
				else a[i][j] = now - '0';
			}
		}
		
		System.out.println(dfs(0, 0));
		
//		for(int i=0;i<N;i++)System.out.println(Arrays.toString(dp[i]));
	}
	private static int dfs(int y, int x) {
		
		if(!in(y, x) || a[y][x] == -1)return 0;
		if(vis[y][x]) {
			System.out.println(-1);
			System.exit(0);
		}
		
		if(dp[y][x] > 0)return dp[y][x];
		
		vis[y][x] = true;
		int value = a[y][x];
		for(int i=0;i<4;i++) {
			int ny = y+dy[i]*value;
			int nx = x+dx[i]*value;
			dp[y][x] = Math.max(dp[y][x], dfs(ny, nx)+1);
		}
		vis[y][x] =false;
		
		return dp[y][x];
		
	}
	private static boolean in(int y, int x) {
		return y >= 0 && y < N && x >=0 && x <M;
	}

}