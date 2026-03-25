class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        long[] rowSums = new long[rows];
        long[] colSums = new long[cols];
        long totalSum = 0;

        // One pass: compute all row sums, column sums and total sum
        for (int row = 0; row < rows; row++) {
            long rowSum = 0;
            for (int col = 0; col < cols; col++) {
                int val = grid[row][col];
                colSums[col] += val;
                rowSum += val;
            }
            rowSums[row] = rowSum;
            totalSum += rowSum;
        }

        // If total sum is odd -> impossible to split into two equal parts
        if ((totalSum & 1) != 0) {  // totalSum % 2 != 0
            return false;
        }

        long halfSum = totalSum >> 1; // totalSum / 2

        // Check if we can split rows or columns
        return hasEqualPartitions(rowSums, halfSum)
               || hasEqualPartitions(colSums, halfSum);
    }

    /**
     * Checks if any prefix sum (from the start) of the array equals half of sum.
     * If the prefix sum ever exceeds the half, any addition to the prefix will
     * only increase its sum. It can never return to exactly equal the half.
     */
    private boolean hasEqualPartitions(long[] array, long halfSum) {
        long prefixSum = 0;
        for (int i = 0; prefixSum < halfSum; i++) {
            prefixSum += array[i];
        }
        return prefixSum == halfSum;
    }
}