class Solution {
    public int[] solution(String[] wallpaper) {
        int min_x = Integer.MAX_VALUE;
        int min_y = Integer.MAX_VALUE;
        int max_x = Integer.MIN_VALUE;
        int max_y = Integer.MIN_VALUE;
        int[] answer = new int[4];
        for(int i=0;i<wallpaper.length;i++){
            for(int j=0;j<wallpaper[i].length();j++){
                if(wallpaper[i].charAt(j)=='#'){
                    min_x = Math.min(min_x,j);
                    min_y = Math.min(min_y,i);
                    max_x = Math.max(max_x,j+1);
                    max_y = Math.max(max_y,i+1);
                }
            }
        }
        answer[0] = min_y;
        answer[1] = min_x;
        answer[2] = max_y;
        answer[3] = max_x;
        return answer;
    }
}