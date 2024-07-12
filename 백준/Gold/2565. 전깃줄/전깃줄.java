import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, a[][], lis[] = new int[504];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a, (o1, o2)->{
			if(o1[0] == o2[0])return Integer.compare(o1[1], o2[1]);
			else return Integer.compare(o1[0], o2[0]);
		});
		int max = 0;
		
		for(int i=0;i<N;i++) {
			lis[i] = 1;
			for(int j=0;j<i;j++) {
				if(a[i][1] > a[j][1]) {
					lis[i] = Math.max(lis[i], lis[j]+1);
				}
			}
			max = Math.max(max, lis[i]);
		}
		System.out.println(N - max);
	}


}