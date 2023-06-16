
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, a[];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[m];
		long lo = 1, hi = 0, mid;
		for(int i=0;i<m;i++) {
			a[i] = Integer.parseInt(bf.readLine());
			hi = Math.max(hi, a[i]);
		}
		long ret = Long.MAX_VALUE ;
		while(lo<=hi) {
			mid = (lo+hi)/2;
			if(check(mid)) {
				ret = Math.min(ret, mid);
				hi = mid -1;
			}else lo = mid+1;
		}
		
		System.out.println(ret);
		
	}
	private static boolean check(long mid) {
		long num = 0;
		for(int i=0;i<m;i++) {
			num += a[i]/mid;
			if(a[i] % mid >0)num++;
		}
		return n >= num;
	}

}
