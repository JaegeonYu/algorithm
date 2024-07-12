import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long le = 0;
        long ri = Long.MAX_VALUE;
        
        long ret = Long.MAX_VALUE;
        while(le <= ri){
            long mid = (le+ri)/2;
            
            if(check(mid, times, n)){
                ret = Math.min(ret, mid);
                ri = mid -1;
            }else le = mid +1;
        }
        return ret;
    }
    boolean check(long time, int[] times, int n){
        long sum = 0;
        for(int i=0; i< times.length;i++){
            sum += time / times[i];
            if(sum >= n)break;
        }
      
        return sum >= n;
    }
}