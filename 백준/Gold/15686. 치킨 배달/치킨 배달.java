import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ret = Integer.MAX_VALUE;
	static List<int[]> homes = new ArrayList<>(), chickens = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int now = Integer.parseInt(st.nextToken());
				if(now == 1) {
					homes.add(new int[] {i,j});
				}else if(now == 2) {
					chickens.add(new int[] {i,j});
				}
			}
		}
		
		combi(-1, new Stack<Integer>());
		System.out.println(ret);
	}
	private static void combi(int start, Stack<Integer> stk) {
		if(stk.size() == M) {
			
			
			check(stk);
			return;
		}
		
		for(int i=start+1; i<chickens.size();i++) {
			stk.push(i);
			combi(i, stk);
			stk.pop();
		}
	}
	private static void check(Stack<Integer> stk) {
		int nowDis = 0;
		for(int[] home : homes) {
			int minDis = Integer.MAX_VALUE;
			for(int idx : stk) {
				int[] chicken = chickens.get(idx);
				
				minDis = Math.min(minDis, Math.abs(chicken[0] - home[0]) + Math.abs(chicken[1] - home[1]));
			}
			nowDis += minDis;
		}
		ret = Math.min(nowDis, ret);
		
	}

}