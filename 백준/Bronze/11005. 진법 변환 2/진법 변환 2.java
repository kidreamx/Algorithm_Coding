import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sa = br.readLine().split(" ");
		int N = Integer.parseInt(sa[0]);
		int B = Integer.parseInt(sa[1]);
		Stack<Character> stack = new Stack<>();
		while(N>0) {
			if(N%B >= 10 && N%B<=35) {
				stack.push((char)(N%B-10+'A'));
			}
			else {
				stack.push((char)((N%B)+'0'));
			}
			N/=B;
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
}