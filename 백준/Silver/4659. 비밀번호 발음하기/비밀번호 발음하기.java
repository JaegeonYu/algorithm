import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			String tmp = br.readLine();
			if(tmp.equals("end"))break;
			
			boolean moem = false;
			boolean result = true;
			int aCnt = 0;
			int bCnt = 0;
			char prev = ' ';
			for(int i=0;i<tmp.length();i++) {
				// 모음인지?
				// 같은 글자인지?
				// 모음 3개, 자음 3개
				char now = tmp.charAt(i);
				
				if(isMoem(now)) {
					moem = true;
					bCnt++;
					aCnt = 0;
				}else {
					aCnt++;
					bCnt = 0;
				}
				
				if(i > 0) {
					if(!checkPrev(now, prev)) {
						result = false;
						break;
					}
				}
				
				if(aCnt ==3 || bCnt ==3) {
					result = false;
					break;
				}
				prev = now;
			}
			
			if(moem && result) {
				System.out.println("<"+tmp+"> is acceptable.");
			}else System.out.println("<"+tmp+"> is not acceptable.");
		}
	}

	private static boolean checkPrev(char now, char prev) {
		if(now == prev) {
			if(now == 'e' || now =='o')return true;
			return false;
		}
		return true;
	}

	private static boolean isMoem(char now) {
		return now == 'a' || now =='e' || now=='i' || now =='o' || now =='u';
	}

}