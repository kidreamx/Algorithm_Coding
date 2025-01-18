import java.util.*;
import java.io.*;

public class Main{
    static int N,M;
    static int[] arr,out;
    static StringBuilder sb;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        arr = new int[N];
        out = new int[M];
        visited = new boolean[N];
        sa = br.readLine().split(" ");
        sb = new StringBuilder();
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(sa[i]);
        }
        Arrays.sort(arr);
        dfs(0,0);
        System.out.println(sb);
    }
    static void dfs(int depth, int start){
        if(depth == M){
            for(int i=0;i<M;i++){
                sb.append(out[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int before=0;
        for(int i=start;i<N;i++){
            if(visited[i] || (before == arr[i])){
                continue;
            }

            before = arr[i];
            visited[i] = true;
            out[depth] = arr[i];
            dfs(depth+1,i+1);
            visited[i] = false;
        }
    }
}