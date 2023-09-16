package numbers;

import java.util.HashSet;
import java.util.Set;

public class Calculations {
    public static boolean even(long num) {
        return num % 2 == 0;
    }

    public static boolean odd(long num) {
        return num % 2 != 0;
    }

    public static boolean buzz(long num) {
        long lastDigit = Math.abs(num) % 10;
        ;

        if ((num % 7 == 0) && (lastDigit == 7)) {
            return true;
        } else if (num % 7 == 0) {
            return true;
        } else if (lastDigit == 7) {
            return true;
        } else {

            return false;
        }
    }

    public static boolean duck(long num) {
        String string = String.valueOf(num);
        if (string.length() > 1) {
            for (int i = 1; i < string.length(); i++) {
                if (string.charAt(i) == '0') {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean palindromic(long num) {
        StringBuilder str = new StringBuilder();
        str = str.append(num);
        String string = String.valueOf(str);
        String str_reverse = String.valueOf(str.reverse());
        return string.equals(str_reverse);
    }

    public static boolean gapful(long num) {
        String str = String.valueOf(num);
        String digits = String.valueOf(str.charAt(0)) + str.charAt(str.length() - 1);
        if (str.length() < 3) {
            return false;
        } else if ((Long.parseLong(str) % Long.parseLong(digits) == 0) && (str.length() >= 3)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean spy(long num) {
        long digit, sum = 0,
                product = 1;
        while (num > 0) {
            digit = num % 10;
            sum += digit;

            product *= digit;
            num = num / 10;
        }

        if (sum == product)
            return true;
        else
            return false;
    }

    public static boolean square(long num) {
        if (num >= 0) {
            int sr = (int) Math.sqrt(num);
            return ((sr * sr) == num);
        }
        return false;
    }

    public static boolean sunny(long num) {
        num = num + 1;
        if (num >= 0) {
            int sr = (int) Math.sqrt(num);
            return ((sr * sr) == num);
        }
        return false;
    }

    public static boolean jumping(long num) {
        while (num != 0) {
            long digit1 = num % 10;
            num = num / 10;
            if (num != 0) {
                long digit2 = num % 10;
                if (Math.abs(digit1 - digit2) != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean happy(long num){
        Set<Long> digits=new HashSet<Long>();
        while(digits.add(num))
        {
            long result = 0;
            while(num > 0)
            {
                result += Math.pow(num % 10, 2);
                num = num/10;
            }
            num = result;
        }
        return num == 1;
    }

    public static boolean sad(long num){
        return !happy(num);
    }
}

