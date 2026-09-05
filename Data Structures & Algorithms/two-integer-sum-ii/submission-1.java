class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int l = 0; int r = n - 1;
        while(l < r) {
            int sum = nums[l] + nums[r];
            if(sum > target) r--;
            else if(sum < target) l++;
            else return new int[]{l+1, r+1};
        }
        return new int[]{};
    }
}
