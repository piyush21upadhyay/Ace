package com.ace.arraystrings;

public class MergeStringsAlternately {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "pqrs";
        String result = "";
        System.out.println(mergedAlternately(str1,str2));

        str1 = "ab";
        str2 = "pqrs";
        System.out.println(mergedAlternately(str1,str2));

        str1 = "abcd";
        str2 = "pq";
        System.out.println(mergedAlternately(str1,str2));

    }

    private static String mergedAlternately(String str1, String str2) {
        int i =0, j=0;
        StringBuilder mergedStr = new StringBuilder();

        while (i< str1.length() || j<str2.length()){
                if(i<str1.length()){
                    mergedStr.append(str1.charAt(i));
                    i++;
                }
                if(j<str2.length()){
                    mergedStr.append(str2.charAt(j));
                    j++;
                }
        }
        return mergedStr.toString();
    }
}
