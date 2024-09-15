package com.ace.twopointers;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string
 * by deleting some (can be none) of the characters without disturbing the relative
 * positions of the remaining characters.
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Example 1:
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 */
public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc")); // Output: true
        System.out.println(isSubsequence("axc", "ahbgdc")); // Output: false
    }

    private static boolean isSubsequence(String abc, String ahbgdc) {
        int i = 0;
        int j = 0;
        while (i < abc.length() && j < ahbgdc.length()) {
            if (abc.charAt(i) == ahbgdc.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == abc.length();
    }
}
