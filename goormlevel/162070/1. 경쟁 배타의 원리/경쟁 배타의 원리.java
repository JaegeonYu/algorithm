import java.io.*;
import java.util.*;
class Main {
	static int N, K;
	static int[][] a = new int[1001][1001];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			a[y1][x1]++;
			a[y2][x2]++;
			a[y1][x2]--;
			a[y2][x1]--;
		}

		int cnt = 0;
		for(int i=0;i<=1000;i++){
			for(int j=0;j<1000;j++){
				a[i][j+1] += a[i][j];
			}
		}
		for(int j=0;j<=1000;j++){
			for(int i=0;i<1000;i++){
				a[i+1][j] += a[i][j];
			}
		}
		
		for(int i=0;i<=1000;i++){
			for(int j=0;j<=1000;j++){
				if(a[i][j] == K)cnt++;
			}
		}
		System.out.println(cnt);
	}
}