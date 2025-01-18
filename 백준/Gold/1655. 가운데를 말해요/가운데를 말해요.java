import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> upper = new PriorityQueue<>();
        int middle =0;
        int newer=0;
        for (int i = 1; i <= N; i++) {
            newer = Integer.parseInt(br.readLine());
            if(i ==1 ){
                middle = newer;
            }
            else{
                if( i%2 == 0){
                    if(middle > newer){
                        upper.add(middle);
                        lower.add(newer);
                        middle = lower.peek();
                    }
                    else{
                        upper.add(newer);
                        lower.add(middle);
                    }
                }
                else{ // i가 홀수 일때
                    int low_num = lower.poll();
                    int upper_num = upper.poll();
                    if(low_num <= newer && newer <= upper_num){
                        lower.add(low_num);
                        upper.add(upper_num);
                        middle = newer;
                    }
                    else if(low_num <= upper_num && upper_num <= newer){
                        lower.add(low_num);
                        upper.add(newer);
                        middle = upper_num;
                    }
                    else if(newer<= low_num && low_num <= upper_num){
                        lower.add(newer);
                        upper.add(upper_num);
                        middle = low_num;
                    }
                }
            }
            bw.write(middle + "\n");
        }
        bw.flush();
        bw.close();

    }

}

