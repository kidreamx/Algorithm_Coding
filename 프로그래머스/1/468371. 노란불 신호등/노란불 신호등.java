class Solution {
    public int solution(int[][] signals) {
        // 문제에서 요구하는 최대 탐색 시간이 1,000,000초라고 가정
        int maxTime = 10000000; 

        // 1초부터 최대 시간까지 탐색
        for (int t = 1; t <= maxTime; t++) {
            boolean allYellow = true;

            for (int i = 0; i < signals.length; i++) {
                int green = signals[i][0];
                int yellow = signals[i][1];
                int red = signals[i][2];
                
                int cycle = green + yellow + red; // 전체 주기

                // t초가 주기 내에서 어디에 해당하는지 계산 (1초부터 시작하므로 t-1)
                int timeInCycle = (t - 1) % cycle;

                // 노란불 구간은 green 시간 이후부터 (green + yellow) 시간 이전까지임
                if (!(timeInCycle >= green && timeInCycle < green + yellow)) {
                    allYellow = false;
                    break; // 하나라도 노란불이 아니면 다음 시간으로 패스
                }
            }

            // 모든 신호등이 노란불이라면 그 시간이 정답
            if (allYellow) {
                return t;
            }
        }

        return -1; // 1,000,000초 안에서 찾지 못한 경우
    }
}