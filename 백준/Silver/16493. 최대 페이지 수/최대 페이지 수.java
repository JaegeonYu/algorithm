import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ret=  Integer.MIN_VALUE;
	static List<Book> arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int page= Integer.parseInt(st.nextToken());
			arr.add(new Book(day, page));
		}
		
		dfs(-1, 0, N);
		System.out.println(ret);
	}
	
	private static void dfs(int depth, int page, int n) {
		ret = Math.max(ret, page);
		
		if(depth == M) {
			return;
		}
		
		for(int i=depth+1;i<M;i++) {
			if(n - arr.get(i).day >= 0) {
				dfs(i, page+arr.get(i).page, n - arr.get(i).day);
			}
		}
		
	}

	static class Book{
		int day;
		int page;
		Book(int day, int page){
			this.day = day;
			this.page = page;
		}
	}

}