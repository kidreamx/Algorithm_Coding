import java.util.*;
import java.io.*;



public class Main {
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sa = br.readLine().split(" ");
		int N = Integer.parseInt(sa[0]);
		int M = Integer.parseInt(sa[1]);
		int[] arr = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = i;
		}
		for(int i=0;i<M;i++) {
			sa = br.readLine().split(" ");
			int start = Integer.parseInt(sa[0]);
			int end = Integer.parseInt(sa[1]);
			
			for(int j=0; j<(end-start+1)/2;j++) {
				int tmp = arr[j+start];
				arr[j+start] = arr[end-j];
				arr[end-j] = tmp;
				
			}
		
		}
		for(int i=1;i<=N;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
