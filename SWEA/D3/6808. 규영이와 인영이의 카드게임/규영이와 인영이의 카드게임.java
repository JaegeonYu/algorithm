import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int TC, a[], win, lose, cnt, card1[] = new int[9], card2[] = new int[9];
	static boolean vis[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		TC = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=TC;t++) {
			a = new int[9];
			vis = new boolean[19];
			win = 0;
			lose = 0;
			cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<9;i++) {
				a[i] = Integer.parseInt(st.nextToken());
				vis[a[i]] = true;
			}
			
			perm(0, 0, 0);
			System.out.println("#"+t+" "+win+ " " + lose);
		}
	}
	private static void perm(int depth, int sum1, int sum2) {
		if(depth == 9) {
			cnt++;
			if(sum1 > sum2)win++;
			else if(sum1 < sum2)lose++;
			return;
		}
		
		for(int i=1;i<=18;i++) {
			if(!vis[i]) {
				vis[i]=true;
				// 계산
				if(i<a[depth])perm(depth+1, sum1+a[depth]+i, sum2);
				else perm(depth+1, sum1, sum2+i+a[depth]);
				vis[i]=false;
			}
		}
	}

}