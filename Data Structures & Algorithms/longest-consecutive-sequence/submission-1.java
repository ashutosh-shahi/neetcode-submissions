class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            int len = 0;
            if(!set.contains(nums[i] - 1)) {
                while(set.contains(nums[i])) {
                    len++;
                    max = Math.max(len, max);
                    nums[i] += 1;
                }
            }
        }
        return max;
    }
}
