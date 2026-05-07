class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;

        // find pivot
        for(int i = n - 1; i > 0; i--) {
            if(nums[i - 1] < nums[i]) {
                pivot = i - 1;
                break;
            }
        }

        // if no pivot found
        if(pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // find next greater element
        int swap_index = pivot;

        for(int j = n - 1; j >= pivot + 1; j--) {
            if(nums[j] > nums[pivot]) {
                swap_index = j;
                break;
            }
        }

        // swap
        swap(nums, swap_index, pivot);

        // reverse remaining part
        reverse(nums, pivot + 1, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        int i = start;
        int j = end;

        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}