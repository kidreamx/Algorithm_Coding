import java.io.*;
import java.util.*;


public class Main {
    static class Point{
        double x;
        double y;
        Point(double x, double y){
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o){
            Point p = (Point)o;

            if(this.x == p.x && this.y == p.y){
                return true;
            }
            else{
                return false;
            }
        }
        @Override
        public int hashCode(){
            return Objects.hash(x,y);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int max=1;
        HashMap<Point, Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            String[] sa = br.readLine().split(" ");
            int x = Integer.parseInt(sa[0]);
            int y = Integer.parseInt(sa[1]);
            arr[i][0] = x;
            arr[i][1] = y;
            map.put(new Point(x, y), 1);
        }
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                double point_x = (double)(arr[i][0] + arr[j][0])/2;
                double point_y = (double)(arr[i][1] + arr[j][1])/2;
                if(map.containsKey(new Point(point_x,point_y))) {
                    int count = map.get(new Point(point_x,point_y))+2;
                    map.put(new Point(point_x,point_y), count);
                    if(count>max){
                        max = count;
                    }
                }
                else{
                    map.put(new Point(point_x,point_y), 2);
                    if(max <2){
                        max =2;
                    }
                }
            }
        }
        bw.write(max+"\n");
        bw.flush();
        bw.close();

    }

}

