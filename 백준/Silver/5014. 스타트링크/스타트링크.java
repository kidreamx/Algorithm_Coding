import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int F = Integer.parseInt(sa[0]);
        int S = Integer.parseInt(sa[1]);
        int G = Integer.parseInt(sa[2]);
        int U = Integer.parseInt(sa[3]);
        int D = Integer.parseInt(sa[4]);
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{S,0});
        int ans = 0;
        boolean canGo = false;
        boolean[] visited = new boolean[F+1];
        while(!queue.isEmpty()){
            int[] n = queue.poll();
            if(n[0]==G){
                canGo = true;
                ans = n[1];
                break;
            }
            if(visited[n[0]]) continue;
            visited[n[0]] = true;
            if(n[0]+U<=F){
                queue.add(new int[]{n[0]+U,n[1]+1});
            }
            if(n[0]-D>0){
                queue.add(new int[]{n[0]-D,n[1]+1});
            }
        }
        if(canGo) System.out.println(ans);
        else System.out.println("use the stairs");
    }
}