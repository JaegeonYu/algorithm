
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, a[];
	static long ret = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(bf.readLine());
			ret = Math.max(ret, a[i]);
	
		}
		
		
		//System.out.println(ret);
		long le = 0, ri = 1000000004;
		while(le <= ri) {
			long mid = (le+ri)/2;
			if(check(mid)) {
				ret = mid;
				ri = mid - 1;
			}else le = mid + 1;
		}
		
		System.out.println(ret);
	}
	private static boolean check(long mid) {
		int cnt = 1;
		long inchul = mid;
		
		for(int i=0;i<n;i++) {
			if(mid - a[i] >= 0) {
				mid -= a[i];
			}else {
				mid = inchul;
				cnt++;
				if(a[i] > mid) return false;
				else mid -= a[i];
			}
		}
		return m >= cnt;
	}

}
