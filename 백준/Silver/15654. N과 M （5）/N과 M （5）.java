import java.util.*;
import java.io.*;
public class Main{
    static int N,M;
    static List<Integer>list = new ArrayList<>();
    static List<Integer>answer = new ArrayList<>();
    static boolean[] visited;
    static int[] num;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        visited = new boolean[N+1];
        sa = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            list.add(Integer.parseInt(sa[i]));
        }
        Collections.sort(list);
        dfs(0);
    }
    static void dfs(int depth){
        if(depth == M){
            for(int i=0;i<answer.size();i++){
                System.out.print(answer.get(i)+" ");
            }
            System.out.println();
            return;
        }
        for(int i=0;i<N;i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            answer.add(list.get(i));
            dfs(depth+1);
            answer.remove(answer.size()-1);
            visited[i] = false;
        }
    }
}