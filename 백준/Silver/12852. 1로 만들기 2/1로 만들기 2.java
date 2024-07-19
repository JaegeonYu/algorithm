import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, dp[], rev[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[1_000_004];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i=1;i<=N;i++) {
			if(i%3==0)dp[i] = Math.min(dp[i/3]+1,dp[i]);
			if(i%2==0)dp[i] = Math.min(dp[i/2]+1,dp[i]);
			dp[i] = Math.min(dp[i-1]+1, dp[i]);
		}
//		for(int i=0;i<=N;i++)System.out.print(dp[i]+" ");
		
		System.out.println(dp[N]-1);
		go(N);
		
	}
	private static void go(int here) {
		if(here == 0)return;
		System.out.print(here+" ");
		if(here % 3 == 0 && dp[here] == (dp[here/3]+1))go(here/3);
		else if(here % 2 == 0 && dp[here] == (dp[here/2]+1))go(here/2);
		else if(here -1 >= 0&& dp[here] == (dp[here-1]+1))go(here-1);
		
	}
	

}