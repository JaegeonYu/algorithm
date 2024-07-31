import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, K, a[][];
	static List<Integer> map[][];
	static int[] dy = {0,0,-1,1};
	static int[] dx = {1,-1,0,0};
	static List<Horse> horses = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		a = new int[N][N];
		map = new ArrayList[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken())-1;
			map[y][x].add(i);
			horses.add(new Horse(y, x, dir));
		}
		
		int cnt = 0;
		boolean finish = false;
		while(true) {
			
			for(int i=0;i<horses.size();i++) {
				int y = horses.get(i).y;
				int x = horses.get(i).x;
				int dir = horses.get(i).dir;
				move(y, x, dir, i);
				if(isOver()) {
					finish=true;
					break;
				}
			}
			cnt++;
			if(cnt == 1000)break;
			if(finish)break;
		}
		
		if(finish)System.out.println(cnt);
		else System.out.println(-1);
	}
	
	private static void move(int y, int x, int dir, int i) {
		int ny = y +dy[dir];
		int nx = x+dx[dir];
		if(nx <0 || nx >= N || ny < 0 || ny >= N || a[ny][nx] ==2) {
			horses.get(i).dir = reverse(dir);
			ny = y+dy[horses.get(i).dir];
			nx = x+dx[horses.get(i).dir];
			if(nx <0 || nx >= N || ny < 0 || ny >= N || a[ny][nx] ==2)return;
		}
		
		int pos = map[y][x].indexOf(Integer.valueOf(i));
		if(a[ny][nx] == 1)Collections.reverse(map[y][x].subList(pos, map[y][x].size()));
		for(int j = pos; j<map[y][x].size();j++) {
			horses.get(map[y][x].get(j)).y = ny;
			horses.get(map[y][x].get(j)).x = nx;
			map[ny][nx].add(map[y][x].get(j));
		}
		while(map[y][x].size() > pos) {
			map[y][x].remove(map[y][x].size()-1);
		}
		
	}

	private static int reverse(int dir) {
		return dir^1;
	}

	private static boolean isOver() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j].size()>=4)return true;
			}
		}
		return false;
	}

	static class Horse{
		int y;
		int x;
		int dir;
		Horse(int y, int x ,int dir){
			this.y=y;
			this.x=x;
			this.dir =dir;
		}
		
		boolean check(int y, int x) {
			return y == this.y && x == this.x;
		}
	}
}