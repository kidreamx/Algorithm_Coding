import java.util.*;
import java.io.*;

public class Main{
    static class Point{
        int x, y, cnt;
        Point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};
        int min_cnt= Integer.MAX_VALUE;
        String[] sa = br.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);
        Queue<Point> queue = new LinkedList<>();
        int[][] arr = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            char[] chars = br.readLine().toCharArray();
            for(int j=0;j<M;j++){
                arr[i][j] = chars[j]-'0';
            }
        }
        queue.add(new Point(0,0,0));
        while(!queue.isEmpty()){
            Point p = queue.poll();
            if(p.x == M-1 && p.y == N-1){
                min_cnt = Math.min(min_cnt, p.cnt+1);
            }
            if(visited[p.y][p.x]){
                continue;
            }
            visited[p.y][p.x] = true;
            for(int i=0;i<4;i++){
                int x = p.x+dx[i];
                int y = p.y+dy[i];
                if(x>=0 && x<M && y>=0 && y<N && arr[y][x]==1){
                    queue.add(new Point(x,y,p.cnt+1));
                }
            }
        }
        System.out.println(min_cnt);
    }
}