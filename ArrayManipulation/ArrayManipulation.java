
public class ArrayManipulation {
    //This solution is from RodneyShag on HackerRank
    //Core concept is to record start point and end point of each query
    //Start point(a) -- from here, each should +k
    //End point(b + 1) -- from here, each should -k
    static long arrayManipulation(int n, int[][] queries) {
        long[] array = new long[n + 1];
        for(int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int k = queries[i][2];

            array[a - 1] += k;
            array[b] -= k;
        }

        long sum = 0;
        long max = 0;
        //if array[i] == 0, it does not affect final result
        //if array[i] is negative, use max
        //-k can be explained with that postions behind here does not plus k
        for(int i = 0; i < n; i++) {
            sum += array[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
