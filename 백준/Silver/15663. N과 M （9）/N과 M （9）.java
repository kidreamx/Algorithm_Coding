import java.util.*;
import java.io.*;



public class Main {
	
	static int N,M;
	static int[] arr;
	static List<Integer> list = new ArrayList<>();
	static HashMap<String, Boolean> hashmap;
	static boolean[] visited;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sa = br.readLine().split(" ");
		N = Integer.parseInt(sa[0]);
		M = Integer.parseInt(sa[1]);
		arr = new int[N];
		visited= new boolean[N];
		hashmap = new HashMap<>();
		sa = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(sa[i]);
		}
		Arrays.sort(arr);
		dfs(0);
	}
	static void dfs(int depth) {
		if(depth == M) {
			StringBuilder key = new StringBuilder();
			for(int i=0;i<list.size();i++) {
				key.append(list.get(i)).append(" ");
			}
			String s = key.toString().trim();
			if(hashmap.containsKey(s)) {
				return;
			}
			hashmap.put(s, true);
			for(int i=0;i<list.size();i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
			return;
		}
		for(int i=0;i<N;i++) {
			if(visited[i]) {
				continue;
			}
			visited[i] = true;
			list.add(arr[i]);
			dfs(depth+1);
			visited[i] = false;
			list.remove(list.size()-1);
		}
	}
}
