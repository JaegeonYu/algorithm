import java.io.*;
import java.util.*;
class Main {
	static int N, a[][];
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new int[N][N];
		for(int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(game());
	}
	
	static int game(){
		int day = 0;
		while(true){
			int cnt = 0;
			
			int[][] copyA = copy();
			
			// 실제 탐색은 원본으로, 바뀐 값은 copy에, 끝나면 copy 값을 원본으로 옮기기
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(a[i][j] > 0){
		
						int minus = 0;
						for(int k=0;k<4;k++){
							int ny = i+dy[k];
							int nx = j+dx[k];
							if(nx < 0 || nx >= N || ny < 0 || ny >= N)continue;
							if(a[ny][nx] == 0)minus++;
						}
						
						if(minus > 0){
		
								cnt++;
						}
						copyA[i][j] = Math.max(a[i][j]-minus,0);
						
					}
				}
			}
			
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					a[i][j] = copyA[i][j];
				}
			}
			
			if(cnt == 0)break;
			day++;
		}
		return day;
	}
	
	static int[][] copy(){
		int[][] arr = new int[N][N];
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				arr[i][j] = a[i][j];
			}
		}
		
		return arr;
	}
}