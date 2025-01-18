import java.util.*;
import java.io.*;
import java.math.*;

public class Main  {
	
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int M = Integer.parseInt(br.readLine());
		int[] contains = new int[20];
		for(int i=0;i<M;i++) {
			String s = br.readLine();
			String word;
			int num;
			if(s.equals("all")|| s.equals("empty")) {
				word = s;
				if(word.equals("all")) {
					Arrays.fill(contains, 1);
				}
				else if(word.equals("empty")) {
					Arrays.fill(contains, 0);
				}
			}
			else {
			String[] sa = s.split(" ");
			word = sa[0];
			num = Integer.parseInt(sa[1]);
			
			if(word.equals("add")) {
				if(contains[num-1]==0) {
					// 넣고
					contains[num-1]=1;
				}
				
			}
			else if(word.equals("remove")) {
				if(contains[num-1]==1) {
					// 빼고 
					contains[num-1] = 0;
				}
			}
			else if(word.equals("check")) {
				if(contains[num-1]==1) {
					bw.write(1+"\n");
				}
				else {
					bw.write(0+"\n");
				}
			}
			else if(word.equals("toggle")) {
				if(contains[num-1]==1) {
					//빼고
					contains[num-1] = 0;
				}
				else { // 없을때
					//넣고
					contains[num-1] = 1;
				}
			}
			}
			
		}
		
		br.close();
		bw.flush();
		bw.close();
		
		
	}
}
