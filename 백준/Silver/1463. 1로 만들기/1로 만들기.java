

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
	
		System.out.println(bfs(N));
		
		
	}
	
	static int bfs(int N) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		int cnt = 0;
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int i=0;i<qSize;i++) {
				int now = q.poll();
				if(now == 1)return cnt;
				if(now %3 == 0) {
					q.offer(now / 3);
				}
				if(now % 2 == 0) {
					q.offer(now / 2);
				}
				q.offer(now - 1);
			}
			cnt++;
	
		}
		return 1;
	}
	
	

}
