
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		int check1 = 0;
		int check2 = 0;
		int count = 0;
		for(int i=0;i<n;i++) {
			char now = str.charAt(i);
			if(now == 'L') check1++;
			else if( now =='S')check2++;
			else if(now =='R') {
				if(check1==0)break;
				else {
					check1--;
					count++;
				}
			}else if(now =='K') {
				if(check2==0)break;
				
				else {
					check2--;
					count++;
				}
			}else {
				
				count++;
			}
			
		}
		
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();

	}

}
