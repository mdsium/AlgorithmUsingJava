import java.util.Scanner;

public class LabReportSolTwo {
    static int[][] matrix = new int[20][20]; // Adjacency matrix for the graph
    static boolean[] visited = new boolean[20]; // To track visited vertices
    public static void main(String[] args) {
        int e = 4, n = 5; // e = number of edges, n = number of vertices
        Inmatrix(e); // Populate adjacency matrix with edges
        // Print the adjacency matrix
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        // Cycle detection
        boolean hasCycle = false;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (detectCycle(i, -1)) {
                    hasCycle = true;
                    break;
                }
            }
        }
        // Output the result
        if (hasCycle) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }
    // Function to populate the adjacency matrix
    static void Inmatrix(int e) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Enter The Edges: ");
        char j, k;
        for (int i = 0; i < e; i++) {
            j = sn.next().charAt(0);
            k = sn.next().charAt(0);
            matrix[(int) j - 65][(int) k - 65] = matrix[(int) k - 65][(int) j - 65] = 1;
        }
        }
    // Function to detect a cycle using DFS
    static boolean detectCycle(int v, int parent) {
        visited[v] = true; // Mark the current vertex as visited
        // Traverse adjacent vertices
        for (int i = 0; i < 20; i++) {
            if (matrix[v][i] == 1) { // There's an edge from v to i
                if (!visited[i]) { // If the adjacent vertex is not visited, recurse
                    if (detectCycle(i, v)) {
                        return true;
                    }
                } else if (i != parent) { // If the adjacent vertex is visited and not the parent, there is a cycle
                    return true;
                }
            }
        }
        return false;
    }
}
