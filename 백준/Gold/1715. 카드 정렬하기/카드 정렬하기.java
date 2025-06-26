import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        int save=0;
        for(int i=0;i<N;i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        while(pq.size()>=2) {
            int first = pq.poll();
            int second = pq.poll();
            save += first + second;
            pq.add(first + second);
        }
        bw.write(Integer.toString(save));
        bw.flush();
        bw.close();

    }

}
