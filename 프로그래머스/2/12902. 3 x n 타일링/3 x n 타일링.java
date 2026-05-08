class Solution {

    public int solution(int n) {
        if (n % 2 == 1) return 0; // 홀수는 불가능

        long[] dp = new long[n + 1];
        long sum = 0;
        dp[2] = 3; // n=2일 때 경우의 수

        for (int i = 4; i <= n; i += 2) {
            dp[i] = (dp[i - 2] * 3 + sum * 2 + 2) % 1_000_000_007;
            sum += dp[i - 2]; // 과거 특수 패턴 누적
        }

        return (int) dp[n];
    }

}