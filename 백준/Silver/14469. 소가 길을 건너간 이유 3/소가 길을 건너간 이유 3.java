
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		
		List<int[]> arr = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());	
			arr.add(new int[] {start,time});
		}
		arr.sort(new Comparator<>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		int all = arr.get(0)[1]+arr.get(0)[0];
		for(int i=1;i<arr.size();i++) {
			all = Math.max(all, arr.get(i)[0]);
			all += arr.get(i)[1];
		}
		System.out.println(all);
	}

}
