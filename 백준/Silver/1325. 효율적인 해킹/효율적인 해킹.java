import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ret[];
	static boolean vis[];
	static List<Integer> adj[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		ret = new int[N+1];
		vis = new boolean[N+1];
		
		for(int i=1;i<=N;i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
		}
		int max = 0;
		for(int i=1;i<=N;i++) {
			Arrays.fill(vis, false);
			vis[i] = true;
			dfs(i);
			
		}
		for(int i=1;i<=N;i++) {
			max = Math.max(max, ret[i]);
		}
	
		for(int i=1;i<=N;i++) {
			if(max == ret[i])bw.write(i+ " ");
		}
		bw.flush();
		bw.close();
		
	}
	private static void dfs(int now) {
		
		for(int next : adj[now]) {
			if(vis[next])continue;
			ret[next]++;
			vis[next]=true;
			dfs(next);
		}

	}

}