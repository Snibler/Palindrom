import java.util.ArrayList;
import java.util.Collections;

public class test {
    public static void main(String [] args){
        ArrayList<Integer> simplenumbers = new ArrayList<>();
        for (int i = 1000; i <= 9999; i++){
            int n = 0;
            for (int j = 1; j <= i; j++) {if (i % j == 0) n++;}
            if (n == 2)  simplenumbers.add(i);

        }
        ArrayList<Long> palindroms = new ArrayList<>();
        for (int i = 0; i < simplenumbers.size(); i++){
            for (int j = 0; j < simplenumbers.size(); j++) {
                long numb1 = simplenumbers.get(i);
                long numb2 = simplenumbers.get(j);
                long result = numb1 * numb2;
                int numbdig = new numberofdigits(result).number;
                int[] digs = new int[numbdig];
                int k = numbdig - 1;
                long number = result;
                while (number > 0){
                    digs[k] = (int)(number % 10);
                    number = number/10;
                    k--;
                }
                int left;
                int right;
                if (numbdig % 2 == 0) {                  // detecting left index and right index of numbers
                    left = numbdig/2 - 1;                // for palindrom with even and odd quantity of numbs.
                    right = numbdig/2;
                }
                else {
                    left = numbdig/2 - 1;
                    right = numbdig/2 + 1;
                }

                while (true){
                    if (left == 0 && right == numbdig - 1 && digs[left] == digs[right]) {
                        if (!palindroms.contains(result)) palindroms.add(result);
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
        System.out.println(palindroms.size());
        Collections.sort(palindroms);
        System.out.println(palindroms.toString());
        long biggestpalindrom = palindroms.get(palindroms.size() - 1);
        System.out.println("The biggest palindrom is " + String.valueOf(biggestpalindrom));
    }



}

