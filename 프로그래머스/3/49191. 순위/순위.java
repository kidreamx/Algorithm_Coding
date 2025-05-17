class Solution {
    public int solution(int n, int[][] results) {

        boolean[][] win = new boolean[n+1][n+1];
        for(int[] i : results){
            win[i[0]][i[1]] = true;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (win[i][k] && win[k][j]) {
                        win[i][j] = true;
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            boolean canDetermine = true;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (!win[i][j] && !win[j][i]) {
                    // i와 j 사이에 승패 관계가 없으면 순위 불명
                    canDetermine = false;
                    break;
                }
            }
            if (canDetermine) answer++;
        }
        return answer;
    
    }
}