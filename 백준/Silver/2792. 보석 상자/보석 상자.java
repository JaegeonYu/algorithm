import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, a[], ret = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new int[M];
		for(int i=0;i<M;i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		int le = 1;
		int ri = Integer.MAX_VALUE-1;
		
		while(le <=ri) {
			int mid = (le+ri)/2;
			if(check(mid)) {
				ret = Math.min(ret, mid);
				ri = mid -1;
			}else {
				le = mid +1;
			}
		}
		System.out.println(ret);
		
		
	}
	private static boolean check(int mid) {
		int re = 0 ;
		for(int i=0;i<M;i++) {
			re += a[i] / mid;
			if(a[i] % mid > 0)re++;
		}
		
		
		return re <= N;
	}

}