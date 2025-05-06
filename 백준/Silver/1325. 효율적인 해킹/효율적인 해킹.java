import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static int[] ans;
    static int[] visited;
    static int visitToken = 1;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            sa = br.readLine().split(" ");
            int a = Integer.parseInt(sa[0]);
            int b = Integer.parseInt(sa[1]);
            graph.get(b).add(a);
        }

        ans = new int[N + 1];
        visited = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dfsIterative(i);
            visitToken++;
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, ans[i]);
        }

        // 결과를 담을 리스트에 추가하고 오름차순 정렬
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (ans[i] == max) {
                result.add(i);
            }
        }
        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        for (int idx : result) {
            sb.append(idx).append(' ');
        }
        System.out.print(sb);
    }

    private static void dfsIterative(int start) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        visited[start] = visitToken;

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            for (int nxt : graph.get(curr)) {
                if (visited[nxt] != visitToken) {
                    visited[nxt] = visitToken;
                    ans[start]++;
                    stack.push(nxt);
                }
            }
        }
    }
}
