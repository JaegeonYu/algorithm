import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N, a[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		a = new int[N][2];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a, new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])return o1[0]-o2[0];
				return o1[1] - o2[1];
			}
		});
		
		int ret = 1;
		int last = a[0][1];

		for(int i=1;i<N;i++) {
			if(a[i][0] < last)continue;
			else {
				last = a[i][1];
				ret++;
			}
		}
		
		System.out.println(ret);
	}

}