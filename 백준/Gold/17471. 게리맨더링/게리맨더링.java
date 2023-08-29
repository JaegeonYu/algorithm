import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, peo[], ret = Integer.MAX_VALUE;
	static List<Integer>[] adj;
	static boolean vis[], flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		peo = new int[N+1];
		adj = new ArrayList[N+1];
		
		for(int i=1;i<=N;i++) {
			adj[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			peo[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			while(st.hasMoreTokens()) {
				adj[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i=0;i < (1<<N); i++) {
			int count = Integer.bitCount(i);
				if(count > 0 && count < N) {
					// 0인 그룹
					
					Set<Integer> zero = new HashSet<>();
					// 1인 그룹
					Set<Integer> one = new HashSet<>();
					vis = new boolean[N+1];
					// 전체 그룹 모두 체크햇는지?
					int zstart = -1;
					int ostart = -1;
					for(int k=0;k<N;k++) {
						if((i & (1 << k)) == 0) {
							zero.add(k+1);
							zstart = k+1;
						}
						else {
							one.add(k+1);
							ostart = k+1;
						}
					}
					vis[zstart]= true;
					vis[ostart]= true;
					int a = dfs(zstart, zero);
					int b = dfs(ostart, one);
					if(a+b == N) {
						flag = true;
						vis = new boolean[N+1];
						vis[zstart]=true;
						vis[ostart]=true;
						int x = people(zstart, zero);
						int y = people(ostart, one);
						if(ret > Math.abs(x-y)) {
							ret = Math.abs(x-y);
						}
						
					}
					// 체크했으면 최소값 구하기
				}
		}
		if(flag)System.out.println(ret);
		else System.out.println(-1);
		
	}
	private static int people(int now, Set<Integer> zero) {
		int ret = peo[now];

		for(int next : adj[now]) {
			if(!vis[next] && zero.contains(next)) {
				vis[next] =true;
				ret += people(next, zero);
			}
		}

		return ret;
	}
	private static int dfs(int now, Set<Integer> zero) {
		int ret = 1;
		
		for(int next : adj[now]) {
			if(!vis[next] && zero.contains(next)) {
				vis[next] =true;
				ret += dfs(next, zero);
			}
		}
		return ret;
	}

}