import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] charArray = br.readLine().toCharArray();
        int N = Integer.parseInt(br.readLine());
        Stack<Character> stack_left = new Stack<>();
        Stack<Character> stack_right = new Stack<>();
        for(int i=0; i<charArray.length; i++){
            stack_left.push(charArray[i]);
        }
        for(int i=0;i<N;i++){
            String[] sa = br.readLine().split(" ");
            if(sa[0].equals("L")){
                if(!stack_left.isEmpty()){
                    stack_right.push(stack_left.pop());
                }
            }
            else if(sa[0].equals("D")){
                if(!stack_right.isEmpty()){
                    stack_left.push(stack_right.pop());
                }
            }
            else if(sa[0].equals("B")){
                if(!stack_left.isEmpty()){
                    stack_left.pop();
                }
            }
            else if(sa[0].equals("P")){
                stack_left.push(sa[1].charAt(0));
            }
        }
        while(!stack_left.isEmpty()){
            stack_right.push(stack_left.pop());
        }
        while(!stack_right.isEmpty()){
            bw.write(stack_right.pop());
        }
        bw.flush();
        bw.close();

    }

}

