import java.util.*;
import java.io.*;

public class Main{
    static class Point{
        int x , y;
        Point(int x, int y){
            this.x =x;
            this.y =y;
        }
    }
    static int R,C;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static char[][] map;
    static boolean[][] fired;
    static boolean[][] visited;
    static Queue<Point> human;
    static Queue<Point> firefire;
    static boolean escape;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        R = Integer.parseInt(sa[0]);
        C = Integer.parseInt(sa[1]);
        map = new char[R][C];
        fired = new boolean[R][C];
        visited = new boolean[R][C];
        human= new ArrayDeque<>();
        firefire = new ArrayDeque<>();
        for(int i=0;i<R;i++){
            char[] chars = br.readLine().toCharArray();
            for(int j=0;j<C;j++){
                map[i][j] = chars[j];
                if(map[i][j] == 'J'){
                    human.add(new Point(j,i));
                    visited[i][j] = true;
                    map[i][j] = '.';
                }else if(map[i][j] == 'F'){
                    firefire.add(new Point(j,i));
                }
            }
        }
        int time=0;
        while(true){
            moving();
            time++;
            if(escape){
                break;
            }
            if(human.isEmpty()){
                break;
            }
        }
        if(escape){
            System.out.println(time);
        }else{
            System.out.println("IMPOSSIBLE");
        }
    }
    static void moving(){
        int humanSize = human.size();
        int fireSize = firefire.size();
        while(humanSize-->0){
            Point p = human.poll();
            if(map[p.y][p.x] == 'F'){
                continue;
            }
            if(p.x==C-1 || p.y == R-1 || p.x==0 || p.y==0){
                escape = true;
                break;
            }
            for(int i=0;i<4;i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx>=0 && nx<C && ny>=0 && ny<R && !visited[ny][nx] && map[ny][nx]=='.'){
                    visited[ny][nx] = true;
                    human.add(new Point(nx,ny));
                }
            }
        }
        while(fireSize-->0){
            Point p = firefire.poll();
            for(int i=0;i<4;i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx>=0 && nx<C && ny>=0 && ny<R && map[ny][nx]=='.'){
                    map[ny][nx] = 'F';
                    firefire.add(new Point(nx,ny));
                }
            }
        }
    }
}