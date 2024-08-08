import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, K, a[];
	static boolean vis[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		a = new int[K];
		vis = new boolean[K+1];
		for(int i=0;i<K;i++)a[i] = Integer.parseInt(st.nextToken());
		
		List<Integer> plugs = new ArrayList<>();
		int ret = 0 ;
		for(int i=0;i<K;i++) {
			if(vis[a[i]])continue;
			
			if(plugs.size() == N) {
				// 가장 안쓰는 거 빼기
				int idx = 0;
				int pos = 0;
				
				for(int plug: plugs) {
					int here = Integer.MAX_VALUE;
					for(int j =i+1; j<K;j++) {
						if(plug == a[j]) {
							here = j;
							break;
						}
					}
					if(idx < here) {
						idx = here;
						pos = plug;
					}
				}
				vis[pos] = false;
				plugs.remove(Integer.valueOf(pos));
				ret++;
			}
			vis[a[i]] = true;
			plugs.add(a[i]);
		}
		System.out.println(ret);
	}

}