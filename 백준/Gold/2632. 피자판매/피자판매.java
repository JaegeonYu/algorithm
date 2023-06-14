
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int p, m, n, a[], b[], psum_a[], psum_b[];
	static Map<Integer, Integer> aCnt, bCnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		p = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		a = new int[m+1];
		psum_a = new int[(m+1)*2];
		b = new int[n+1];
		psum_b = new int[(n+1)*2];
		aCnt = new HashMap<>();
		bCnt = new HashMap<>();
		
		for(int i=1;i<=m;i++) {
			a[i]=Integer.parseInt(bf.readLine());
			psum_a[i] = psum_a[i-1]+a[i];
		}
		for(int i=m+1;i<=2*m;i++)psum_a[i]= psum_a[i-1]+a[i-m];
		for(int i=1;i<=n;i++) {
			b[i]=Integer.parseInt(bf.readLine());
			psum_b[i] = psum_b[i-1]+b[i];
		}
		for(int i=n+1;i<=2*n;i++)psum_b[i]=psum_b[i-1]+b[i-n];
		
		make(m, psum_a, aCnt);
		make(n, psum_b, bCnt);
		
		int sum = 0;
		for(int i=1;i<p;i++) {
			sum += aCnt.getOrDefault(p-i, 0)*bCnt.getOrDefault(i,0);
		}
		sum += aCnt.getOrDefault(p, 0);
		sum += bCnt.getOrDefault(p, 0);
		
		System.out.println(sum);
		
	}
	private static void make(int n, int[] psum, Map<Integer, Integer> map) {
		for(int interval = 1; interval <=n;interval++) {
			for(int start = interval; start<=n+interval-1;start++) {
				int sum = psum[start]-psum[start-interval];
				map.put(sum, map.getOrDefault(sum,0)+1);
				if(interval == n)break;
			}
		}
		return;
	}

}
