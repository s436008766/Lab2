package lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author hmh25
 */
public class Puzzle {

    public int dimension = 3;

    int[] row = {1, 0, -1, 0};
    int[] col = {0, -1, 0, 1};

    public int calculateCost(int[][] initial, int[][] goal) {
        int count = 0;
        int n = initial.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (initial[i][j] != 0 && initial[i][j] != goal[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isItSafe(int x, int y) {
        return (x >= 0 && x < dimension && y >= 0 && y < dimension);
    }

    public void printPath(Nodes root) {
        if (root == null) {
            return;
        }
        printPath(root.origin);
        printMatrix(root.matrix);
        System.out.println();
    }

    public boolean isItSolvable(int[][] matrix) {
        int count = 0;
        List<Integer> array = new ArrayList<Integer>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                array.add(matrix[i][j]);
            }
        }

        Integer[] anotherArray = new Integer[array.size()];
        array.toArray(anotherArray);

        for (int i = 0; i < anotherArray.length - 1; i++) {
            for (int j = i + 1; j < anotherArray.length; j++) {
                if (anotherArray[i] != 0 && anotherArray[j] != 0 && anotherArray[i] > anotherArray[j]) {
                    count++;
                }
            }
        }

        return count % 2 == 0;
    }

    public void solve(int[][] initial, int[][] goal, int x, int y) {
        PriorityQueue<Nodes> pq = new PriorityQueue<Nodes>(1000, (a, b) -> (a.cost + a.dest) - (b.cost + b.dest));
        Nodes root = new Nodes(initial, x, y, x, y, 0, null);
        root.cost = calculateCost(initial, goal);
        pq.add(root);

        while (!pq.isEmpty()) {
            Nodes min = pq.poll();
            if (min.cost == 0) {
                printPath(min);
                return;
            }

            for (int i = 0; i < 4; i++) {
                if (isItSafe(min.x + row[i], min.y + col[i])) {
                    Nodes child = new Nodes(min.matrix, min.x, min.y, min.x + row[i], min.y + col[i], min.dest + 1, min);
                    child.cost = calculateCost(child.matrix, goal);
                    pq.add(child);
                }
            }
        }
    }

}
