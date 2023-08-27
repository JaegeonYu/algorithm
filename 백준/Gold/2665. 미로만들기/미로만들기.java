import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, a[][], vis[][];
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		a = new int[N][N];
		vis = new int[N][N];
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			for(int j=0;j<N;j++) {
				a[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		for(int i=0;i<N;i++) {
			Arrays.fill(vis[i], Integer.MAX_VALUE);
		}
		
		bfs(0,0);
		System.out.println(vis[N-1][N-1]);

	}
	private static void bfs(int y, int x) {
		
		vis[y][x] = 0;
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(y, x));
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int i=0;i<4;i++) {
				int ny = now.y+dy[i];
				int nx = now.x+dx[i];
				if(nx <0 || nx >= N || ny <0 || ny >= N)continue;
				if(vis[ny][nx] > vis[now.y][now.x]) {
					if(a[ny][nx]==1) {
						vis[ny][nx] = vis[now.y][now.x];
					}else vis[ny][nx] = vis[now.y][now.x]+1;
					q.offer(new Point(ny, nx));
				}
			}
		}
		
	}
	
	static class Point{
		int y;
		int x;
		Point(int y, int x){
			this.y=y;
			this.x=x;
		}
	}

}