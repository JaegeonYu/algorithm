import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] days = new int[progresses.length];
        for(int i=0;i<days.length;i++){
            days[i] = (int)Math.ceil((double)(100 - progresses[i])/(double)speeds[i]);
        }
        
        
        
        
        List<Integer> ans = new ArrayList<>();
        int idx = 0;
        while(idx < days.length){
            int now = days[idx];
            int cnt = 1;
            boolean check = true;
            while(true){
                idx++;
                if(idx == days.length)break;
                if(now < days[idx]){
                    ans.add(cnt);
                    check = false;
                    break;
                }else cnt++;
            }
            if(check){
                ans.add(cnt);
                break;
            }
        }

        int[] answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
       
        return answer;
    }
}