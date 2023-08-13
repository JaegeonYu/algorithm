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
	static int N, K;
	static long ret;
	static List<int[]> jual = new ArrayList<>();
	static List<Integer> bag = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			jual.add(new int[] {M, K});
		}
		
		for(int i=0;i<K;i++) {
			bag.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(jual, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		Collections.sort(bag);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int j= 0;
		for(int i=0;i<K;i++) {
			while(j<N && jual.get(j)[0] <= bag.get(i))pq.offer(jual.get(j++)[1]);
			if(!pq.isEmpty()) {
				ret += pq.poll();
			}
		}
		
		System.out.println(ret);
	}

}