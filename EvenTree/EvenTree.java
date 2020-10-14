import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EvenTree {

    private static boolean[] visited;
    private static int result;
    // Complete the evenForest function below.
    //use dfs
    //iterate child node of each node, count subtree node numbers
    //when current node number are even, remove it
    static int evenForest(int t_nodes, int t_edges, List<Integer> t_from, List<Integer> t_to) {
        visited = new boolean[t_nodes];
        result = 0;
        dfs(t_nodes, t_from, t_to, 1);
        return result;
    }

    static int dfs(int t_nodes, List<Integer> t_from, List<Integer> t_to, int curNode) {
        List<Integer> listIndex = new LinkedList<>();
        int currentNodesNumber = 0;
        visited[curNode - 1] = true;
        //get child node index in list(t_from)
        for(int i = 0; i < t_to.size(); i++) {
            if(t_to.get(i) == curNode) {
                listIndex.add(i);
            }
        }
        //iterate child node
        for(int i = 0; i < listIndex.size(); i++) {
            int index = listIndex.get(i);
            if(!visited[t_from.get(index) - 1]) {
                //count node numbers of subtree
                int subtreeNodeCount = dfs(t_nodes, t_from, t_to, t_from.get(index));
                //if subtree node number is even, it can be removed
                if(subtreeNodeCount % 2 == 0) {
                    result++;
                } else {
                    currentNodesNumber += subtreeNodeCount;
                }
            }
        }
        return currentNodesNumber + 1;
    }

    public static void main(String[] args) {
        List<Integer> t_from = new LinkedList<>();
        List<Integer> t_to = new LinkedList<>();
        for(int i = 2; i <= 10; i++) {
            t_from.add(i);
        }
        t_to.add(1);
        t_to.add(1);
        t_to.add(3);
        t_to.add(2);
        t_to.add(1);
        t_to.add(2);
        t_to.add(6);
        t_to.add(8);
        t_to.add(8);
        int r = evenForest(10, 9, t_from, t_to);
        System.out.println(r);
    }
}
