import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		
		int a = 0;
		int b = 0;
		int aRes = 0;
		int bRes = 0;
		int prev = 0;
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int team = Integer.parseInt(st.nextToken());
			String timeStr = st.nextToken();
			int sec = change(timeStr);
			if(a>b) {
				aRes += sec -prev;
			}else if(b>a) {
				bRes += sec - prev;
			}
			if(team== 1)a++;
			else b++;
			prev = sec;
		}
		int finish = change("48:00");
		if(a>b) {
			aRes += finish -prev;
		}else if(b>a) {
			bRes += finish - prev;
		}
		System.out.printf("%02d:%02d\n", aRes/60, aRes%60);
		System.out.printf("%02d:%02d\n", bRes/60, bRes%60);
		
	}

	private static int change(String timeStr) {
		String[] split = timeStr.split(":");
		int minute = Integer.parseInt(split[0]) * 60;
		int second = Integer.parseInt(split[1]);
		return minute+second;
	}

}