import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, H, a[][][], notTomato;
	static int dx[] = { 1, -1, 0, 0, 0, 0 };
	static int dy[] = { 0, 0, 1, -1, 0, 0 };
	static int dz[] = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		a = new int[H][N][M];

		Queue<Point> q = new LinkedList<>();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					a[i][j][k] = Integer.parseInt(st.nextToken());
					if (a[i][j][k] == 1) {
						q.offer(new Point(i, j, k));
					} else if (a[i][j][k] == 0) {
						notTomato++;
					}
				}
			}
		}

		int day = 0;
		while (notTomato > 0 && !q.isEmpty()) {
			int qSize = q.size();
			for (int j = 0; j < qSize; j++) {
				Point now = q.poll();
				for (int i = 0; i < 6; i++) {
					int nz = now.z + dz[i];
					int ny = now.y + dy[i];
					int nx = now.x + dx[i];
					if (nx < 0 || nx >= M || ny < 0 || ny >= N || nz < 0 || nz >= H || a[nz][ny][nx] != 0)
						continue;
					notTomato--;
					a[nz][ny][nx] = 1;
					q.offer(new Point(nz, ny, nx));
				}
			}
			day++;
		}


		if (notTomato == 0)
			System.out.println(day);
		else
			System.out.println(-1);
	}

	static class Point {
		int z;
		int y;
		int x;

		Point(int z, int y, int x) {
			this.z = z;
			this.y = y;
			this.x = x;
		}
	}
}