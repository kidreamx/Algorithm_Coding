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
    static List<Pos> snack = new ArrayList<>();
    static int N,K,L,d,time;
    static int[] direct;
    static int[][] maps;
    static boolean[][] body;
    static Pos head, tail;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        maps = new int[N+1][N+1];
        direct =  new int[10001];
        body = new boolean[N+1][N+1];
        head = new Pos(1,1);
        tail = new Pos(1,1);
        body[1][1] = true;
        snack.add(new Pos(head.x,head.y));
        d=0;
        time=1;
        for(int i=0;i<K;i++){
            String[] sa = br.readLine().split(" ");
            int col = Integer.parseInt(sa[0]);
            int row = Integer.parseInt(sa[1]);
            maps[col][row] = 1;
        }
        L = Integer.parseInt(br.readLine());
        for(int i=0;i<L;i++){
            String[] sa = br.readLine().split(" ");
            int time = Integer.parseInt(sa[0]);
            char c = sa[1].charAt(0);
            if(c=='L'){
                direct[time] = 1;
            }else if(c=='D'){
                direct[time] = 2;
            }
        }
        while(true){

            if(canMove()){
                move();
                changeDirect(time);
            }else{
                break;
            }
            time++;
        }
        System.out.println(time);

    }
    // 2) 이동시 벽인지 자신의 몸통인지 먼저 확인
    static boolean canMove(){
        int nx = head.x+dx[d];
        int ny = head.y+dy[d];
        if(nx<=0 || ny<=0 || nx>N || ny>N || body[ny][nx]){
            return false;
        }else{
            head.x = nx;
            head.y = ny;
            return true;
        }
    }
    // 1) 방향을 바꾸는지 확인
    static void changeDirect(int time){
        if(direct[time]>0){
            if(direct[time]==1){
                d = (d+3)%4;
            }else if(direct[time]==2){
                d = (d+1)%4;
            }
        }
    }
    static void move(){

        // 이동하는 곳이 사과인지 아닌지 부터 확인
        if(maps[head.y][head.x]==1){
            maps[head.y][head.x] = 0;
            body[head.y][head.x] = true;
            Pos p = new Pos(head.x,head.y);
            snack.add(p);

        }else{
            body[head.y][head.x] = true;
            Pos p = new Pos(head.x,head.y);
            snack.add(p);
            body[tail.y][tail.x] = false;
            snack.remove(0);
            tail = snack.get(0);
        }
    }
}