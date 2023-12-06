import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, a[][], vis[][];
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		a = new int[N][M];
		vis = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			for(int j=0;j<M;j++) {
				a[i][j] = tmp.charAt(j)-'0';
			}
		}
		
		
		vis[0][0] = 1;
		System.out.println(bfs(0,0));
		

		

	}
	private static int bfs(int y, int x) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {y,x});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i=0;i<4;i++) {
				int ny = now[0]+dy[i];
				int nx = now[1]+dx[i];
				if(ny == N-1 && nx == M-1) {
					return vis[now[0]][now[1]]+1;
				}
				if(nx <0 || nx >= M || ny <0 || ny >= N || vis[ny][nx] != 0 || a[ny][nx] == 0)continue;
				vis[ny][nx] = vis[now[0]][now[1]]+1;
				q.offer(new int[] {ny, nx});
			}
		}
		return 0;
	}

}