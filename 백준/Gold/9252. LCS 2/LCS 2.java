import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s1 = br.readLine();
        char[] chars1 = s1.toCharArray();
        String s2 = br.readLine();
        char[] chars2 = s2.toCharArray();
        int[][] lcs = new int[s1.length()+1][s2.length()+1];
        int arrow_x, arrow_y;
        int max_count;
        Stack<Character> stack = new Stack<>();
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(chars1[i-1]==chars2[j-1]){
                    lcs[i][j] = lcs[i-1][j-1]+1;
                }
                else{
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        arrow_x = s1.length();
        arrow_y = s2.length();
        max_count = lcs[s1.length()][s2.length()];
        bw.write(max_count+"\n");
        while(max_count>0){
            if(max_count == lcs[arrow_x-1][arrow_y]){
                arrow_x--;
            }
            else if(max_count == lcs[arrow_x][arrow_y-1]){
                arrow_y--;
            }
            else{
                arrow_x--;
                arrow_y--;
                stack.push(chars1[arrow_x]);
                max_count--;
            }
        }
        while(!stack.isEmpty()){
            bw.write(stack.pop());
        }
        br.close();
        bw.flush();
        bw.close();

    }

}