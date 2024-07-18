import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static long dp[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0)break;
			dp = new long[32][32];
			System.out.println(go(N, 0));
		}

	}
	private static long go(int whole, int half) {
		if(whole == 0 && half == 0)return 1;
		if(dp[whole][half] > 0)return dp[whole][half];
		long ret = 0;
		if(whole > 0)ret += go(whole-1, half+1);
		if(half > 0)ret += go(whole, half-1);
		dp[whole][half] = ret;
		
		return ret;
	}

}