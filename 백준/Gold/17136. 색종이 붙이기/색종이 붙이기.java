import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int a[][], ret = Integer.MAX_VALUE;
	static boolean vis[][], flag = true;
	static int paper[] = {0, 5, 5, 5, 5, 5};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		a = new int[10][10];
		
		for(int i=0;i<10;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0,0);
		if(ret == Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(ret);
		
	}
	private static void dfs(int y, int x, int cnt) {
		if(y == 9 && x > 9) {
			ret = Math.min(cnt, ret);
			return;
		}
		
		if(cnt >= ret) {
			return;
		}
		
		if(x > 9) {
			dfs(y+1, 0, cnt);
			return;
		}
		
		if(a[y][x]==1) {
			for(int i=5;i>=1;i--) {
				if(paper[i] > 0 && isAttach(y, x, i)) {
					// 붙이기
					paper[i]--;
					attach(y, x, i, 0);
					dfs(y, x+1, cnt+1);
					paper[i]++;
					attach(y, x, i, 1);
					// 떼기
				}
			}
		}else {
			dfs(y, x+1, cnt);
		}
	}
	private static void attach(int y, int x, int k, int stamp) {
		for(int i=y;i<y+k;i++) {
			for(int j=x;j<x+k;j++) {
				a[i][j] =stamp;
			}
		}
		
	}
	private static boolean isAttach(int y, int x, int k) {
		for(int i=y;i<y+k;i++) {
			for(int j=x;j<x+k;j++) {
				if(i >= 10 || j >= 10 || a[i][j] == 0)return false;
			}
		}
		return true;
	}

	
}