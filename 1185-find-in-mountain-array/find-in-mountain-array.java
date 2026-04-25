// MountainArray interface is given in problem
// interface MountainArray {
//     public int get(int index);
//     public int length();
// }

class Solution {

    private int peakIndexInMountainArray(MountainArray mountainArr){
        int n = mountainArr.length();
        int low = 0;
        int high = n - 1;

        while(low < high){
            int mid = low + (high - low) / 2;

            if(mountainArr.get(mid) < mountainArr.get(mid + 1)){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Ascending Binary Search
    private int AscBinarySearch(MountainArray mountainArr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low) / 2;
            int val = mountainArr.get(mid);// because to many get calls give TLE

            if(val == target) return mid;

            if(val < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Descending Binary Search
    private int DscBinarySearch(MountainArray mountainArr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low) / 2;
            int val = mountainArr.get(mid);

            if(val == target) return mid;

            if(val < target){
                high = mid - 1; 
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        int idx = peakIndexInMountainArray(mountainArr);

        // search in ascending part( 0 to peakindex)
        int result_idx = AscBinarySearch(mountainArr, 0, idx, target);
        if(result_idx != -1){
            return result_idx;
        }

        // search in descending part(index+1 to n-1)
        return DscBinarySearch(mountainArr, idx + 1, n - 1, target);
    }
}