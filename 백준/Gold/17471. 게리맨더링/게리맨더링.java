import java.util.*;
import java.io.*;
public class Main{
	static int N;
	static int[] num;
	static boolean[] visited;
	static boolean[][] voting;
	static int min = Integer.MAX_VALUE;
 	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		num = new int[N+1];
		voting = new boolean[N+1][N+1];
		String[] sa = br.readLine().split(" ");
		for(int i=1;i<=N;i++) {
			num[i] = Integer.parseInt(sa[i-1]);
		}
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<>());
		}
		for(int i=1;i<=N;i++) {
			sa = br.readLine().split(" ");
			for(int j=1;j<=Integer.parseInt(sa[0]);j++) {
				list.get(i).add(Integer.parseInt(sa[j]));
				voting[i][Integer.parseInt(sa[j])] = true;
			}
			
		}
		for(int i=1;i<=N/2;i++) {
			visited = new boolean[N+1];
			findVoting(0,1,i);
		}
		if(min==Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(min);
		
	}
	static void findVoting(int depth , int start, int cnt) {
		if(depth == cnt) {
			List<Integer> front = new ArrayList<>();
			List<Integer> prev = new ArrayList<>();
			for(int i=1;i<=N;i++) {
				if(visited[i]) {
					front.add(i);
				}
				else {
					prev.add(i);
				}
			}
			
			if(is_voting(front)) {
				if(is_voting(prev)) {
					int sum1 = 0;
					int sum2 = 0;
					for(int i=0;i<front.size();i++) {
						sum1+= num[front.get(i)];
					}
					for(int i=0;i<prev.size();i++) {
						sum2+= num[prev.get(i)];
					}
					int result_sum = Math.abs(sum1-sum2);
					min = Math.min(min,result_sum);
				}
				else {
					return;
				}
			}
			else {
				return;
			}
		}
		for(int i=start; i<=N;i++) {
			if(visited[i]) {
				continue;
			}
			visited[i] = true;
			findVoting(depth+1, i+1, cnt);
			visited[i] = false;
		}
	}
	static boolean is_voting(List<Integer> test) {
		boolean[] visited_test = new boolean[N+1];
		boolean[] test_2 = new boolean[N+1];
		if(test.size()==1) {
			return true;
		}
		for(int i=0;i<test.size();i++) {
			test_2[test.get(i)] = true;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(test.get(0));
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			visited_test[tmp] = true;
			for(int i=0;i<list.get(tmp).size();i++) {
				if(test_2[list.get(tmp).get(i)]&& !visited_test[list.get(tmp).get(i)]) {
					queue.add(list.get(tmp).get(i));
				}
			}
		}
		for(int i=0;i<test.size();i++) {
			if(!visited_test[test.get(i)]) {
				return false;
			}
		}
		return true;
	}
	
}