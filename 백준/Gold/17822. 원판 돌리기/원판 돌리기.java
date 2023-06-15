
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	static int n, m, t, a[][], roll[][], vis[][];
	static int dx[]= {1,0,-1,0};
	static int dy[]= {0,1,0,-1};
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		a = new int[n][m];
		vis = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<m;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		roll = new int[t][3];
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			for(int j=x-1;j<n;j+=x) {
				rotate(j,d,k);
			}
			
			if(!check()) {
				setAverage();
			};
		}
		int ret =0 ;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				ret += a[i][j];
			}
		}
		System.out.println(ret);
		
	}
	private static void setAverage() {
		// TODO Auto-generated method stub
		int sum = 0;
		int cnt = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(a[i][j]==0)continue;
				sum += a[i][j];
				cnt++;
			}
		}
		double av = (double)sum / (double)cnt;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(a[i][j]==0)continue;
				if((double)a[i][j]>av) a[i][j]--;
				else if((double)a[i][j]<av)a[i][j]++;
			}
		}
	}
	private static boolean check() {
		flag = false;
		vis = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(a[i][j]==0 || vis[i][j] > 0)continue;
				dfs(i,j);
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(vis[i][j]>0)a[i][j]=0;
			}
		}
		return flag;
		
		
	}
	private static void dfs(int y, int x) {
		for(int i=0;i<4;i++) {
			int ny = y +dy[i];
			int nx = (x+dx[i]+m) % m;
			if(ny <0 || ny >=n)continue;
			if(vis[ny][nx] >0)continue;
			if(a[y][x] == a[ny][nx]) {
				vis[y][x]=vis[ny][nx]=1;
				flag = true;
				dfs(ny,nx);
			}
		}
		
	}
	private static void rotate(int x, int d, int k) {
		
		if(d==0) {// 시계
			for(int count=0;count<k;count++) {
				int temp = a[x][m-1];
				for(int j=m-1;j>0;j--) {
					a[x][j]=a[x][j-1];
				}
				a[x][0]= temp;
			}
		}else { // 반시계
			for(int count=0;count<k;count++) {
				int temp = a[x][0];
				for(int j=0;j<m-1;j++) {
					a[x][j]=a[x][j+1];
				}
				a[x][m-1] = temp;
			}
		}
	}
		
	

}
