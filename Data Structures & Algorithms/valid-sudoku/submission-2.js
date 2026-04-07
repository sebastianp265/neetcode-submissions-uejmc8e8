class Solution {
    /**
     * @param {string[][]} board
     * @return {boolean}
     */
    isValidSudoku(board) {
        const rowToSeenValues = this._initializeIndexToSeenMap();
        const columnToSeenValues = this._initializeIndexToSeenMap();
        const squareToSeenValues = this._initializeIndexToSeenMap();

        for (let i = 0; i < 9; i++) {
            for (let j = 0; j < 9; j++) {
                const current = board[i][j];
                if (current === ".") {
                    continue;
                }

                if (rowToSeenValues.get(i).has(current)) {
                    return false;
                }
                rowToSeenValues.get(i).add(current);

                if (columnToSeenValues.get(j).has(current)) {
                    return false;
                }
                columnToSeenValues.get(j).add(current);

                const squareRow = Math.floor(i / 3);
                const squareColumn = Math.floor(j / 3);
                if (squareToSeenValues.get(squareRow * 3 + squareColumn).has(current)) {
                    return false;
                }
                squareToSeenValues.get(squareRow * 3 + squareColumn).add(current);
            }
        }

        return true;
    }

    _initializeIndexToSeenMap() {
        const numbersFrom0To8 = Array.from({ length: 9 }, (_, i) => i);
        return new Map(numbersFrom0To8.map((n) => [n, new Set()]));
    }
}
