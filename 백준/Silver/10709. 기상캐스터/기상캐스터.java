import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, a[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new int[N][M];
		
		for(int i=0;i<N;i++) {
			Arrays.fill(a[i], -1);
		}
		
		
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			for(int j=0;j<M;j++) {
				if(tmp.charAt(j)=='c') {
					a[i][j] = 0;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(a[i][j]==0) {
					int y = i;
					int x = j;
					int cnt = 1;
					while(true) {
						x++;	
						if(x == M || a[y][x] >=0)break;
						a[y][x]=cnt++;
					}
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}

}