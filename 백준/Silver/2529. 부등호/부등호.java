import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, num[];
	static char a[];
	static boolean vis[];
	static List<String> ret = new ArrayList<>(); 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		a = new char[N];
		vis = new boolean[10];
		num = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			a[i] = st.nextToken().charAt(0);
		}
		for(int i=0;i<=9;i++) {
			vis[i]=true;
			num[0]=i;
			perm(1);
			vis[i]=false;
		}
		
		Collections.sort(ret);
		System.out.println(ret.get(ret.size()-1));
		System.out.println(ret.get(0));
		
	}
	private static void perm(int depth) {
		if(depth == N+1) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<N+1;i++) {
				sb.append(num[i]);
			}
			ret.add(sb.toString());
			return;
		}
		
		for(int i=0;i<=9;i++) {
			if(!vis[i] && checkPrev(num[depth-1], i, depth-1)) {
				vis[i]=true;
				num[depth] = i;
				perm(depth+1);
				vis[i]=false;
			}
		}
	}
	private static boolean checkPrev(int prev, int now, int depth) {
		if(a[depth]=='>') {

			if(prev > now)return true;
			else return false;
		}else {

			if(prev < now)return true;
			else return false;
		}
	}

}