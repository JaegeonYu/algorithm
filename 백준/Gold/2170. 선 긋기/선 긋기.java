
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static List<int[]> lines = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			lines.add(new int[] {from, to});
		}
		Collections.sort(lines, (o1, o2)->{
			if(o1[0]==o2[0])return o1[1]-o2[1];
			return o1[0]-o2[0];
		});
		
		int l = lines.get(0)[0];
		int r = lines.get(0)[1];
		int ret = 0;
		for(int i=1;i<n;i++) {
			if(r<lines.get(i)[0]) {
				ret += (r-l);
				l = lines.get(i)[0];
				r= lines.get(i)[1];
			}else if(lines.get(i)[0] <= r && lines.get(i)[1]>=r){
				r = lines.get(i)[1];
			}
		}
		ret += r-l;
		System.out.println(ret);

	}

}
