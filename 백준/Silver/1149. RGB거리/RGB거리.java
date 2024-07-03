import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, arr[][], dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];
		dp = new int[N][3];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0] = arr[0];
	
		for(int i=1;i<N;i++) {
			for(int j=0;j<3;j++) {
				int prev = Math.min(dp[i-1][(j+1) % 3], dp[i-1][(j+2) % 3]);
				dp[i][j] = prev + arr[i][j];
			}
		}
		
		System.out.println(Math.min(Math.min(dp[N-1][0], dp[N-1][1]),dp[N-1][2]));
		
	}

}