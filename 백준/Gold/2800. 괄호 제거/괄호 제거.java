import java.util.*;
import java.io.*;

public class Main{
    static class Pair{
        int openIdx, closedIdx;
        Pair(int openIdx, int closedIdx){
            this.openIdx = openIdx;
            this.closedIdx = closedIdx;
        }
    }
    static List<Pair> list;
    static char[] chars;
    static int cnt;
    static TreeSet<String> treeSet;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        chars = s.toCharArray();
        init();
        dfs(new boolean[chars.length],0);
        treeSet.remove(s);
        StringBuilder sb = new StringBuilder();
        for(String s1 : treeSet){
            System.out.println(s1);
        }
    }
    /*
    총 괄호가 몇개인지 파악하는 로직을 구현한다.
     */
    public static void init(){
        treeSet = new TreeSet<>();
        cnt = 0;
        list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<chars.length;i++){
            if(chars[i] == '('){
                stack.add(i);
                cnt++;
            }else if(chars[i] == ')'){
                list.add(new Pair(stack.pop(),i));
            }
        }
    }
    public static void dfs(boolean[] use, int depth){
        if(depth == cnt){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<chars.length;i++){
                if(!use[i]){
                    sb.append(chars[i]);
                }
            }
            treeSet.add(sb.toString());
            return;
        }
        Pair pair = list.get(depth);
        use[pair.openIdx] = false;
        use[pair.closedIdx] = false;
        dfs(use,depth+1);
        use[pair.openIdx] = true;
        use[pair.closedIdx] = true;
        dfs(use, depth+1);
    }
}