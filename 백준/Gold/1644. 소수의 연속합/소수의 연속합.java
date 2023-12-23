import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int N, ret, idx, prime[];
	
	static boolean vis[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		makePrime();

		check();
		System.out.println(ret);
	}
	
	private static void check() {
		int le = 0;
		int ri = 0;
		int sum = 0;
		
		while(true) {
			if(sum >= N)sum -= prime[le++];
			else if(ri == idx)break;
			else sum += prime[ri++];
			if(sum == N)ret++;
			
		}
	}
	
	private static void makePrime() {
		vis = new boolean[N*2];
		for(int i=2;i<=N;i++) {
			if(!vis[i]) {
				// 배수 
				for(int j=i+i; j<=N;j+=i) {
					vis[j] = true;
				}
			}
		}
		
		prime = new int[N];
		for(int i=2;i<=N;i++) {
			if(!vis[i])prime[idx++] = i;
		}
		
	}

}