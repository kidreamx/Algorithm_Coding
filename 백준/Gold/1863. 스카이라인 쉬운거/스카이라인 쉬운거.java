import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] height = new int[N];
        Stack<Integer> stack = new Stack<>();
        int result  = 0;
        for(int i=0; i<N;i++){{
            String[] sa = br.readLine().split(" ");
            height[i] = Integer.parseInt(sa[1]);
        }}
        for(int i=0; i<N;i++){
            if(height[i] == 0){
                result += stack.size();
                stack.clear();
            }
            else if(!stack.isEmpty()){
                int tmp = stack.peek();
                if(tmp < height[i]){
                    stack.push(height[i]);
                }
                else {
                    while(!stack.isEmpty() && stack.peek() > height[i]){
                        stack.pop();
                        result++;
                    }
                    if(!stack.isEmpty() && stack.peek() < height[i]){
                        stack.push(height[i]);
                    }
                    if(stack.isEmpty()){
                        stack.push(height[i]);
                    }
                }
            }
            else{
                stack.push(height[i]);
            }

        }
        result += stack.size();
        stack.clear();
        bw.write(result+"");
        bw.flush();
        bw.close();

    }

}

