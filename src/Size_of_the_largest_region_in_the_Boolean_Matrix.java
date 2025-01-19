import java.util.*;

public class Size_of_the_largest_region_in_the_Boolean_Matrix {

    static class Cell {
        int i, j;

        public Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static int sizeOfLargestRegion(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int maxRegion = 0;

        // Direction vectors for 8 possible moves
        int[] dRow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dCol = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the cell is not visited and is a filled cell (1)
                if (!visited[i][j] && arr[i][j] == 1) {
                    int regionSize = bfs(arr, visited, i, j, dRow, dCol);
                    maxRegion = Math.max(maxRegion, regionSize);
                }
            }
        }

        return maxRegion;
    }

    private static int bfs(int[][] arr, boolean[][] visited, int row, int col, int[] dRow, int[] dCol) {
        int rows = arr.length;
        int cols = arr[0].length;
        int regionSize = 0;

        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(row, col));
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            regionSize++;

            for (int i = 0; i < 8; i++) {
                int newRow = current.i + dRow[i];
                int newCol = current.j + dCol[i];

                // Check bounds and ensure the cell is unvisited and a filled cell
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                        !visited[newRow][newCol] && arr[newRow][newCol] == 1) {
                    visited[newRow][newCol] = true;
                    queue.add(new Cell(newRow, newCol));
                }
            }
        }

        return regionSize;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 1, 1, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1}
        };
        System.out.println(sizeOfLargestRegion(arr));
    }
}
