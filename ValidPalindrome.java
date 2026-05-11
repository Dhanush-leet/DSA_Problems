// LeetCode #125 - Valid Palindrome
// NeetCode: Two Pointers
// Difficulty: Easy
//
// Problem:
// A phrase is a palindrome if, after converting all uppercase letters
// to lowercase and removing all non-alphanumeric characters, it reads
// the same forward and backward.
//
// Example 1:
// Input: s = "A man, a plan, a canal: Panama" => Output: true
// Example 2:
// Input: s = "race a car" => Output: false
//
// Approach: Two Pointers - O(n) Time | O(1) Space

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            // Skip non-alphanumeric from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;

            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome sol = new ValidPalindrome();

        System.out.println("Test 1: " + sol.isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println("Test 2: " + sol.isPalindrome("race a car"));                      // false
        System.out.println("Test 3: " + sol.isPalindrome(" "));                               // true
    }
}
