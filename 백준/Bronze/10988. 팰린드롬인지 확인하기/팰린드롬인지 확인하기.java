import java.util.*;

import java.io.*;



public class Main {
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] chars = br.readLine().toCharArray();
		boolean palindrom=false;
		for(int i=0;i<chars.length/2;i++) {
			if(chars[i] == chars[chars.length-1-i]) {
				palindrom = true;
			}
			else {
				palindrom = false;
				break;
			}
		}
		if(palindrom || chars.length==1) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}
}
