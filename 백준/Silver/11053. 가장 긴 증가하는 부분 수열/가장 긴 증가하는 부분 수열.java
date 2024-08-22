import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, a[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = new int[N];
		for(int i=0;i<N;i++)a[i] = Integer.parseInt(st.nextToken());
		
		List<Integer> lis = new ArrayList<>();
		for(int i=0;i<N;i++) {
			int idx = Collections.binarySearch(lis, a[i]);
			if(lis.isEmpty() || lis.get(lis.size()-1) < a[i]) {
				lis.add(a[i]);
				continue;
			}
			idx = idx < 0 ? -idx-1 : idx;
			lis.set(idx, a[i]);
			
			
	
		}
		System.out.println(lis.size());

	}

}