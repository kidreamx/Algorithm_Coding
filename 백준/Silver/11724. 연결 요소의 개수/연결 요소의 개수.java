import java.util.*;
import java.io.*;

class Main{
    static boolean[] visited;
    static List<List<Integer>> list;
    static int N,M;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        list = new ArrayList<>();
        visited = new boolean[N+1];
        int count=0;
        for(int i=0;i<N+1;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++){
            sa = br.readLine().split(" ");
            int first = Integer.parseInt(sa[0]);
            int second = Integer.parseInt(sa[1]);
            list.get(first).add(second);
            list.get(second).add(first);
        }
        for(int i=1;i<=N;i++){
            if(!visited[i]){
                dfs(i,list);
                count++;
            }
        }
        System.out.println(count);

    }
    static void dfs(int node, List<List<Integer>> list){
        visited[node] = true;
        for(int index : list.get(node)){
            if(!visited[index]){
                dfs(index, list);
            }
        }
    }
}