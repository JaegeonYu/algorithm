import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M , K, a[][];
	static boolean vis[][];
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     StringTokenizer st = new StringTokenizer(br.readLine());
	     
	     N = Integer.parseInt(st.nextToken());
	     M= Integer.parseInt(st.nextToken());
	     K = Integer.parseInt(st.nextToken());
	     a = new int[N][M];
	     vis = new boolean[N][M];
	     
	     for(int i=0;i<K;i++) {
	    	 st = new StringTokenizer(br.readLine());
	    	 int sx  = Integer.parseInt(st.nextToken());
	    	 int sy = Integer.parseInt(st.nextToken());
	    	 int ex = Integer.parseInt(st.nextToken());
	    	 int ey = Integer.parseInt(st.nextToken());
	    	 for(int y=sy;y<ey;y++) {
	    		 for(int x=sx;x<ex;x++) {
		    		 a[y][x]=1;
		    	 }
	    	 }
	     }
	     List<Integer> ret = new ArrayList<>();
	     for(int i=0;i<N;i++) {
    		 for(int j=0;j<M;j++) {
    			 if(a[i][j]==0 && !vis[i][j]) {
    				 vis[i][j] = true;
    				 ret.add(dfs(i,j));
    				 
    			 }
    		 }
    	 }
	     Collections.sort(ret);
	     bw.write(String.valueOf(ret.size()));
	     bw.newLine();
	     for(int x : ret) {
	    	 bw.write(String.valueOf(x)+" ");
		}

	     bw.flush();
	     bw.close();
	     br.close();

	}

	private static int dfs(int y, int x) {
		int sum = 1;
		for(int i=0;i<4;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			if(nx <0 || nx >= M || ny <0 || ny >= N)continue;
			if(a[ny][nx]==1 || vis[ny][nx])continue;
			vis[ny][nx]=true;
			sum += dfs(ny,nx);
		}
		return sum;
	}

}