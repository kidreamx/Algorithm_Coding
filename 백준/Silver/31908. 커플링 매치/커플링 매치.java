import java.io.*;
import java.util.*;

public class Main{
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   
      int n = Integer.parseInt(br.readLine());
      int size=0;
      String[] names = new String[n];
      String[] rings = new String[n];
      StringBuilder sb = new StringBuilder();
      HashMap<String,Integer> hm = new HashMap<>();
      
      StringTokenizer st;
      for(int i=0;i<n;i++) {
         st = new StringTokenizer(br.readLine());
         names[i]=st.nextToken();
         rings[i]=st.nextToken();
         hm.put(rings[i], hm.getOrDefault(rings[i], 0)+1);
      }
      for(int i=0;i<n;i++) {
         if(rings[i].equals("-")) {
            hm.remove(rings[i]);
         }
         else {
         if(hm.get(rings[i])==2){
            hm.put(rings[i],1);
            for(int j =i+1 ; j<n ;j++) {
               if(rings[i].equals(rings[j])) {
                  size++;
                  sb.append(names[i]+" "+names[j]+"\n");
               }
            }
         }
         }
      }
      sb.insert(0, size+"\n");
      if(size==0) {
         bw.write("0");
      }else {
         bw.write(sb.toString());
      }
      bw.flush();
      bw.close();
      br.close();
      
      
   }
}
