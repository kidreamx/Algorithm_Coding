import java.util.*;
import java.io.*;

public class Main{
    static class Point{
        int x, y, time;
        Point(int x,int y,int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};
        for(int t=0;t<T;t++){
            String[] sa = br.readLine().split(" ");
            int w = Integer.parseInt(sa[0]);
            int h = Integer.parseInt(sa[1]);
            int min_time = Integer.MAX_VALUE;
            Queue<Point> queue = new LinkedList<>();
            Queue<Point> fire = new LinkedList<>();
            char[][] arr = new char[h][w];
            boolean[][] visited = new boolean[h][w];
            for(int i=0;i<h;i++){
                char[] chars = br.readLine().toCharArray();
                for(int j=0;j<w;j++){
                    arr[i][j] = chars[j];
                    if(arr[i][j] == '@'){
                        queue.add(new Point(j,i,0));
                    }
                    else if(arr[i][j] == '*'){
                        fire.add(new Point(j,i,0));
                    }
                }
            }
            while(!queue.isEmpty()){
                int size = fire.size();
                while(size-->0){
                    Point point = fire.poll();
                    for(int i=0;i<4;i++){
                        int x = point.x +dx[i];
                        int y=  point.y+ dy[i];
                        if(x>=0 && x<w && y>=0 && y<h && arr[y][x]=='.'){
                            arr[y][x] = '*';
                            fire.add(new Point(x,y,0));
                        }
                    }
                }

                int people_size = queue.size();
                for(int r=0;r<people_size;r++) {
                    Point p = queue.poll();
                    if (p.x == w - 1 || p.y == h - 1 || p.x == 0 || p.y == 0) {
                        min_time = Math.min(min_time, p.time + 1);
                    }
                    if (visited[p.y][p.x]) {
                        continue;
                    }
                    visited[p.y][p.x] = true;
                    arr[p.y][p.x] = '.';
                    for (int i = 0; i < 4; i++) {
                        int x = p.x + dx[i];
                        int y = p.y + dy[i];
                        if (x >= 0 && x < w && y >= 0 && y < h && arr[y][x] == '.') {
                            queue.add(new Point(x, y, p.time + 1));
                            arr[y][x] = '@';
                        }
                    }
                }

            }

            if(min_time==Integer.MAX_VALUE){
                sb.append("IMPOSSIBLE").append("\n");
            }
            else{
                sb.append(min_time).append("\n");
            }
        }
        System.out.println(sb);
    }
}