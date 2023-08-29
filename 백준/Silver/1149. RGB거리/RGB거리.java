

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, a[][], ret = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new int[N][3];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
			a[i][2] = Integer.parseInt(st.nextToken());
		}
		int dp[][] = new int[N][3];
		dp[0][0] = a[0][0];
		dp[0][1] = a[0][1];
		dp[0][2] = a[0][2];
		
		for(int i=1;i<N;i++) {
			for(int j=0;j<3;j++) {
				int min = Integer.MAX_VALUE;
				for(int k=0;k<3;k++) {
					if(j == k)continue;
					if(min > dp[i-1][k]) {
						min = dp[i-1][k];
					}
				}
				dp[i][j] = min + a[i][j];
			}
		}
		
		for(int i=0;i<3;i++) {
			ret = Math.min(ret, dp[N-1][i]);
		}
		
		System.out.println(ret);
	}

}
