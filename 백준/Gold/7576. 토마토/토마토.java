import java.util.*;
import java.io.*;

class Main{
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int M = Integer.parseInt(sa[0]);
        int N = Integer.parseInt(sa[1]);
        int zero_count=0;
        Queue<Point> queue = new LinkedList<>();
        int[][] tomato = new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            sa = br.readLine().split(" ");
            for(int j=1;j<=M;j++){
                tomato[i][j] = Integer.parseInt(sa[j-1]);
                if(tomato[i][j]==1){
                    queue.add(new Point(j,i));
                }
                else if(tomato[i][j]==0){
                    zero_count++;
                }
            }
        }
        int days;
        int count = 0;
        while(!queue.isEmpty()){
            days = queue.size();
            while(days-->0) {
                Point p = queue.poll();
                if(p.x-1>0 && tomato[p.y][p.x-1]==0){
                    tomato[p.y][p.x-1] = 1;
                    queue.add(new Point(p.x-1,p.y));
                    zero_count--;
                }
                if(p.x+1<=M && tomato[p.y][p.x+1]==0){
                    tomato[p.y][p.x+1] = 1;
                    queue.add(new Point(p.x+1, p.y));
                    zero_count--;
                }
                if(p.y-1>0 && tomato[p.y-1][p.x]==0){
                    tomato[p.y-1][p.x] = 1;
                    queue.add(new Point(p.x,p.y-1));
                    zero_count--;
                }
                if(p.y+1<=N && tomato[p.y+1][p.x]==0){
                    tomato[p.y+1][p.x] = 1;
                    queue.add(new Point(p.x, p.y+1));
                    zero_count--;
                }
            }
            count++;
        }
        if(zero_count>0){
            System.out.println(-1);
        }
        else {
            System.out.println(count - 1);
        }
    }
}