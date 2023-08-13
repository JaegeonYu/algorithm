
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, a[];
	static List<List<Integer>> adj = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		int max = (int)Math.pow(2, n)-1;
		a = new int[max];
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
		}
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<max;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		dfs(0, max-1, 0);
		for(List row : adj) {
			for(int i=0;i<row.size();i++) {
				System.out.print(row.get(i)+" ");
			}
			System.out.println();
		}
	}
	private static void dfs(int le, int ri, int depth) {
		// TODO Auto-generated method stub
		if(le==ri) {
			adj.get(depth).add(a[le]);
			return;
		}
		int mid = (le+ri)/2;
		dfs(le, mid-1, depth+1);
		adj.get(depth).add(a[mid]);
		dfs(mid+1, ri, depth+1);
	}

}
