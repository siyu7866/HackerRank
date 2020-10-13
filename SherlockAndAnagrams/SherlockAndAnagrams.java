import java.util.*;

public class SherlockAndAnagrams {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        //char[] array = s.toCharArray();
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = 1; j < s.length(); j++) {
                if(i + j <= s.length()) {
                    //String newS = new String(array)
                    String newS = sortString(s.substring(i, i + j));
                    if(!map.containsKey(newS)) {
                        map.put(newS, 1);
                    } else {
                        int tmp = map.get(newS);
                        tmp++;
                        map.put(newS, tmp);
                        res = res + tmp - 1;
                    }
                }
            }
        }
        return res;
    }

    private static String sortString(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        String res = new String(array);
        return res;
    }
}
