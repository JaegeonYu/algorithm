
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n, c, a[]= new int[1004];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		
		Map<Integer, Integer> mp = new LinkedHashMap<>();
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
			mp.put(a[i],mp.getOrDefault(a[i],0)+1);
		}
		
		List<Integer> arr = new ArrayList<>(mp.keySet());
		Collections.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return mp.get(o2)- mp.get(o1);
			}
		});
		for(int key : arr) {
			for(int i=0;i<mp.get(key);i++) {
				bw.write(key+" ");
			}
		}
		bw.flush();
		bw.close();
	}

}
