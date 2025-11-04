import java.util.*;
class Pos{
    int x,y,cnt;
    Pos(int x ,int y, int cnt){
        this.x =x;
        this.y = y;
        this.cnt = cnt;
    }
}
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int n = maps.length; // 세로 길이
        int m = maps[0].length; // 가로 길이
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(0,0,1));
        boolean[][] visited = new boolean[n][m];
        while(!queue.isEmpty()){
            Pos p = queue.poll();
            if(p.x == (m-1) && p.y == (n-1)){
                answer = p.cnt;
            }
            if(visited[p.y][p.x]) continue;
            visited[p.y][p.x] = true;
            for(int i=0;i<4;i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx>=0 && nx<m && ny>=0 && ny<n && !visited[ny][nx] && maps[ny][nx] == 1){
                    queue.add(new Pos(nx,ny,p.cnt+1));
                }
            }
        }
        if(answer ==0) answer = -1;
        return answer;
    }
}