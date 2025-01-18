import java.io.*;
import java.util.*;

public class Main{
    static class Point{
        int x;
        int y;
        int length;
        Point(int x, int y, int length){
            this.x = x;
            this.y = y;
            this.length = length;
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sa = br.readLine().split(" ");
        int n = Integer.parseInt(sa[0]);
        int m = Integer.parseInt(sa[1]);
        int[][] arr = new int[n][m];
        int[][] result = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(result[i],-1);
        }
        boolean[][] visited = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            sa = br.readLine().split(" ");
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(sa[j]);
                if(arr[i][j] == 2){
                    queue.add(new Point(j,i,0));
                    result[i][j] = 0;
                    visited[i][j] = true;
                }
                else if(arr[i][j] == 0){
                    result[i][j]  = 0;
                }
            }
        }
        while(!queue.isEmpty()){
            Point point = queue.poll();
            if(point.x+1<m && (arr[point.y][point.x+1]==1)){
                if(!visited[point.y][point.x+1]){
                    visited[point.y][point.x+1] = true;
                    result[point.y][point.x+1] = point.length+1;
                    queue.add(new Point(point.x+1,point.y,point.length+1));
                }
            }
            if(point.y+1<n && (arr[point.y+1][point.x]==1)){
                if(!visited[point.y+1][point.x]){
                    visited[point.y+1][point.x] = true;
                    result[point.y+1][point.x] = point.length+1;
                    queue.add(new Point(point.x,point.y+1,point.length+1));
                }
            }
            if(point.x-1>=0 && (arr[point.y][point.x-1]==1)){
                if(!visited[point.y][point.x-1]){
                    visited[point.y][point.x-1] = true;
                    result[point.y][point.x-1] = point.length+1;
                    queue.add(new Point(point.x-1,point.y,point.length+1));
                }
            }
            if(point.y-1>=0 && (arr[point.y-1][point.x]==1)){
                if(!visited[point.y-1][point.x]){
                    visited[point.y-1][point.x] = true;
                    result[point.y-1][point.x] = point.length+1;
                    queue.add(new Point(point.x,point.y-1,point.length+1));
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                bw.write(result[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}