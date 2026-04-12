class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = Arrays.stream(piles).max().orElse(1);
        int l = 1;
        while (l < r) {
            int p = l + (r - l) / 2;
            var hoursSpentEatingWithPRate = hoursSpentEating(piles, p);
            if (hoursSpentEatingWithPRate <= h) {
                r = p;
            } else {
                l = p + 1;
            }
        }

        return r;
    }

    private int hoursSpentEating(int[] piles, int bananasPerHour) {
        return Arrays.stream(piles)
            .map(p -> p / bananasPerHour + (p % bananasPerHour != 0 ? 1 : 0))
            .sum();
    }
}