import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, lis[]=new int[504];
	static List<int[]> a = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			a.add(new int[] {x,y});
		}
		Collections.sort(a, (o1, o2)->{
			if(o1[0]==o2[0])return o1[1]-o2[1];
			else return o1[0]-o2[0];
		});
		int ret = 0;
		for(int i=0;i<a.size();i++) {
			ret = Math.max(recur(i), ret);
			
		}
		
		System.out.println(n - ret);
	}
	private static int recur(int N) {
		if(lis[N] == 0) {
			lis[N]=1;
			for(int i= N+1;i<a.size();i++) {
				if(a.get(N)[1] < a.get(i)[1]) {
					lis[N] = Math.max(lis[N], recur(i)+1);
				}
			}
		}
		return lis[N];
	}

}
