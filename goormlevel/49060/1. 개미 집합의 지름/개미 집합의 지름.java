import java.io.*;
import java.util.*;

class Main {
	static int N, D;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()){
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list);
		
		int beg =0,  end = 0;
		int maxAnt = 0;
		
		while(beg < N && end < N){
			int length = list.get(end)-list.get(beg);
			int nowAnt = end - beg + 1;
			
			if(length <= D){
				if(maxAnt < nowAnt)maxAnt = nowAnt;
				end++;
			}else beg++;
			
		}
		
		System.out.println(N-maxAnt);
	}
}