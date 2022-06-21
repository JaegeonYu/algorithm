package algo;



import java.util.Arrays;
import java.util.Scanner;	

class Main {
	public int[] solution(int n,int s, int a[]) {
		int cache[]=new int[n];
		for(int x : a) {
			int pos=-1;
			for(int i=0;i<n;i++)if(cache[i]==x)pos=i;
			if(pos==-1) {
				for(int i=n-1;i>0;i--) {
					cache[i]=cache[i-1];
				}
			}else {
				for(int i=pos;i>0;i--) {
					cache[i]=cache[i-1];
				}
			}
			cache[0]=x;
			
		}
		return cache;
	}
	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int s=kb.nextInt();
		int a[]=new int[s];
		for(int i=0;i<s;i++)a[i]=kb.nextInt();
		for(int x : T.solution(n,s, a))System.out.print(x+" ");
	}
}
