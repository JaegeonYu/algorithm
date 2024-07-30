import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int a[][], ret = Integer.MAX_VALUE;
	static int[] paper = {0,5,5,5,5,5};
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	a = new int[10][10];
	for(int i=0;i<10;i++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int j=0;j<10;j++) {
			a[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
	dfs(0, 0, 0);
	
	System.out.println(ret == Integer.MAX_VALUE? -1 : ret);
	}
	private static void dfs(int y, int x, int cnt) {
		if(cnt >= ret)return;
		
		if(x == 10) {
			dfs(y+1, 0 , cnt);
			return;
		}
		if(y == 10) {
			ret = Math.min(ret, cnt);
			return;
		}
		
		if(a[y][x] == 0) {
			dfs(y, x+1, cnt);
			return;
		}
		
		for(int i=5;i>=1;i--) {
			if(paper[i] == 0)continue;
			if(!canAttach(y, x, i))continue;
			isAttach(y, x, i,0);
			paper[i]--;
			dfs(y, x+i, cnt+1);
			paper[i]++;
			isAttach(y, x, i,1);
		}
	}
	
	private static void isAttach(int y, int x, int paper, int num) {
		for(int i=y;i<y+paper;i++) {
			for(int j=x;j<x+paper;j++) {
				a[i][j] = num;
			}
		}
	}
	
	private static boolean canAttach(int y, int x, int paper) {
		if(y+paper > 10 || x+paper > 10)return false;
		
		for(int i=y;i<y+paper;i++) {
			for(int j=x;j<x+paper;j++) {
				if(a[i][j]==0)return false;
			}
		}
		
		return true;
	}
}