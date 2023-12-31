import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, T, map[][], vis[][];
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0,-1,0,1};
	static int dy2[] = {0, 1, 0, -1};
	static boolean flag;
	static List<int[]> chung = new ArrayList<>(), chung1 = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		vis = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					if(!flag) {
						flag = true;
						chung = make(i,j, dx, dy);
					}else {
						chung1 = make(i, j, dx, dy2);
					}
				}
			}
		}
		
		while(T-- > 0) {
			distribute();
			
			clean(chung1);
			clean(chung);
		}
		
		int ret = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]>0)ret += map[i][j];
			}
		}
		
		System.out.println(ret);
	}
	private static void clean(List<int[]> chung) {
		for(int i=chung.size()-1 ; i>0;i--) {
			map[chung.get(i)[0]][chung.get(i)[1]] = map[chung.get(i-1)[0]][chung.get(i-1)[1]];
		}
		map[chung.get(0)[0]][chung.get(0)[1]] = 0;
	}
	private static void distribute() {
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] > 0 ) {
					int sum = 0;
					for(int k=0;k<4;k++) {
						int ny = i+dy[k];
						int nx = j+dx[k];
						if(nx < 0 || nx >= M || ny < 0 || ny >=N || map[ny][nx] == -1)continue;
						sum++;
						vis[ny][nx] += map[i][j]/5;
					}
					map[i][j] -= (map[i][j]/ 5) * sum;
				}
			}
		}
		
		// vis + map
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(vis[i][j] > 0) {
					map[i][j] += vis[i][j];
					vis[i][j] = 0;
				}
			}
		}

	}
	private static List<int[]> make(int i, int j, int[] dx, int[] dy) {
		int dir = 0;
		int ny = i;
		int nx = j;
		List<int[]> v = new ArrayList<>();
		while(true) {
			ny += dy[dir];
			nx += dx[dir];
			if(nx < 0 || nx >= M || ny < 0 || ny >= N) {
				ny -= dy[dir];
				nx -= dx[dir];
				dir++;
				ny += dy[dir];
				nx += dx[dir];
			}
			if(ny == i && nx == j)break;
			v.add(new int[] {ny, nx});
		}
		return v;
	}

}