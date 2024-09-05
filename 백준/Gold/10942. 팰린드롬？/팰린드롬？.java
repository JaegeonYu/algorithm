import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, a[], M;
	static boolean dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		a= new int[N];
		dp = new boolean[N][N];
		for(int i=0;i<N;i++)a[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++)dp[i][i] = true;
		
		for(int i=0;i<N-1;i++) {
			if(a[i] == a[i+1]) {
				dp[i][i+1] = true;
			}
		}
		
		for(int length=3;length<=N;length++) {
			for(int i=0;i<N-length+1;i++) {
				int j = i+length-1;
				if(a[i] == a[j] && dp[i+1][j-1]) {
					dp[i][j] = true;
				}
				
			}
		}
		
		M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			sb.append(dp[s][e] ? 1 : 0).append("\n");
		}
		System.out.println(sb.toString());

	}

}