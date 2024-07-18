import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T, W, a[], dp[][][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		a = new int[T];
		
		for(int i=0;i<T;i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		dp = new int[1004][2][34];
		System.out.println(Math.max(max(0, 1, W-1), max(0, 0, W)));
		

	}
	private static int max(int idx, int tree, int cnt) {
		if(cnt < 0)return Integer.MIN_VALUE;
		if(idx == T)return 0;
		
		int ret = dp[idx][tree][cnt];
		if(ret > 0)return ret;
		
		dp[idx][tree][cnt] = Math.max(max(idx+1, tree, cnt), max(idx+1, tree^1, cnt-1));
		if(tree == a[idx] -1)dp[idx][tree][cnt]++;
				
		return dp[idx][tree][cnt];
	}

}