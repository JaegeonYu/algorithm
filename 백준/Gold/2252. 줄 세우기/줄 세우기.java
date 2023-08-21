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
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int edge[] = new int[N+1];
		List<Integer>[] adj = new ArrayList[N+1];
		
		for(int i=0;i<=N;i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			edge[b]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			if(edge[i]==0) {
				q.offer(i);
			}
		}

		while(!q.isEmpty()) {
			
			int now = q.poll();
			System.out.print(now+" ");
			List<Integer> nowAdj = adj[now];
			
			for(int next : nowAdj) {
				edge[next]--;
				if(edge[next] == 0) {
					q.offer(next);
				}
			}
		}
	}

}