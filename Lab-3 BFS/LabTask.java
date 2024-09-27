import java.util.*;

public class LABTask {
    static int[][] matrix = new int[20][20];

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        System.out.print("Enter number of edges: ");
        int e = sn.nextInt();

        System.out.print("Enter number of vertices: ");
        int n = sn.nextInt();

        Inmatrix(e, sn);

        System.out.println("Adjacency Matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("Enter starting node: ");
        char startNode = sn.next().charAt(0);
        int startIndex = startNode - 'A';

        if (startIndex >= 0 && startIndex < n) {
            printNodeLevels(startIndex, n);
        } else {
            System.out.println("Invalid starting node.");
        }

        sn.close();
    }
    static void Inmatrix(int e, Scanner sn) {
        System.out.println("Enter the edges : ");
        for (int i = 0; i < e; i++) {
            char j = sn.next().charAt(0);
            char k = sn.next().charAt(0);

            int index1 = j - 'A';
            int index2 = k - 'A';

            if (index1 >= 0 && index1 < 20 && index2 >= 0 && index2 < 20) {
                matrix[index1][index2] = matrix[index2][index1] = 1;
            } else {
                System.out.println("Invalid edge: " + j + " " + k);
            }
        }
    }
    static void printNodeLevels(int startIndex, int n) {
        int[] levels = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(levels, -1);
        Queue<Integer> queue = new LinkedList<>();
        visited[startIndex] = true;
        levels[startIndex] = 0;
        queue.add(startIndex);
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (matrix[currentNode][neighbor] == 1 && !visited[neighbor]) {
                    visited[neighbor] = true;
                    levels[neighbor] = levels[currentNode] + 1;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println("Node Levels (from starting node " + (char)(startIndex + 'A') + "):");
        for (int i = 0; i < n; i++) {
            if (levels[i] != -1) {
                System.out.println((char)(i + 'A') + " : Level " + levels[i]);
            }
        }
    }
}