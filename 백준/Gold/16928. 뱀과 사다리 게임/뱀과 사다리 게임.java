import java.util.*;
import java.io.*;

public class Main{
    static class Pos{
        int x , cnt;
        Pos(int x, int cnt){
            this.x= x;
            this.cnt =cnt;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);
        int[] ladder = new int[101];
        int[] snack = new int[101];
        for(int i=0;i<N;i++){
            sa = br.readLine().split(" ");
            int x = Integer.parseInt(sa[0]);
            int y = Integer.parseInt(sa[1]);
            ladder[x] = y;
        }
        for(int i=0;i<M;i++){
            sa = br.readLine().split(" ");
            int x = Integer.parseInt(sa[0]);
            int y = Integer.parseInt(sa[1]);
            snack[x] = y;
        }
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(1,0));
        boolean[] visited = new boolean[101];
        int ans = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            Pos pos = queue.poll();
            if(pos.x == 100){
                ans = Math.min(ans,pos.cnt);
            }
            if(visited[pos.x]) continue;
            visited[pos.x] = true;
            if(ladder[pos.x]>0){
                if(visited[ladder[pos.x]]) continue;
                pos.x = ladder[pos.x];
            }
            if(snack[pos.x]>0){
                if(visited[snack[pos.x]]) continue;
                pos.x = snack[pos.x];
            }
            for (int i = 1; i <= 6; i++) {
                if (pos.x + i > 100) continue;
                if (visited[pos.x + i]) continue;
                queue.add(new Pos(pos.x + i, pos.cnt + 1));
            }
        }
        System.out.println(ans);
    }
}