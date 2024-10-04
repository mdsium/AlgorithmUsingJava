import java.util.*;

public class LRPOne {
    static int[][] matrix = new int[20][20]; // Adjacency matrix
    static boolean[] visited = new boolean[20]; // Visited array

    public static void main(String[] args) {
        int e = 8, n = 5; // Number of edges and vertices
        Inmatrix(e);
        System.out.println("Output: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }

        // Call to cycle detection method
        boolean hasCycle = detectCycleUsingBFS(n);
        if (hasCycle) {
            System.out.println("Cycle detected in the graph.");
        } else {
            System.out.println("No cycle detected in the graph.");
        }
    }

    static void Inmatrix(int e) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Enter The Edges: ");
        char j, k;
        for (int i = 0; i < e; i++) {
            j = sn.next().charAt(0);
            k = sn.next().charAt(0);
            matrix[(int) j - 65][(int) k - 65] = matrix[(int) k - 65][(int) j - 65] = 1;
        }
        sn.close();
    }

    // Helper class for storing vertex and parent in BFS
    static class Node {
        int vertex;
        int parent;

        Node(int vertex, int parent) {
            this.vertex = vertex;
            this.parent = parent;
        }
    }

    // Method to detect cycle using BFS
    static boolean detectCycleUsingBFS(int n) {
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (bfsCheckCycle(i, n)) {
                    return true;
                }
            }
        }
        return false;
    }

    // BFS to check if there is a cycle
    static boolean bfsCheckCycle(int src, int n) {
        Queue<Node> queue = new LinkedList<>();
        visited[src] = true;
        queue.add(new Node(src, -1)); // Start with source and parent -1

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int vertex = current.vertex;
            int parent = current.parent;

            for (int i = 0; i < n; i++) {
                if (matrix[vertex][i] == 1) { // If an edge exists
                    if (!visited[i]) {
                        visited[i] = true;
                        queue.add(new Node(i, vertex));
                    } else if (i != parent) { // If visited and not parent, a cycle exists
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
