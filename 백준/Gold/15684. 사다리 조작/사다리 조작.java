import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M, H, ret = Integer.MAX_VALUE;
	static boolean vis[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		vis = new boolean[H+1][N+2];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			vis[y][x] = true;
		}
		
		go(1,0);
		if(ret == Integer.MAX_VALUE)bw.write(String.valueOf(-1));
		else bw.write(String.valueOf(ret));
		
		bw.flush();
		bw.close();

	}
	private static void go(int here, int cnt) {
		if(cnt > 3 || ret <= cnt)return;
		if(check()) {
			ret = Math.min(ret, cnt);
			return;
		}
		
		for(int i=here;i<=H;i++) {
			for(int j=1;j<=N;j++) {
				if(vis[i][j] || vis[i][j-1] || vis[i][j+1])continue;
				vis[i][j] = true;
				go(i, cnt+1);
				vis[i][j] = false;
			}
		}
		
	}
	private static boolean check() {
		for(int i=1;i<=N;i++) {
			int start = i;
			for(int j=1;j<=H;j++) {
				if(vis[j][start])start++;
				else if(vis[j][start-1])start--;
			}
			if(start != i)return false;
		}
		return true;
	}

}