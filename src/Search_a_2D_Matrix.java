public class Search_a_2D_Matrix {

//    public boolean searchMatrix(int[][] matrix, int target) {
//         int m = matrix.length;
//         int n = matrix[0].length;

//         int low = 0;
//         int high = m * n - 1;

//         while (low <= high) {
//             int mid = low + (high - low) / 2;
//             int row = mid / n;
//             int col = mid % n;

//             if (matrix[row][col] == target) {
//                 return true;
//             } else if (matrix[row][col] < target) {
//                 low = mid + 1;
//             } else {
//                 high = mid - 1;
//             }
//         }

//         return false;
//     }
// }
        public boolean searchMatrix(int[][] matrix, int target) {
            int sr = 0;
            int er = matrix.length - 1;
            int n = matrix[0].length;

            while (sr <= er) {
                int midR = (sr + er) / 2;

                // If target is within this row
                if (target >= matrix[midR][0] && target <= matrix[midR][n - 1]) {
                    // Binary search in this row
                    int sc = 0, ec = n - 1;
                    while (sc <= ec) {
                        int midC = (sc + ec) / 2;
                        if (matrix[midR][midC] == target) {
                            return true;
                        } else if (matrix[midR][midC] < target) {
                            sc = midC + 1;
                        } else {
                            ec = midC - 1;
                        }
                    }
                    return false;
                }
                // Move search to upper or lower rows
                else if (target < matrix[midR][0]) {
                    er = midR - 1;
                } else {
                    sr = midR + 1;
                }
            }

            return false;
        }
}







