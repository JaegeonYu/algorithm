import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = 0;
		int k = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken())-1;
		
		if(k > n/2) {
			k = n-k;
		}
		
		long ret =1;
		for(long i=n;i>n-k;i--) {
			ret *= i;
		}
		
		for(long i=k;i>=1;i--) {
			ret /= i;
		}
		System.out.println(ret);
	}

}