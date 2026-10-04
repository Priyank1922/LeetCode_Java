import java.util.*;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> usedInteger = new HashSet<>();
        
        while (n != 1) {
            int sum = 0;
            
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            
            n = sum;
            
            if (usedInteger.contains(n)) {
                return false; 
            }
            usedInteger.add(n);
        }
        
        return true; 
    }
}
