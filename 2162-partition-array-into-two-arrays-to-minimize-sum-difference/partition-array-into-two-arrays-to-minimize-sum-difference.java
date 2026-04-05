import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int num : nums) total += num;

        int half = n / 2;
        // left half
        List<List<Integer>> leftSums = getSubsetSums(Arrays.copyOfRange(nums, 0, half));
        // right half
        List<List<Integer>> rightSums = getSubsetSums(Arrays.copyOfRange(nums, half, n));
        for (List<Integer> list : rightSums) Collections.sort(list);

        int ans = Integer.MAX_VALUE;

        for (int k = 0; k <= half; k++) {
            List<Integer> leftList = leftSums.get(k);
            List<Integer> rightList = rightSums.get(half - k);

            for (int sumLeft : leftList) {
                int target = total / 2 - sumLeft;
                int idx = Collections.binarySearch(rightList, target);
                if (idx < 0) idx = -idx - 1;

                if (idx < rightList.size()) {
                    int sumRight = rightList.get(idx);
                    int sumChosen = sumLeft + sumRight;
                    ans = Math.min(ans, Math.abs(total - 2 * sumChosen));
                }
                if (idx > 0) {
                    int sumRight = rightList.get(idx - 1);
                    int sumChosen = sumLeft + sumRight;
                    ans = Math.min(ans, Math.abs(total - 2 * sumChosen));
                }
            }
        }
        return ans;
    }

    private List<List<Integer>> getSubsetSums(int[] arr) {
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= n; i++) res.add(new ArrayList<>());
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0, bits = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += arr[i];
                    bits++;
                }
            }
            res.get(bits).add(sum);
        }
        return res;
    }
}

