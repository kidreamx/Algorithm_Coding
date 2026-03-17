import java.util.*;

class Solution {
    boolean[] isSpoiled;
    boolean[] spoiledWord;
    String[] words;
    HashSet<String> set;
    HashSet<String> ans;
    public int solution(String message, int[][] spoiler_ranges) {
        init(message, spoiler_ranges);
        calculate();
        int answer = ans.size();
        return answer;
    }
    public void init(String message, int[][] spoiler_ranges){
        isSpoiled = new boolean[message.length()];
        words = message.split(" ");
        spoiledWord = new boolean[words.length];
        ans = new HashSet<>();
        set = new HashSet<>();
        initSpoiled(spoiler_ranges);
        enrollNormalWord();
    }
    public void initSpoiled(int[][] spoiler_ranges){
        for(int i=0;i<spoiler_ranges.length;i++){
            for(int j=spoiler_ranges[i][0];j<=spoiler_ranges[i][1];j++){
                isSpoiled[j] = true;
            }
        }
    }
    public void enrollNormalWord(){
        int index = 0;
        for(int i=0;i<words.length;i++){
            boolean canEnroll = true;
            for(int j=index;j<index+words[i].length();j++){
                if(isSpoiled[j]) {
                    canEnroll = false;
                    break;
                }
            }
            if(canEnroll){
                System.out.println(words[i]);
                set.add(words[i]);
                spoiledWord[i] = true;
            }
            index += words[i].length() +1;
        }
    }
    public void calculate(){
        for(int i=0;i<words.length;i++){
            if(spoiledWord[i] || set.contains(words[i])) continue;
            ans.add(words[i]);
        }
    }
}