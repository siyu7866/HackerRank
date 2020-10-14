import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> mapAppearance = new HashMap<>();

        //Use HashMap to store appearnce times of each character
        for(int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
                //listChar.add(s.charAt(i));
            } else {
                int tmp = map.get(s.charAt(i));
                tmp++;
                map.put(s.charAt(i), tmp);
            }
        }
        //traverse map to create HashMap recording differenct apperance times
        //if they are all the same number, it is a valid string
        //the value (mapAppearance) is how many times this number appears totally
        for(int value: map.values()) {
            if(!mapAppearance.containsKey(value)) {
                mapAppearance.put(value, 1);
            } else {
                int tmp = mapAppearance.get(value);
                tmp++;
                mapAppearance.put(value, tmp);
            }
        }

        if(mapAppearance.size() == 1) return "YES";
        else if(mapAppearance.size() == 2) {
            //took lots of time on how to converting set to array
            //here should use Integer[] to initialize array, rather than int[]
            Set<Integer> set = mapAppearance.keySet();
            Integer[] array = new Integer[2];
            array = set.toArray(array);
            int diff = Math.abs(array[1] - array[0]);
            for(int key: mapAppearance.keySet()) {
                //if one character only appear once, it is "YES"
                if(key == 1 && mapAppearance.get(key) == 1) {
                    return "YES";
                }
                //if there is only one character whose appearance times is one bigger than any other character, it should be "YES"
                if(diff == 1 && mapAppearance.get(key) == 1) {
                    return "YES";
                }
            }
            return "NO";
        }
        else return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
