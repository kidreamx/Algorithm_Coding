import java.util.*;

import java.io.*;



public class Main {
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=1;i<=N;i++) {
			for(int j=0;j<N-i;j++) {
				System.out.print(" ");
			}
			for(int k=0;k<2*i-1;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=N-1;i>=0;i--) {
			for(int j=0;j<N-i;j++) {
				System.out.print(" ");
			}
			for(int k=0;k<2*i-1;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
