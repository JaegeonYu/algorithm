import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, a[][], dp [];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = new int[N+1][2];
		
		for(int i=1;i<=N;i++) {
			a[i][0] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			a[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[101];
		for(int i=1;i<=N;i++) {
			int health = a[i][0];
			int happy = a[i][1];
			for(int j=100;j>=Math.max(health, 1);j--) {
				dp[j] = Math.max(dp[j], dp[j-health]+happy);
			}
		}

		System.out.println(dp[99]);
	}

}