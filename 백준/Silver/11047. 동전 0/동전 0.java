import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sa = br.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);
        int result=0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++){
            stack.push(Integer.parseInt(br.readLine()));
        }
        while(!stack.isEmpty()){
            int num = stack.pop();
            if(num<=K){
                while(num<=K){
                    K-= num;
                    result++;
                }
            }
        }
        bw.write(result+"");
        bw.flush();
        bw.close();

    }

}

