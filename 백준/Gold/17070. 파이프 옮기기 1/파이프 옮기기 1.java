import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, arr[][], dp[][][];
	static int dy[] = {0,1,1};
	static int dx[] = {1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new int[N][N][3];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][1][0] = 1;
		for(int i=0;i<N;i++) {
			for(int j=2;j<N;j++) {
				if(arr[i][j] == 1)continue;
				// 0 -> x 축, 1 -> y축 , 2-> 대각선
				dp[i][j][0] = dp[i][j-1][0]+dp[i][j-1][2];
				
				if(i == 0)continue;
				dp[i][j][1] = dp[i-1][j][1]+dp[i-1][j][2];
				
				if(arr[i-1][j] ==1 || arr[i][j-1] == 1)continue;
				dp[i][j][2] = dp[i-1][j-1][0]+dp[i-1][j-1][1]+dp[i-1][j-1][2];
			}
		}
		
		int ret = 0 ;
		for(int i=0;i<3;i++) {
			ret += dp[N-1][N-1][i];
		}

		System.out.println(ret);
	}


}