import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, mp, mf, ms, mv, ret = Integer.MAX_VALUE, ff;
	static Food[] foods;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		mp = Integer.parseInt(st.nextToken());
		mf = Integer.parseInt(st.nextToken());
		ms = Integer.parseInt(st.nextToken());
		mv = Integer.parseInt(st.nextToken());
		
		foods = new Food[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			foods[i] = new Food(p, f, s, v, c);
		}

		dfs(0, 0, 0, 0, 0, 0, 0);
		if(ret != Integer.MAX_VALUE) {
			System.out.println(ret);
			
			for(int i=0;i<N;i++) {
				if((ff & (1<< i)) > 0)System.out.print((i+1)+" ");
			}
		}else System.out.println(-1);
		
	}

	private static void dfs(int p, int f, int s, int v, int c, int flag, int start) {
		if (ret <= c) {
			return;
		}
		// 조건 확인, 맞을 시 가격 체크
		if (p >= mp && f >= mf && s >= ms && v >= mv) {
			ret = Math.min(ret, c);
			if(c == ret) {
				ff = flag;
			}
			return;
		}
		// 최저 가격 보다 비싸면 리턴
		
		// N개 음식 중 접근 가능한 음식 체크, 재귀 호출+6
		for (int i = start; i < N; i++) {
			dfs(p + foods[i].p, f + foods[i].f, s + foods[i].s, v + foods[i].v, c + foods[i].c,(flag | (1 << i)), i+1);
			
		}

	}

	static class Food {
		int p;
		int f;
		int s;
		int v;
		int c;

		Food(int p, int f, int s, int v, int c) {
			this.p = p;
			this.f = f;
			this.s = s;
			this.v = v;
			this.c = c;
		}
	}
}