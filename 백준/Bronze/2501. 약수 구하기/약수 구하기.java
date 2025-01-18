// import java.util.*;
// import java.io.*;

// public class Main {
	
// 	static int[][] arr ;
// 	static int min = Integer.MAX_VALUE;
// 	static int N, start_score=0 , link_score=0;
// 	static boolean[] visited, link_visited, start_visited;
// 	static List<Integer> list = new ArrayList<>();
// 	static List<Integer> start = new ArrayList<>();
// 	static List<Integer> link = new ArrayList<>();
// 	static List<Integer> answer = new ArrayList<>();
// 	public static void main(String[] args) throws IOException{
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		int N = Integer.parseInt(br.readLine());
// 		int[][] arr = new int[N+1][N+1];
// 		visited = new boolean[N+1];
// 		link_visited = new boolean[N/2];
// 		start_visited = new boolean[N/2];
// 		for(int i=1;i<=N;i++){
// 			String[] sa = br.readLine().split(" ");
// 			for(int j=1;j<=N;j++){
// 				arr[i][j] = Integer.parseInt(sa[j-1]);
// 			}
// 		}
// 		dfs(0);
// 		System.out.println(min);
		
// 	}
// 	static void dfs(int depth){
// 		if(depth==N){
// 			for(int i=0;i<list.size();i++){
// 				if(i>=0 && i<(list.size()/2)){
// 					start.add(list.get(i));
// 				}
// 				else{
// 					link.add(list.get(i));
// 				}
// 			}
// 			soccer(0,0);
// 			soccer(0,1);
// 			System.out.println(start_score+" "+link_score);
// 			min = Math.min(min,Math.abs(start_score-link_score));
// 			return;
// 		}
// 		for(int i=1;i<=N;i++){
// 			if(visited[i]){
// 				continue;
// 			}
// 			visited[i] = true;
// 			list.add(i);
// 			dfs(depth+1);
// 			list.remove(list.size()-1);
// 			visited[i] = false;
// 		}
// 	}
// 	static void soccer(int depth, int team){
// 		if(depth == 2){
// 			if(team==0){
// 				start_score = start_score + (arr[answer.get(0)][answer.get(1)] + arr[answer.get(1)][answer.get(0)]);	
// 				return;
// 			}
// 			else{
// 				link_score = link_score + (arr[answer.get(0)][answer.get(1)] + arr[answer.get(1)][answer.get(0)]);
// 				return;
// 			}
			
// 		}
// 		if(team == 0){
// 			for(int i=0;i<start.size();i++){
// 				if(start_visited[i]){
// 					continue;
// 				}
// 				start_visited[i] = true;
// 				answer.add(start.get(i));
// 				soccer(depth+1,team);
// 				answer.remove(answer.size()-1);
// 				start_visited[i] = false;
// 			}
// 		}
// 		else {
// 			for(int i=0;i<link.size();i++){
// 				if(link_visited[i]){
// 					continue;
// 				}
// 				link_visited[i] = true;
// 				answer.add(link.get(i));
// 				soccer(depth+1,team);
// 				answer.remove(answer.size()-1);
// 				link_visited[i] = false;
// 			}
// 		}
		
		
		
// 	}
// }

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        List<Integer>list = new ArrayList<>();
        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);
        for(int i=1;i<=N/2;i++){
            if(N%i==0){
                list.add(i);
            }
        }
        list.add(N);
        int result=0;
        if(list.size()<K){
            System.out.println(0);
        }
        else{
            while(K-->0){
                result = list.remove(0);
            }
            System.out.println(result);
        }   
    }
} 