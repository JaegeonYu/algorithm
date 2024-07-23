import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, dp[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE-5);
		dp[1] = 0;
		for(int i=1;i<=N;i++) {
			if(i % 3 == 0)dp[i] = Math.min(dp[i], dp[i/3]+1);
			if(i % 2 == 0)dp[i] = Math.min(dp[i], dp[i/2]+1);
			dp[i] = Math.min(dp[i], dp[i-1]+1);
		}
		
		System.out.println(dp[N]);
		
		go(N);
	}
	private static void go(int here) {
		System.out.print(here+" ");
		if(here == 1)return;
		
		if(here % 3 == 0 && dp[here/3] == dp[here]-1)go(here/3);
		else if(here % 2 == 0 && dp[here/2] == dp[here]-1)go(here/2);
		else if(here -1 > 0 && dp[here-1] == dp[here]-1)go(here-1);
		
	}

}