import java.util.*;

import java.io.*;



public class Main {
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char[] chars = s.toCharArray();
		int sum =0;
		for(int i=0;i<s.length();i++) {
			if(chars[i]>='A' && chars[i]<='A'+2) {
				sum+= 3;
			}
			else if(chars[i]>='D' && chars[i]<='D'+2) {
				sum+=4;
			}
			else if(chars[i]>='G' && chars[i]<='G'+2) {
				sum+=5;
			}
			else if(chars[i]>='J' && chars[i]<='J'+2) {
				sum+=6;
			}
			else if(chars[i]>='M' && chars[i]<='M'+2) {
				sum+=7;
			}
			else if(chars[i]>='P' && chars[i]<='P'+3) {
				sum+=8;
			}
			else if(chars[i]>='T' && chars[i]<='T'+2) {
				sum+=9;
			}
			else if(chars[i]>='W' && chars[i]<='W'+3) {
				sum+=10;
			}
		}
		System.out.println(sum);
	}
}
