import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, a[][], vis[][], res;
	static int dx[]= {1,-1,0,0};
	static int dy[]= {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     
	     StringTokenizer st = new StringTokenizer(br.readLine());
	     N = Integer.parseInt(st.nextToken());
	     M = Integer.parseInt(st.nextToken());
	     a = new int[N][M];
	     vis = new int[N][M];
	     
	     for(int i=0;i<N;i++) {
	    	 String tmp = br.readLine();
	    	 for(int j=0;j<M;j++) {
	    		 a[i][j] = (tmp.charAt(j)-'0');
	    	 }
	     }
	     
	     vis[0][0] = 1;
	     bfs();
	     System.out.println(vis[N-1][M-1]);
	     
	}

	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0,0));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int i=0;i<4;i++) {
				int ny = now.y+dy[i];
				int nx = now.x+dx[i];
				if(nx <0 || nx >= M || ny <0 || ny >= N)continue;
				if(a[ny][nx]==0 || vis[ny][nx] > 0)continue;
				vis[ny][nx] = vis[now.y][now.x]+1;
				if(ny == N-1 && nx == M-1)break;
				q.offer(new Point(nx, ny));
			}
		}
	}

}

class Point{
	int x;
	int y;
	
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}