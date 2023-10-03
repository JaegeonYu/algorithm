import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ret[], res;
	static boolean vis[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		vis = new boolean[N][N];

		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			vis[a][b] = true;
		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(vis[i][k] && vis[k][j]) {
						vis[i][j] = true;
					}
				}
			}
		}
		
		ret = new int[N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(vis[i][j] || vis[j][i])ret[i]++;
			}
		}
		
		for(int i=0;i<N;i++) {
			if(ret[i]==N-1)res++;
		}
		
		System.out.println(res);
	}


}