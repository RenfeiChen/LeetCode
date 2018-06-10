class Solution {
    public String validIPAddress(String IP) {
        if (IP.length() == 0) {
            return "Neither";
        }
        if (IPv4(IP)) {
            return "IPv4";
        }
        if (IPv6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }
    
    private boolean IPv4(String IP) {
        if (IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') {
            return false;
        }
        String[] strs = IP.split("\\.");
        int len = strs.length;
        if (len != 4) {
            return false;
        }
        for (String str : strs) {
            int l = str.length();
            if (l > 3 || l == 0) {
                return false;
            }
            if (str.charAt(0) == '0' && l > 1) {
                return false;
            }
            int sum = 0;
            for (int i = 0; i < l; i++) {
                char c = str.charAt(i);
                if (!Character.isDigit(c)) {
                    return false;
                }
                sum = sum * 10 + c - '0';
            }
            if (sum > 255) {
                return false;
            }
        }
        return true;
    }
    
    private boolean IPv6(String IP) {
        if (IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') {
            return false;
        }
        String[] strs = IP.split(":");
        int len = strs.length;
        if (len != 8) {
            return false;
        }
        for (String s : strs) {
            int l = s.length();
            if (l > 4 || l == 0) {
                return false;
            }
            for (int i = 0; i < l; i++) {
                char c = s.charAt(i);
                if (!(Character.isDigit(c) || (c >= 65 && c <= 70) || (c >= 97 && c <= 102))) {
                    return false;
                }
            }
        }
        return true;
    }
}.