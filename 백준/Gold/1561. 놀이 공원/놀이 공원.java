import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, a[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		long le = 0;
		long ri = 2_000_000_000L * 30 + 1;
		if(N<=M) {
			System.out.println(N);
			return;
		}
		
		long ret = 0;
		while(le <= ri) {
			long mid = (le+ri)/2;
			if(checkMid(mid)) {
				ret = mid;
				ri = mid - 1;
				
			}else {
				le = mid +1;
			}
		}
		long temp = M;
		for(int i=0;i<M;i++) {
			temp+=(ret-1)/a[i];
		}

		for(int i=0;i<M;i++) {
			if(ret % a[i] == 0) temp++;
			if(temp == N) {
				System.out.println(i+1);
				break;
			}
		}
		
	}
	private static boolean checkMid(long mid) {
		long cnt = M;
		for(int i=0;i<M;i++) {
			cnt += mid / a[i];
		}
		return cnt >= N;
	}

}