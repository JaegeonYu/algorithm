import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, a[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		a = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			for(int j=0;j<N;j++) {
				a[i][j] = tmp.charAt(j)-'0';
			}
		}
		
		System.out.println(divide(N, 0, 0));
	}
	private static String divide(int n, int y, int x) {
		if(n==1) {
			return String.valueOf(a[y][x]);
		}else {
			int now = a[y][x];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(a[y+i][x+j]!=now) {
						// 4등분하고 리턴
						StringBuilder sb = new StringBuilder("(");
						sb.append(divide(n/2, y, x));
						sb.append(divide(n/2, y, x+n/2));
						sb.append(divide(n/2, y+n/2, x));
						sb.append(divide(n/2, y+n/2, x+n/2));
						sb.append(")");
						return sb.toString();
					}
				}
			}
			return String.valueOf(a[y][x]);
		}
	}

}