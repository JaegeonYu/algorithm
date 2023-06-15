

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, a[][], ret = Integer.MAX_VALUE;
	static int dy[] = {-1, 0, 1, 0}; 
	static int dx[] = {0, 1, 0, -1}; 
	static List<int[]> cctv = new ArrayList<>(); 
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<m;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if(a[i][j]>=1 && a[i][j]<=5)cctv.add(new int[] {i,j});
			}
		}
		
		dfs(0);
		System.out.println(ret);
		
	}

	private static void dfs(int depth) {
		if(depth == cctv.size()) {
			int cnt = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(a[i][j]==0) cnt++;
				}
			}
            // 크기 체크, 체킹 안된 부분 최소값 변경
			ret = Math.min(cnt, ret);
			return;
		}
		// 카메라 리스트 조합 선택
		for(int i=0;i<4;i++) {
			List<int[]> change = extendCCTV(depth, i);
			dfs(depth+1);
			for(int[] b : change) {
				a[b[0]][b[1]]=0;// 체킹 전 배열로 복귀, 4방향 돌리면서 다시 체킹
			}
		}
		
		
	}
	private static List<int[]> extendCCTV(int depth, int dir) {
		List<int[]> change = new ArrayList<>();
		int y = cctv.get(depth)[0];
		int x = cctv.get(depth)[1];
		if(a[y][x]==1) {
			while(true){
	            int ny = y + dy[dir]; 
	            int nx = x + dx[dir]; 
	            if(ny >= 0 && ny < n && nx >= 0 && nx < m && a[ny][nx] != 6){// 체킹, 자기 자신, 일직선 체크, 벽이나 끝에 도달시 끝
	                if(a[ny][nx] == 0){
	                    a[ny][nx] = 8; 
	                    change.add(new int[]{ny, nx});
	                }
	                y = ny; 
	                x = nx; 
	            }else break;
	        }
		}else if(a[y][x]==2) {
			 for(int i = 0; i <= 2; i +=2){
		            int _y = y;
		            int _x = x;
		            while(true){
		                int ny = _y + dy[(dir + i) % 4];
		                int nx = _x + dx[(dir + i) % 4]; 
		                if(ny >= 0 && ny < n && nx >= 0 && nx < m && a[ny][nx] != 6){
		                    if(a[ny][nx] == 0){
		                    	a[ny][nx] = 8;
		                    	change.add(new int[]{ny, nx});
		                    }
		                    _y = ny;
		                    _x = nx;
		                }else break;
		            }
		        }
		}else if(a[y][x] == 3){
	        for(int i = 0; i < 2; i++){
	            int _y = y;
	            int _x = x;
	            while(true){
	                int ny = _y + dy[(dir + i) % 4];
	                int nx = _x + dx[(dir + i) % 4];
	                if(ny >= 0 && ny < n && nx >= 0 && nx < m && a[ny][nx] != 6){
	                    if(a[ny][nx] == 0){a[ny][nx] = 8;change.add(new int[]{ny, nx});}
	                    _y = ny;
	                    _x = nx;
	                }else break;
	            }
	        }
	    }else if(a[y][x] == 4){
	        for(int i = 0; i < 3; i++){
	            int _y = y;
	            int _x = x;
	            while(true){
	                int ny = _y + dy[(dir + i) % 4];
	                int nx = _x + dx[(dir + i) % 4];
	                if(ny >= 0 && ny < n && nx >= 0 && nx < m && a[ny][nx] != 6){
	                    if(a[ny][nx] == 0){a[ny][nx] = 8;change.add(new int[]{ny, nx});}
	                    _y = ny;
	                    _x = nx;
	                }else break;
	            }
	        }
	    }else if(a[y][x] == 5){
	        for(int i = 0; i < 4; i++){
	            int _y = y;
	            int _x = x;
	            while(true){
	                int ny = _y + dy[(dir + i) % 4];
	                int nx = _x + dx[(dir + i) % 4]; 
	                if(ny >= 0 && ny < n && nx >= 0 && nx < m && a[ny][nx] != 6){
	                    if(a[ny][nx] == 0){a[ny][nx] = 8;change.add(new int[]{ny, nx});}
	                    _y = ny;
	                    _x = nx;
	                }else break;
	            }
	        }
	    }
		return change;
	}


}
