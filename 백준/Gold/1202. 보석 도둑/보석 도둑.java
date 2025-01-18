import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    static class Jewelry{
        int mass;
        int value;
        Jewelry(int mass, int value){
            this.mass = mass;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sa = br.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);
        int[] bucket = new int[K];
        Jewelry[] jewelry = new Jewelry[N];
        long result=0;
        PriorityQueue<Integer> before = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<N;i++) {
            sa = br.readLine().split(" ");
            jewelry[i] = new Jewelry(Integer.parseInt(sa[0]), Integer.parseInt(sa[1]));
        }
        for(int i=0;i<K;i++) {
            bucket[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(jewelry, (o1, o2) -> {
            if(o1.mass == o2.mass) {
                return o2.value -o1.value;
            }
            else{
                return o1.mass - o2.mass;
            }
        });
        Arrays.sort(bucket);
        for(int i=0 ,index = 0;i<K;i++) {

            while(index<N && bucket[i]>= jewelry[index].mass) {
                before.offer(jewelry[index++].value);
            }
            if(!before.isEmpty()){
                result+=before.poll();
            }
        }
        bw.write(result+"");
        bw.flush();
        bw.close();

    }

}

