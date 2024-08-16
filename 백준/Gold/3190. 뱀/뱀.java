import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int N, K,L, a[][], b[][];
	static int[] dy = {0,1,0,-1};
	static int[] dx = {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		a = new int[N][N];
		
		for(int i=0;i<K;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			a[y][x] = 1;
		}
		
		L = Integer.parseInt(br.readLine());
		b = new int[L][2];
		for(int i=0;i<L;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			b[i][0] = Integer.parseInt(st.nextToken());
			char next = st.nextToken().charAt(0);
			if(next == 'L')b[i][1] = 3;
			else b[i][1] = 1;
		}
		
		int cnt = 0;
		
		int time = 0;
		
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {0,0});
		a[0][0] = 2;
		int dir = 0;
		while(!dq.isEmpty()) {
			// 이동
			time++;
			int[] now = dq.peekFirst();
			int ny = now[0]+dy[dir];
			int nx = now[1]+dx[dir];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N || a[ny][nx] == 2)break;
			dq.offerFirst(new int[] {ny, nx});
			if(a[ny][nx] == 1) {	
				a[ny][nx] = 2;
			}else {
				a[ny][nx] = 2;
				int[] prev = dq.pollLast();
				a[prev[0]][prev[1]] = 0;
			}
	
			
			// 방향 전환
			if(cnt < L && b[cnt][0] == time) {
				dir = (dir+b[cnt][1]) % 4;
				cnt++;
			}

		}
		System.out.println(time);
	}

}