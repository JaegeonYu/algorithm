import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import javax.sound.midi.Soundbank;

public class Main {
	static int n, a[][], ret = 1;
	static boolean vis[][];
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     
	     n = Integer.parseInt(br.readLine());
	     a = new int[n][n];
	    
	     
	     StringTokenizer st;
	     for(int i=0;i<n;i++) {
	    	 st = new StringTokenizer(br.readLine());
	    	 for(int j=0;j<n;j++) {
	    		 a[i][j] = Integer.parseInt(st.nextToken());
	    	 }
	     }
	     
	     for(int h=0;h<=100;h++) {
	    	 vis = new boolean[n][n];
	 
	    	 int sum = 0;
	    	 for(int i=0;i<n;i++) {
	    		 for(int j=0;j<n;j++) {
	    			 if(a[i][j] > h && !vis[i][j]) {
	    				 vis[i][j]=true;
	    				 dfs(i,j, h);
	    				 sum ++;
	    			 }
	    		 }
	    	 }
	    	 
	    	 // 높이 구하기
	    	 ret = Math.max(ret, sum);
	  
	     }
	     System.out.println(ret);
	     
	}
	private static void dfs(int y, int x, int h) {
		
		for(int i=0;i<4;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			if(nx <0 || nx >=n || ny >= n || ny < 0)continue;
			if(a[ny][nx] <= h || vis[ny][nx])continue;
			vis[ny][nx]=true;
			dfs(ny, nx, h);
			
		}
		
	}

}