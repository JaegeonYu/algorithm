import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, a[], ret = Integer.MAX_VALUE, vis[][][] = new int[64][64][64];
	static int[][] atk = new int[][] { { 1, 3, 9 }, { 1, 9, 3 }, { 3, 1, 9 }, { 3, 9, 1 }, { 9, 1, 3 }, { 9, 3, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new int[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		Queue<int[]> q = new LinkedList<>();
		q.offer(a);
		
		
		vis[a[0]][a[1]][a[2]] = 1;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			if (vis[0][0][0] != 0)break;

			for (int i = 0; i < atk.length; i++) {
				int na = Math.max(0, now[0] - atk[i][0]);
				int nb = Math.max(0, now[1] - atk[i][1]);
				int nc = Math.max(0, now[2] - atk[i][2]);
				if (vis[na][nb][nc] > 0)continue;
				
				vis[na][nb][nc] = vis[now[0]][now[1]][now[2]] + 1;
				q.offer(new int[] { na, nb, nc });
			}
		}

		System.out.println(vis[0][0][0] - 1);
	}

}