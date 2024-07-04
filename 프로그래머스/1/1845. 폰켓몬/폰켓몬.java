import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        // 1. N/2 마리 포켓몬 가져가기
        // 2. N개중 N/2 고르는 방법은 몇 개인가 ?
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        return Math.min(nums.length/2, map.size());
    }
}