import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int minuscount=0;
        long result=0;
        int index=0;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i]<=0)
            {
                minuscount++;
            }

        }
        Arrays.sort(arr);
        while(minuscount>index) { //음수 부분 합이나 곱 계산
            if (minuscount == 1) { // 음수가 하나 일때
                result += arr[0];
                break;
            }
            else if(minuscount-1 == index){ //minuscount가 홀수 일 때 실행되는 조건문
                result += arr[index];
                index++;
            }
            else{
                result+= (long) arr[index] * arr[index+1] ;
                index = index+2;
            }
        }
        index = n-1;
        while(index>=minuscount){
            if(n-minuscount==1){ // 양수가 하나만 있는 경우
                result+=arr[n-1];
                break;
            }
            else if(index==minuscount){
                result+= arr[index];
                index--;
            }
            else{
                if((arr[index]==1) || (arr[index-1]==1)){
                        result += arr[index] + arr[index-1];
                        index = index-2;
                }
                else {
                    result += (long) arr[index] * arr[index - 1];
                    index = index - 2;
                }
            }
        }
        bw.write(result+ "");
        bw.flush();
        bw.close();
    }

}
