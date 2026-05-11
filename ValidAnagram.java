public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        for (char c : t.toCharArray()) count[c - 'a']--;
        for (int val : count) {
            if (val != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram sol = new ValidAnagram();
        System.out.println("Test 1: " + sol.isAnagram("anagram", "nagaram"));
        System.out.println("Test 2: " + sol.isAnagram("rat", "car"));
        System.out.println("Test 3: " + sol.isAnagram("listen", "silent"));
    }
}
