import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, a[];
	static long ret;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++)a[i] = Integer.parseInt(st.nextToken());
		
		if(N <= M) {
			System.out.println(N);
			return;
		}
		
		long le = 1;
		long ri = 2_000_000_000L * 30 + 1;
		while(le <= ri) {
			long mid = (le+ri)/2;
			if(check(mid)) {
				ret = mid ;
				ri = mid -1;
			}else {
				le = mid + 1;
			}
		}
		
		long tmp = M;
		for(int i=0;i<M;i++) {
			tmp += ((ret-1) / a[i]);
		}
		
		for(int i=0;i<M;i++) {
			if(ret % a[i] == 0)tmp++;
			if(tmp == N) {
				System.out.println(i+1);
				break;
			}
		}
		

	}
	private static boolean check(long mid) {
		long sum  = M;
		for(int i=0;i<M;i++)sum += mid / a[i];
		
		
		return sum >= N;
	}

}