import java.util.*;
class Pos{
    int x, y, sum;
    Pos(int x, int y, int sum){
        this.x = x;
        this.y = y;
        this.sum = sum;
    }
}
class Solution {
    public int[] solution(String[] maps) {
        int[] answer = {};
        List<Integer> ans = new ArrayList<>();
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        char[][] map = new char[maps.length][maps[0].length()];
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                map[i][j] = maps[i].charAt(j);
            }
        }
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        Queue<Pos> queue = new ArrayDeque<>();
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(visited[i][j] || map[i][j] == 'X') continue;
                int sum = 0;
                queue.add(new Pos(j,i,map[i][j]-'0'));
                while(!queue.isEmpty()){
                    Pos p = queue.poll();
                    if(visited[p.y][p.x]) continue;
                    sum += p.sum;
                    visited[p.y][p.x] = true;
                    for(int r=0;r<4;r++){
                        int nx = p.x+dx[r];
                        int ny = p.y+dy[r];
                        if(nx<0 || ny<0 || nx>=maps[0].length() || ny>=maps.length){
                            continue;
                        }
                        if(map[ny][nx] != 'X'){
                            queue.add(new Pos(nx,ny,(map[ny][nx]-'0')));
                        }
                    }
                }
                if(sum!=0) ans.add(sum);
            }
        }
        if(ans.size()==0) return new int[]{-1};
        Collections.sort(ans);
        answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}