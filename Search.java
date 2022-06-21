package algo;

import java.util.Scanner;

public class Search {
	public int  solution(String str, char x) {
		int answer=0;
		str = str.toUpperCase();
		x = Character.toUpperCase(x);
		for(int i=0;i<str.length();i++) {
			if(x==str.charAt(i))answer++;
		}
		return answer;
	}
	public static void main(String[] args) {
		Search T = new Search();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		char x = kb.next().charAt(0);
		System.out.println(T.solution(str, x));

	}

}
