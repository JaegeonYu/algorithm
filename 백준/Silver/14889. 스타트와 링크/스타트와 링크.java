
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, s[][] = new int[24][24], ret= Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<n;j++) {
				s[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<(1<<n);i++) {
			if(Integer.bitCount(i) != n/2)continue;
			List<Integer> start = new ArrayList<>();
			List<Integer> link = new ArrayList<>();
			for(int j=0;j<n;j++) {
				if((i & (1<<j)) > 0)start.add(j);
				else link.add(j);
			}
			ret = Math.min(ret, go(start, link));
		}
		System.out.println(ret);
	}
	private static int go(List<Integer> a, List<Integer> b) {
		int arr[ ] = new int[2];
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<n/2;j++) {
				if(i==j)continue;
				arr[0]+=s[a.get(i)][a.get(j)];
				arr[1]+=s[b.get(i)][b.get(j)];
			}
		}
		return Math.abs(arr[0]-arr[1]);
	}

}
