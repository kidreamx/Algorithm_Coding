import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String word = br.readLine();
        Stack<Character> stack = new Stack<Character>();
        if(input.length()<word.length()){
            bw.write(input);
        } else{
            for(int i=0;i< input.length();i++){
                stack.add(input.charAt(i));
                if(stack.size()>=word.length() && stack.peek() == word.charAt(word.length()-1)){
                    int check=1;
                    for(int j=0;j<word.length();j++){
                        if(stack.get(stack.size()-word.length()+j) != word.charAt(j)){
                            check=0;
                            break;
                        }
                    }
                    if(check==1){
                        for(int j=0;j<word.length();j++){
                            stack.pop();
                        }
                    }
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for(Character c: stack){
            answer.append(c);
        }
        if(answer.length()==0){
            bw.write("FRULA");
        }
        else{
            bw.write(answer+"");
        }
        bw.flush();
        bw.close();

    }

}
