import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a[] = new int[n];
		int ret[] = new int[n];
		for(int i=0;i<n;i++)a[i] = Integer.parseInt(st.nextToken());
		
		Arrays.fill(ret, -1);
		Stack<Integer> stk = new Stack<>();
		
		for(int i=0;i<n;i++) {
			while(!stk.isEmpty() && a[stk.peek()] < a[i]) {
					ret[stk.pop()] = a[i];
				}
				stk.push(i);
			}
			
		
		for(int x: ret) {
			bw.write(x+" ");
		}
		bw.flush();
		bw.close();
	}

}