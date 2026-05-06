class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right-left);
        int[] answer = new int[size+1];
        for(long i=left;i<=right;i++){
            long divied = i/n;
            long remain = i%n;
            int row = (int)divied+1;
            int col = (int)remain+1;
            answer[(int)(i-left)] = Math.max(row,col);
        }
        return answer;
    }
}