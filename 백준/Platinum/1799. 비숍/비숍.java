import java.util.*;
import java.io.*;

public class Main{
    static class Point{
        int x ,y;
        Point(int x, int y){
            this.x =x ;
            this.y = y;
        }
    }
    static int N;
    static int L;
    static int ans;
    static int[][] chess;
    static List<List <Point>> cPoint;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        chess = new int[N][N];
        for(int i=0;i<N;i++){
            String[] sa = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                chess[i][j] = Integer.parseInt(sa[j]);
            }
        }
        cPoint = new ArrayList<>();
        ans = 0;
        for(int i=0;i<=2*N-1;i++){
            cPoint.add(new ArrayList<>());
        }
        L = 2*N-1;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(chess[i][j]==1) cPoint.get(i+j).add(new Point(j,i));
            }
        }
        dfs(0,0,new boolean[L]);
        System.out.println(ans);
    }
    static void dfs(int depth , int cnt , boolean[] visited){
        if(ans>=cnt+L-depth) return;
        if(depth == L){
            ans = Math.max(ans,cnt);
            return;
        }
        for(Point p : cPoint.get(depth)){
            int line = p.y- p.x + (N-1);
            if(!visited[line]) {
                visited[line] = true;
                dfs(depth + 1, cnt + 1, visited);
                visited[line] = false;
            }
        }
        // 아얘 놓을자리가 없어서 안놓고 넘길때
        dfs(depth+1, cnt, visited);
    }
}