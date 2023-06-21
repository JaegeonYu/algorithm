import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, a[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		a = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		List<Integer> bs = new ArrayList<>();
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(st.nextToken());
			if(bs.isEmpty() || bs.get(bs.size()-1) < a[i]) {
				bs.add(a[i]);
			}else {
				int idx = Collections.binarySearch(bs, a[i]);
				idx = idx >=0? idx : -idx-1;
				bs.set(idx, a[i]);
			}
		}
		
		System.out.println(bs.size());
	}

}
