import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static long arr[][], psum[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		
		arr = new long[n][n];
		psum = new long[n][n];

		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Long.parseLong(st.nextToken());
			}
		}
		
		// psum
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==0) {
					psum[i][j] = arr[i][j];
				}else psum[i][j] = arr[i][j]+psum[i-1][j];
			}
		}
		
		for(long i=0;i<m;i++) {
			long sum = 0;
			st = new StringTokenizer(br.readLine());
			int sy = Integer.parseInt(st.nextToken())-1;
			int sx = Integer.parseInt(st.nextToken())-1;
			int ey = Integer.parseInt(st.nextToken())-1;
			int ex = Integer.parseInt(st.nextToken())-1;
			
			 
			for(int j=sx;j<=ex;j++) {
				sum += psum[ey][j]-psum[sy][j]+arr[sy][j];
			}
			bw.write(String.valueOf(sum));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

}