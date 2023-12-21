import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		List<int[]> cup = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			cup.add(new int[] {day, value});
		}
		
		Collections.sort(cup, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			pq.offer(cup.get(i)[1]);
			while(pq.size() > cup.get(i)[0]) {
				pq.poll();
			}
		}
		
		int ret = 0;
		while(!pq.isEmpty()) {
			ret += pq.poll();
		}
		System.out.println(ret);

	}

}