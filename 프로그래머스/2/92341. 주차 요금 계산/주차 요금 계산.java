import java.util.*;
class Record{
    String time;
    int carNum;
    Record(String time , int carNum){
        this.time = time;
        this.carNum = carNum;
    }
}
class Car{
    int carNum;
    int fee;
    Car(int carNum , int fee){
        this.carNum = carNum;
        this.fee = fee;
    }
}
class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Record> list = new ArrayList<>();
        
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<records.length;i++){
            String[] sa = records[i].split(" ");
            String time = sa[0];
            int carNum = Integer.parseInt(sa[1]);
            if(sa[2].equals("IN")){
                // 들어갈때
                list.add(new Record(time,carNum));
            }else if(sa[2].equals("OUT")){
                // 여기서 계산
                for(Record record : list){
                    if(record.carNum == carNum){
                        int amount = timeCompare(record.time , time);
                        int before = hashMap.getOrDefault(record.carNum,0);
                        hashMap.put(carNum,before+amount);
                        list.remove(record);
                         break;
                    }
                    
                }
            }
        }
        
        for(Record record : list){
            int amount  = timeCompare(record.time , "23:59");
            int before = hashMap.getOrDefault(record.carNum,0);
            hashMap.put(record.carNum,before+amount);
        }
        
        Set<Integer> keySet = hashMap.keySet();
        List<Integer> key = new ArrayList<>(keySet);
        int[] answer = new int[key.size()];
        Collections.sort(key);
        for(int i =0; i<key.size();i++){
            int time = hashMap.get(key.get(i));
            answer[i] = timeTofee(time, fees);
        }
        
        return answer;
    }
    public int timeCompare(String before , String after){
        int beforeHour = Integer.parseInt(before.split(":")[0]);
        int beforeMinute = Integer.parseInt(before.split(":")[1]);
        int afterHour = Integer.parseInt(after.split(":")[0]);
        int afterMinute = Integer.parseInt(after.split(":")[1]);
        if(afterMinute - beforeMinute <0){
            int finalHour = afterHour-1-beforeHour;
            int finalMinute = 60+afterMinute - beforeMinute;
            return 60*finalHour + finalMinute;
        }else{
            int finalHour = afterHour-beforeHour;
            int finalMinute = afterMinute - beforeMinute;
            return 60*finalHour + finalMinute;
        }
    }
    public int timeTofee(int time, int[] fees){
        if(time <= fees[0]){
            return fees[1];
        }else{
            int sum = fees[1];
            time -= fees[0];
            if(time%fees[2]==0){
                sum += (time/fees[2])*fees[3];
            }else{
                sum += ((time/fees[2])+1)*fees[3];
            }
            return sum;
        }
    }
}