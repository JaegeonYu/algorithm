import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, a[][], dp[][][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new int[N][N];
		dp = new int[N][N][3];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 0 -> 가로, 1-> 세로, 2-> 대각
		dp[0][1][0] = 1;
		
		for(int i=2;i<N;i++) {
			if(a[0][i] == 1)continue;
			dp[0][i][0] += dp[0][i-1][0];
		}
		
		for(int i=1;i<N;i++) {
			for(int j=2;j<N;j++) {
				if(a[i][j] == 1)continue;
				dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
				dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
				if(a[i-1][j-1] != 1 && a[i-1][j] != 1 && a[i][j-1] != 1)dp[i][j][2] = dp[i-1][j-1][1] + dp[i-1][j-1][0] + dp[i-1][j-1][2];
			}
		}
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				int sum = 0;
//				for(int k= 0;k<3;k++) {
//					sum += dp[i][j][k];
//				}
//				System.out.print(sum+" ");
//			}
//			System.out.println();
//		}
		System.out.println(dp[N-1][N-1][0]+dp[N-1][N-1][1]+dp[N-1][N-1][2]);
	}

}