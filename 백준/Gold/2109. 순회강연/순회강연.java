import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, a[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[i][1] = Integer.parseInt(st.nextToken());
			a[i][0] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a, (o1, o2)-> Integer.compare(o1[0], o2[0]));

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int i=0;i<N;i++) {
			pq.offer(a[i][1]);
			while(pq.size() > a[i][0]) {
				pq.poll();			}
			
		}
		int ret = 0;
		while(!pq.isEmpty()) {
			ret += pq.poll();
		}
		System.out.println(ret);
	}

}