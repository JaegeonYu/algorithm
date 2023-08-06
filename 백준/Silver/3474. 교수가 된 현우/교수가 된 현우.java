import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int TC, N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		TC = Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			N = Integer.parseInt(br.readLine());
			int ret = 0;
			int two = 0;
			int five = 0;
			for(int i=2; i<= N; i *= 2) {
				two += N / i;
			}
			for(int i=5; i<= N; i *= 5) {
				five += N / i;
			}
	
			ret += Math.min(two, five);
			
			
			System.out.println(ret);
		}
	}

}