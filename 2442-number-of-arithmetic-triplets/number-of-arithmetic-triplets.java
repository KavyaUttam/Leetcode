class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        boolean[] seen = new boolean[201];
        int count = 0;
        for (int num : nums) {
            seen[num] = true;
        }
        for (int num : nums) {

            if (num + diff * 2 <= 200 && seen[num + diff] && seen[num + diff * 2]) {
                count++;
            }
        }
       return count;
    }
}