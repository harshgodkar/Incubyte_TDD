package com.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {
    
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String[] parts = splitNumbers(numbers);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();
        
        for (String number : parts) {
            int num = Integer.parseInt(number);
            if (num < 0) {
                negatives.add(num);
            }
            sum += num;
        }

        if (!negatives.isEmpty()) {
            StringBuilder negativeNumbersMessage = new StringBuilder("Negative numbers not allowed: ");
            for (int i = 0; i < negatives.size(); i++) {
                negativeNumbersMessage.append(negatives.get(i));
                if (i < negatives.size() - 1) {
                    negativeNumbersMessage.append(", ");
                }
            }
            throw new IllegalArgumentException(negativeNumbersMessage.toString());
        }

        return sum;
    }

    private String[] splitNumbers(String numbers) {
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            String delimiter = numbers.substring(2, delimiterIndex);
            String numberString = numbers.substring(delimiterIndex + 1);
            return numberString.split(Pattern.quote(delimiter));
        }
        return numbers.split(",|\n");
    }
}
