import java.util.*;
public class Minimum_time_required_to_rot_all_oranges_graph {
    // Pair class to store cell coordinates and time
    static class Cell {
        int row, col, time;

        public Cell(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static int minTimeToRotOranges(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Initialize the queue for BFS
        Queue<Cell> queue = new LinkedList<>();
        int freshCount = 0;

        // Add all initially rotten oranges to the queue and count fresh ones
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Cell(i, j, 0));
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // Directions for adjacent cells (up, down, left, right)
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        int timeElapsed = 0;

        // Perform BFS
        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            int row = current.row;
            int col = current.col;
            int time = current.time;

            // Update time elapsed
            timeElapsed = Math.max(timeElapsed, time);

            // Explore all 4 adjacent cells
            for (int i = 0; i < 4; i++) {
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                // Check if the new cell is within bounds and contains a fresh orange
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                    // Rot the fresh orange
                    grid[newRow][newCol] = 2;
                    freshCount--;
                    queue.add(new Cell(newRow, newCol, time + 1));
                }
            }
        }

        // If there are still fresh oranges, return -1
        return freshCount == 0 ? timeElapsed : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 0, 2, 1},
                {0, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };

        int result = minTimeToRotOranges(grid);
        if (result == -1) {
            System.out.println("All oranges cannot be rotten.");
        } else {
            System.out.println("Minimum time required to rot all oranges = " + result);
        }
    }
}

