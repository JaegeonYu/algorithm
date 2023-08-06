import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M, J, a[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		J = Integer.parseInt(br.readLine());
		a = new int[J];
		
		for(int i=0;i<J;i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		int le = 1;
		int ri = 0;
		
		int ret = 0;
		for(int i=0;i<J;i++) {
			ri = le + M -1;
			if(le <= a[i] && a[i] <= ri) {
				continue;
			}else if(a[i] < le) {
				ret += le - a[i];
				le = a[i];
				
			}else {
				ret += a[i] - ri;
				le += a[i] - ri;
			}
		}
		
		System.out.println(ret);
		

	}

}