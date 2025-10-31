import java.util.*;
class Pos{
    int x, y;
    Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        Pos left = new Pos(0,3) , right =  new Pos(2,3);
        for(int i=0;i<numbers.length;i++){
            if(numbers[i] == 1){
                answer = answer.concat("L");
                left = new Pos(0,0);
            }else if(numbers[i] == 2){
                int leftLen = Math.abs(1-left.x) + Math.abs(left.y - 0);
                int rightLen = Math.abs(1-right.x) + Math.abs(right.y-0);
                if(leftLen == rightLen){
                    if(hand.equals("right")){
                        answer = answer.concat("R");
                        right = new Pos(1,0);
                    }else{
                        answer = answer.concat("L");
                        left = new Pos(1,0);
                    }
                }else if(leftLen < rightLen){
                    answer = answer.concat("L");
                    left = new Pos(1,0);
                }else{
                    answer = answer.concat("R");
                    right = new Pos(1,0);
                }
            }else if(numbers[i] == 3){
                answer = answer.concat("R");
                right = new Pos(2,0);
            }else if(numbers[i] == 4){
                answer = answer.concat("L");
                left = new Pos(0,1);
            }else if(numbers[i] == 5){
                int leftLen = Math.abs(1-left.x) + Math.abs(left.y - 1);
                int rightLen = Math.abs(1-right.x) + Math.abs(right.y-1);
                if(leftLen == rightLen){
                    if(hand.equals("right")){
                        answer = answer.concat("R");
                        right = new Pos(1,1);
                    }else{
                        answer = answer.concat("L");
                        left = new Pos(1,1);
                    }
                }else if(leftLen < rightLen){
                    answer = answer.concat("L");
                    left = new Pos(1,1);
                }else{
                    answer = answer.concat("R");
                    right = new Pos(1,1);
                }
            }else if(numbers[i] == 6){
                answer = answer.concat("R");
                right = new Pos(2,1);
            }else if(numbers[i] == 7){
                answer = answer.concat("L");
                left = new Pos(0,2);
            }else if(numbers[i] == 8){
                int leftLen = Math.abs(1-left.x) + Math.abs(left.y - 2);
                int rightLen = Math.abs(1-right.x) + Math.abs(right.y-2);
                if(leftLen == rightLen){
                    if(hand.equals("right")){
                        answer = answer.concat("R");
                        right = new Pos(1,2);
                    }else{
                        answer = answer.concat("L");
                        left = new Pos(1,2);
                    }
                }else if(leftLen < rightLen){
                    answer = answer.concat("L");
                    left = new Pos(1,2);
                }else{
                    answer = answer.concat("R");
                    right = new Pos(1,2);
                }
            }else if(numbers[i] == 9){
                answer = answer.concat("R");
                right = new Pos(2,2);
            }else if(numbers[i] == 0){
                int leftLen = Math.abs(1-left.x) + Math.abs(left.y - 3);
                int rightLen = Math.abs(1-right.x) + Math.abs(right.y-3);
                if(leftLen == rightLen){
                    if(hand.equals("right")){
                        answer = answer.concat("R");
                        right = new Pos(1,3);
                    }else{
                        answer = answer.concat("L");
                        left = new Pos(1,3);
                    }
                }else if(leftLen < rightLen){
                    answer = answer.concat("L");
                    left = new Pos(1,3);
                }else{
                    answer = answer.concat("R");
                    right = new Pos(1,3);
                }
            }

        }
        return answer;
    }
}