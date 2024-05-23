package primeService.util;

public class CheckPrime {
    public static final int THRESHOLD = 3;

    public static String checkPrime(int value) {
        if (value < THRESHOLD) {
            return "Invalid";
        }

        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return "No";
            }
        }
        return "Yes";
    }
    
    
}
