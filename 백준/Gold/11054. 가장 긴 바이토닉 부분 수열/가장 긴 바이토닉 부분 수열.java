import java.util.*;

import java.io.*;



public class Main {
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] sa = br.readLine().split(" ");
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(sa[i]);
		}
		int[] up_dp = new int[N];
		Arrays.fill(up_dp,1);
		for(int i=1;i<N;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					up_dp[i] = Math.max(up_dp[i], up_dp[j]+1);
				}
			}
		}
		int[] down_dp= new int[N];
		Arrays.fill(down_dp, 1);
		for(int i=N-2;i>=0;i--) {
			for(int j=N-1;j>i;j--) {
				if(arr[j]<arr[i]) {
					down_dp[i] = Math.max(down_dp[i], down_dp[j]+1);
				}
			}
		}
		int result=0;
		int max=0;
		for(int i=0;i<N;i++) {
			result = down_dp[i]+up_dp[i]-1;
			max = Math.max(result, max);
		}
		System.out.println(max);
	}
}
