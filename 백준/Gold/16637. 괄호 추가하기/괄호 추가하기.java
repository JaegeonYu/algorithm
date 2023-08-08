import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int N, ret = Integer.MIN_VALUE;
	static List<Integer> num = new ArrayList<>();
	static List<Character> oper = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		String tmp = br.readLine();
		for(int i=0;i<tmp.length();i++) {
			if(i % 2 == 0)num.add(tmp.charAt(i)-'0');
			else oper.add(tmp.charAt(i));
		}
		
		dfs(0, num.get(0));
		System.out.println(ret);
	}
	private static void dfs(int depth, int sum) {
		if(depth == N/2) {
			ret = Math.max(ret, sum);
			return ;
		}
		
		dfs(depth+1, oper(sum, num.get(depth+1), oper.get(depth)));
		if(depth+2 <= N/2) {
			int next = oper(num.get(depth+1), num.get(depth+2), oper.get(depth+1));
			dfs(depth+2, oper(sum, next, oper.get(depth)));
		}
	}
	private static int oper(int a, int b, char op) {
		if(op=='+')return a+b;
		else if(op=='-')return a-b;
		return a*b;
	}

}