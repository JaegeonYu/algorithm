import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, arr[];
	static long ret = Long.MAX_VALUE-1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
		long le = 1;
		long ri = Long.MAX_VALUE-1;
		while(le <= ri) {
			long mid = (le+ri)/2;
			if(check(mid)) {
				ret= mid;
				
				ri = mid -1;
			}else le = mid + 1;
		}
		System.out.println(ret);
	}
	private static boolean check(long mid) {
		int cnt = 1;
		int tmp = 0;
		for(int i=0;i<N;i++) {
			if(mid < arr[i])return false;
			if(tmp + arr[i] > mid) {
				cnt++;
				tmp = arr[i];
			}else {
				tmp += arr[i];
			}
		}

		return cnt <= M;
	}

}