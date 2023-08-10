import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, a[][], vis[][], ret = -1;
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a= new int[N][M];
		vis = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			for(int j=0;j<M;j++) {
				a[i][j] = tmp.charAt(j)-48;
			}
		}
		
		bfs(0,0);

		System.out.println(ret);
	}
	private static void bfs(int y, int x) {
		vis[y][x] = 1;
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(y, x, true, 1));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			if(now.x == M-1 && now.y == N-1) {
				ret = now.pos;
				break;
			}
			
			for(int i=0;i<4;i++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];
				if(nx <0 || nx >= M || ny <0 || ny >= N)continue;
				if(vis[ny][nx]==0) {
					if(a[ny][nx] == 1 && now.wall) {
						vis[ny][nx] = 1;
						q.offer(new Point(ny, nx, false, now.pos+1));
					}else if(a[ny][nx]==0) {
						vis[ny][nx] = 1;
						q.offer(new Point(ny, nx, now.wall, now.pos+1));
					}
					
				}else if(vis[ny][nx]==1 && now.wall) {
					if(a[ny][nx] == 2 && now.wall) {
						vis[ny][nx] = 2;
						q.offer(new Point(ny, nx, false, now.pos+1));
					}else if(a[ny][nx]==0) {
						vis[ny][nx] = 2;
						q.offer(new Point(ny, nx, now.wall, now.pos+1));
					}
				}
			}
		}
		
	}
	
	static class Point{
		int y;
		int x;
		boolean wall;
		int pos;
		
		Point(int y, int x, boolean wall, int pos){
			this.y=y;
			this.x=x;
			this.wall = wall;
			this.pos = pos;
		}
	}
}