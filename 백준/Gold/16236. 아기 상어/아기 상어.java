import java.util.*;
import java.io.*;
public class Main{
    static class Pos{
        int x, y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static class Shark implements Comparable<Shark>{
        Pos p;
        int size;
        int distance;
        int cnt;
        Shark(Pos p, int size, int distance, int cnt){
            this.p = p;
            this.size = size;
            this.distance= distance;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Shark o){
            if(this.distance == o.distance){
                if(this.p.y == o.p.y){
                    return this.p.x - o.p.x;
                }else{
                    return this.p.y - o.p.y;
                }
            }else{
                return this.distance - o.distance;
            }
        }
    }
    static BufferedReader br;
    static int N, res;
    static int[][] fish;
    static int[] dx= {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Shark shark;
    static PriorityQueue<Shark> pq;
    public static void main(String[] args) throws IOException{
        br= new BufferedReader(new InputStreamReader(System.in));
        input();
        pq = new PriorityQueue<>();
        while(findFish()){
            shark = pq.poll();
            pq = new PriorityQueue<>();
            res+= shark.distance;
            shark.distance=0;
            fish[shark.p.y][shark.p.x] = 0;

        }
        System.out.println(res);
    }
    static void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        res = 0;
        fish = new int[N][N];
        for(int i=0;i<N;i++){
            String[] sa = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                fish[i][j] = Integer.parseInt(sa[j]);
                if(fish[i][j]==9){
                    shark = new Shark(new Pos(j,i), 2, 0,0);
                }
            }
        }
    }
    static boolean findFish(){
        // 먼저 현재 상어의 위치에서 가장 가까운 먹을 수 있는 물고기를 찾아야한다.
        Queue<Shark> queue = new ArrayDeque<>();
        queue.add(shark);
        boolean[][] visited = new boolean[N][N];
        while(!queue.isEmpty()){
            Shark s = queue.poll();
            if(visited[s.p.y][s.p.x]) continue;
            visited[s.p.y][s.p.x] = true;
            for(int i=0;i<4;i++){
                int nx = s.p.x+dx[i];
                int ny = s.p.y+dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                if(visited[ny][nx]) continue;
                // 먹을수 있는지 , 지나갈지 여부 판단후 pq에 넣는다. (먹을수 있는건)
                // 먼저 지나갈수 있는지 부터 판단
                //  지나가려면 상어의 사이즈보다 작거나 같으면 된다.
                if(s.size>= fish[ny][nx]){
                    // 여기서 먹을수 있는 것들
                    if(s.size > fish[ny][nx] && fish[ny][nx]!=0){
                        if(s.cnt+1 == s.size){
                            pq.add(new Shark(new Pos(nx,ny),s.size+1,s.distance+1,0));
                        }else{
                            pq.add(new Shark(new Pos(nx,ny),s.size,s.distance+1,s.cnt+1));
                        }
                        queue.add(new Shark(new Pos(nx,ny),s.size+1,s.distance+1,s.cnt));
                    }else{
                        queue.add(new Shark(new Pos(nx,ny),s.size,s.distance+1,s.cnt));
                    }
                }
            }
        }
        fish[shark.p.y][shark.p.x] = 0;
        return !pq.isEmpty();
    }

}