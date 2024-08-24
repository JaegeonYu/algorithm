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
		
		dp = new int[T][2][W+1];
		a = new int[T];
		for(int i=0;i<T;i++) {
			a[i] = Integer.parseInt(br.readLine())-1;
		}
		
		System.out.println(Math.max(go(0, 0, W), go(0, 1, W-1)));

	}
	private static int go(int idx, int here, int cnt) {
		if(cnt < 0)return Integer.MIN_VALUE;
		if(idx == T)return 0;
		int ret = dp[idx][here][cnt];
		if(ret > 0)return ret;
		
		dp[idx][here][cnt] = Math.max(go(idx+1, here, cnt), go(idx+1, here ^ 1, cnt -1));
		if(here == a[idx])dp[idx][here][cnt]++;
		
		return dp[idx][here][cnt];
	}

}