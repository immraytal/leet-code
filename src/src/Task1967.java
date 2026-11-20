
/*
*
*
* Given an array of strings patterns and a string word, return the number of strings in patterns that exist as a substring in word.

A substring is a contiguous sequence of characters within a string.



Example 1:

Input: patterns = ["a","abc","bc","d"], word = "abc"
Output: 3
Explanation:
- "a" appears as a substring in "abc".
- "abc" appears as a substring in "abc".
- "bc" appears as a substring in "abc".
- "d" does not appear as a substring in "abc".
3 of the strings in patterns appear as a substring in word.
Example 2
*
* */

public class Task1967 {
    public int numOfStrings(String[] patterns, String word) {
        char[] letters = word.toCharArray();
        int n = 0;
        int patternsUsed = 0;
        for (int i =0; i < letters.length; i++) {
            if (patternsUsed == patterns.length) {
                return n;
            }
            for ( int p = 0; p< patterns.length; p++) {
                if (patterns[p] != null && patterns[p].charAt(0) == word.charAt(i)) {
                    int j = 0;
                    while (j <= patterns[p].length() - 1 && i + j < letters.length) {
                        if (patterns[p].charAt(j) == word.charAt(i + j)) {
                            if (j == patterns[p].length() - 1) {
                                n++;
                                patternsUsed++;
                                patterns[p] = null;
                                break;
                            }
                            j++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        return n;
    }

    public static void main(String[] args) {
        System.out.println(new Task1967().numOfStrings(new String[] {"a","abc","bc","d"}, "abc"));
        System.out.println(new Task1967().numOfStrings(new String[] {"a","b","c"}, "aaaaabbbbb"));
        System.out.println(new Task1967().numOfStrings(new String[] {"a","a","a"}, "ab"));
    }

}
