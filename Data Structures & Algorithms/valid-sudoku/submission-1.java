class Solution {

    void clearArray(boolean[] checked) {
        for(int i = 0; i < checked.length; i++) {
            checked[i] = false;
        }
    }

    public boolean isValidSudoku(char[][] board) {
        boolean[] checked = new boolean[10];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 9; k++) {
                    int num = board[i * 3 + k / 3][j * 3 + k % 3] - '0';
                    if(num > 0 && num <= 9) {
                        if (checked[num]) {
                            return false;
                        }
                        checked[num] = true;
                    }
                }

                clearArray(checked);
            }
        }

        for(int i = 0; i < 9; i++) {
            for(int k = 0; k < 9; k++) {
                int num = board[i][k] - '0';
                if(num > 0 && num <= 9) {
                    if(checked[num]) {
                        return false;
                    }
                    checked[num] = true;
                }
            }
            clearArray(checked);

            for(int k = 0; k < 9; k++) {
                int num = board[k][i] - '0';
                if(num > 0 && num <= 9) {
                    if (checked[num]) {
                        return false;
                    }
                    checked[num] = true;
                }
            }

            clearArray(checked);
        }



        return true;
    }
}
