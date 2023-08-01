import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n, arr[], k;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n+1];
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		k = Integer.parseInt(br.readLine());
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int per = Integer.parseInt(st.nextToken());	
			int idx = Integer.parseInt(st.nextToken());	
			
			if(per == 1) {	
				int cnt = 1;
				while(idx * cnt <= n) {	
					arr[idx * cnt] ^= 1;	
					cnt++;
				}
			} else {
				int left = idx-1;
				int right = idx+1;
				while(left >=1 && right <=n) {	
					if(arr[left] != arr[right]) break;				
					left--;
					right++;
				}
				left++; right--;	
				
				for(int j = left; j <= right; j++) {
					arr[j] ^= 1;	
				}
			}
		}
		for(int i = 1; i<=n; i++) {
			bw.write(arr[i] + " ");
			if(i % 20 == 0) {	
				bw.newLine();	
			}
		}	
		bw.flush();
		bw.close();

	}
}