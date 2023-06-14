
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, map[][] = new int[104][104], ret;
	static List<Integer> dragon[][] = new ArrayList[4][11];
	static int dx[]= {1,0,-1,0};
	static int dy[]= {0,-1,0,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		makeDragon();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int x= Integer.parseInt(st.nextToken());
			int y= Integer.parseInt(st.nextToken());
			int d= Integer.parseInt(st.nextToken());
			int g= Integer.parseInt(st.nextToken());
			
			go(x,y,d,g);
		}
		for(int i=0;i<=100;i++) {
			for(int j=0;j<=100;j++) {
				if(map[i][j]>0 && map[i+1][j]>0 && map[i][j+1]>0 && map[i+1][j+1]>0)ret++;
			}
		}
		System.out.println(ret);
	}
	private static void go(int x, int y, int d, int g) {
		map[x][y]=1;
		for(int i=0;i<=g;i++) {
			for(int dir : dragon[d][i]) {
				x+=dx[dir];
				y+=dy[dir];
				map[x][y]=1;
			}
		}
		
	}
	private static void makeDragon() {
		for(int i=0;i<4;i++) {
			for(int j=0;j<11;j++) {
				dragon[i][j] = new ArrayList<>();
			}
		}
		
		for(int i=0;i<4;i++) {
			dragon[i][0].add(i);
			dragon[i][1].add((i+1)%4);
			for(int j=2;j<=10;j++) {
				int n = dragon[i][j-1].size();
				for(int k=n-1;k>=0;k--) {
					dragon[i][j].add((dragon[i][j-1].get(k)+1)%4);
				}
				for(int k=0;k<n;k++) {
					dragon[i][j].add(dragon[i][j-1].get(k));
				}
			}
		}
		
	}

}
