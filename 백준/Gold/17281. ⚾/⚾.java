import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,a[][], idx[], ret;
	static boolean vis[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		a = new int[N][9];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		idx = new int[9];
		vis = new boolean[9];
		perm(0);
		System.out.println(ret);
	}
	private static void perm(int depth) {
		if(depth == 9) {
			// play game
			playGame();
			return;
		}
		
		if(depth == 3) {
			idx[depth] = 0;
			perm(depth+1);
			return;
		}
		
		for(int i=1;i<9;i++) {
			if(!vis[i]) {
				vis[i] = true;
				idx[depth] = i;
				perm(depth +1);
				vis[i] = false;
			}
		}
	}
	
	private static void playGame() {
		int batter = 0;
		int cnt = 0;
		boolean vis[];

		for(int i=0;i<N;i++) {
			int out = 0;
			vis = new boolean[4];
			while(true) {
				// 치기
				switch(a[i][idx[batter]]) {
					case 0:
						out++;
						break;
					case 1:
						for(int j=3;j>0;j--) {
							if(vis[j]) {
								if(j==3) {
									cnt++;
									vis[j] = false;
									continue;
								}
								
								vis[j] = false;
								vis[j+1] = true;
							}
						}
						vis[1]=true;
						break;
					case 2:
						for(int j=3;j>0;j--) {
							if(vis[j]) {
								if(j==3 || j==2) {
									cnt++;
									vis[j] = false;
									continue;
								}
								
								vis[j] = false;
								vis[j+2] = true;
							}
						}
						vis[2]=true;
						break;
					case 3:
						for(int j=3;j>0;j--) {
							if(vis[j]) {
								cnt++;
								vis[j] = false;
							}
						}
						vis[3]=true;
						break;
					case 4:
						for(int j=1;j<4;j++) {
							if(vis[j]) {
								cnt++;
								vis[j] = false;
							}
						}
						cnt++;
						break;
				}
				batter++;
				if(batter == 9)batter = 0;
				if(out == 3)break;
			}
		}
		ret = Math.max(ret, cnt);
		
	}
	private static void move(int[] plate) {
		for(int i=3;i>0;i--) {
			plate[i]=plate[i-1];
		}
	}

}