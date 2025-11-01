import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data , new Comparator<int[]>(){
            @Override
            public int compare(int[] o1 , int[] o2){
                if(o1[col-1] == o2[col-1]){
                    return o2[0] - o1[0];
                }else{
                    return o1[col-1] - o2[col-1];    
                }
            }
        });
        List<Integer> result = new ArrayList<>();
        for(int i=row_begin-1 ; i<=row_end-1; i++){
            int sum = 0;
            int index = i+1;
            for(int j=0;j<data[i].length;j++){
                sum  += (data[i][j] % index);
            }
            result.add(sum);
        }
        answer = result.get(0);
        for(int i=1;i<result.size();i++){
            answer = (answer ^ result.get(i));
        }
        return answer;
    }
}