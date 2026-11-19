public class Task2000 {
    public String reversePrefix(String word, char ch) {
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                prefix.append(word, 0, i + 1);
                prefix.reverse();
                prefix.append(word.substring(i+1));
                return prefix.toString();
            }
        }
        return word;
    }
}
