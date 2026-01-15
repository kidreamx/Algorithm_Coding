import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x, y, len;
        Point(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
    
    // 섬의 경계면 좌표만 따로 저장할 리스트 (메모리 절약)
    static class Island {
        List<Point> borderPoints;
        Island() {
            borderPoints = new ArrayList<>();
        }
    }

    static int N;
    static int[][] map; // arr과 islandMap을 하나로 합쳐서 쓰는 게 효율적입니다.
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int min = Integer.MAX_VALUE;
    static List<Island> islands = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 섬 구분하기 (라벨링)
        labelIslands();

        // 2. 다리 놓기 (최단 거리 구하기)
        for (int i = 0; i < islands.size(); i++) {
            bfsBridge(i); // 각 섬별로 BFS 수행
        }

        System.out.println(min);
    }

    // 섬에 번호 매기기 (BFS)
    static void labelIslands() {
        visited = new boolean[N][N];
        int islandIdx = 2; // 바다(0), 원래땅(1)과 겹치지 않게 2부터 시작

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    Island island = new Island();
                    Queue<Point> q = new ArrayDeque<>();
                    
                    q.add(new Point(j, i, 0));
                    visited[i][j] = true;
                    map[i][j] = islandIdx; // 지도에 바로 번호 덮어쓰기

                    while (!q.isEmpty()) {
                        Point p = q.poll();
                        
                        boolean isBorder = false; // 경계면인지 확인
                        
                        for (int k = 0; k < 4; k++) {
                            int nx = p.x + dx[k];
                            int ny = p.y + dy[k];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                            // 방문 안 한 육지라면 같은 섬으로 확장
                            if (map[ny][nx] == 1 && !visited[ny][nx]) {
                                visited[ny][nx] = true;
                                map[ny][nx] = islandIdx;
                                q.add(new Point(nx, ny, 0));
                            }
                            
                            // 바다와 닿아있다면 경계면임
                            if (map[ny][nx] == 0) {
                                isBorder = true;
                            }
                        }
                        
                        // 경계면 좌표만 리스트에 추가 (중복 방지를 위해 리스트 사용 시 주의, 여기선 단순화)
                        if(isBorder) {
                            island.borderPoints.add(new Point(p.x, p.y, 0));
                        }
                    }
                    islands.add(island);
                    islandIdx++;
                }
            }
        }
    }

    // 다리 길이 구하기 (Multi-source BFS)
    static void bfsBridge(int islandIndex) {
        Queue<Point> q = new ArrayDeque<>();
        boolean[][] visitedMap = new boolean[N][N];
        
        int currentIslandNum = islandIndex + 2; // 2부터 시작했으므로
        Island currentIsland = islands.get(islandIndex);

        // 해당 섬의 모든 경계면을 큐에 넣고 시작 (Multi-source)
        for(Point p : currentIsland.borderPoints) {
            q.add(new Point(p.x, p.y, 0));
            visitedMap[p.y][p.x] = true;
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            // 가지치기: 현재 min보다 길어지면 볼 필요 없음
            if (p.len >= min) return; 

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visitedMap[ny][nx]) continue;
                
                // 같은 섬이면 통과
                if (map[ny][nx] == currentIslandNum) continue;

                // 바다라면 다리 잇기 계속
                if (map[ny][nx] == 0) {
                    visitedMap[ny][nx] = true;
                    q.add(new Point(nx, ny, p.len + 1));
                } 
                // 다른 섬에 도착했다면! (여기가 핵심)
                else {
                    min = Math.min(min, p.len);
                    return; // ★ 찾자마자 종료 (속도 향상의 핵심)
                }
            }
        }
    }
}