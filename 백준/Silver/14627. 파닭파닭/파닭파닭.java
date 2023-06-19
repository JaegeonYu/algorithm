import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long s, c, l[], ret, sol;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		s = Long.parseLong(st.nextToken());
		c = Long.parseLong(st.nextToken());
		l = new long[(int)s];
		for(int i=0;i<s;i++) {
			l[i] = Long.parseLong(bf.readLine());
			sol += l[i];
		}
		Arrays.sort(l);
		long le = 1, ri = (int)1e9;
		while(le <= ri) {
			long mid = (le+ri)/2;
			
			if(check(mid)) {
				le = mid+1;
				ret= mid;
			}else ri = mid-1;
		}

		System.out.println(sol- ret*c);
		//System.out.println(sol);
	}
	private static boolean check(long mid) {
		int cnt = 0 ;
		for(int i=0;i<s;i++) {
			cnt += l[i]/ mid;
		}
		return cnt >= c;
	}

}
