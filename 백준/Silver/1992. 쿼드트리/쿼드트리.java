import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;
	static char a[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		a = new char[N][N];
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			for(int j=0;j<N;j++) {
				a[i][j] = tmp.charAt(j);
			}
		}
		
		String ret = dfs(0, 0, N);
		System.out.println(ret);
	}
	private static String dfs(int y, int x, int size) {
		if(size == 1) {
			return String.valueOf(a[y][x]);
		}
		StringBuilder tmp = new StringBuilder();
		for(int i=y;i<y+size;i++) {
			for(int j=x;j<x+size;j++) {
				if(a[i][j] != a[y][x]) {
					tmp.append("(");
					tmp.append(dfs(y,x, size/2));
					tmp.append(dfs(y,x+size/2, size/2));
					tmp.append(dfs(y+size/2, x, size/2));
					tmp.append(dfs(y+size/2, x+size/2, size/2));
					tmp.append(")");
					return tmp.toString();
				}
			}
		}
		
		return String.valueOf(a[y][x]);
	}

}