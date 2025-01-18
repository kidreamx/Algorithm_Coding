import java.io.*;
import java.util.*;


public class Main {
    static class Point{
        int x,y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int rotate;
        String sentence;
        char[] chars;
        for(int i=0;i<N;i++){
            String[] sa = br.readLine().split(" ");
            rotate = Integer.parseInt(sa[0]);
            sentence = sa[1];
            chars = sentence.toCharArray();
            for(int j=0;j<sentence.length();j++){
                for(int k=0;k<rotate;k++){
                    bw.write(chars[j]);
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();

    }

}
