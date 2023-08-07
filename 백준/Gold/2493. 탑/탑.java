import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n+1];
		int ret[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++)a[i] = Integer.parseInt(st.nextToken());
		Stack<Top> stk = new Stack<>();
		for(int i=1;i<=n;i++) {
			while(!stk.isEmpty()) {
				if(stk.peek().height >= a[i]) {
					bw.write(stk.peek().pos+" ");
					break;
				}
				stk.pop();
			}
			
			if(stk.isEmpty())bw.write("0 ");
			
			stk.push(new Top(i, a[i]));
		}
		
		bw.flush();
		bw.close();
		

	}
	static class Top{
		int pos;
		int height;
		Top(int pos, int height){
			this.pos = pos;
			this.height = height;
		}
	}
}