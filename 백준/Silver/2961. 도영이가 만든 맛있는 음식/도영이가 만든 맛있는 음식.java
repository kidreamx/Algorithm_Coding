import java.util.*;
import java.io.*;

public class Main{
	static int N;
	static int[] sour, bitter;
	static int mindiff= Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];
		for(int i=0;i<N;i++) {
			String[] sa = br.readLine().split(" ");
			sour[i] = Integer.parseInt(sa[0]);
			bitter[i] = Integer.parseInt(sa[1]);
		}
		dfs(0,1,0,0);
		System.out.println(mindiff);
		
	}
	static void dfs(int depth,int sour1, int bitter1, int count) {
		if(depth==N) {
			if(count>0) mindiff = Math.min(mindiff, Math.abs(sour1-bitter1));
			return;
		}
		dfs(depth+1, sour1*sour[depth], bitter1+bitter[depth],count+1);
		dfs(depth+1, sour1,bitter1,count);
		
	}
}