import java.io.*;
import java.util.*;
class Point{
    int x, y,count;

    public Point(int x, int y,int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }

}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int start_x , start_y , destination_x, destination_y;
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited;
        while(N-->0){
            int line = Integer.parseInt(br.readLine());
            visited = new boolean[line][line];
            String[] sa = br.readLine().split(" ");
            start_x = Integer.parseInt(sa[0]);
            start_y = Integer.parseInt(sa[1]);
            sa = br.readLine().split(" ");
            destination_x = Integer.parseInt(sa[0]);
            destination_y = Integer.parseInt(sa[1]);
            int count=0;
            int min_count = Integer.MAX_VALUE;
            queue.add(new Point(start_x,start_y,count));
            while(!queue.isEmpty()){
                Point p = queue.poll();
                visited[p.y][p.x] = true;
                if(p.x==destination_x && p.y==destination_y){
                    if(min_count>p.count){
                        min_count = p.count;
                    }
                }
                else {
                    if ((p.x - 2) >= 0 && (p.y - 1) >= 0) {
                        if(!visited[p.y - 1][p.x - 2])
                        {
                            int point = p.count;
                            point = point +1;
                            queue.add(new Point(p.x - 2, p.y - 1, point));
                            visited[p.y - 1][p.x - 2] = true;
                        }
                    }
                    if ( (p.x - 1) >= 0 && (p.y - 2) >= 0) {
                        if(!visited[p.y - 2][p.x - 1])
                        {
                            int point = p.count;
                            point = point +1;
                            queue.add(new Point(p.x - 1, p.y - 2, point ));
                            visited[p.y - 2][p.x - 1] = true;
                        }
                    }
                    if ((p.x - 1) >= 0 && (p.y + 2) < line ) {
                        if(!visited[p.y + 2][p.x - 1]) {
                            int point = p.count;
                            point = point +1;
                            queue.add(new Point(p.x - 1, p.y + 2, point ));
                            visited[p.y + 2][p.x - 1] = true;
                        }
                    }
                    if ((p.x - 2) >= 0 && (p.y + 1) < line) {
                        if(!visited[p.y + 1][p.x - 2])
                        {
                            int point = p.count;
                            point = point +1;
                            queue.add(new Point(p.x - 2, p.y + 1, point));
                            visited[p.y + 1][p.x - 2] = true;
                        }
                    }
                    if ((p.x + 1) <line && (p.y - 2) >=0  ) {
                        if(!visited[p.y - 2][p.x + 1])
                        {
                            int point = p.count;
                            point = point +1;
                            queue.add(new Point(p.x + 1, p.y - 2, point ));
                            visited[p.y - 2][p.x + 1] = true;
                        }
                    }
                    if ((p.x + 2) <line && (p.y - 1) >= 0 ) {
                        if(!visited[p.y - 1][p.x + 2])
                        {
                            int point = p.count;
                            point = point +1;
                            queue.add(new Point(p.x + 2, p.y - 1, point ));
                            visited[p.y - 1][p.x + 2] = true;
                        }
                    }
                    if ( p.x + 1 <line && p.y + 2 < line) {
                        if(!visited[p.y + 2][p.x + 1])
                        {
                            int point = p.count;
                            point = point +1;
                            queue.add(new Point(p.x + 1, p.y + 2, point ));
                            visited[p.y + 2][p.x + 1] = true;
                        }
                    }
                    if (p.x + 2 <line && p.y + 1 < line ) {
                        if(!visited[p.y + 1][p.x + 2])
                        {
                            int point = p.count;
                            point = point +1;
                            queue.add(new Point(p.x + 2, p.y + 1, point ));
                            visited[p.y + 1][p.x + 2] = true;
                        }
                    }
                }

            }
            bw.write(min_count+"\n");
        }
        br.close();
        bw.flush();
        bw.close();

    }

}
