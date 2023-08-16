import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int a[][] = new int[4][18], b[][] = new int[4][18];
	static int game[][] = {
			{0,1},{0,2},{0,3}, {0,4}, {0,5},
			{1,2}, {1,3}, {1,4}, {1,5},
			{2,3}, {2,4}, {2,5},
			{3,4}, {3,5}, {4,5}
	};
	static int WIN = 0, DRAW = 1, LOSE = 2, ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=0;i<4;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<18;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<4;i++) {
			ans = 0;
			dfs(0, i);
			System.out.print(ans+" ");
		}
	}

	private static void dfs(int depth, int row) {
		if(depth == game.length) {
			if(check(row))ans = 1;
			return ;
		}
		
		int team1 = game[depth][0];
		int team2 = game[depth][1];
		if(b[row][team1*3+ WIN]+1 <= a[row][team1*3+ WIN] && b[row][team2*3+ LOSE]+1 <= a[row][team2*3+ LOSE]) {
			b[row][team1*3+ WIN]++;
			b[row][team2*3+ LOSE]++;
			dfs(depth+1, row);
			b[row][team1*3+ WIN]--;
			b[row][team2*3+ LOSE]--;
		}
		
		if(b[row][team1*3+ LOSE]+1 <= a[row][team1*3+ LOSE] && b[row][team2*3+ WIN]+1 <= a[row][team2*3+ WIN]) {
			b[row][team1*3+ LOSE]++;
			b[row][team2*3+ WIN]++;
			dfs(depth+1, row);
			b[row][team1*3+ LOSE]--;
			b[row][team2*3+ WIN]--;
		}
		
		if(b[row][team1*3+ DRAW]+1 <= a[row][team1*3+ DRAW] && b[row][team2*3+ DRAW]+1 <= a[row][team2*3+ DRAW]) {
			b[row][team1*3+ DRAW]++;
			b[row][team2*3+ DRAW]++;
			dfs(depth+1, row);
			b[row][team1*3+ DRAW]--;
			b[row][team2*3+ DRAW]--;
		}
	}

	private static boolean check(int row) {
		for(int j=0;j<18;j++) {
			if(a[row][j] != b[row][j])return false;
		}
		return true;
	}
}