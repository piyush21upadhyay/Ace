package com.ace.arraystrings;

/**
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower
 * and upper cases, more than once.
 *
 * Example 1:
 * Input: s = "hello"
 * Output: "holle"
 *
 * Example 2:
 * Input: s = "leetcode"
 * Output: "leotcede"
 */
public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));       // Output: "holle"
        System.out.println(reverseVowels("leetcode"));    // Output: "leotcede"
        
    }

    private static String reverseVowels(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        String vowels = "aeiouAEIOU";

        while (left<right){
            // Move left pointer to the right until it finds a vowel
            while (left < right && vowels.indexOf(chars[left]) == -1) {
                left++;
            }

            while (left < right && vowels.indexOf(chars[right]) == -1) {
                right--;
            }
            if(left<right){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
