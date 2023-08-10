import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int MAX = 200000;
	static int N, K, vis[], mask[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		vis = new int[MAX+4];
		mask = new int[MAX+4];
		
		vis[N] = 1;
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now == K)break;
			for(int next : new int[] {now+1, now-1, now*2}) {
				if(next >= 0 && next <= MAX) {
					if(vis[next] == 0) {
						vis[next] = vis[now]+1;
						mask[next] = now;
						q.offer(next);
					}
				}
			}
		}
		
		System.out.println(vis[K]-1);
		List<Integer> ret = new ArrayList<>();
		ret.add(K);
		for(int i=K; i!=N; i=mask[i]) {
			ret.add(mask[i]);
		}
		for(int i=ret.size()-1;i>=0;i--) {
			System.out.print(ret.get(i)+" ");
		}
	}

}