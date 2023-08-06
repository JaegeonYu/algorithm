import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		
		List<BigDecimal> ret = new ArrayList<>(); 
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<tmp.length();j++) {
				if(tmp.charAt(j) < 65 ){ // 숫자
					sb.append(tmp.charAt(j));
				}else { // 영어
					if(sb.length() > 0) {
						ret.add(new BigDecimal(sb.toString()));
						sb = new StringBuilder();
					}
				}
			}
			if(sb.length() > 0) {
				ret.add(new BigDecimal(sb.toString()));
			}
		}
		
		Collections.sort(ret);
		for(BigDecimal x : ret) {
			System.out.println(x);
		}
	}
}