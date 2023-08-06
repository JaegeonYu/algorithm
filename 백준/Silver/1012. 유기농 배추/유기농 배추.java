import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int TC, N, M, K, a[][], ret;
	static boolean vis[][];
	static int dx[]= {1,-1,0,0};
	static int dy[]= {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     
	     TC = Integer.parseInt(br.readLine());
	     for(int t=1;t<=TC;t++) {
	    	 ret = 0;
	    	 StringTokenizer st = new StringTokenizer(br.readLine());
		     M = Integer.parseInt(st.nextToken());
		     N = Integer.parseInt(st.nextToken());
		     K = Integer.parseInt(st.nextToken());
		     a = new int[N][M];
		     vis = new boolean[N][M];
		     
		     for(int i=0;i<K;i++) {
		    	 st = new StringTokenizer(br.readLine());
		    	 int x = Integer.parseInt(st.nextToken());
		    	 int y = Integer.parseInt(st.nextToken());
		    	 a[y][x] = 1;
		     }
		     
		     for(int i=0;i<N;i++) {
		    	 for(int j=0;j<M;j++) {
		    		 if(a[i][j]==1 && !vis[i][j]) {
		    			 vis[i][j] = true;
		    			 dfs(i,j);
		    			 ret++;
		    		 }
		    	 }
		     }
		     System.out.println(ret);
	     }
	     
	     
	}
	private static void dfs(int y, int x) {
		for(int i=0;i<4;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			if(nx <0 || nx >= M || ny <0 || ny >= N)continue;
			if(a[ny][nx]==0 || vis[ny][nx])continue;
			vis[ny][nx] =true;
			dfs(ny,nx);
		}
	}

}