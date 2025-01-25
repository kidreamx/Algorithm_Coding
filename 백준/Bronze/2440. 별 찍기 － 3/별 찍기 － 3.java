//import java.util.*;
//import java.io.*;
//
//public class Main{
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int[][] arr = new int[N][2];
//        int max_index=0,max=0;
//        for(int i=0;i<N;i++){
//            String[] sa = br.readLine().split(" ");
//            arr[i][0] = Integer.parseInt(sa[0]);
//            arr[i][1] = Integer.parseInt(sa[1]);
//        }
//
//        Arrays.sort(arr, (o1,o2) -> {
//            return o1[0] - o2[0];
//        });
//        for(int i=0;i<N;i++){
//            if(max<arr[i][1]){
//                max = arr[i][1];
//                max_index = i;
//            }
//        }
//        int start = arr[0][0];
//        int end = arr[N-1][0];
//        int sum=arr[0][1];
//        System.out.println(sum);
//        int start_max=arr[0][1];
//        boolean init = false;
//        for(int i=0;i<max_index;i++){
//            if(start_max<arr[i][1]){
//                sum += start_max * (arr[i][0]-start-1);
//                start_max = arr[i][1];
//                sum+=arr[i][1];
//                start = arr[i][0];
//                init = true;
//            }
//            if(i==max_index-1){
//                sum += start_max * (arr[i][0]-start-1);
//
//            }
//
//        }
//        if(!init){
//            sum+= start_max * (arr[max_index][0]-start-1);
//        }
//        System.out.println(sum);
//        sum+=arr[max_index][1];
//        int end_max = arr[N-1][1];
//        System.out.println(sum);
//        sum+= arr[N-1][1];
//        init = false;
//        for(int i=N-1;i>max_index;i--){
//            if(end_max<arr[i][1]){
//                sum += end_max * (end-arr[i][0]-1);
//                end_max = arr[i][1];
//                sum+=arr[i][1];
//                init=true;
//            }
//        }
//        if(!init){
//            System.out.println(end+" "+sum+" "+arr[max_index][0]);
//            sum+= end_max * (end - arr[max_index][0]-1);
//        }
//        System.out.println(sum);
//    }
//}
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            for(int j=N;j>i;j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}