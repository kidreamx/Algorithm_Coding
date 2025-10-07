class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer;
        int first_index=0;
        int second_index=0;
        boolean canMake=true;
        for(int i=0;i<goal.length;i++){
            if(first_index<cards1.length && cards1[first_index].equals(goal[i])){
                first_index++;
            }else if(second_index<cards2.length &&cards2[second_index].equals(goal[i])){
                second_index++;
            }else{
                canMake=false;
                break;
            }
        }
        if(canMake){
            answer = "Yes";
        }else{
            answer = "No";
        }
        return answer;
    }
}