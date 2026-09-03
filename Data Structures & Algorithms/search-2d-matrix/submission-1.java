class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        if (m == 0) {
            return false;
        }

        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int pivotRow = (r - l) / 2 + l;
            if (target < matrix[pivotRow][0]) {
                r = pivotRow - 1;
            } else if (target > matrix[pivotRow][m - 1]) {
                l = pivotRow + 1;
            } else {
                l = 0;
                r = m - 1;
                while (l <= r) {
                    int pivotColumn = (r - l) / 2 + l;
                    if (target < matrix[pivotRow][pivotColumn]) {
                        r = pivotColumn - 1;
                    } else if (target > matrix[pivotRow][pivotColumn]) {
                        l = pivotColumn + 1;
                    } else {
                        return true;
                    }
                }

                return false;
            }
        }
        return false;
    }

}

void main() {
    var sol = new Solution();
    System.out.println(sol.searchMatrix(new int[][]{
        {1, 2, 4, 8},
        {10, 11, 12, 13},
        {14, 20, 30, 40}
    }, 14));
}
