import java.util.*;

class Checker implements Comparator<Player> {
    public int compare(Player a, Player b) {
        int length = a.name.length() > b.name.length() ? a.name.length() : b.name.length();
        char[] desArrayA = new char[length];
        char[] desArrayB = new char[length];
        char[] srcArrayA = a.name.toCharArray();
        char[] srcArrayB = b.name.toCharArray();

        //convert string to char array to compare letters
        System.arraycopy(srcArrayA, 0, desArrayA, 0, a.name.length());
        System.arraycopy(srcArrayB, 0, desArrayB, 0, b.name.length());
        //compare a & b name letter by letter
        int frontName = 0;
        for(int i = 0; i < length; i++) {
            if(desArrayA[i] - 'a' > desArrayB[i] - 'a') {
                frontName = 1;
                break;
            }
            else if(desArrayA[i] - 'a' < desArrayB[i] - 'a') {
                frontName = -1;
                break;
            } else {
                continue;
            }
        }

        //compare a & b scores
        //when a & b have the same score, compare their names
        if(a.score < b.score) return 1;
        else if(a.score > b.score) return -1;
        else {
            return frontName;
        }
    }
}