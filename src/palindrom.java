//Программа, которая возвращает наибольшее число палиндром,
//которое является произведением двух простых пятизначных чисел, а также возвращает сами сомножители.
//Простое число - это натуральное число, которое делится нацело только на 1 и на себя само (2, 3, 5, 7, 11, …)
//Палиндром – строка, которая читается одинаково в обоих направлениях (например ABBA)

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class palindrom {

    public static void main(String[] args){
        long start = System.currentTimeMillis();
        Map<Long, String> multipliers = new HashMap<>();
// Searching 5-digit simple numbers
        ArrayList<Integer> simplenumbers = new ArrayList<>();
        for (int i = 10000; i <= 99999; i++){
            int n = 0;
            for (int j = 1; j <= i; j++) {if (i % j == 0) n++;}
            if (n == 2)  simplenumbers.add(i);
        }
// Searching palindroms
        ArrayList<Long> palindroms = new ArrayList<>();
// Multiplying of simple numbers
        for (int i = 0; i < simplenumbers.size(); i++){
            for (int j = 0; j < simplenumbers.size(); j++){

                long numb1 = simplenumbers.get(i);
                long numb2 = simplenumbers.get(j);
                long result = numb1 * numb2;
// Searching number of digits in testing number
                int numbdig = new numberofdigits(result).number;
// Splitting digits of testing number for comparing
                int[] digs = new int[numbdig];
                int k = numbdig - 1;
                long number = result;
                while (number > 0){
                    digs[k] = (int)(number % 10);
                    number = number/10;
                    k--;
                }
// Detecting of indexes of left and right digit (from center of testing number)
                int left;
                int right;
                if (numbdig % 2 == 0) {         // indexes for even quantity of digits
                    left = numbdig/2 - 1;
                    right = numbdig/2;
                }
                else {                          // indexes for odd quantity of digits
                    left = numbdig/2 - 1;
                    right = numbdig/2 + 1;
                }
// Testing number: is it palindrome?
                while (true){
                    if (left == 0 && right == (numbdig - 1) && digs[left] == digs[right]) {
                        if (!palindroms.contains(result)) {
                            palindroms.add(result);
                            multipliers.put(result, "The mutlipliers: " + String.valueOf(numb1)
                                                                + " and " + String.valueOf(numb2));
                        }
                        break;
                    }
                    if (digs[left] != digs[right]) break;
                    else {
                        left--;
                        right++;
                    }
                }
            }
        }

        Collections.sort(palindroms);
        long biggestpalindrom = palindroms.get(palindroms.size() - 1);
        System.out.println("The biggest palindrom is " + String.valueOf(biggestpalindrom) + " " + multipliers.get(biggestpalindrom));
        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        System.out.println("Consumed time: " + timeConsumedMillis/1000 + "sec. " + timeConsumedMillis % 1000 + "ms");
    }

}

