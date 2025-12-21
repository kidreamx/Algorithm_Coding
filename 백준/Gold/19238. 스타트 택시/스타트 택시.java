import java.util.*;
import java.io.*;

public class Main{
    static class Pos{
        int x ,y,cnt=0;
        Pos(int x, int y){
            this.x =x ;
            this.y = y;
        }
        Pos(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static class Car{
        Pos pos;
        int storage;
        Car(Pos pos , int storage){
            this.pos = pos;
            this.storage = storage;
        }
    }
    static class Passenger implements Comparable<Passenger>{
        int index;
        Pos pos;
        int route;
        Passenger(int index,Pos pos, int route){
            this.index = index;
            this.pos = pos;
            this.route = route;
        }
        @Override
        public int compareTo(Passenger o){
            if(this.route == o.route){
                // 행번호가 작은 순번대로
                if(this.pos.y == o.pos.y){
                    // 행번호가 같으면 열번호 순번대로
                    return this.pos.x - o.pos.x;
                }
                return this.pos.y - o.pos.y;
            }
            return this.route - o.route;
        }
    }
    static int N,M,initStorage;
    static int[][] wall;
    static Car car;
    static int[][] passenger;
    static List<Pos> destination;
    static boolean[] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa  = br.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        initStorage = Integer.parseInt(sa[2]);
        wall = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            sa = br.readLine().split(" ");
            for(int j=1;j<=N;j++){
                wall[i][j] = Integer.parseInt(sa[j-1]);
            }
        }
        sa = br.readLine().split(" ");
        car = new Car(new Pos(Integer.parseInt(sa[1]),Integer.parseInt(sa[0])),initStorage);
        passenger = new int[N+1][N+1];
        destination = new ArrayList<>();
        for(int i=0;i<M;i++){
            sa = br.readLine().split(" ");
            passenger[Integer.parseInt(sa[0])][Integer.parseInt(sa[1])] = i+1;
            destination.add(new Pos(Integer.parseInt(sa[3]),Integer.parseInt(sa[2])));
        }
        visited = new boolean[M+1];
        for(int i=0;i<M;i++){
            Passenger p = findPassenger();
            // 갈수 없거나 연료 부족인 경우
            if(p == null){
                System.out.println(-1);
                return;
            }
            // 갈수 있는 경우 (태우러)
            car.pos = p.pos;
            passenger[p.pos.y][p.pos.x] = 0;
//            System.out.print(car.storage + " - "+ p.route +" - ");
            car.storage -= p.route;
            int route = minRoute(new Pos(car.pos.x, car.pos.y),destination.get(p.index-1));
            if(!canGo(car.pos,destination.get(p.index-1)) || car.storage< route){
                System.out.println(-1);
                return;
            }
//            System.out.println(route +" + "+2*route);
            car.storage = car.storage - route + 2*route;
            car.pos = destination.get(p.index-1);

        }
        System.out.println(car.storage);
    }
    static boolean canGo(Pos start, Pos end){
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(start);
        boolean[][] visited = new boolean[N+1][N+1];
        while(!queue.isEmpty()){
            Pos p = queue.poll();
            if(visited[p.y][p.x]) continue;
            visited[p.y][p.x] = true;
            if(p.x == end.x && p.y == end.y){
                return true;
            }
            for(int i=0;i<4;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx<=0 || ny<=0 || nx>N || ny>N){
                    continue;
                }
                if(!visited[ny][nx] && wall[ny][nx] ==0){
                    queue.add(new Pos(nx,ny));
                }
            }
        }
        return false;
    }
    static int minRoute(Pos start, Pos end){
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(start);
        boolean[][] visited = new boolean[N+1][N+1];
        while(!queue.isEmpty()){
            Pos pos = queue.poll();
            if(visited[pos.y][pos.x]) continue;
            visited[pos.y][pos.x] = true;
            if(pos.x == end.x && pos.y == end.y){
                return pos.cnt;
            }
            for(int i=0;i<4;i++){
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                if(nx<=0 || ny<=0 || nx>N || ny>N){
                    continue;
                }
                if(!visited[ny][nx] && wall[ny][nx] ==0){
                    queue.add(new Pos(nx,ny,pos.cnt+1));
                }
            }
        }
        return 0;
    }

    /*
        태울 승객중에 누가 가장 작은 지 알려주는 메서드
     */
    static Passenger findPassenger(){
        // 1: 1~ M 까지 돌면서 아직 안데려다준 고객이 있으면 pq에 시간 검사해서 다 넣는다.
        // 1-1 : 출발지에서 도착지가 갈수 없거나 , 남은 연료보다 가는데 까지 가는 연료가 많이 들면 안됨
//        PriorityQueue<Passenger> pq = new PriorityQueue<>();
//        for(int i=1;i<=M;i++){
//            if(visited[i]) continue;
//            int storage = minRoute(car.pos,passenger.get(i-1));
//            if(!canGo(car.pos,passenger.get(i-1)) || storage > car.storage){
//                return null;
//            }
//            pq.add(new Passenger(i,passenger.get(i-1),storage));
//        }
//        return pq.poll();
        PriorityQueue<Passenger> pq = new PriorityQueue<>();
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(car.pos.x, car.pos.y));
        boolean[][] visited = new boolean[N+1][N+1];
        if(passenger[car.pos.y][car.pos.x]>0){
            return new Passenger(passenger[car.pos.y][car.pos.x], new Pos(car.pos.x, car.pos.y),0);
        }
        int minDist = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            Pos p = queue.poll();
            if(p.cnt >= minDist) break;
            for(int i=0;i<4;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx<=0 || ny<=0 || nx>N || ny>N){
                    continue;
                }
                if (wall[ny][nx] == 1 || visited[ny][nx]) continue;
                if(passenger[ny][nx]>0){
                    if (minDist > p.cnt + 1) {
                        minDist = p.cnt + 1;
                    }
                    pq.add(new Passenger(passenger[ny][nx], new Pos(nx,ny),p.cnt+1));
                }
                visited[ny][nx] = true;
                queue.add(new Pos(nx, ny, p.cnt + 1));
            }
        }
        return pq.poll();
    }



}