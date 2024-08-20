import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, atk;
	static Dungeon[] dungeons;
	static long ret = Integer.MAX_VALUE;
	static class Dungeon{
		int t;
		int a;
		int h;
		public Dungeon(int t, int a, int h) {
			super();
			this.t = t;
			this.a = a;
			this.h = h;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		atk = Integer.parseInt(st.nextToken());
		
		dungeons = new Dungeon[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			dungeons[i] = new Dungeon(t, a, h);
		}
		
		long le = 1;
		long ri = Long.MAX_VALUE-1;
		
		while(le <= ri) {
			long mid = (le+ri)/2;

			if(check(mid)) {
				ret = mid;
				ri = mid -1;
			}else le = mid +1;
		}
		System.out.println(ret);
	}
	private static boolean check(long mid) {
		long now = mid;
		long nowAtk = atk;
		for(int i=0;i<N;i++) {
			if(dungeons[i].t == 1) {
				int h = dungeons[i].h;
				
				long div = h/nowAtk;
				if(h % nowAtk > 0)div++;
				now -= (div-1) * dungeons[i].a;
				
			}else {
				nowAtk += dungeons[i].a;
				now = Math.min(mid, now+dungeons[i].h);
			}
			if(now <= 0)return false;
		}

		return now > 0;
	}

}