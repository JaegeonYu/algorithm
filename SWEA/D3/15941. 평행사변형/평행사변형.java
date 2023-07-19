import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	static int TC;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		TC = Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			int n = Integer.parseInt(br.readLine());
			int ret = n * n;
			bw.write("#"+t+ " "+ret +"\n");
		}
		bw.flush();
		bw.close();
	}

}