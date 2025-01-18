import java.util.*;
import java.io.*;


public class Main  {
	
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] sa = br.readLine().split(" ");
		int A_length = Integer.parseInt(sa[0]);
		int B_length = Integer.parseInt(sa[1]);
		int[] a = new int[A_length];
		int[] b = new int[B_length];
		Set<Integer> setA = new HashSet<>();
		Set<Integer> setB = new HashSet<>();
		int result=A_length+B_length;
		sa = br.readLine().split(" ");
		for(int i=0;i<A_length;i++) {
			setA.add(Integer.parseInt(sa[i]));
		}
		sa = br.readLine().split(" ");
		for(int i=0;i<B_length;i++) {
			setB.add(Integer.parseInt(sa[i]));
		}
		for(int num : setA) {
			if(setB.contains(num)) {
				result-=2;
			}
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
			
		
		
	}
}
