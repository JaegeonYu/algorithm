import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        
        // 1. 장르 PQ
        Map<String, Integer> map = new HashMap<>();
        Map<String, PriorityQueue<int[]>> genreMap = new HashMap<>();
        
        for(int i=0;i<genres.length;i++){
            if(map.containsKey(genres[i])){
                map.put(genres[i], map.get(genres[i])+plays[i]);
                genreMap.get(genres[i]).offer(new int[]{i, plays[i]});
            }else{
                map.put(genres[i], plays[i]);
                PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
                    // 0 -> idx, 1 -> plays
                    if(o1[1] == o2[1])return Integer.compare(o1[0], o2[0]);
                    return Integer.compare(o2[1], o1[1]);
                });
                pq.offer(new int[]{i, plays[i]});
                genreMap.put(genres[i], pq);
            }
        }
        
        List<Genre> genreList = new ArrayList<>();
        map.forEach((key, value)->{
          
            genreList.add(new Genre(key, value));
        });
        
        Collections.sort(genreList);
        
       List<Integer> ans = new ArrayList<>();
        
        for(Genre g : genreList){
            //System.out.println(g);
            if(genreMap.get(g.name).size()==1){
                ans.add(genreMap.get(g.name).poll()[0]);
            }else{
                ans.add(genreMap.get(g.name).poll()[0]);
                ans.add(genreMap.get(g.name).poll()[0]);
            }
        }
        // 2. 장르 내에 재생 노래 PQ, 재생 횟수 같으면 고유 번호 낮은 노래 먼저
        int[] answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}

class Genre implements Comparable<Genre>{
    String name;
    int counts;
    
    Genre(String name, int counts){
        this.name = name;
        this.counts = counts;
    }
    
    @Override
    public int compareTo(Genre a){
        return Integer.compare(a.counts, this.counts);
    }
    
    @Override
    public String toString(){
        return name + " " + counts;
    }
}