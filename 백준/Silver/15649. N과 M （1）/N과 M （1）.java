import java.io.*;
import java.util.*;

public class Main{
    static int N,M;
    static List<Integer> list = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        visited= new boolean[N+1];
        dfs(0);
    }
    static void dfs(int depth){
        if(depth == M){
            for(int i=0;i<list.size();i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
            return;
        }
        for(int i=1;i<=N;i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            list.add(i);
            dfs(depth+1);
            visited[i] = false;
            list.remove(list.size()-1);
        }

    }
}

