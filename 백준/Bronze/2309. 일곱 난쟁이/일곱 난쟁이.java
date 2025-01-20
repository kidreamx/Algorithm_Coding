import java.util.*;
import java.io.*;

public class Main{
    static int[] out;
    static int[] arr;
    static StringBuilder sb;
    static boolean is_print;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];
        out = new int[7];
        is_print= false;
        visited = new boolean[9];
        sb = new StringBuilder();
        for(int i=0;i<9;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        dfs(0,0);
        System.out.println(sb);
    }
    static void dfs(int depth, int start){
        if(depth == 7 && !is_print){
            int sum=0;
            for(int i=0;i<7;i++){
                sum+= out[i];
            }
            if(sum == 100){
                for(int i=0;i<7;i++){
                    sb.append(out[i]+"\n");
                }
                is_print= true;
            }
            return;
        }
        for(int i=start;i<9;i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            out[depth] = arr[i];
            dfs(depth+1,i+1);
            if(is_print){
                break;
            }
            visited[i] = false;
        }
    }
}