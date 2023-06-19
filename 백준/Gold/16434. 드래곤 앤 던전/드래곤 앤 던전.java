import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long n, atk, dng[][];
	static long ret;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		dng = new long[(int)n][3];
		atk = Integer.parseInt(st.nextToken());
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			int check = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			dng[i] = new long[]{check, a, h};
		}
		long le =0, ri = Long.MAX_VALUE;
		while(le <= ri) {
			long mid = (le+ri)/2;
			if(check(mid)) {
				ri = mid -1;
				ret = mid;
			}else le = mid +1;
		}
		System.out.println(ret);
	}
	private static boolean check(long mid) {
		long tmpAtk = atk;
		long initHp = mid;
		
		for(int i=0;i<n;i++) {
			if(dng[i][0]==1) {
				long monHp = dng[i][2];
				long div = monHp / tmpAtk;
				if(monHp % tmpAtk > 0)div++;
				mid -= (div-1) * dng[i][1];
				
			}else {
				tmpAtk += dng[i][1];
				mid = Math.min(initHp, dng[i][2]+mid);
			}
			
			if(mid<=0)return false;
		}
		return true;
	}

}
