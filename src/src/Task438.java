import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s.length() < p.length()) {
            return list;
        }

        int[] freqS = new int[26];
        int[] freqP = new int[26];


        for(int i=0; i<p.length(); i++) {
            freqS[s.charAt(i)-'a']++;
            freqP[p.charAt(i)-'a']++;
        }

        if(Arrays.equals(freqS, freqP)) {
            list.add(0);
        }

        int start = 0;
        int end = p.length();

        while(end < s.length()) {

            freqS[s.charAt(start)-'a']--;
            freqS[s.charAt(end)-'a']++;

            if(Arrays.equals(freqS, freqP)) {
                list.add(start+1);
            }
            end++;
            start++;
        }
        return list;
    }

    public static void main(String[] args) {
        Task438 task438 = new Task438();
        System.out.println(task438.findAnagrams("baa", "aa"));
        System.out.println(task438.findAnagrams("abab", "ab"));
        System.out.println(task438.findAnagrams("cbaebabacd", "abc"));
    }
}
