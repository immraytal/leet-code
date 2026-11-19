import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task301 {

    private boolean isValid(String s) {
        int count = 0;
        for (Character c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> valid = new ArrayList<>();

        Set<String> level = new HashSet<>();
        level.add(s);
        while (true) {
            for (String str : level) {
                if (isValid(str)) {
                    valid.add(str);
                }
            }

            if (!valid.isEmpty()) {
                return valid;
            }

            Set<String> nextLevel = new HashSet<>();
            for (String str : level) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                        String newStr = str.substring(0, i) + str.substring(i + 1);
                        nextLevel.add(newStr);
                    }
                }
            }
            level = nextLevel;
        }

    }
}
