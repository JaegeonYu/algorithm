import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, a[], ret = Integer.MAX_VALUE, max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			a[i] = Integer.parseInt(st.nextToken());
			max += a[i];
		}
		
		int le = 1;
		int ri = max;
		while(le <= ri) {
			int mid = (le+ri)/2;
			if(check(mid)) {
				ri = mid -1;
				ret = mid;
			}else le = mid +1;
		}
		
		System.out.println(ret);
		
	}
	private static boolean check(int mid) {
		for(int i=0;i<N;i++) {
			if(a[i] > mid)return false;
		}
		int cnt = 1;
		int cd = mid;
		for(int i=0;i<N;i++) {
			
			if(cd - a[i]<0) {
				cd = mid;
				cnt++;
			}
			cd -= a[i];
		}
		
		return M >= cnt;
	}

}