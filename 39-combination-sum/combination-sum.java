class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, target, new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(int[] candidates, int idx, int target, List<Integer> current, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (idx >= candidates.length || sum > target) return;

        // Take
        current.add(candidates[idx]);
        backtrack(candidates, idx, target, current, sum + candidates[idx]);
        current.remove(current.size() - 1); // backtrack

        // Not take
        backtrack(candidates, idx + 1, target, current, sum);
    }
}