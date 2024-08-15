import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, a[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new int[N][N];
		
		int ret = Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1;i<(1<<N);i++) {
			if(Integer.bitCount(i) != N/2)continue;
			List<Integer> a = new ArrayList<>();
			List<Integer> b = new ArrayList<>();
			
			for(int j=0;j<N;j++) {
				if((i & (1 << j)) > 0)a.add(j);
				else b.add(j);
			}

			int retA = get(a);
			int retB = get(b);
			ret = Math.min(ret, Math.abs(retA - retB));
		}
		
		
		System.out.println(ret);
	}

	private static int get(List<Integer> team) {
		int ret = 0;
		for(int i=0;i<team.size();i++) {
			for(int j=0;j<team.size();j++) {
				if(i == j)continue;
				ret += a[team.get(i)][team.get(j)];
			}
		}
		
		return ret;
	}

}