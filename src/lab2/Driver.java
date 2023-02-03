
package lab2;

/**
 *
 * @author hmh25
 */
public class Driver {

    public static void main(String[] args) {

        System.out.println("Puzzle number 1:\n");

        int[][] start = {{1, 8, 2}, {0, 4, 3}, {7, 6, 5}};
        int[][] goal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};

        int x = 1, y = 0;

        Puzzle puzzle = new Puzzle();
        if (puzzle.isItSolvable(start)) {
            puzzle.solve(start, goal, x, y);

            System.out.println("This puzzle is solveable.\n");

        } else {
            System.out.println("This puzzle is unsolveable.");
        }

        System.out.println("Puzzle number 2:\n");

        int[][] start2 = {{1, 8, 2}, {0, 6, 3}, {7, 4, 5}};
        int[][] goal2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};

        int xx = 1, yy = 0;

        Puzzle puzzle2 = new Puzzle();
        if (puzzle2.isItSolvable(start2)) {
            puzzle2.solve(start2, goal2, xx, yy);
        } else {
            System.out.println("This puzzle is unsolveable.");
        }

    }
}
