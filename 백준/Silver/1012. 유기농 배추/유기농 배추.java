import java.util.*;
import java.io.*;

class Main {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] sa = br.readLine().split(" ");
            int M = Integer.parseInt(sa[0]);
            int N = Integer.parseInt(sa[1]);
            int K = Integer.parseInt(sa[2]);

            int[][] arr = new int[N][M];
            boolean[][] visited = new boolean[N][M];
            Queue<Point> queue = new LinkedList<>();
            int result = 0;

            // 배추 위치 입력
            for (int j = 0; j < K; j++) {
                sa = br.readLine().split(" ");
                arr[Integer.parseInt(sa[1])][Integer.parseInt(sa[0])] = 1;
            }

            // BFS 탐색
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (visited[j][k] || arr[j][k] != 1) continue;

                    // 새로운 구역 발견
                    queue.add(new Point(k, j));
                    visited[j][k] = true;

                    while (!queue.isEmpty()) {
                        Point p1 = queue.poll();

                        // 상하좌우 방향으로 탐색
                        int[] dx = {-1, 1, 0, 0};
                        int[] dy = {0, 0, -1, 1};

                        for (int d = 0; d < 4; d++) {
                            int nx = p1.x + dx[d];
                            int ny = p1.y + dy[d];

                            if (nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[ny][nx] && arr[ny][nx] == 1) {
                                queue.add(new Point(nx, ny));
                                visited[ny][nx] = true;
                            }
                        }
                    }
                    result++;
                }
            }

            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }
}
