

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n, arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[1001];
		StringTokenizer st;
		
		int start = Integer.MAX_VALUE ;
		int end = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x] = y;
			start = Math.min(start, x);
			end = Math.max(end, x);
		}
		
		Stack<Integer> stk = new Stack<>();
		
		int temp = arr[start];
		for(int i = start+1; i<=end;i++) {
			if(arr[i] < temp) {
				stk.push(i);
			}else {
				while(!stk.isEmpty()) {
					int pos = stk.pop();
					arr[pos] = temp;
				}
				temp = arr[i];
			}
		}
		
		stk.clear();
		temp = arr[end];
		for(int i= end-1; i>=start; i--) {
			if(arr[i] < temp) {
				stk.push(i);
			}else {
				while(!stk.isEmpty()) {
					int pos = stk.pop();
					arr[pos] = temp;
				}
				temp = arr[i];
			}
		}
		
		int sum = 0;
		for(int i=start;i<=end;i++) {
			sum += arr[i];
		}
		
		
		
		System.out.println(sum);
	}
}
