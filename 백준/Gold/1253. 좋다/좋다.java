import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, a[], ret;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)a[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(a);
		
		for(int i=0;i<N;i++) {
			int le = 0;
			int ri = N-1;
			while(le<ri) {
				if(le == i)le++;
				else if(ri == i)ri--;
				if(le >= ri)break;
				long sum = a[le]+a[ri];
				if(sum == a[i]) {	
					ret++;
					break;
				}else if(sum < a[i]) {
					le++;
				}else if(sum > a[i]) {
					ri--;
				}
			}
		}
		System.out.println(ret);
		

	}

}