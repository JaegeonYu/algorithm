import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = 0;
		int m = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		while (st.hasMoreTokens()) {
			pq.offer(Long.parseLong(st.nextToken()));
		}

		while (m-- > 0) {
			long a = pq.poll();
			long b = pq.poll();
			pq.offer(a+b);
			pq.offer(a+b);
		}
		
		long sum = 0;
		for(long x : pq) {
			sum += x;
		}
		System.out.println(sum);
	}

}