import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static int a[] = new int[9];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int not1 = 0;
		int not2 = 0;
		
		int sum = 0;
		for(int i=0;i<9;i++) {
			a[i] = Integer.parseInt(br.readLine());
			sum += a[i];
		}
		Arrays.sort(a);
		for(int i=0;i<8;i++) {
			for(int j=i+1;j<9;j++) {
				if(sum - a[i] - a[j] == 100) {
					not1 = i;
					not2 = j;
				}
			}
		}
		
		for(int i=0;i<9;i++) {
			if(i != not1 && i != not2)System.out.println(a[i]);
		}
		
	}

}