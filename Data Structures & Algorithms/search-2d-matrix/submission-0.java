class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = n * m - 1;
        while (l <= r) {
            int p = (r - l) / 2 + l;

            int i = p / n;
            int j = p % n;
            if (matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] > target) {
                r = p - 1;
            } else {
                l = p + 1;
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
