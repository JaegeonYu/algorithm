
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, a[][], ret;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		a = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Board c = new Board();
		c.map = a;
		
		subset(c, 0);
		System.out.println(ret);
		
		
		
	}
	private static void subset(Board c, int depth) {
		if(depth == 5) {
			ret = Math.max(ret, c.getMax());
			return;
		}
		
		for(int i=0;i<4;i++) {
			Board now = new Board();
			now.map = copyMap(c.map);
			now.move();
			subset(now, depth+1);
			c.rotate();
		}
		
	}
	private static int[][] copyMap(int[][] map) {
		int[][] temp = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				temp[i][j] = map[i][j];
			}
		}
		return temp;
	}
	static class Board{
		int map[][] = new int[N][N];
		
		void move() {
			int tmp[][] = new int[N][N];
			for(int i=0;i<N;i++) {
				int d=-1, c=-1;
				for(int j=0;j<N;j++) {
					if(map[i][j]==0)continue;
					if(d==-1) {
						// 일단 넣고 d = 0
						tmp[i][++c] = map[i][j];
						d = 0;
					}else {
						// 가장 마지막에 들어간 것과 이제 넣을 것 비교
						
						// 같으면 합치기
						if(tmp[i][c] == map[i][j]) {
							tmp[i][c] += tmp[i][c];
							d = -1;
						}else {// 다르면 그냥 추가
							tmp[i][++c] = map[i][j];
						}
					}
				}
				for(c++ ; c<N;c++) {
					tmp[i][c] = 0;
				}
			}
			map = tmp;
		}
		
		void print() {
			for(int i=0;i<N;i++) {
				System.out.println(Arrays.toString(map[i]));
			}
		}
		
		void rotate() {
			int tmp[][] = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					tmp[i][j] = map[N-j-1][i];
				}
			}
			map = tmp;
		}
		
		int getMax() {
			int max = Integer.MIN_VALUE;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					max = Math.max(max, map[i][j]);
				}
			}
			return max;
		}
		
	}
}
