import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams sol = new GroupAnagrams();
        List<List<String>> result1 = sol.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println("Test 1: " + result1);
        List<List<String>> result2 = sol.groupAnagrams(new String[]{""});
        System.out.println("Test 2: " + result2);
        List<List<String>> result3 = sol.groupAnagrams(new String[]{"a"});
        System.out.println("Test 3: " + result3);
    }
}
