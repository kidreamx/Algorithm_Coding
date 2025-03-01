import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] memory = new int[n + 1];
        int[] cost = new int[n + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int sumCost = 0;
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            sumCost += cost[i];
        }
        
        // dp[c] : 비용의 합이 c일 때 해제할 수 있는 최대 메모리
        int[] dp = new int[sumCost + 1];
        // dp[0] = 0으로 초기화되었으므로 이미 초기값 세팅 완료
        
        // 0-1 배낭 문제 방식으로 업데이트 (역순 순회)
        for (int i = 1; i <= n; i++) {
            for (int j = sumCost; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
            }
        }
        
        // dp[c]가 m 이상이 되는 최소 c를 찾음
        int answer = Integer.MAX_VALUE;
        for (int c = 0; c <= sumCost; c++) {
            if (dp[c] >= m) {
                answer = c;
                break;
            }
        }
        System.out.println(answer);
    }
}
