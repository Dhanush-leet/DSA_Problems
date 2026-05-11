import java.util.HashMap;

public class LongestSubstringWithoutRepeating {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating sol = new LongestSubstringWithoutRepeating();
        System.out.println("Test 1: " + sol.lengthOfLongestSubstring("abcabcbb"));
        System.out.println("Test 2: " + sol.lengthOfLongestSubstring("bbbbb"));
        System.out.println("Test 3: " + sol.lengthOfLongestSubstring("pwwkew"));
        System.out.println("Test 4: " + sol.lengthOfLongestSubstring(""));
    }
}
