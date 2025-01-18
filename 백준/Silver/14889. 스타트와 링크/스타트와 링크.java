import java.util.*;
import java.io.*;

public class Main {
    static int N, sum1, sum2, min = Integer.MAX_VALUE;
    static int[][] matrix;
    static List<Integer> list = new ArrayList<>();
    static List<Integer> another = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        // 입력 처리
        for (int i = 1; i <= N; i++) {
            String[] sa = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = Integer.parseInt(sa[j - 1]);
            }
        }

        dfs(0, 1);
        System.out.println(min);
    }

    // DFS로 팀 나누기
    static void dfs(int depth, int start) {
        if (depth == N / 2) {
            sum1 = 0;
            sum2 = 0;

            // 방문하지 않은 노드를 another 리스트에 추가
            another.clear();
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    another.add(i);
                }
            }

            // 두 팀의 능력치 계산
            sum(list, 0);
            sum(another, 1);

            // 최소값 갱신
            min = Math.min(min, Math.abs(sum1 - sum2));
            return;
        }

        // DFS로 조합 생성
        for (int i = start; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(i);
                dfs(depth + 1, i + 1);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    // 팀 능력치 계산
    static void sum(List<Integer> team, int index) {
        int size = team.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (index == 0) {
                    sum1 += matrix[team.get(i)][team.get(j)] + matrix[team.get(j)][team.get(i)];
                } else {
                    sum2 += matrix[team.get(i)][team.get(j)] + matrix[team.get(j)][team.get(i)];
                }
            }
        }
    }
}
