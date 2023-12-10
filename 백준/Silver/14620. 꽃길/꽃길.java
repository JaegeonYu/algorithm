import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, a[][], ret = Integer.MAX_VALUE;
	static boolean vis[][];
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		a = new int[N][N];
		vis = new boolean[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		System.out.println(ret);
		
	}
	private static void dfs(int cnt, int sum) {
		if(cnt == 3) {
			ret = Math.min(ret, sum);
			return;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(checkFlower(i, j)) {
					// flower 체크
					int now = seedFlower(i, j);
					dfs(cnt+1, sum + now);
					// flower 체크 해제
					flowerCut(i, j);
				}
			}
		}
		
	}
	private static void flowerCut(int y, int x) {
		vis[y][x] = false;
		for(int i=0;i<4;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			vis[ny][nx] = false;
		}
	}
	private static int seedFlower(int y, int x) {
		int sum = a[y][x];
		vis[y][x] = true;
		for(int i=0;i<4;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			sum += a[ny][nx];
			vis[ny][nx] = true;
		}
		return sum;
	}
	private static boolean checkFlower(int y, int x) {
		if(vis[y][x])return false;
		for(int i=0;i<4;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			if(nx < 0 || nx >= N || ny <0 || ny >= N || vis[ny][nx])return false;
		}
		
		return true;
	}

}