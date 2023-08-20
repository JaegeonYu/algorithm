import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, a[][] = new int[101][101], ret = 100;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int j=y;j<y+10;j++) {
				for(int k=x;k<x+10;k++) {
					a[j][k] = 1;
				}
			}
		}
		
		for(int i=0;i<99;i++) {
			for(int j=0;j<100;j++) {
				if(a[i][j] != 0 && a[i+1][j] != 0) {
					a[i+1][j] = a[i][j]+1;
				}
			}
		}
		
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				int h = 100;
				for(int k=j;k<100;k++) {
					h = Math.min(h, a[i][k]);
					if(h == 0)break;
					ret = Math.max(ret, h*(k-j+1));
				}
			}
		}
		
		System.out.println(ret);
	}

}