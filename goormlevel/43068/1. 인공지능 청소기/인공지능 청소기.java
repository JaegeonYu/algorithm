import java.io.*;
import java.util.*;
class Main {
	static int T, X, Y, N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while(T-- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine()) ;
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			int dis = Math.abs(X)+Math.abs(Y);
			if(N < dis)System.out.println("NO");
			else if(N == dis)System.out.println("YES");
			else{
				if((N-dis) % 2 == 0)System.out.println("YES");
				else System.out.println("NO");
			}
		}
		
	}
}