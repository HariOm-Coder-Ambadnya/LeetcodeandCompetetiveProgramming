package Easy;

import java.util.HashMap;

public class Leetcode_13 {
    HashMap<String, Integer> values = new HashMap<>();

    public void Solution() {
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);

        values.put("IV", 4);
        values.put("IX", 9);
        values.put("XL", 40);
        values.put("XC", 90);
        values.put("CD", 400);
        values.put("CM", 900);

    }

    public int romanToInt(String s) {

        int sum = 0;
        int i = 0;

        while (i < s.length()) {

            // Check if there are at least 2 characters left
            if (i < s.length() - 1) {

                String twoSymbols = s.substring(i, i + 2);

                // If it is a special Roman numeral
                if (values.containsKey(twoSymbols)) {
                    sum += values.get(twoSymbols);
                    i += 2;
                    continue;
                }
            }

            // Otherwise, use a single character
            String oneSymbol = s.substring(i, i + 1);
            sum += values.get(oneSymbol);
            i++;
        }

        return sum;
    }
}
