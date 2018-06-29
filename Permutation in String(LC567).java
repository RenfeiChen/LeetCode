class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int start = 0, count = 0;
        for (int end = 0; end < m; end ++) {
            char c = s2.charAt(end);
            // System.out.println(c + " " + start + " " + end);
            if (!map.containsKey(c)) {
                count = 0;
                // System.out.println("------------------");
                // for (char ch : map.keySet()) {
                //         System.out.println(ch + " " + map.get(ch));
                //     }
                // System.out.println("------------------1");
                for (int i = start; i < end; i++) {
                    char cur = s2.charAt(i);
                    map.put(cur, map.get(cur) + 1);
                }
                start = end + 1;
            } else if(map.get(c) == 0) {
                while (start < end) {
                    if (s2.charAt(start) == c) {
                        break;
                    }
                    map.put(s2.charAt(start), map.get(s2.charAt(start)) + 1);
                    count--;
                    start++;
                }
                start++;
                // System.out.println("------------------");
                // for (char ch : map.keySet()) {
                //     System.out.println(ch + " " + map.get(ch));
                // }
                // System.out.println("------------------2");
                
            } else {
                count++;
                if (count == n) {
                    return true;
                }
                map.put(c, map.get(c) - 1);
                // System.out.println("------------------");
                //                 for (char ch : map.keySet()) {
                //         System.out.println(ch + " " + map.get(ch));
                //     }
                // System.out.println("------------------3");
            }
        }
        return false;
    }
}