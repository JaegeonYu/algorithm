class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i=1;i<=s.length()/2;i++){
            int zipLength = 1;
            String zipStr = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            for(int j=i;j<=s.length();j+=i){

                String nextStr = s.substring(j, (i+j > s.length()) ? s.length() : i+j);
                if(zipStr.equals(nextStr))zipLength++;
                else{
                    sb.append(((zipLength != 1) ? zipLength : "") + zipStr);
                    zipStr = nextStr;
                    zipLength = 1;
                }
            }
            sb.append(zipStr);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}