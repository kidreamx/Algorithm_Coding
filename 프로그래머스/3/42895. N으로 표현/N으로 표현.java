import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        dp.add(null);
        dp.add(Set.of(N));
        if(N==number){
            return 1;
        }
        for(int i=2;i<=8;i++){
            Set<Integer> s = new HashSet<>();
            int concat = Integer.parseInt(String.valueOf(N).repeat(i));
            s.add(concat);
            for(int j=1;j<i;j++){
                for(int a : dp.get(j)){
                    for(int b: dp.get(i-j)){
                        s.add(a+b);
                        s.add(a-b);
                        s.add(a*b);
                        if(b!=0) s.add(a/b);
                    }
                }
            }
            dp.add(s);
            if(s.contains(number)){
                return i;
            }
        }
        return -1;
    }
}