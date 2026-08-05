class Solution {

    private final String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        
        List<String> ans = new ArrayList<>();
        if(digits==null || digits.length()==0){
            return ans;
        }

        backtrack(digits, 0, new StringBuilder(), ans );
        return ans;
    }

    private void backtrack(String digits, int index, StringBuilder sb, List<String> ans){
        if(index==digits.length()){
            ans.add(sb.toString());
            return;
        }

        String letters = map[digits.charAt(index)-'0'];

        for(char ch : letters.toCharArray()){
            sb.append(ch);
            backtrack(digits, index+1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}