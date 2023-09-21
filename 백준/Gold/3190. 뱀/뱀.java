
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int n, k, l,map[][], dir[][], go=0, ret =0, now = 0;
	static boolean vis[][];
	static int dy[]= {0,1,0,-1};
	static int dx[]= {1,0,-1,0}; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		map = new int[n][n];
		vis = new boolean[n][n];
		k = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(bf.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			map[y][x]=1;
		}
		l = Integer.parseInt(bf.readLine());
		dir = new int[l][2];
		for(int i=0;i<l;i++) {
			st = new StringTokenizer(bf.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			char direction = st.nextToken().charAt(0);
			if(direction == 'D') {
				dir[i]= new int[]{tmp,1};
			}else dir[i]= new int[] {tmp,3};
		}
		Deque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[]{0,0});
		while(!dq.isEmpty()) {
			ret++;
			int[] tmp = dq.peekFirst();
			int ny = tmp[0] + dy[go];
			int nx = tmp[1] + dx[go];
			if(nx <0 || nx >=n || ny <0 || ny >=n|| vis[ny][nx])break;
			if(map[ny][nx]==1) {
				map[ny][nx]=0;
			}else {
				int out[] = dq.removeLast();
				vis[out[0]][out[1]]=false;
			}
			vis[ny][nx]=true;
			dq.addFirst(new int[] {ny, nx});
			
			if(now < dir.length && ret == dir[now][0]) {
				go = (go+dir[now++][1]) % 4;
			}
		}
		System.out.println(ret);
		
	}

}
