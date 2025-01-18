import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

class point{
    int x;
    int y;
    point(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        Queue<point> q = new LinkedList<>();
        Queue<Integer> point = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int town = 0;
        int area = 0;
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                arr[i][j] = s.charAt(j)-'0';
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j]==1 && !visited[i][j]){
                    town++;
                    q.add(new point(i,j));
                    while(!q.isEmpty()){
                        point p = q.poll();
                        if(visited[p.x][p.y]){
                            continue;
                        }
                        area++;
                        visited[p.x][p.y]=true;
                        if(p.x-1>=0 && !visited[p.x-1][p.y] && arr[p.x-1][p.y]==1){
                            q.add(new point(p.x-1,p.y));
                        }
                        if(p.x+1<N && !visited[p.x+1][p.y] && arr[p.x+1][p.y]==1){
                            q.add(new point(p.x+1,p.y));
                        }
                        if(p.y-1>=0 && !visited[p.x][p.y-1] && arr[p.x][p.y-1]==1){
                            q.add(new point(p.x,p.y-1));
                        }
                        if(p.y+1<N && !visited[p.x][p.y+1] && arr[p.x][p.y+1]==1){
                            q.add(new point(p.x,p.y+1));
                        }
                    }
                    point.add(area);
                    area=0;
                }
            }
        }
        System.out.println(town);
        int[] ans = new int[town];
        int index=0;
        while(!point.isEmpty()){
           ans[index++] = point.poll();
        }
        Arrays.sort(ans);
        for(int i=0;i<town;i++){
            System.out.println(ans[i]);
        }

    }
}