import java.math.*;

class Solution {
    public String smallestGoodBase(String nn) {
        long n = Long.parseLong(nn);
        long res = 0;
        for(int k = 60; k >= 2; k--){
            long left = 2, right = n;
            while(left < right){
                long mid = left + (right - left) / 2;   
                BigInteger first = BigInteger.valueOf(mid);
                first = first.pow(k).subtract(BigInteger.ONE);
                BigInteger second = BigInteger.valueOf(n).multiply(BigInteger.valueOf(mid).subtract(BigInteger.ONE));
                int cur = first.compareTo(second);
                if(cur == 0){
                    res =  mid;
                    break;
                } else if(cur < 0){
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if(res != 0) break;
        }
        return "" + res;
    }
}