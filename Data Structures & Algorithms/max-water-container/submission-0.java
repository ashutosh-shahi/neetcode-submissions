class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int l = 0; int r = n - 1;
        int maxArea = 0;
        while(l < r) {
            maxArea = Math.max(maxArea, (Math.min(heights[l], heights[r]) * (r-l)));
            if(heights[r] < heights[l]) r--;
            else l++;
        }
        return maxArea;
    }
}
