public class Task1544 {
    public String makeGood(String str) {
        if (str.length() < 2 ) {
            return str.toString();
        }
        StringBuilder s = new StringBuilder(str);
        for (int i = 0; i< s.length() - 1; i++) {
            char c = s.charAt(i);
            char cNext = s.charAt(i + 1);
            if (Math.abs(c - cNext) == 32) {
                //System.out.println(Character.toString(c) + Character.toString(cNext));
                s.deleteCharAt(i);
                s.deleteCharAt(i);
            }
        }
        if (s.length() != str.length()) {
            return makeGood(s.toString());
        }
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Task1544().makeGood("abBAcC"));
    }
}
