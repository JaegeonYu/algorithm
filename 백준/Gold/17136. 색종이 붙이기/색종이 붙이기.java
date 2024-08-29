import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map = new int[10][10];
	static int paper[] = {0,5,5,5,5,5};
	static int ret = Integer.MAX_VALUE;
	static boolean vis[][] = new boolean[10][10];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<10;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, 0);
		System.out.println(ret != Integer.MAX_VALUE ? ret : -1);
		
	}

	private static void dfs(int y, int x, int cnt) {
		if(cnt >= ret)return;

		
		if(x == 10) {
			dfs(y+1, 0, cnt);
			return;
		}
		
		if(y == 10) {
			ret = Math.min(ret, cnt);
			return;
		}
		if(map[y][x] == 0) {
			dfs(y, x+1, cnt);
			return;
		}

		
		for(int i=5;i>=1;i--) {
			if(paper[i] == 0)continue;
			if(!check(y, x, i))continue;
			paper(y, x, i, 0);
			paper[i]--;
			// dfs
			dfs(y, x+1, cnt+1);
			paper[i]++;
			// vis uncheck
			paper(y, x, i, 1);
		}
		
	}

	private static void paper(int y, int x, int cnt, int value) {
		for(int i=y;i<y+cnt;i++) {
			for(int j=x;j<x+cnt;j++) {
				map[i][j] = value;
			}
		}
	}

	private static boolean check(int y, int x, int cnt) {
		if(y+cnt > 10 || x+cnt > 10)return false;
		for(int i=y;i<y+cnt;i++) {
			for(int j=x;j<x+cnt;j++) {
				if(map[i][j] == 0)return false;
			}
		}
		
		return true;
		
	}

}