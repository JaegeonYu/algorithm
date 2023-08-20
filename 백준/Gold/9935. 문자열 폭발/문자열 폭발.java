import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static String s, bomb;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		s = bf.readLine();
		bomb = bf.readLine();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			sb.append(ch);
			if(sb.length()>=bomb.length()) {
				boolean flag =true;
				for(int j=0;j<bomb.length();j++) {
					char ch1 = sb.charAt(sb.length()-bomb.length()+j);
					char ch2 = bomb.charAt(j);
					if(ch1 != ch2) {
						flag =false;
						break;
					}
				}
				if(flag) {
					sb.delete(sb.length()-bomb.length(), sb.length());
				}
			}
		}
		
		if(sb.length()==0)System.out.println("FRULA");
		else System.out.println(sb);
	}

}
