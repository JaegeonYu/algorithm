import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N, M, a[][], hx, hy, ret= Integer.MAX_VALUE;
	static List<Point> chickenList = new ArrayList<>(), homeList = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if(a[i][j]==1)homeList.add(new Point(i, j));
				else if(a[i][j]==2)chickenList.add(new Point(i,j));
			}
		}
		
		combi(-1, new Stack<Integer>());
		System.out.println(ret);
	}
	
	private static void combi(int start, Stack<Integer> stack) {
		if(stack.size() == M) {
			checkDistance(stack);
		}
		for(int i=start+1;i<chickenList.size();i++) {
			stack.push(i);
			combi(i, stack);
			stack.pop();
		}
	}

	private static void checkDistance(Stack<Integer> chickenIdx) {
		
		int nowSum = 0;
		for(Point home : homeList) {
			int dis = Integer.MAX_VALUE;
			for(int idx : chickenIdx) {
				int homeChicken = Math.abs(chickenList.get(idx).x-home.x)+Math.abs(chickenList.get(idx).y-home.y);
				dis = Math.min(dis, homeChicken);
			}
			nowSum += dis;
		}
		
		
		ret = Math.min(nowSum, ret);
		
	}

	static class Point{
		int y;
		int x;
		Point(int y, int x) {
			this.y=y;
			this.x=x;
			
		}
	}
}