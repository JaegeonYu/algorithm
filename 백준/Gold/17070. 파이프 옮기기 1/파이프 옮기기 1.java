import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, a[][], vis[][], ret, pos;
	static int dx[] = {1,0,1};
	static int dy[] = {0,1,1};
	static Point last;
	static Deque<Point> dq = new ArrayDeque<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		a = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		vis = new int[N][N];
		vis[0][0] = 1;
		vis[0][1] = 1;
		last = new Point(0,0);
		dq.offer(new Point(0, 0));
		dq.offer(new Point(0,1));
		pos = 0;
		dfs(0,1);
		
//		vis = new int[N][N];
//		vis[0][0] = 1;
//		vis[0][1] = 1;
//		last = new Point(0,0);
//		dq.offer(new Point(0, 0));
//		dq.offer(new Point(0,1));
//		pos = 0;
//		bfs(0,1);
		System.out.println(ret);
	}

	private static void bfs(int y, int x) {
		
		
		
	}

	private static void dfs(int y, int x) {
		if(y == N-1 && x == N-1) {
			ret++;
			return;
		}
		
		for(int i=0;i<3;i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny <0 || ny >= N || nx < 0 || nx >= N || a[ny][nx] == 1)continue;

			if(pos == 0) {
				if(i==1)continue;
				else if(i==0) {
					move(y, x, ny, nx, pos, i);
				}else {
					if(!checkDae(y, x))continue;
					move(y, x, ny, nx, pos, i);
				}
			}else if(pos == 1) {
				if(i==0)continue;
				else if(i==1) {
					move(y, x, ny, nx, pos, i);
				}else {
					if(!checkDae(y, x))continue;
					move(y, x, ny, nx, pos, i);
				}
			}else if(pos == 2){
				if(i==0) {
					move(y, x, ny, nx, pos, i);
				}
				else if(i==1) {
					move(y, x, ny, nx, pos, i);
				}else {
					if(!checkDae(y, x))continue;
					move(y, x, ny, nx, pos, i);
				}
			}
		}	
	}
	private static boolean checkDae(int y, int x) {
		for(int i=0;i<3;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			if(ny <0 || ny >= N || nx < 0 || nx >= N || a[ny][nx]==1)return false;
		}
		return true;
	}

	private static void move(int y, int x , int ny, int nx, int prev, int next) {
//		vis[last.y][last.x] = 0;
//		Point temp = new Point(last.y, last.x);
//		last = new Point(y, x);
//		vis[ny][nx] = 1;
//		pos = next;
//		dfs(ny, nx);
//		pos = prev;
//		vis[ny][nx] = 0 ;
//		vis[temp.y][temp.x] = 1;
//		last = new Point(temp.y, temp.x);
		
		
		
//		vis[dq.peekFirst().y][dq.peekFirst().x] = 0;
//		dq.offer(new Point(ny, nx));
//		vis[ny][nx] = 1;
		pos = next;
//		print();
		dfs(ny, nx);
//		dq.pollLast();
		pos = prev;
//		vis[ny][nx] = 0 ;
//		vis[dq.peekFirst().y][dq.peekFirst().x] = 1;
	}	
	static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)System.out.print(vis[i][j]+" ");
			System.out.println();
		}
		System.out.println("====================="); 
	
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