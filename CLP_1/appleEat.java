import java.util.*;
import java.io.*;

public class Main {
    static class FenwickTree {
        int[] bit;
        int n;

        public FenwickTree(int n) {
            this.n = n;
            this.bit = new int[n + 1]; // 1-based index
        }

        public void update(int idx, int delta) {
            while (idx <= n) {
                bit[idx] += delta;
                idx += idx & -idx;
            }
        }

        public int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        // Read number of apples
        int N = Integer.parseInt(br.readLine());

        // Array to hold apple positions (x, y)
        int[][] apples = new int[N][2];

        // Reading all apple positions
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            apples[i][0] = Integer.parseInt(line[0]); // x coordinate
            apples[i][1] = Integer.parseInt(line[1]); // y coordinate
        }

        // Sort apples by x-coordinate, and if equal by y-coordinate
        Arrays.sort(apples, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        // Fenwick tree for y-coordinates, we need to map y-coordinates to smaller space
        int MAX_Y = 1000000000; // max value of y-coordinate
        FenwickTree fenwick = new FenwickTree(MAX_Y);

        // To store results
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            int x = apples[i][0];
            int y = apples[i][1];

            // Query how many apples have been seen with y <= current y
            result[i] = fenwick.query(y);

            // Update fenwick tree to mark this apple's y as seen
            fenwick.update(y, 1);
        }

        // Output results
        for (int i = 0; i < N; i++) {
            out.println(result[i]);
        }

        out.flush();
        out.close();
    }
}
