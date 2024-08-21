import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N, a[];
	static int[] lis;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new int[N];
		lis = new int[N];
		List<Integer> bs = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			a[i] = Integer.parseInt(st.nextToken());
			if(bs.isEmpty() || bs.get(bs.size()-1) < a[i]) {
				lis[i] = bs.size();
				bs.add(a[i]);
				continue;
			}
			
			int idx = Collections.binarySearch(bs, a[i]);
			idx = idx < 0 ? -idx-1 : idx;
			lis[i] = idx;
			bs.set(idx, a[i]);
		}
		
		int idx = bs.size()-1;	
		Stack<Integer> stk = new Stack<>();
		for(int i=N-1;i>=0;i--) {
			if(lis[i] == idx) {
				idx--;
				stk.push(a[i]);
			}
		}
		System.out.println(bs.size());
		while(!stk.isEmpty())System.out.print(stk.pop()+" ");
	}

}