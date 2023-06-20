import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n, a[], lis[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		a = new int[n];
		lis = new int[n];
		
		List<Integer> bs = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(st.nextToken());
			if(bs.isEmpty() || bs.get(bs.size()-1) < a[i]) {
				lis[i] = bs.size();
				bs.add(a[i]);
				continue;
			}
			
			int idx = Collections.binarySearch(bs, a[i]);
			idx = idx >=0 ? idx : -idx-1;
			lis[i] = idx;
			bs.set(idx, a[i]);
		}
		int idx  = bs.size()-1;
		Stack<Integer> stack = new Stack<>();
		for(int i=n-1;i>=0;i--) {
			if(lis[i]==idx) {
				idx--;
				stack.push(a[i]);
			}
		}
		System.out.println(bs.size());
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		
	}

}
