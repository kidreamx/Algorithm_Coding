import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Main {
    static class Point{
        int x,  y ,  k , count;
        Point(int x, int y, int k, int count){
            this.x = x;
            this.y = y;
            this.k = k;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        String[] sa = br.readLine().split(" ");
        int W = Integer.parseInt(sa[0]);
        int H = Integer.parseInt(sa[1]);
        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};
        int[] s_dx = {1,2,2,1,-1,-2,-2,-1};
        int[] s_dy  = {-2,-1,1,2,2,1,-1,-2};
        int[][] mokey = new int[H][W];
        boolean[][][] visited = new boolean[H][W][K+1];
        for(int i=0;i<H;i++) {
            sa = br.readLine().split(" ");
            for(int j=0;j<W;j++) {
                mokey[i][j] = Integer.parseInt(sa[j]);
            }
        }

        int min = Integer.MAX_VALUE;
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0,0,K,0));
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            if(p.x==W-1 && p.y==H-1) {
                min = Math.min(min,p.count);
            }
            for(int i=0;i<8;i++) {
                int x_1 = p.x + s_dx[i];
                int y_1 = p.y + s_dy[i];
                if(i>=0 && i<4) {
                    int x = p.x + dx[i];
                    int y = p.y + dy[i];
                    if (x >= 0 && x < W && y >= 0 && y < H && !visited[y][x][p.k] &&  mokey[y][x] == 0) {
                            visited[y][x][p.k]= true;
                            queue.add(new Point(x, y, p.k, p.count + 1));
                    }
                }
                if(p.k>0) {
                    if (x_1 >= 0 && x_1 < W && y_1 >= 0 && y_1 < H && !visited[y_1][x_1][p.k - 1] && mokey[y_1][x_1] == 0) {
                            visited[y_1][x_1][p.k-1] = true;
                            queue.add(new Point(x_1, y_1, p.k - 1, p.count + 1));
                    }
                }
            }
        }
        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

}
