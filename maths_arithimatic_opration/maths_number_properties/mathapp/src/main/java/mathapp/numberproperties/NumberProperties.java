package mathapp.numberproperties;

import java.util.ArrayList;
import java.util.List;

public class NumberProperties {

    // positive number
    public static boolean positive(double number) {
        return number >= 0;
    }

    // negative number
    public static boolean negative(double number) {
        return number < 0;
    }

    // prime number
    public static boolean prime(int number) {
        if (number < 2) return false;
        if (number % 2 == 0) return number == 2;
        for (int i = 3; (long) i * i <= number; i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }

    // odd number
    public static boolean oddNumber(double n) {
        return ((long) n) % 2 != 0;
    }

    // even number
    public static boolean evenNumber(double n) {
        return ((long) n) % 2 == 0;
    }

    // check number list comes under real number (non-empty)
    public static boolean isRealNumberList(ArrayList<Integer> numberSeries) {
        return numberSeries != null && !numberSeries.isEmpty();
    }

    // Natural Number (all > 0)
    public static boolean isNaturalNumberList(ArrayList<Integer> numberSeries) {
        if (numberSeries == null || numberSeries.isEmpty()) return false;
        for (int num : numberSeries) {
            if (num <= 0) return false;
        }
        return true;
    }

    // whole Number (all >= 0)
    public static boolean isWholeNumberList(ArrayList<Integer> numberSeries) {
        if (numberSeries == null || numberSeries.isEmpty()) return false;
        for (int number : numberSeries) {
            if (number < 0) return false;
        }
        return true;
    }

    // rational number (non-empty)
    public static boolean isRationalNumberList(ArrayList<Double> numberSeries) {
        return numberSeries != null && !numberSeries.isEmpty();
    }

    // check any one even number
    public static boolean anyEvenInList(ArrayList<Double> numberSeries) {
        if (numberSeries == null || numberSeries.isEmpty()) return false;
        for (double number : numberSeries) {
            if (evenNumber(number)) return true;
        }
        return false;
    }

    // odd number list
    public static boolean anyOddInList(ArrayList<Double> numberSeries) {
        if (numberSeries == null || numberSeries.isEmpty()) return false;
        for (double number : numberSeries) {
            if (oddNumber(number)) return true;
        }
        return false;
    }

    // odd count in list
    public static int oddCountInList(ArrayList<Double> numberSeries) {
        if (numberSeries == null || numberSeries.isEmpty()) return 0;
        int count = 0;
        for (double number : numberSeries) {
            if (oddNumber(number)) count++;
        }
        return count;
    }

    // even count in list
    public static int evenCountInList(ArrayList<Double> numberSeries) {
        if (numberSeries == null || numberSeries.isEmpty()) return 0;
        int count = 0;
        for (double number : numberSeries) {
            if (evenNumber(number)) count++;
        }
        return count;
    }

    // factors (prime factors style was not clear; keeping same behavior: add i where n % i == 0, for i in [2,n))
    public static List<Integer> factors(double numberFactor, List<Integer> numberFactorList) {
        int n = (int) numberFactor;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                numberFactorList.add(i);
            }
        }
        return numberFactorList;
    }

    private static int findHcf(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // hcf of list
    public static int hcf(ArrayList<Double> numberList) {
        if (numberList == null || numberList.isEmpty()) return 0;
        int result = numberList.get(0).intValue();
        for (int i = 1; i < numberList.size(); i++) {
            result = findHcf(result, numberList.get(i).intValue());
            if (result == 1) return 1;
        }
        return result;
    }

    // lcm of list
    public static int lcm(ArrayList<Double> numberList) {
        if (numberList == null || numberList.isEmpty()) return 0;
        int result = numberList.get(0).intValue();
        for (int i = 1; i < numberList.size(); i++) {
            int nextNum = numberList.get(i).intValue();
            if (nextNum == 0 || result == 0) return 0;
            result = (result * nextNum) / findHcf(result, nextNum);
        }
        return result;
    }
}

