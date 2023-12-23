

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, K, plug[];
	static boolean vis[]; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		plug = new int[K];
		vis = new boolean[K+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			plug[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> uses = new ArrayList<>();
		int cnt = 0;
		for(int i=0;i<K;i++) {

			if(vis[plug[i]])continue;
			if(uses.size() == N) {
				// 지금 쓰는 기구 중에 나중에 안쓰는 기구 빼기
				int last_idx =0, pos =0 ;
				for(int use : uses) {
					int here = Integer.MAX_VALUE;
					for(int j=i+1;j<K;j++) {
						if(plug[j] == use) {
							here = j;
							break;
						}
					}
					if(last_idx < here) {
						last_idx = here;
						pos = use;
					}
				}
				vis[pos] = false;
				uses.remove(Integer.valueOf(pos));
				cnt++;
				
				// 모두 안 쓰면 맨앞에 있는 것 빼기
			}
				// 일단 추가
			vis[plug[i]] = true;
			uses.add(plug[i]);
		}
		System.out.println(cnt);
	}

}
