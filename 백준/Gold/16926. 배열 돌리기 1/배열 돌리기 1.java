

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int map[][], N, M, R;
	static int dy[] = {1, 0, -1, 0};
	static int dx[] = {0,1, 0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(R-->0) {
			int[][] copy = new int[N][M];
			int y = 0;
			int x = 0;
			while(true) {
				// 돌리고
				int ny = y;
				int nx = x;
				if(y == N/2 || x == M/2)break;
				int dir = 0;
				while(true) {
					int tmp = map[ny][nx];
					ny +=dy[dir];
					nx +=dx[dir];
					if(ny < y || ny >= N-y || nx < x || nx >= M-x) {
						ny -=dy[dir];
						nx -=dx[dir];
						dir++;
						ny +=dy[dir];
						nx +=dx[dir];
					}
					
					copy[ny][nx] = tmp;
					if(ny == y && nx == x)break;
//					System.out.println("ny :" + ny +" nx : " + nx);
					
				}
//				System.out.println("===copy===");
//				for(int i=0;i<N;i++)System.out.println(Arrays.toString(copy[i]));
				// y 증가
				y++;
				x++;
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					map[i][j] = copy[i][j];
				}
			}
//			System.out.println("===");
//			for(int i=0;i<N;i++)System.out.println(Arrays.toString(map[i]));
			
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+" ");
			}
		System.out.println();
		}
	}

}
