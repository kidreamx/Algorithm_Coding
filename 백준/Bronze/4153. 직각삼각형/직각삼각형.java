import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String[] sa = br.readLine().split(" ");
            int max=0;
            int index=0;
            int first = Integer.parseInt(sa[0]);
            int second = Integer.parseInt(sa[1]);
            int third = Integer.parseInt(sa[2]);
            if(first==0 && second==0 &&third==0){
                break;
            }
            if (first > max) {
                max = first;
                index=1;
            }
            if (second > max) {
                max = second;
                index=2;
            }
            if (third > max) {
                max = third;
                index=3;
            }
            if(index==1){
                if(first*first == second*second + third*third){
                    bw.write("right\n");
                }
                else{
                    bw.write("wrong\n");
                }
            }
            else if(index==2){
                if(second*second == third*third + first*first){
                    bw.write("right\n");
                }
                else{
                    bw.write("wrong\n");
                }
            }
            else if(index==3){
                if(third*third == second*second + first*first){
                    bw.write("right\n");
                }
                else{
                    bw.write("wrong\n");
                }
            }


        }
        bw.flush();
        bw.close();

    }

}

