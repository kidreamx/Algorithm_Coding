import java.util.*;
import java.io.*;

public class Main{
    static int T;
    static List<List<Integer>> list;
    static int[] alpha;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            alpha = new int[26];
            for(int i=0;i<26;i++){
                list.add(new ArrayList<>());
            }
            // 처음 순회하면서 각 알파벳별 갯수 및 값 저장
            calculate1(w);
            calculate2(k);
        }
    }
    static void calculate1(String w){
        for(int i=0;i<w.length();i++){
            char c = w.charAt(i);
            alpha[c-'a']++;
            list.get(c-'a').add(i);
        }
    }
    static void calculate2(int k){
        boolean canFind = false;
        int third=Integer.MAX_VALUE;
        int fourth=0;
        for(int i=0;i<26;i++){
            if(list.get(i).size()>=k){
                canFind = true;
                int end = k-1;
                int start = 0;
                while(end < list.get(i).size()){
                    third = Math.min(third, list.get(i).get(end) - list.get(i).get(start));
                    fourth= Math.max(fourth, list.get(i).get(end) - list.get(i).get(start));
                    start++;
                    end++;
                }
            }
        }
        if(canFind){
            System.out.println((third+1)+" "+(fourth+1));
        }
        else{
            System.out.println(-1);
        }
    }
}