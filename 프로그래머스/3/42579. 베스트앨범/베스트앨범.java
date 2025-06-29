import java.util.*;
class Music implements Comparable<Music>{
    int index;
    int plays;
    Music(int index, int plays){
        this.index = index;
        this.plays = plays;
    }
    @Override
    public int compareTo(Music o){
        if(this.plays == o.plays){
            return this.index - o.index;
        }else{
            return o.plays - this.plays;
        }
    }
}
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, List<Music>> music = new HashMap<>();
        HashMap<String, Integer> sum = new HashMap<>();
        for(int i=0;i<plays.length;i++){
            sum.put(genres[i],sum.getOrDefault(genres[i],0)+plays[i]);
            if(!music.containsKey(genres[i])){
                Music m = new Music(i,plays[i]);
                List<Music> list= new ArrayList<>();
                list.add(m);
                music.put(genres[i],list);
            }else{
                Music m = new Music(i,plays[i]);
                List<Music> list= music.get(genres[i]);
                list.add(m);
                music.put(genres[i],list);
            }
        }
        
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(sum.entrySet());

        // 2) 값(value) 기준으로 정렬
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2)            {
                return e2.getValue().compareTo(e1.getValue());
            }
        });
        int index=0;
        int two=0;
        int one=0;
        Collection<List<Music>> collection = music.values();
        List<List<Music>> musicList = new ArrayList<>(collection);
        for(List<Music> list : musicList){
            if(list.size()>=2){
                two++;
            }else{
                one++;
            }
        }
        answer = new int[two*2+one];
        for (Map.Entry<String, Integer> e : entries) {
            int cnt=0;
            List<Music> musicMap = music.get(e.getKey());
            Collections.sort(musicMap);
            for(Music m : musicMap){
                if(cnt==2){
                    break;
                }
                answer[index++] = m.index;
                cnt++;
            }
        }
        
        return answer;
    }
}