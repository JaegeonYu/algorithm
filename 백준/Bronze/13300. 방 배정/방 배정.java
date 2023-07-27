import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int arr[][] = new int[7][2];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(x==0) {
				arr[y][0]++;
			}else arr[y][1]++;
		}
		
		int sum = 0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i][0] > 0) {
				sum += arr[i][0] / k;
				sum += arr[i][0] % k;
			}
			
			if(arr[i][1] > 0) {
				sum += arr[i][1] / k;
				sum += arr[i][1] % k;
			}
		}
		System.out.println(sum);
	}

}