import java.util.*;

public class SnakesAndLadders {

    // Complete the quickestWayUp function below.
    private static int[] steps = new int[] {1, 2, 3, 4, 5, 6};
    
    static int quickestWayUp(int[][] ladders, int[][] snakes) {

        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> mapLadders = new HashMap<>();
        HashMap<Integer, Integer> mapSnakes = new HashMap<>();
        boolean[] marked = new boolean[100];

        for(int i = 0; i < ladders.length; i++) {
            mapLadders.put(ladders[i][0], ladders[i][1]);
        }
        for(int i = 0; i < snakes.length; i++) {
            mapSnakes.put(snakes[i][0], snakes[i][1]);
        }

        q.add(1);
        int res = 0;
        while(!q.isEmpty()) {
            res++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int current = q.poll();
                //if(current == 100) return res;
                marked[current - 1] = true;
                for(int k = 0; k < 6; k++) {
                    int newK = current + steps[k];
                    if(newK == 100) return res;
                    if(mapLadders.containsKey(newK) && newK < 100 && !marked[newK - 1]) {
                        marked[newK - 1] = true; 
                        if(mapLadders.get(newK) == 100) {
                            return res;
                        } else {
                            q.add(mapLadders.get(newK));
                        }
                        continue;
                    }
                    if(mapSnakes.containsKey(newK) && newK < 100 &&!marked[newK - 1]) {
                        marked[newK - 1] = true;
                        q.add(mapSnakes.get(newK));
                        continue;
                    }
                    if(newK < 100 && !marked[newK - 1]) {
                        q.add(newK);
                    }
                }
            }
        }
        return -1;
    }
}
