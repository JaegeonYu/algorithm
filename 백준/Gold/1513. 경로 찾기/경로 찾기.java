import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, C, a[][], dp[][][][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		a = new int[N][M];
		for(int i=1;i<=C;i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			a[y][x] = i;
		}
		
		dp = new int[N][M][C+1][C+1];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				for(int k=0;k<=C;k++)Arrays.fill(dp[i][j][k], -1);
			}
		}
		
		for(int i=0;i<=C;i++) {
			System.out.print(go(0, 0, i, 0)+" ");
		}
	}
	private static int go(int y, int x, int cnt, int prev) {
		if(y >= N || x >= M || cnt == -1) return 0;
		if(y == N-1 && x == M-1) {
			if(cnt == 0 && a[y][x] == 0)return 1;
			if(cnt == 1 && a[y][x] > prev) return 1;
			return 0;
		}
//		System.out.println(y + " " + x + " " + cnt + " " + prev);
		int ret = dp[y][x][cnt][prev];
		if(ret != -1)return ret;
		
		ret = 0;
		if(a[y][x] == 0) {
			ret = (go(y+1, x, cnt, prev)+ go(y, x+1, cnt, prev)) % 1000007;
		}else if(a[y][x] > prev) {
			ret = (go(y+1, x, cnt-1, a[y][x]) + go(y, x+1, cnt-1, a[y][x])) % 1000007;
		}
		
		dp[y][x][cnt][prev] = ret;
		return ret;
	}

}