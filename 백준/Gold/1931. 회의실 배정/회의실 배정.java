import java.util.*;
import java.io.*;
class Main{

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] meeting = new int[N][2];
        for(int i=0;i<N;i++){
            String[] sa = br.readLine().split(" ");
            meeting[i][0] = Integer.parseInt(sa[0]);
            meeting[i][1] = Integer.parseInt(sa[1]);
        }
        Arrays.sort(meeting, new Comparator<int[]>(){
            
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                else{
                    return o1[1] - o2[1];
                }
            }
        });
        int count=0;
        int prev_end_time=0;
        for(int i=0;i<N;i++){
            if(prev_end_time<= meeting[i][0]){
                prev_end_time = meeting[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}