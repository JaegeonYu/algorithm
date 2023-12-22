import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int jual[][] = new int[N][2];
		int bag[] = new int[K];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			jual[i][0] = Integer.parseInt(st.nextToken());
			jual[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<K;i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(jual, (o1, o2)->{
			return Integer.compare(o1[0], o2[0]);
		});
		Arrays.sort(bag);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		long ret = 0;
		int cnt = 0;
		
		for(int i=0;i<K;i++) {
			while(cnt < N && jual[cnt][0] <= bag[i]) {
				pq.offer(jual[cnt++][1]);
			}
			
			if(!pq.isEmpty())ret += pq.poll();
		}
		
		System.out.println(ret);
	}

}