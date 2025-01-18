import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static char[][] arr;
    static int[][] visited;
    static int count;
    static int count1;
    static Queue<Point> q;
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static void bfs_1(int[][] visited , char[][] arr){
        q = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visited[i][j] == 0){
                    q.add(new Point(i,j));
                    while(!q.isEmpty()) {
                        Point p = q.poll();
                        if(visited[p.x][p.y] == 1){
                            continue;
                        }
                        visited[p.x][p.y] = 1;
                        char c = arr[p.x][p.y];
                        if (p.x - 1 >= 0) {
                            if (c == arr[p.x - 1][p.y] && visited[p.x - 1][p.y] != 1) {
                                q.add(new Point(p.x - 1, p.y));
                            }
                        }
                        if (p.x + 1 < N) {
                            if (c == arr[p.x + 1][p.y] && visited[p.x+1][p.y] != 1) {
                                q.add(new Point(p.x + 1, p.y));
                            }
                        }
                        if (p.y - 1 >= 0) {
                            if (c == arr[p.x][p.y - 1] && visited[p.x][p.y-1] != 1) {
                                q.add(new Point(p.x, p.y - 1));
                            }
                        }
                        if (p.y + 1 < N) {
                            if (c == arr[p.x][p.y + 1] && visited[p.x][p.y+1] != 1) {
                                q.add(new Point(p.x, p.y + 1));
                            }
                        }
                    }
                    count++;
                }

            }
        }
    }
    static void bfs_2(int[][] visited , char[][] arr){
        q = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visited[i][j] == 0){
                    q.add(new Point(i,j));
                    while(!q.isEmpty()) {
                        Point p = q.poll();
                        if(visited[p.x][p.y] == 1){
                            continue;
                        }
                        visited[p.x][p.y] = 1;
                        char c = arr[p.x][p.y];
                        if(c == 'G' || c == 'R'){
                            if (p.x - 1 >= 0) {
                                if (('R' == arr[p.x - 1][p.y] || 'G' == arr[p.x-1][p.y]) && visited[p.x - 1][p.y] != 1) {
                                    q.add(new Point(p.x - 1, p.y));
                                }
                            }
                            if (p.x + 1 < N) {
                                if (('R' == arr[p.x + 1][p.y] || 'G' == arr[p.x+1][p.y]) && visited[p.x + 1][p.y] != 1) {
                                    q.add(new Point(p.x + 1, p.y));
                                }
                            }
                            if (p.y - 1 >= 0) {
                                if (('R' == arr[p.x][p.y-1] || 'G' == arr[p.x][p.y-1]) && visited[p.x][p.y-1] != 1) {
                                    q.add(new Point(p.x, p.y - 1));
                                }
                            }
                            if (p.y + 1 < N) {
                                if (('R' == arr[p.x][p.y+1] || 'G' == arr[p.x][p.y+1]) && visited[p.x][p.y+1] != 1) {
                                    q.add(new Point(p.x, p.y + 1));
                                }
                            }
                        }
                        else {
                            if (p.x - 1 >= 0) {
                                if (c == arr[p.x - 1][p.y] && visited[p.x - 1][p.y] != 1) {
                                    q.add(new Point(p.x - 1, p.y));
                                }
                            }
                            if (p.x + 1 < N) {
                                if (c == arr[p.x + 1][p.y] && visited[p.x + 1][p.y] != 1) {
                                    q.add(new Point(p.x + 1, p.y));
                                }
                            }
                            if (p.y - 1 >= 0) {
                                if (c == arr[p.x][p.y - 1] && visited[p.x][p.y - 1] != 1) {
                                    q.add(new Point(p.x, p.y - 1));
                                }
                            }
                            if (p.y + 1 < N) {
                                if (c == arr[p.x][p.y + 1] && visited[p.x][p.y + 1] != 1) {
                                    q.add(new Point(p.x, p.y + 1));
                                }
                            }
                        }
                    }
                    count1++;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        visited = new int[N][N];
        count=0;
        count1=0;
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < N; j++) {
                arr[i][j] = input.charAt(j);
            }
        }
        bfs_1(visited, arr);
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                visited[i][j] = 0;
            }
        };
        bfs_2(visited, arr);
        bw.write(count + " " + count1);
        bw.flush();
        bw.close();

    }

}
