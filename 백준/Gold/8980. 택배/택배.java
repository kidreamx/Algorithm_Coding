import java.util.*;
import java.io.*;

public class Main{
    static class City implements Comparable<City>{
        int x,y;
        int value;
        City(int x, int y, int value){
            this.x =x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(City o) {
            if(this.y == o.y){
                return this.x - o.x;
            }
            return this.y-o.y;
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int C = Integer.parseInt(sa[1]);
        int M = Integer.parseInt(br.readLine());
        int[] weight = new int[N];
        Arrays.fill(weight,C);
        City[] cities = new City[M];
        for(int i=0;i<M;i++){
            sa = br.readLine().split(" ");
            int x = Integer.parseInt(sa[0]);
            int y = Integer.parseInt(sa[1]);
            int value = Integer.parseInt(sa[2]);
            cities[i] = new City(x,y,value);
        }
        Arrays.sort(cities);
        int answer=0;
        for(int i=0;i<M;i++){
            int min = Integer.MAX_VALUE;
            for(int r=cities[i].x;r<cities[i].y;r++){
               min = Math.min(min,weight[r]);
            }
            // value값이 더 작으면 다 배송가능한 경우
            if(min>cities[i].value){
                min = cities[i].value;
            }
            // value값이 크면 min정도만 배송가능해서 뺀다.
            for(int r=cities[i].x;r<cities[i].y;r++){
                weight[r] -= min;
            }
            answer+=min;
        }
        System.out.println(answer);
    }
}