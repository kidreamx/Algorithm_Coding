import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int count=0;
        for(int i=0;i<chars.length;){
            if(chars[i]=='c'){
                if(i+1 <chars.length &&chars[i+1]=='-'){
                    count++;
                    i+=2;
                }else if(i+1 <chars.length &&chars[i+1]=='='){
                    count++;
                    i+=2;
                }else{
                    i++;
                    count++;
                }
            }else if(chars[i]=='d'){
                if(i+1 <chars.length &&chars[i+1]=='z'){
                    if(i+2 <chars.length &&chars[i+2]=='='){
                        i+=3;
                        count++;
                    }else{
                        i++;
                        count++;
                    }
                }
                else if(i+1 <chars.length &&chars[i+1]=='-'){
                    i+=2;
                    count++;
                }
                else{
                    i++;
                    count++;
                }

            }else if(chars[i]=='l'){
                if(i+1 <chars.length &&chars[i+1]=='j'){
                    i+=2;
                    count++;
                }else{
                    i++;
                    count++;
                }
            }else if(chars[i]=='n'){
                if(i+1 <chars.length &&chars[i+1]=='j'){
                    i+=2;
                    count++;
                }else{
                    i++;
                    count++;
                }
            } else if (chars[i] == 's') {
                if(i+1 <chars.length &&chars[i+1]=='='){
                    i+=2;
                    count++;
                }else{
                    i++;
                    count++;
                }
            }else if(chars[i]=='z'){
                if(i+1 <chars.length &&chars[i+1]=='='){
                    i+=2;
                    count++;
                }else{
                    i++;
                    count++;
                }
            }else{
                i++;
                count++;
            }
        }
        System.out.println(count);
    }
}