class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = count(n);
        int target  = n+1;
        while(true){
           if(cnt == count(target)){
               return target;
           } 
            target++;
        }
    }
    public int count(int num){
        int cnt = 0;
        while(num>0){
            if(num%2==1) cnt++;
            num = num/2;
        }
        return cnt;
    }
}