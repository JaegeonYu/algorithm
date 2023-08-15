import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {	
	static int N, r, c, ret = 0, solve;
	static int dy[] = {0,0,1,1};
	static int dx[] = {0,1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int m = (int)Math.pow(2, N);
		dfs(0,0, m);
		
		System.out.println(solve);
		
	}
	private static void dfs(int y, int x, int size) {
		if(solve != 0)return;
		if(size == 4) {
			if(Math.abs(r-y)>=4) {
				ret += 16;
				return;
			}
		}
		
		if(size == 4) {
			if(Math.abs(c-x)>=4) {
				ret += 16;
				return;
			}
		}
		
		if(size == 8) {
			if(Math.abs(r-y)>=8) {
				ret += 64;
				return;
			}
		}
		
		if(size == 8) {
			if(Math.abs(c-x)>=8) {
				ret += 64;
				return;
			}
		}
		
		if(size == 2) {
			for(int i=0;i<4;i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				ret++;
				if(ny == r && nx == c) {
					solve = ret-1;
					return;
				}
			}
			return;
		}
		
	
		
		dfs(y,x , size/2);
		dfs(y, x+size/2, size/2);
		dfs(y+size/2, x, size/2);
		dfs(y+size/2, x+size/2, size/2);
		
	}

}