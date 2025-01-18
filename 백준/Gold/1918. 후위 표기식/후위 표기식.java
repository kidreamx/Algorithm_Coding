import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        Stack<Character> sign = new Stack<>();
        String result="";
        for(int i=0;i<chars.length;i++){
            if(chars[i]>='A' && chars[i]<='Z'){
                result = result.concat(Character.toString(chars[i]));
            }
            else if(chars[i]==')'){
                while(!sign.isEmpty()) {
                    if(sign.peek()=='('){
                        sign.pop();
                        break;
                    }
                    result = result.concat(Character.toString(sign.pop())); // 기호가 빠진다.
                }
            }
            else if(chars[i]=='+'|| chars[i]=='-'){
                if(sign.isEmpty()){
                    sign.push(chars[i]);
                    continue;
                }
                if(sign.peek()=='*' || sign.peek()=='/' ){
                    while(!sign.isEmpty()){
                        if(sign.peek()=='('){
                            break;
                        }
                        result= result.concat(Character.toString(sign.pop()));
                    }
                }
                else if(sign.peek()=='+' || sign.peek()=='-'){
                    result = result.concat(Character.toString(sign.pop()));
                }
                sign.push(chars[i]);
            }
            else if(chars[i]=='*' || chars[i]=='/'){
                if(sign.isEmpty()){
                    sign.push(chars[i]);
                    continue;
                }
                if(sign.peek()=='*' || sign.peek()=='/'){
                    result = result.concat(Character.toString(sign.pop()));
                }
                sign.push(chars[i]);
            }
            else{
                sign.push(chars[i]);
            }
        }
        while(!sign.isEmpty()){
            result = result.concat(Character.toString(sign.pop()));
        }
        System.out.println(result);
    }
}

