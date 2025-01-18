import java.util.*;
import java.io.*;

public class Main {
	static int N,M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sa = br.readLine().split(" ");
		N = Integer.parseInt(sa[0]);
		M = Integer.parseInt(sa[1]);
		arr = new int[M];
		dfs(0,arr);
		System.out.println(sb);
	}
	static void dfs(int depth,int[] arr) throws IOException {
		if(depth == M) {
			for(int i=0;i<arr.length;i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
		return;
		}
		for(int i=1;i<=N;i++) {
			arr[depth] = i;
			dfs(depth+1,arr);
		}
		
	}
}
