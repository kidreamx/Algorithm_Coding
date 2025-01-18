import java.util.*;

import java.io.*;



public class Main {
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] chars = br.readLine().toCharArray();
		int[] alpha = new int[26];
		int[] count = new int[1000001];
		for(int i=0;i<chars.length;i++) {
			if(chars[i]>='A' && chars[i]<='Z') {
				alpha[chars[i]-'A']++;
			}
			else if(chars[i]>='a' && chars[i]<='z') {
				alpha[chars[i]-'a']++;
			}
		}
		int max = 0;
		int max_index=0;
		for(int i=0;i<26;i++) {
			count[alpha[i]]++;
			if(max<alpha[i]) {
				max = alpha[i];
				max_index = i;
			}
		}
		if(count[max]>=2) {
			System.out.println("?");
		}
		else {
			System.out.println((char)('A'+max_index));
		}
	}
}
