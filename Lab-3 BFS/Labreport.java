import java.util.*;
public class Labreport {
    public static boolean isCyclic(int[][] graph, int n) {
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (CycleCheck(graph, i, visited, n)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean CycleCheck(int[][] graph, int start, boolean[] visited, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, -1});
        visited[start] = true;
        while (!queue.isEmpty()) {
            int[] nodeData = queue.poll();
            int currentNode = nodeData[0];
            int parent = nodeData[1];
            for (int adj = 0; adj < n; adj++) {
                if (graph[currentNode][adj] == 1) {
                    if (!visited[adj]) {
                        queue.add(new int[]{adj, currentNode});
                        visited[adj] = true;
                    } else if (adj != parent) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] graph = new int[n][n];
        graph[0][1] = 1; graph[1][0] = 1; // Edge between 0 and 1
        graph[1][2] = 1; graph[2][1] = 1; // Edge between 1 and 2
        graph[2][3] = 1; graph[3][2] = 1; // Edge between 2 and 3
        graph[3][4] = 1; graph[4][3] = 1; // Edge between 3 and 4
        graph[4][0] = 1; graph[5][0] = 1; // Edge between 4 and 0 (introduces a cycle)
        if (isCyclic(graph, n)) {
            System.out.println("Cycle detected in the graph.");
        } else {
            System.out.println("No cycle in the graph.");
        }
    }
}
