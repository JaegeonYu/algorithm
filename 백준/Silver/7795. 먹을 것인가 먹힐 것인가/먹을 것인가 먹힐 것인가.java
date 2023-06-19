
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int t, n, m, a[], b[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(bf.readLine());
		for(int T=0;T<t;T++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			a = new int[n];
			b = new int[m];
			st = new StringTokenizer(bf.readLine());
			for(int i=0;i<n;i++)a[i]=Integer.parseInt(st.nextToken());
			st = new StringTokenizer(bf.readLine());
			for(int i=0;i<m;i++)b[i]=Integer.parseInt(st.nextToken());
			
			
			Arrays.sort(a);
			Arrays.sort(b);
			int ret = 0;
			
			int j =0 ;
			for(int i=0;i<n;i++) {
				int le = 0;
				int ri = m-1;
				int idx = 0;
				while(le <= ri) {
					int mid = (le+ri)/2;
					if(b[mid]<a[i]) {
						le =mid+1;
						idx = mid+1;
					}else ri = mid -1;
				}
				ret += idx;
				
			}
			System.out.println(ret);
			
			
		}
		

	}

}
