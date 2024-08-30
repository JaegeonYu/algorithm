import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, K, map[][];
	static List<Integer>[][] adj;
	static List<Horse> horses = new ArrayList<>();
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,-1,1};
	static class Horse{
		int y;
		int x;
		int dir;

		public Horse(int y, int x, int dir) {
			super();
			this.y= y;
			this.x=x;
			this.dir = dir;
		}
		
		void reverse(){
			if(dir == 0)dir = 1;
			else if(dir == 1)dir = 0;
			else if(dir ==2)dir =3;
			else if(dir ==3)dir = 2;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		adj = new ArrayList[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				adj[i][j] = new ArrayList<>();
			}
		}
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken())-1;
			horses.add(new Horse(y, x, dir));
			adj[y][x].add(i);
		}
		
		int ret = 0;
		boolean finish =false;
		while(true) {
			for(int i=0;i<horses.size();i++) {
				int y = horses.get(i).y;
				int x = horses.get(i).x;
				int dir = horses.get(i).dir;
				move(y, x, dir, i);
				if(isOver()) {
					finish = true;
					break;
				}
			}
			ret++;
			if(ret == 1000)break;
			if(finish)break;
		}
		
		if(finish)System.out.println(ret);
		else System.out.println(-1);
	}
	private static boolean isOver() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(adj[i][j].size()>=4)return true;
			}
		}
		return false;
	}
	private static void move(int y, int x, int dir, int i) {
		int ny = y+dy[dir];
		int nx = x+dx[dir];
		if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[ny][nx] == 2) {
			horses.get(i).reverse();
			ny = y+dy[horses.get(i).dir];
			nx = x+dx[horses.get(i).dir];
			if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[ny][nx] == 2)return;
		}
		
		int pos = adj[y][x].indexOf(Integer.valueOf(i));
		if(map[ny][nx] == 1)Collections.reverse(adj[y][x].subList(pos, adj[y][x].size()));
		for(int j=pos;j<adj[y][x].size();j++) {
			
			horses.get(adj[y][x].get(j)).y = ny;
			horses.get(adj[y][x].get(j)).x = nx;
			adj[ny][nx].add(adj[y][x].get(j));
		}
		while(adj[y][x].size() > pos) {
			adj[y][x].remove(adj[y][x].size()-1);
		}
		
	}
	private static int reverse(int dir) {
		return dir^1;
	}

}