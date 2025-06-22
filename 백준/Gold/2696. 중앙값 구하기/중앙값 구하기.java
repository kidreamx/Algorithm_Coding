import java.util.*;
import java.io.*;

public class Main{
    static int T;
    static int N;
    static int[] num;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            StringBuilder sb = new StringBuilder();
            input(br);
            calculate(sb);
            System.out.println(sb);
        }

    }
    static void input(BufferedReader br) throws IOException{
        N = Integer.parseInt(br.readLine());
        num = new int[N+1];
        for(int k=0;k<=(N/10);k++) {
            String[] sa = br.readLine().split(" ");
            int cnt=0;
            int i =1+(k*10);
            for (; i <= N; i++) {
                if(cnt==10){
                    break;
                }
                num[i] = Integer.parseInt(sa[i-k*10 - 1]);
                cnt++;
            }
        }
    }
    static void calculate(StringBuilder sb){
        sb.append(((N+1)/2)+"\n");
        PriorityQueue<Integer> higher = new PriorityQueue<>();
        PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
        int mid =num[1];
        sb.append(mid+" ");
        for(int i=2;i<=N;i++){
            if(num[i]>=mid){
                higher.add(num[i]);
            }
            else{
                lower.add(num[i]);
            }
            if(i%2==1){
                if(higher.size()==lower.size()){
                    sb.append(mid+" ");
                }
                else if(higher.size()>lower.size()){
                    lower.add(mid);
                    mid = higher.poll();
                    sb.append(mid+" ");
                }else {
                    higher.add(mid);
                    mid = lower.poll();
                    sb.append(mid+" ");
                }
            }
            if((i+1)%20==0){
                sb.append("\n");
            }
        }

    }
}