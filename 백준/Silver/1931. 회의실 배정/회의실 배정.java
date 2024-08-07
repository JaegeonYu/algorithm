import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N , a[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		a = new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a, (o1, o2) -> {
			if(o1[1]==o2[1])return Integer.compare(o1[0], o2[0]);
			else return Integer.compare(o1[1], o2[1]);
		});
		
		int time = a[0][1];
		int ret = 1;
		for(int i=1;i<N;i++) {
			if(time <= a[i][0]) {
				ret++;
				time = a[i][1];
				
			}
		}
		System.out.println(ret);
	}

}