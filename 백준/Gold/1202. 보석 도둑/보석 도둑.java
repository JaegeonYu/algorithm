import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int a[][] = new int[N][2];
		int[] b = new int[K];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
		}
		

		for(int i=0;i<K;i++) {
			
			b[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(a, (o1, o2) -> Integer.compare(o1[0], o2[0]));
		Arrays.sort(b);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		int j = 0;
		long ret  = 0;
		
		for(int i=0;i<K;i++) {
			while(j<N && a[j][0] <= b[i])pq.offer(a[j++][1]);
			if(!pq.isEmpty())ret += pq.poll();
		}
		
		System.out.println(ret);
		
	}

}