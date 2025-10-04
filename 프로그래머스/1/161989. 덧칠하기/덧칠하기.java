class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] draw = new boolean[n+1];
        for(int i=0;i<section.length;i++){
            draw[section[i]] = true;
        }
        for(int i=1;i<=n;i++){
            if(draw[i]){
                answer++;
                for(int j=i;j<i+m && j<=n;j++){
                    draw[j] = false;
                }
            }
        }
        return answer;
    }
}