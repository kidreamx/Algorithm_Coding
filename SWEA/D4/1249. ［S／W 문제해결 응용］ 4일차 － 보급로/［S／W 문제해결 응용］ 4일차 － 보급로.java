import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
    // tank가 이동하는 위치 값을 저장하고 이동 거리를 저장하기 위한 객체
    static class Point{
        int x , y, count;
        Point(int x, int y, int count){
            this.x =x;
            this.y =y;
            this.count = count;
        }
    }
    // 전역 변수 설정 지역
    static int T;
    static int N;
    static int[][] tank;

    // 방향 백터 변수 설정
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 기본 초기화 진행 파트
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            tank = new int[N][N];
            for(int i=0;i<N;i++){
                char[] chars = br.readLine().toCharArray();
                for(int j=0;j<N;j++){
                    tank[i][j] = chars[j]-'0';
                }
            }

            // 메인 로직
            Queue<Point> queue = new ArrayDeque<>();
            queue.add(new Point(0,0,tank[0][0]));
            // dp를 사용한 이유는 bfs로 진행하면 시간이 오래 걸리지만 dp를 사용하게 되면 중복 계산이 줄게 되고 또한 각 위치에서 최소 이동횟수가 매 점마다 보장이 되기 때문에
            // dp에 저장된 이동횟수보다 큰 이동횟수인 경우에는 queue에 넣지 않고 다른 경우를 탐색하게 해서 불필요한 중복계산을 막았다.
            int[][] dp = new int[N][N];
            // MAX_VALUE로 채워야 작은 값으로 초기화 되기 때문에 MAX_VALUE로 초기화를 진행했다.
            for(int i=0;i<N;i++){
                Arrays.fill(dp[i],Integer.MAX_VALUE);
            }
            while(!queue.isEmpty()){
                Point p = queue.poll();
                for(int i=0;i<4;i++){
                    int nx = p.x+dx[i];
                    int ny = p.y+dy[i];
                    if(nx>=0 && nx<N && ny>=0 && ny<N ){
                        // 이 부분을 통해서 p객체의 count값과 이동할 위치의 tank값을 더한게 거리값인데 이게 최소이면 초기화해서 계속 이동시키고
                        // 최소가 아니면 다른 방향으로 이동할 수 있는지 확인한다.
                        int distance = p.count + tank[ny][nx];
                        if(distance<dp[ny][nx]){
                            dp[ny][nx] = distance;
                            queue.add(new Point(nx,ny,distance));
                        }
                    }
                }
            }
            // 결국 끝점의 최소 이동거리를 알아야하기 때문에 dp[N-1][N-1]이 정답이 되게 된다.
            sb.append("#"+t+" "+dp[N-1][N-1]+"\n");

        }
        System.out.println(sb);
    }
}