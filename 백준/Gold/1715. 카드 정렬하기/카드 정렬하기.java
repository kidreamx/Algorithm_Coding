import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        int sum=0;
        while(pq.size()>=2){
            int num1 = pq.poll();
            int num2 = pq.poll();
            sum+= num1+num2;
            pq.add((num1+num2));
        }
        System.out.println(sum);
    }
}