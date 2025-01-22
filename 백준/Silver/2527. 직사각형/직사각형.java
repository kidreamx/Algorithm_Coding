import java.util.*;
import java.io.*;

public class Main{
    static class Square{
        int start_x , start_y , end_x , end_y;

        public Square(int start_x, int start_y, int end_x, int end_y) {
            this.start_x = start_x;
            this.start_y = start_y;
            this.end_x = end_x;
            this.end_y = end_y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<4;i++) {
            String[] sa = br.readLine().split(" ");
            int x1 = Integer.parseInt(sa[0]);
            int y1 = Integer.parseInt(sa[1]);
            int p1 = Integer.parseInt(sa[2]);
            int q1 = Integer.parseInt(sa[3]);
            int x2 = Integer.parseInt(sa[4]);
            int y2 = Integer.parseInt(sa[5]);
            int p2 = Integer.parseInt(sa[6]);
            int q2 = Integer.parseInt(sa[7]);

            if(p1<x2 || q1 < y2 || x1>p2 || y1 > q2){
                System.out.println("d");
            }
            else if((p1== x2 && q1 == y2) || (p1 == x2 && y1 == q2) || (p2 == x1 && q2 == y1) || (p2 == x1 && y2 == q1)){
                System.out.println("c");
            }
            else if((p1 == x2) || (p2 == x1) || (y1 == q2) || (q1 == y2)){
                System.out.println("b");
            }
            else{
                System.out.println("a");
            }
        }
    }
}