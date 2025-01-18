import java.util.*;
import java.io.*;



public class Main {
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sa = br.readLine().split(" ");
		int N = Integer.parseInt(sa[0]);
		int[] ball = new int[N+1];
		int M = Integer.parseInt(sa[1]);
		for(int i=0;i<M;i++) {
			sa = br.readLine().split(" ");
			int start = Integer.parseInt(sa[0]);
			int end = Integer.parseInt(sa[1]);
			int ball_num = Integer.parseInt(sa[2]);
			for(int j=start;j<=end;j++) {
				ball[j] = ball_num;
			}
		}
		for(int i=1;i<=N;i++) {
			System.out.print(ball[i]+" ");
		}
	}
}
