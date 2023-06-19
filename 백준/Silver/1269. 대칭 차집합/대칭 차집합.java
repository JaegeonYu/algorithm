import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int n, m, a[], b[];
	static Map<Integer, Integer> aMap = new HashMap<>();
	static Map<Integer, Integer> bMap = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n]; b = new int[m];
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(st.nextToken());
			aMap.put(a[i],1);
		}
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<m;i++) {
			b[i] = Integer.parseInt(st.nextToken());
			bMap.put(b[i], 1);
		}
		int ret = 0;
		for(int i=0;i<n;i++) {
			if(bMap.getOrDefault(a[i], 0)==0)ret++;
		}
		for(int i=0;i<m;i++) {
			if(aMap.getOrDefault(b[i], 0)==0)ret++;
		}
		System.out.println(ret);
	}

}
