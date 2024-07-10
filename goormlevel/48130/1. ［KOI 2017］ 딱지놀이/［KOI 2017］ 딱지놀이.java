import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++){
			StringTokenizer st = new  StringTokenizer(br.readLine());
			Student a = new Student();
			
			int cnt = Integer.parseInt(st.nextToken());
			for(int j =0;j<cnt;j++){
				a.update(Integer.parseInt(st.nextToken()));
			}
			Student b = new Student();
		st = new  StringTokenizer(br.readLine());
			cnt = Integer.parseInt(st.nextToken());
			for(int j =0;j<cnt;j++){
				b.update(Integer.parseInt(st.nextToken()));
			}
			
			if(a.star != b.star){
				if(a.star > b.star)sb.append("A\n");
				else sb.append("B\n");
			}else if(a.circle != b.circle){
				if(a.circle > b.circle)sb.append("A\n");
				else sb.append("B\n");
			}else if(a.rect != b.rect){
				if(a.rect > b.rect)sb.append("A\n");
				else sb.append("B\n");
			}else if(a.tryangle != b.tryangle){
				if(a.tryangle > b.tryangle)sb.append("A\n");
				else sb.append("B\n");
			}else sb.append("D\n");
		}
		System.out.println(sb.toString());
	}
	
	static class Student{
		String st;
		int star;
		int circle;
		int tryangle;
		int rect;
		
		public  void update(int num){
			if(num == 4)star++;
			else if(num == 3)circle++;
			else if(num == 2)rect++;
			else if(num == 1)tryangle++;
		}
	}
}