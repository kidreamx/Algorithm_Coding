import java.io.*;
import java.util.*;

public class Main {
    static Queue<Point> queue;
    static int N,M, after_count2;
    static int[][] virus;
    static int[][] copy_virus;
    static int max;
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sa = br.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        virus = new int[N][M];
        copy_virus = new int[N][M];
        max = Integer.MIN_VALUE;
        queue = new LinkedList<>();
        for(int i=0;i<N;i++){
            sa = br.readLine().split(" ");
            for(int j=0;j<M;j++){
                virus[i][j] = Integer.parseInt(sa[j]);
                if(virus[i][j] == 2){
                    queue.add(new Point(i,j));
                }

            }
        }
        dfs(0);
        bw.write(max+"");

        br.close();
        bw.flush();
        bw.close();

    }
    static void dfs(int wallCnt) {
        //벽이 3개가 설치 된 경우 bfs 탐색 시작
        if(wallCnt == 3) {
            bfs();
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(virus[i][j] == 0) {
                    virus[i][j] = 1;
                    dfs(wallCnt+1);
                    virus[i][j] = 0;
                }
            }
        }
    }
    public static void bfs(){
        boolean[][] visited = new boolean[N][M];
        Queue<Point> Copy_Queue = new LinkedList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(virus[i][j] == 2) {
                    Copy_Queue.add(new Point(i,j));
                }
            }
        }
        for (int i = 0; i < N; i++) {
            copy_virus[i] = virus[i].clone();
        }
        while(!Copy_Queue.isEmpty()){
            Point p = Copy_Queue.poll();
            visited[p.x][p.y] = true;
            if(p.x!= N-1){
                if(copy_virus[p.x+1][p.y] == 0 && !visited[p.x+1][p.y]){
                    copy_virus[p.x+1][p.y] = 2;
                    Copy_Queue.add(new Point(p.x+1,p.y));
                }


            }
            if(p.y != M-1) {
                if(copy_virus[p.x][p.y+1] ==0 && !visited[p.x][p.y+1]) {
                    copy_virus[p.x][p.y+1]=2;
                    Copy_Queue.add(new Point(p.x, p.y + 1));
                }
            }
            if(p.x != 0){
                if(copy_virus[p.x-1][p.y] ==0 && !visited[p.x-1][p.y]) {
                    copy_virus[p.x-1][p.y]=2;
                    Copy_Queue.add(new Point(p.x-1, p.y ));
                }

            }
            if(p.y !=0){
                if(copy_virus[p.x][p.y-1] ==0 && !visited[p.x][p.y-1]) {
                    copy_virus[p.x][p.y-1]=2;
                    Copy_Queue.add(new Point(p.x, p.y -1));
                }

            }
        }
        funcSafeZone(copy_virus);
    }
    private static void funcSafeZone(int[][] copy_virus) {
        int safeZone =0;
        for(int i=0; i<N ; i++) {
            for(int j=0; j<M; j++) {
                if(copy_virus[i][j] == 0) {
                    safeZone++;
                }
            }
        }
        if (max < safeZone) {
            max = safeZone;
        }
    }
}