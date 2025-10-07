import java.util.*;
class Point{
    int x, y;
    Point(int x, int y){
        this.x= x;
        this.y = y;
    }
}
class Solution {
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        boolean[][] moving = new boolean[storage.length][storage[0].length()];
        for(int i=0;i<storage.length;i++){
            Arrays.fill(moving[i],true);
        }
        for(int i=0;i<requests.length;i++){
            boolean[][] tmp = new boolean[storage.length][storage[0].length()];
            for(int j=0;j<storage.length;j++){
                for(int k=0;k<storage[j].length();k++){
                    tmp[j][k] = moving[j][k];
                }
            }
            if(requests[i].length()==1){
                // 지게차로 접근 가능할때
                for(int j=0;j<storage.length;j++){
                    for(int k=0;k<storage[j].length();k++){
                        if(j==0 || j== (storage.length-1) || k==0 || k==(storage[j].length()-1)){
                        if(storage[j].charAt(k) == requests[i].charAt(0)){
                                tmp[j][k] = false; 
                        }
                       if(!moving[j][k]){
                            Queue<Point> queue =new ArrayDeque<>();
                            queue.add(new Point(k,j));
                            boolean[][] visited = new boolean[moving.length][moving[0].length];
                            while(!queue.isEmpty()){
                                Point p = queue.poll();
                                if(visited[p.y][p.x]) continue;
                                visited[p.y][p.x] = true;
                                if(!moving[p.y][p.x]){
                                    for(int r=0;r<4;r++){
                                        int nx = p.x + dx[r];
                                        int ny = p.y + dy[r];
                                        if(nx>=0 && nx<storage[j].length()&& ny>=0 && ny<storage.length && !visited[ny][nx]){
                                            if(moving[ny][nx] && (storage[ny].charAt(nx) == requests[i].charAt(0))){
                                                tmp[ny][nx] = false;
                                            }
                                            if(!moving[ny][nx]){
                                                queue.add(new Point(nx,ny));
                                            }
                                        }
                                    }
                                }
                            }
                        }    
                    }
                }
                }
            }else {
                for(int j=0;j<storage.length;j++){
                    for(int k=0;k<storage[j].length();k++){
                        if(requests[i].charAt(0)== storage[j].charAt(k)){
                            tmp[j][k] = false;
                        }
                    }
                }
            }
            moving = tmp;
        }
        for(int i=0;i<storage.length;i++){
            for(int j=0;j<storage[i].length();j++){
                if(moving[i][j]) answer++;
            }
        }
        return answer;
    }
}