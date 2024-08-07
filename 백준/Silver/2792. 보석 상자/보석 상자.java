import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, arr[], ret = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		for(int i=0;i<M;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int le = 1;
		int ri = Integer.MAX_VALUE-1;
		while(le <= ri) {
			int mid = (le+ri)/2;
			
			if(check(mid)) {
				ret = mid;
				ri = mid -1;
				
			}else le = mid +1;
		}
		
		System.out.println(ret);
	}
	private static boolean check(int mid) {

		int cnt = 0;
		for(int i=0;i<M;i++) {
			cnt += arr[i] / mid;
			if(arr[i] % mid > 0)cnt++;
		}

		return N >= cnt;
	}

}