package SlidingwindowProblem;


// Given a string and we need to find length of longest substring without repeating characters
public class LongestSubstringFinder {
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        int length = s.length();
        for(int i= 0; i < length; i++){
            boolean [] visited = new boolean [256];
            for(int j = i;j<length;j++){
                if(visited[s.charAt(j)] == true){
                    break;
                }else{
                    result = Math.max(result,j-i+1);
                    visited[s.charAt(j)] = true;
                }
            }
            visited[s.charAt(i)] = false;
        }
        return result;
    }

    public static void main(String [] args){
        String str = "dvdf";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
