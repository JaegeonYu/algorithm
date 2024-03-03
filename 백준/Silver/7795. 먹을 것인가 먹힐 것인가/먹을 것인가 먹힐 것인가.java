import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int T, n, m, a[], b[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			a = new int[n];
			b = new int[m];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++)a[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<m;i++)b[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(a);
			Arrays.sort(b);
			
			int tmp = 0 ;
			int ret = 0;
			for(int i=0;i<n;i++) {
				while(tmp < m && a[i] > b[tmp]) {
					tmp++;
				}
				ret += tmp;
			}
			System.out.println(ret);
		}
		
	}

}