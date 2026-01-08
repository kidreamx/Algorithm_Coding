import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, L, R;
    static int[][] arr;
    static boolean[][] visited; // 방문 체크 배열
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        L = Integer.parseInt(sa[1]);
        R = Integer.parseInt(sa[2]);
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            sa = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(sa[j]);
            }
        }

        int days = 0;
        while (true) {
            boolean isMove = false; // 오늘 인구 이동이 있었는지 체크
            visited = new boolean[N][N]; // 매일 방문 기록 초기화

            // 모든 좌표를 돌면서 아직 방문하지 않은 나라에 대해 BFS 시작
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        // BFS 결과, 연합이 형성되어 이동이 일어났다면(true)
                        if (bfs(j, i)) {
                            isMove = true;
                        }
                    }
                }
            }

            // 전체 맵을 다 돌았는데 이동이 한 번도 없었다면 종료
            if (!isMove) break;
            days++;
        }
        System.out.println(days);
    }

    // BFS: 연합을 찾고, 찾았다면 인구 이동까지 처리하는 함수
    // 반환값: 이동이 일어났으면 true, 아니면 false
    static boolean bfs(int x, int y) {
        Queue<Point> q = new ArrayDeque<>();
        List<Point> unionList = new ArrayList<>(); // 이번 연합에 포함된 나라들

        q.add(new Point(x, y));
        unionList.add(new Point(x, y));
        visited[y][x] = true;

        int sum = arr[y][x]; // 연합의 총 인구수

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[ny][nx]) continue;

                // [중요] 여기서 바로 국경선 조건을 체크합니다. (init 함수 대체)
                int diff = Math.abs(arr[p.y][p.x] - arr[ny][nx]);
                if (diff >= L && diff <= R) {
                    visited[ny][nx] = true;
                    q.add(new Point(nx, ny));
                    unionList.add(new Point(nx, ny)); // 연합 목록에 추가
                    sum += arr[ny][nx]; // 인구수 누적
                }
            }
        }

        // 연합에 속한 나라가 2개 이상이어야 인구 이동이 발생함
        if (unionList.size() > 1) {
            int avg = sum / unionList.size();
            for (Point p : unionList) {
                arr[p.y][p.x] = avg; // 인구수 갱신
            }
            return true; // 이동 발생함
        }

        return false; // 이동 발생 안함 (나 혼자임)
    }
}