class Solution {
    public String decodeString(String s) {
        int i = 0;
        String result = "";
        Stack<Integer> count = new Stack<>();
        Stack<String> strs = new Stack<>();
        while (i < s.length()) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                count.push(num);
            } else if (c == '[') {
                strs.push(result);
                result = "";
                i++;
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder(strs.pop());
                int repeat = count.pop();
                for (int k = 0; k < repeat; k++) {
                    temp.append(result);
                }
                result = temp.toString();
                i++;
            } else {
                result += s.charAt(i);
                i++;
            }
        }
        return result;
    }
}