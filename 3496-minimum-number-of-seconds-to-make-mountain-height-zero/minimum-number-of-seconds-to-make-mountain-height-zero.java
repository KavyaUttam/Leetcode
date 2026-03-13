class Solution {

    public boolean canFinish(long T, int mountainHeight, int[] workerTimes) {
        long total = 0;

        for (int w : workerTimes) {
            long x = (long)((Math.sqrt(1.0 + 8.0 * T / w) - 1) / 2);

            while (1L * w * x * (x + 1) / 2 > T) {
                x--;
            }
            while (1L * w * (x + 1) * (x + 2) / 2 <= T) {
                x++;
            }

            total += x;
            if (total >= mountainHeight) {
                return true;
            }
        }

        return total >= mountainHeight;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int minW = Integer.MAX_VALUE;
        for (int w : workerTimes) {
            minW = Math.min(minW, w);
        }

        long low = 0;
        long high = 1L * minW * mountainHeight * (mountainHeight + 1) / 2;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canFinish(mid, mountainHeight, workerTimes)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}