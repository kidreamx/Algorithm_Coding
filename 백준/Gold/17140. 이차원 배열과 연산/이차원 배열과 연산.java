import java.util.*;
import java.io.*;

public class Main{
    /*
     1부터 시작하고 1초 지날떄마다 연산 적용
     1) 행 열 갯수 판단해서 R인지 C인지 판단
     2-1) R정렬 : 모든 행에 대해서 정렬 수행 (조건 행 >=열)
     2-2) C정렬 : 모든 열에 대해서 정렬 수행 (조건 행 < 열)

     */
    static class Number implements Comparable<Number>{
        int num;
        int cnt;
        Number(int num , int cnt){
            this.num = num;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Number o1){
            if(this.cnt == o1.cnt){
                return this.num - o1.num;
            }
            return this.cnt - o1.cnt;
        }
    }
    static int[][] arr;
    static int[] num;
    static int r,c,k;
    static int rowCount , colCount;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[101][101];
        init(br);
        int timeCount = 0;
        while(timeCount<=100){
            if(arr[r][c] == k){
                System.out.println(timeCount);
                return;
            }
            if(timeCount==100){
                System.out.println(-1);
                return;
            }
            int std = judgement();
            if(std==0){
                sortR();
            }else if(std==1){
                sortC();
            }
            timeCount++;
        }

    }
    public static void init(BufferedReader br) throws IOException{
        String[] sa = br.readLine().split(" ");
        r = Integer.parseInt(sa[0]);
        c = Integer.parseInt(sa[1]);
        k = Integer.parseInt(sa[2]);
        rowCount = 3;
        colCount = 3;
        for(int i=1;i<=3;i++){
            sa = br.readLine().split(" ");
            for(int j=1;j<=3;j++){
                arr[i][j] = Integer.parseInt(sa[j-1]);
            }
        }
    }

    public static int judgement(){
        if(rowCount >= colCount){
            // 0이면 sortR ,1이면 sortC
            return 0;
        }else{
            return 1;
        }
    }

    public static void sortR(){
        int stdRow = rowCount;
        int maxCol =0;
        for(int i=1;i<=stdRow;i++){
            List<Number> list = new ArrayList<>();
            int[] numCount = new int[101];
            for(int j=1;j<=100;j++){
                if(arr[i][j] == 0) continue;
                numCount[arr[i][j]]++;
            }
            for(int j=1;j<=100;j++){
                if(numCount[j]>0){
                    list.add(new Number(j,numCount[j]));
                }
            }
            Collections.sort(list);
            int index=1;
            for(Number number : list){
                if(index>100){
                    break;
                }
                arr[i][index] = number.num;
                arr[i][index+1] = number.cnt;
                index = index+2;
            }
            for(int j = index; j<=100;j++){
                arr[i][j] = 0;
            }
            index = index-1;
            maxCol = Math.max(maxCol, index);
        }
        colCount = maxCol;
    }

    public static void sortC(){
        int stdCol = colCount;
        int maxRow = 0;
        for(int i=1;i<=stdCol;i++){
            List<Number> list = new ArrayList<>();
            int[] numCount = new int[101];
            for(int j=1;j<=100;j++){
                if(arr[j][i] == 0) continue;
                numCount[arr[j][i]]++;
            }
            for(int j=1;j<=100;j++){
                if(numCount[j]>0){
                    list.add(new Number(j,numCount[j]));
                }
            }
            Collections.sort(list);
            int index=1;
            for(Number number : list){
                if(index>100){
                    break;
                }
                arr[index][i] = number.num;
                arr[index+1][i] = number.cnt;
                index = index+2;
            }
            for(int j = index; j<=100;j++){
                arr[j][i] = 0;
            }
            index = index-1;
            maxRow = Math.max(maxRow,index);
        }
        rowCount = maxRow;

    }
}