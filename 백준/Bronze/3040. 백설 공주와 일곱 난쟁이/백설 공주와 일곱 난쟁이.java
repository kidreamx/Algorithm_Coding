import java.util.*;
import java.io.*;

public class Main{
	static int[] people;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		people = new int[9];
		sb = new StringBuilder();
		for(int i=0;i<9;i++) {
			people[i] = Integer.parseInt(br.readLine());
		}
		dfs(0,0,0,new int[7]);
		System.out.println(sb);
	}
	static void dfs(int depth, int start, int sum, int[] out) {
		if(depth==7) {
			if(sum==100) {
				for(int i=0;i<7;i++) {
					sb.append(out[i]+"\n");
				}
				return;
			}
			return;
		}
		for(int i=start;i<9;i++) {
			out[depth] = people[i];
			dfs(depth+1, i+1, sum+people[i],out);
		}
	}
}